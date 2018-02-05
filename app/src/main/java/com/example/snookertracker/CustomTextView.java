package com.example.snookertracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by shreyagarge on 2/5/18.
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

    private static final float DEFAULT_FONT_SIZE = 15.0f;
    private static float font_size;
    private static SharedPreferences preferences;
    private static final String pref_name = "FONT_SIZE_PREF";
    private static final String FONT_SIZE_PREF = "font_size";


    public CustomTextView(Context context) {
        super(context); //call to super class with preset attributes
        init(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs); // call to super class with attributes passed from xml
        init(context);
    }

    private void init(Context context) {
        font_size = getPrefs(context).getFloat(/*get saved fontsize*/FONT_SIZE_PREF,
                /*If its not available return default*/ DEFAULT_FONT_SIZE);

        setTextSize(font_size);
        updateFontSize(context, font_size);
    }

    public static void updateFontSize(Context context, float size) {
        font_size = size;
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putFloat(FONT_SIZE_PREF, size);
        editor.apply();
    }


    private static SharedPreferences getPrefs(Context context) {
        if (preferences == null) {
            preferences = context.getSharedPreferences(pref_name, 0);
        }
        return preferences;
    }

}
