package com.dev.covid19stats.ui;

import android.content.Context;
import android.content.SharedPreferences;

public class ThemeSwitch {
    SharedPreferences mSwitch;

    public ThemeSwitch(Context context){
        mSwitch = context.getSharedPreferences("filename",Context.MODE_PRIVATE);

    }
    void setDarkMode(Boolean state){
        SharedPreferences.Editor editor = mSwitch.edit();
        editor.putBoolean("DarkMode",state);
        editor.apply();
    }

    //load dark mode
    public Boolean loadDarkMode(){
        Boolean state = mSwitch.getBoolean("DarkMode",false);
        return state;
    }
}
