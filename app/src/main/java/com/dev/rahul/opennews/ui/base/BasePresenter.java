package com.dev.rahul.opennews.ui.base;

/**
 * Created by rahul on 4/1/18.
 */

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    private V view;

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        view = null;
    }

    public V view() {
        return view;
    }
}
