package com.mvpandroidsample.login;

public class LoginModel {

    private LoginResponse loginResponse;
    private Boolean isFieldValid = false;

    public LoginResponse getLoginResponse() {
        return loginResponse;
    }

    public void setLoginResponse(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
    }

    public Boolean getFieldValid() {
        return isFieldValid;
    }

    public void setFieldValid(Boolean fieldValid) {
        isFieldValid = fieldValid;
    }
}
