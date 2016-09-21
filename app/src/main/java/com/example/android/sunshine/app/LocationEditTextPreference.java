package com.example.android.sunshine.app;

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

/**
 * Created by Danish Rafique on 21-09-2016.
 */
public class LocationEditTextPreference extends EditTextPreference{

    static final private int DEFAULT_MINIMUM_LOCATION_LENGTH = 2;
    private int mMinLength;

    public LocationEditTextPreference(Context context, AttributeSet attrs){

        super(context,attrs);
        /**
         * TypedArray -- Container for an array of values that were retrieved with
         * obtainStyledAttributes(AttributeSet, int[], int, int)
         * or obtainAttributes(AttributeSet, int[]). Be sure to call recycle()
         * when done with them. The indices used to retrieve values from this
         * structure correspond to the positions of the attributes given to
         * obtainStyledAttributes.
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.LocationEditTextPreference,0,0);
        try{

            //	getInteger(int index, int defValue)
           // Retrieve the integer value for the attribute at index.
            mMinLength = a.getInteger(R.styleable.LocationEditTextPreference_minLength, DEFAULT_MINIMUM_LOCATION_LENGTH);

        }finally {
            a.recycle(); //Recycles the TypedArray, to be re-used by a later caller.
        }

    }


    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);
        EditText et=getEditText();
        /**
         * addTextChangedListener(TextWatcher watcher)
         Adds a TextWatcher to the list of those whose methods
         are called whenever this TextView's text changes.
         */
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                Dialog d = getDialog();
                if( d instanceof AlertDialog){

                    AlertDialog dialog = (AlertDialog) d;
                    Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);

                    //Check if the EditText is empty
                    if(s.length()<mMinLength){
                        //Disable OK Button
                        positiveButton.setEnabled(false);
                    }else{
                        //Re-enable the button
                        positiveButton.setEnabled(true);
                    }
                }
            }
        });
    }
}
