package com.mvpandroidsample;

import android.view.View;

public class AppPinPresenter implements AppPinConf.Presenter {

    private AppPinConf.View view;
    private PinModel model;

    public AppPinPresenter(AppPinConf.View view) {
        this.view = view;
        model = new PinModel();
    }

    @Override
    public void loadNextScreen() {
        view.navigateToNextPage();
    }

    @Override
    public void defaultSettings() {
        view.setButtonColor(R.color.lightGrey,R.color.white);
        view.showOnButtonClick(false);
        view.showTickImage(View.INVISIBLE);
    }

    @Override
    public void verifyEntries() {
        view.setButtonColor(R.color.colorAccent,R.color.white);
        view.showOnButtonClick(true);
        view.showTickImage(View.VISIBLE);
    }

    @Override
    public void savePassword(String password) {
        model.setPin(password);
    }

    @Override
    public String appendIndvidualPassword(String first, String second, String third, String fourth) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(first).append(second).append(third).append(fourth);
        return stringBuilder.toString();
    }
}
