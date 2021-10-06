package com.rizkyyuhari.recipeapp.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.rizkyyuhari.recipeapp.Adapter.SliderAdapter;
import com.rizkyyuhari.recipeapp.R;
import com.rizkyyuhari.recipeapp.Util.SessionManager;

public class Onboarding extends AppCompatActivity {

    private ViewPager viewpager;


    SliderAdapter sliderAdapter;
    private Button btnGetStarted;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        initView();






        sliderAdapter = new SliderAdapter(this);
        viewpager.setAdapter(sliderAdapter);

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Onboarding.this,LoginActivity.class);
                startActivity(intent);
            }
        });


    }


    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.slider);

        btnGetStarted = (Button) findViewById(R.id.btn_getStarted);
    }


}