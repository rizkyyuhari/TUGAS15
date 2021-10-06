package com.rizkyyuhari.recipeapp.Util;

import static com.rizkyyuhari.recipeapp.Util.CONFIGUTIL.HEX_COLOR_BLACK;

import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;


import androidx.annotation.RequiresApi;
import androidx.core.view.WindowInsetsControllerCompat;

public class Utility {

    public static void lightStatusBar(Window window, Boolean isLigth){
        WindowInsetsControllerCompat wic = new WindowInsetsControllerCompat(window,window.getDecorView());
        wic.setAppearanceLightStatusBars(isLigth);
        wic.setAppearanceLightNavigationBars(isLigth);
    }

    public static final void setStatusColor(Window window,String color){
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        int myColor = Color.parseColor(color);
        window.setStatusBarColor(myColor);
    }
}
