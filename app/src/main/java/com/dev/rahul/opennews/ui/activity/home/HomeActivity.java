package com.dev.rahul.opennews.ui.activity.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.dev.rahul.opennews.R;
import com.dev.rahul.opennews.ui.base.BaseActivity;
import com.dev.rahul.opennews.ui.fragment.category.CategoryFragment;
import com.dev.rahul.opennews.ui.fragment.news.NewsFragment;
import com.dev.rahul.opennews.ui.fragment.sources.SourceFragment;
import com.dev.rahul.opennews.util.CPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private CPagerAdapter pagerAdapter;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    public int getFragmentContainerId() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        setUpPagerAdapter();
    }

    private void setUpPagerAdapter() {
        pagerAdapter = new CPagerAdapter(getSupportFragmentManager());
        pagerAdapter.add(new NewsFragment(), "Top Headlines");
        pagerAdapter.add(new SourceFragment(), "Sources");
        pagerAdapter.add(new CategoryFragment(), "Categories");

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onRefresh() {

    }
}
