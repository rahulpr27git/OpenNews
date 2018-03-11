package com.dev.rahul.opennews.ui.fragment.sources;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.dev.rahul.opennews.R;
import com.dev.rahul.opennews.ui.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SourceFragment extends BaseFragment implements SourceMVP.IView {


    public SourceFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutRes() {
        return R.layout.fragment_source;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onRefresh() {

    }
}
