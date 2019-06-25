package com.mvpandroidsample;

public interface AppPinConf {

    interface View{
        void showOnButtonClick(Boolean value);
        void setButtonColor(int buttonBackgroundColor, int buttonTextColor);
        void showTickImage(int value);
        void showError(String error);
        void navigateToNextPage();
    }

    interface Presenter {
        void loadNextScreen();
        void defaultSettings();
        void verifyEntries();
        void savePassword(String password);
        String appendIndvidualPassword(String first, String second, String third, String fourth);
    }
}
