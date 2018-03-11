package com.dev.rahul.opennews.ui.fragment.sources;

import com.dev.rahul.opennews.ui.base.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by rahul on 4/3/18.
 */

public class SourcePresenter<V extends SourceMVP.IView> extends BasePresenter<V> implements SourceMVP.IPresenter<V> {

    public static final String TAG = SourcePresenter.class.getSimpleName();

    private CompositeDisposable disposable;
    private SourceRepository repository;

    public SourcePresenter(SourceRepository repository) {
        this.repository = repository;
        disposable = new CompositeDisposable();
    }

    @Override
    public void onDestroy() {

    }
}
