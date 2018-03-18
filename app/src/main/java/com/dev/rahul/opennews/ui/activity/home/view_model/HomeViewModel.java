package com.dev.rahul.opennews.ui.activity.home.view_model;

import android.arch.lifecycle.ViewModel;

import com.dev.rahul.opennews.ui.fragment.sources.SourceMVP;
import com.dev.rahul.opennews.ui.fragment.sources.SourcePresenter;

/**
 * Created by rahul on 18/3/18.
 */

public class HomeViewModel extends ViewModel {

    private SourceMVP.IPresenter sourcePresenter;

    public SourceMVP.IPresenter getSourcePresenter() {
        if (sourcePresenter == null) {
            sourcePresenter = new SourcePresenter();
        }

        return sourcePresenter;
    }
}
