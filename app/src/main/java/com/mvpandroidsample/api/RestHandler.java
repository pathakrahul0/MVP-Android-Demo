git package com.mvpandroidsample.api;

import android.content.Context;


import com.mvpandroidsample.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestHandler {

    Retrofit retrofit;
    RetrofitListener retrofitListener;
    Context context;

    public RestHandler(RetrofitListener retrofitListener, Context context) {
        this.retrofitListener = retrofitListener;
        this.context = context;

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();
    }

    public RestInterface getClient(){
        return retrofit.create(RestInterface.class);
    }

    public void makeHttpRequest(Call call, final Method method){


        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                retrofitListener.onSuccess(response,method);

            }

            @Override
            public void onFailure(Call call, Throwable t) {

                retrofitListener.onFailure(t.getMessage());
            }
        });
    }
}
