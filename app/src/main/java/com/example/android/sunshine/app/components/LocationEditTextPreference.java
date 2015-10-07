package com.example.android.sunshine.app.components;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.sunshine.app.R;

/**
 * Created by davidduque on 10/7/15.
 */
public class LocationEditTextPreference extends EditTextPreference {

    private static final int DEFAULT_MINIMUM_LOCATION_LENGTH = 3;
    private int mMinLength;

    public LocationEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.LocationEditTextPreference, 0, 0);
        try {
            mMinLength = a.getInteger(R.styleable.LocationEditTextPreference_minLength,
                    DEFAULT_MINIMUM_LOCATION_LENGTH);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);

        final EditText editText = getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //nothing to do
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //nothing to do
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Dialog dialog = getDialog();

                if (dialog instanceof AlertDialog) {
                    Button okBtn = ((AlertDialog)dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    String text = editable.toString();
                    boolean enabled = text.length()>=mMinLength;
                    okBtn.setEnabled(enabled);
                }
            }
        });
    }

    public int getMinLength() {
        return mMinLength;
    }
}
