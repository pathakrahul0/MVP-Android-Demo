package com.mvpandroidsample.api;

import retrofit2.Response;

public interface RetrofitListener {

    void onSuccess(Response response, Method method);
    void onFailure(String message);

}
