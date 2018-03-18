package com.dev.rahul.opennews.ui.fragment.sources.adapter;

import com.dev.rahul.opennews.pojo.SourceImages;
import com.dev.rahul.opennews.pojo.Sources;
import com.dev.rahul.opennews.ui.base.BaseAdapterPresenter;

import java.util.List;

/**
 * Created by rahul on 18/3/18.
 */

public class SourceAdapterPresenter<T extends SourceAdapter.SourceHolder, E extends Sources>
        extends BaseAdapterPresenter<T,E> implements SourceAdapterMVP.IPresenter<T,E> {

    public SourceAdapterPresenter(List<E> list) {
        super(list);
    }

    @Override
    public void onBind(T holder, int position) {
        E model = getElementAtPos(position);

        holder.showImage(SourceImages.getImageById(model.getId()));
        holder.showCategory(model.getCategory());
        holder.showDescription(model.getDescription());
        holder.showLanguage(model.getLanguage());
        holder.showName(model.getName());
    }

    @Override
    public void onRecycle(T holder) {

    }
}
