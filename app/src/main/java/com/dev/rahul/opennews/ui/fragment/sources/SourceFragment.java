package com.dev.rahul.opennews.ui.fragment.sources;


import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dev.rahul.opennews.R;
import com.dev.rahul.opennews.pojo.Sources;
import com.dev.rahul.opennews.ui.activity.home.view_model.HomeViewModel;
import com.dev.rahul.opennews.ui.base.BaseFragment;
import com.dev.rahul.opennews.ui.fragment.sources.adapter.SourceAdapter;
import com.dev.rahul.opennews.ui.fragment.sources.adapter.SourceAdapterMVP;
import com.dev.rahul.opennews.ui.fragment.sources.adapter.SourceAdapterPresenter;
import com.dev.rahul.opennews.util.RLog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SourceFragment extends BaseFragment implements SourceMVP.IView {

    public static final String TAG = SourceFragment.class.getSimpleName();

    @BindView(R.id.recyclerSource)
    RecyclerView recyclerSource;

    private Context context;
    private SourceMVP.IPresenter presenter;
    private SourceAdapterMVP.IPresenter adapterPresenter;

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
        ButterKnife.bind(this,view);
        context = getBaseContext();

        HomeViewModel viewModel = ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication()).create(HomeViewModel.class);

        presenter = viewModel.getSourcePresenter();
        presenter.onAttach(this);
        presenter.fetchSourcesFromLocal();

        recyclerSource.setHasFixedSize(true);
        recyclerSource.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public void onDestroyView() {
        presenter.onDestroy();
        super.onDestroyView();
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void showSourceList(List<Sources> list) {
        RLog.print(TAG, "showSourceList : list is " + (list == null), RLog.ERROR);

        adapterPresenter = new SourceAdapterPresenter(list);
        recyclerSource.setAdapter(new SourceAdapter(adapterPresenter));
    }
}
