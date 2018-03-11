package com.dev.rahul.opennews.ui.fragment.sources;

import com.dev.rahul.opennews.pojo.Response;
import com.dev.rahul.opennews.pojo.Sources;
import com.dev.rahul.opennews.ui.base.BasePresenter;
import com.dev.rahul.opennews.util.Constant;

import java.util.List;

import io.reactivex.SingleObserver;
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
        if (sourcesList == null) {
            repository.getSources()
                    .subscribeWith(sourceObserver());
        } else {

        }
    }

    @Override
    public void fetchSourcesFromNetwork() {

        repository.getSourcesNetwork().map(new Function<Response, List<Sources>>() {
            @Override
            public List<Sources> apply(Response response) throws Exception {
                if (response.getStatus().equals(Constant.OK))
                    return response.getSources();
                return null;
            }
        }).subscribeWith(sourceObserver());
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
                    sourcesList = list;
                } else {
                    fetchSourcesFromNetwork();
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        };
    }
}
