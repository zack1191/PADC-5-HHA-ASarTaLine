package com.hha.heinhtetaung.asataline.data.model;

import android.content.Context;

import com.google.gson.Gson;
import com.hha.heinhtetaung.asataline.network.api.ASarTaLineApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by E5 on 7/7/2018.
 */

public class BaseModel {
    protected ASarTaLineApi theApi;


    protected BaseModel(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-2/asartaline/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        theApi = retrofit.create(ASarTaLineApi.class);
    }
}
