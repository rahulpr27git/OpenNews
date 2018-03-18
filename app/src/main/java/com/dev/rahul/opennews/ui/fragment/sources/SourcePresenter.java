package com.dev.rahul.opennews.ui.fragment.sources;

import com.dev.rahul.opennews.pojo.Response;
import com.dev.rahul.opennews.pojo.Sources;
import com.dev.rahul.opennews.ui.base.BasePresenter;
import com.dev.rahul.opennews.util.Constant;
import com.dev.rahul.opennews.util.RLog;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by rahul on 4/3/18.
 */

public class SourcePresenter<V extends SourceMVP.IView> extends BasePresenter<V>
        implements SourceMVP.IPresenter<V> {

    public static final String TAG = SourcePresenter.class.getSimpleName();
    private List<Sources> sourcesList;

    private CompositeDisposable disposable;
    private SourceRepository repository;

    public SourcePresenter() {
        repository = new SourceRepository();
        disposable = new CompositeDisposable();
    }

    @Override
    public void onDestroy() {
        disposable.clear();
        onDetach();
    }

    @Override
    public void fetchSourcesFromLocal() {
        RLog.print(TAG, "fetchSourcesFromLocal : check source List is null or not", RLog.ERROR);
        if (sourcesList == null) {
            RLog.print(TAG, "fetchSourcesFromLocal : check source List is null", RLog.ERROR);
            repository.getSources()
                    .subscribeWith(sourceObserver());
        }
    }

    @Override
    public void fetchSourcesFromNetwork() {

        repository.getSourcesNetwork().map(new Function<Response, List<Sources>>() {
            @Override
            public List<Sources> apply(Response response) throws Exception {
                RLog.print(TAG, "fetchSourcesFromNetwork : data from network", RLog.ERROR);
                if (response.getStatus().equals(Constant.OK)) {
                    repository.insertIntoSourceTable(response.getSources());
                    return response.getSources();
                } else
                    throw new Exception("No News source available. Please try again later");
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(sourceObserver());
    }

    private SingleObserver<List<Sources>> sourceObserver() {
        return new SingleObserver<List<Sources>>() {

            @Override
            public void onSubscribe(Disposable d) {
                disposable.add(d);
            }

            @Override
            public void onSuccess(List<Sources> list) {
                if (list != null && !list.isEmpty()) {
                    RLog.print(TAG, "sourceObserver : Source List has data", RLog.ERROR);
                    sourcesList = list;
                    view().showSourceList(sourcesList);
                } else {
                    RLog.print(TAG, "sourceObserver : Source List is null or empty call from network", RLog.ERROR);
                    fetchSourcesFromNetwork();
                }
            }

            @Override
            public void onError(Throwable e) {
                view().onError(e.getMessage());
                e.printStackTrace();
            }
        };
    }
}
