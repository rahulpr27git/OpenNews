package com.dev.rahul.opennews.ui.fragment.sources;

import com.dev.rahul.opennews.api.Retro;
import com.dev.rahul.opennews.app.NewsApp;
import com.dev.rahul.opennews.pojo.Response;
import com.dev.rahul.opennews.pojo.Sources;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rahul on 4/3/18.
 */

public class SourceRepository implements SourceMVP.IRepository {
    @Override
    public Single<Response> getSourcesNetwork() {
        return Retro.SERVICE.getNewsSource()
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Single<List<Sources>> getSources(String country, String language, String category) {
        return NewsApp.getDb()
                .sourceDao()
                .getSourcesByCountryOrLanguageOrCategory(
                        country, language, category
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<List<Sources>> getSources() {
        return NewsApp.getDb()
                .sourceDao()
                .getAllSources()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void insertIntoSourceTable(List<Sources> list) {
        NewsApp.getDb()
                .sourceDao()
                .insert(list);
    }
}
