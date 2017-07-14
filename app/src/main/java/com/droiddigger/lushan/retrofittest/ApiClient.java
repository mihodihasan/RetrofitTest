package com.droiddigger.lushan.retrofittest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mihodihasan on 7/13/17.
 */

public class ApiClient {

    private static final String baseURL="http://10.0.2.2/retrofitTest/";
    private static Retrofit retrofit;

    public static Retrofit getApiClient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(baseURL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
