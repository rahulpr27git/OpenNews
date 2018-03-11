package com.dev.rahul.opennews.ui.fragment.sources;

import com.dev.rahul.opennews.pojo.Response;
import com.dev.rahul.opennews.ui.base.IBasePresenter;
import com.dev.rahul.opennews.ui.base.IBaseView;

import java.util.HashMap;

import io.reactivex.Single;

/**
 * Created by rahul on 4/3/18.
 */

public interface SourceMVP {

    interface IView extends IBaseView {

    }

    interface IPresenter<V extends IView> extends IBasePresenter<V> {

    }

    interface IRepository {
        Single<Response> getSources(HashMap<String, String> queries);
    }
}
