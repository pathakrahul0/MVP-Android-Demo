package com.mvpandroidsample.validator;

import android.widget.EditText;

public class Validator {
    EditText editText;
    Type type;

    public Validator(EditText editText, Type type) {
        this.editText = editText;
        this.type = type;
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
