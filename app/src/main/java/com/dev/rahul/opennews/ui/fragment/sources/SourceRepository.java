package com.dev.rahul.opennews.ui.fragment.sources;

import com.dev.rahul.opennews.api.Retro;
import com.dev.rahul.opennews.pojo.Response;

import java.util.HashMap;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rahul on 4/3/18.
 */

public class SourceRepository implements SourceMVP.IRepository {
    @Override
    public Single<Response> getSources(HashMap<String, String> queries) {
        return Retro.SERVICE.getNewsSource(queries)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
