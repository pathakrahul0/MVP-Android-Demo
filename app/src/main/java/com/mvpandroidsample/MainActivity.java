package com.mvpandroidsample;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements AppPinConf.View, View.OnClickListener {


    private AppPinConf.Presenter presenter;
    private Button btFinish;
    private EditText etNewPin1;
    private EditText etNewPin2;
    private EditText etNewPin3;
    private EditText etNewPin4;
    private EditText etConfirmPin1;
    private EditText etConfirmPin2;
    private EditText etConfirmPin3;
    private EditText etConfirmPin4;
    private ImageView ivNewPin;
    private ImageView ivConfirmPin;
    private String password1;
    private String password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new AppPinPresenter(this);
        btFinish = (Button) findViewById(R.id.btFinish);
        etNewPin1 = (EditText) findViewById(R.id.etNewPin1);
        etNewPin2 = (EditText) findViewById(R.id.etNewPin2);
        etNewPin3 = (EditText) findViewById(R.id.etNewPin3);
        etNewPin4 = (EditText) findViewById(R.id.etNewPin4);
        etConfirmPin1 = (EditText) findViewById(R.id.etConfirmPin1);
        etConfirmPin2 = (EditText) findViewById(R.id.etConfirmPin2);
        etConfirmPin3 = (EditText) findViewById(R.id.etConfirmPin3);
        etConfirmPin4 = (EditText) findViewById(R.id.etConfirmPin4);
        ivNewPin = (ImageView) findViewById(R.id.ivNewPin);
        ivConfirmPin = (ImageView) findViewById(R.id.ivConfirmPin);

        etNewPin1.addTextChangedListener(textWatcher);
        etNewPin2.addTextChangedListener(textWatcher);
        etNewPin3.addTextChangedListener(textWatcher);
        etNewPin4.addTextChangedListener(textWatcher);
        etConfirmPin1.addTextChangedListener(textWatcher);
        etConfirmPin2.addTextChangedListener(textWatcher);
        etConfirmPin3.addTextChangedListener(textWatcher);
        etConfirmPin4.addTextChangedListener(textWatcher);

        presenter.defaultSettings();
        btFinish.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btFinish:
                presenter.loadNextScreen();
                break;
        }
    }

    @Override
    public void showOnButtonClick(Boolean value) {
        btFinish.setEnabled(value);
    }

    @Override
    public void setButtonColor(int buttonBackgroundColor, int buttonTextColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                btFinish.setBackgroundTintList(getResources().getColorStateList(buttonBackgroundColor,this.getTheme()));
            }
            btFinish.setTextColor(getResources().getColor(buttonTextColor));
        }
        //btFinish.setBackgroundColor(getResources().getColor(buttonBackgroundColor));

    }

    @Override
    public void showTickImage(int value) {

        ivNewPin.setVisibility(value);
        ivConfirmPin.setVisibility(value);

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void navigateToNextPage() {

    }


    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            EditText editText = (EditText) getCurrentFocus();
            if (editText != null && editText.length() > 0) {
                View next = editText.focusSearch(View.FOCUS_RIGHT);
                if (next != null) {
                    next.requestFocus();
                }

            }
            password1 = presenter.appendIndvidualPassword(etNewPin1.getText().toString(), etNewPin2.getText().toString(), etNewPin3.getText().toString(), etNewPin4.getText().toString());
            password2 = presenter.appendIndvidualPassword(etConfirmPin1.getText().toString(), etConfirmPin2.getText().toString(), etConfirmPin3.getText().toString(), etConfirmPin4.getText().toString());

           if (password1.equals(password2) && !password1.isEmpty() && !password2.isEmpty()) {
                presenter.verifyEntries();
                presenter.savePassword(password1);
                return;
            } else {
                presenter.defaultSettings();
                return;
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
