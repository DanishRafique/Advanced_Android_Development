package com.example.android.sunshine.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.EditTextPreference;
import android.util.AttributeSet;

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
}
