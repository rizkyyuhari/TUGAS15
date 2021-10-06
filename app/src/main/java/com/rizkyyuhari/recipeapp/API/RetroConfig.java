package com.rizkyyuhari.recipeapp.API;

import static com.rizkyyuhari.recipeapp.Util.CONFIGUTIL.*;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroConfig {

    private static Retrofit retrofit;

    public static Retrofit retrofitConnect(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}