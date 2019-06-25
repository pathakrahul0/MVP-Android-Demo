package com.mvpandroidsample.login;

import android.content.Context;
import android.widget.EditText;


import com.mvpandroidsample.api.Method;
import com.mvpandroidsample.api.RestHandler;
import com.mvpandroidsample.api.RetrofitListener;
import com.mvpandroidsample.validator.Type;
import com.mvpandroidsample.validator.Validate;
import com.mvpandroidsample.validator.Validator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class LoginPresenter implements LoginConf.Presenter, Validate.OnValidate, RetrofitListener {

    LoginConf.View view;
    LoginModel loginModel;
    List<Validator> validatorList;
    Context context;
    RestHandler restHandler;

    public LoginPresenter(LoginConf.View view, Context context) {
        this.view = view;
        this.context = context;
        loginModel = new LoginModel();
        validatorList = new ArrayList<>();
        restHandler = new RestHandler(this, context);
    }

    @Override
    public void defaultSettings() {

        view.hideLoader();
    }

    @Override
    public void addValidator(EditText editText, Type type) {

        Validator validator = new Validator(editText, type);
        validatorList.add(validator);
    }

    @Override
    public Boolean validateField(String value, Type type) {

        return new Validate(context, value, type, this).validate();

    }

    @Override
    public Boolean validateField(String value, Type type, Integer id) {

        return new Validate(context, value, type, id, this).validate();
    }

    @Override
    public void validateOnSubmit() {

        for (Validator validator : validatorList) {
            loginModel.setFieldValid(validateField(validator.getEditText().getText().toString().trim(), validator.getType(), validator.getEditText().getId()));
            if (!loginModel.getFieldValid()) {
                break;
            }
        }

    }


    @Override
    public void doLogin(String username, String password) {

        if (loginModel.getFieldValid()) {
            view.showLoader();
            restHandler.makeHttpRequest(restHandler.getClient().login(username, password, "abc123", "android"), Method.LOGIN);
        }
    }

    @Override
    public void loadNextScreen() {

    }

    @Override
    public void setOnValidateSuccess(Type type) {

    }

    @Override
    public void setOnValidateSuccess(Type type, Integer id) {

    }

    @Override
    public void setOnValidateError(Type type, String message) {

    }

    @Override
    public void setOnValidateError(Type type, Integer id, String message) {

        view.showValidationError(message, id);
    }

    @Override
    public void onSuccess(Response response, Method method) {

        view.hideLoader();
        switch (method) {
            case LOGIN:
                LoginResponse loginResponse = (LoginResponse) response.body();
                if (loginResponse != null) {
                    if (loginResponse.getStatus() == 200){
                        view.showSuccessMessage(loginResponse.getMessage());
                    }else {
                        view.showError(loginResponse.getMessage());
                    }

                }
                break;
        }
    }

    @Override
    public void onFailure(String message) {

        view.hideLoader();
        view.showError(message);
    }
}
