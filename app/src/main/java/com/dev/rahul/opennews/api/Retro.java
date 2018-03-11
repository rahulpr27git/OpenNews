package com.dev.rahul.opennews.api;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rahul on 10/3/18.
 */

public interface Retro {

    retrofit2.Retrofit RETROFIT = new retrofit2.Retrofit.Builder()
            .baseUrl(API.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    APIService SERVICE = RETROFIT.create(APIService.class);
}
