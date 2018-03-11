package com.dev.rahul.opennews.api;

import com.dev.rahul.opennews.pojo.Response;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/**
 * Created by rahul on 10/3/18.
 */

public interface APIService {

    @Headers("X-Api-Key : " + API.API_KEY)
    @GET(API.SOURCE)
    Single<Response> getNewsSource(@QueryMap Map<String,String> queries);

    @Headers("X-Api-Key : " + API.API_KEY)
    @GET(API.SOURCE)
    Single<Response> getNewsSource();
}
