package com.mvpandroidsample.login;

import android.widget.EditText;

import com.mvpandroidsample.validator.Type;


public interface LoginConf {

    interface View{

        void showLoader();
        void hideLoader();
        void showSuccessMessage(String message);
        void showError(String message);
        void showValidationError(String message, Integer id);
        void navigateToNextPage();
    }

    interface Presenter{

        void defaultSettings();
        void addValidator(EditText editText, Type type);
        Boolean validateField(String value, Type type);
        Boolean validateField(String value, Type type, Integer id);
        void validateOnSubmit();
        void doLogin(String username, String password);
        void loadNextScreen();
    }
}
