package com.rizkyyuhari.recipeapp.Util;

import android.content.Context;
import android.content.SharedPreferences;

import com.rizkyyuhari.recipeapp.R;

public class SessionManager {
    private Context context;
    private SharedPreferences sharedPreferences;

    public SessionManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file_key),context.MODE_PRIVATE);
    }

    public boolean isUserLogin(){
        return sharedPreferences.getBoolean(context.getString(R.string.pref_is_user_login),false);
    }

    public void updateUserLoginStatus(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getString(R.string.pref_is_user_login),status);
        editor.apply();
    }

    public void saveNamedofUser(String name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_name_of_user),name);
        editor.apply();
    }

    public String getNamaofUser(){
        return sharedPreferences.getString(context.getString(R.string.pref_name_of_user),"Unknown");
    }

    public String isOpenedOnce(){
        return "";
    }


}
