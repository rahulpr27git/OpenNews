package com.dev.rahul.opennews.ui.fragment.sources.adapter;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.dev.rahul.opennews.R;
import com.dev.rahul.opennews.pojo.Sources;
import com.dev.rahul.opennews.ui.base.BaseAdapter;
import com.dev.rahul.opennews.ui.base.BaseHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rahul on 18/3/18.
 */

public class SourceAdapter<T extends SourceAdapter.SourceHolder, E extends Sources, P extends SourceAdapterMVP.IPresenter<T,E>>
        extends BaseAdapter<T,E,P> {

    public SourceAdapter(P presenter) {
        super(presenter);
    }

    @Override
    public T getHolder(ViewGroup parent, int viewType) {
        return (T) new SourceHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycler_sources, parent, false)
        );
    }

    class SourceHolder extends BaseHolder implements SourceAdapterMVP.IVew {

        @BindView(R.id.imgSource)
        AppCompatImageView imgSource;
        @BindView(R.id.tvSourceName)
        AppCompatTextView tvSourceName;
        @BindView(R.id.tvCategory)
        AppCompatTextView tvCategory;
        @BindView(R.id.tvLanguage)
        AppCompatTextView tvLanguage;
        @BindView(R.id.tvDescription)
        AppCompatTextView tvDescription;

        public SourceHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void showImage(String url) {
            Glide.with(imgSource.getContext())
                    .load(url)
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC)
                    .centerCrop())
                    .into(imgSource);
        }

        @Override
        public void showName(String name) {
            tvSourceName.setText(name);
        }

        @Override
        public void showCategory(String category) {
            tvCategory.setText(category);
        }

        @Override
        public void showLanguage(String language) {
            tvLanguage.setText(language);
        }

        @Override
        public void showDescription(String description) {
            tvDescription.setText(description);
        }
    }
}
