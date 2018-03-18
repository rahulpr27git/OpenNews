package com.dev.rahul.opennews.ui.fragment.sources.adapter;

import com.dev.rahul.opennews.pojo.Sources;
import com.dev.rahul.opennews.ui.base.IBaseAdapterPresenter;

/**
 * Created by rahul on 18/3/18.
 */

public interface SourceAdapterMVP {

    interface IVew {
        void showImage(String url);
        void showName(String name);
        void showCategory(String category);
        void showLanguage(String language);
        void showDescription(String description);
    }

    interface IPresenter<T extends SourceAdapter.SourceHolder, E extends Sources>
            extends IBaseAdapterPresenter<T,E> {

    }
}
