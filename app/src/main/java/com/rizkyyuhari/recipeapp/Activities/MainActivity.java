package com.rizkyyuhari.recipeapp.Activities;

import static com.rizkyyuhari.recipeapp.Util.CONFIGUTIL.HEX_COLOR_WHITE;
import static com.rizkyyuhari.recipeapp.Util.Utility.lightStatusBar;
import static com.rizkyyuhari.recipeapp.Util.Utility.setStatusColor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.rizkyyuhari.recipeapp.Adapter.VPAdapter;
import com.rizkyyuhari.recipeapp.R;
import com.rizkyyuhari.recipeapp.Util.SessionManager;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    private Button btnLogout;
    private SessionManager sessionManager;
    private TabLayout tablayout;
    private ViewPager viewpagerhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setTheme
        setTheme(R.style.Theme_newRecipe);
        setContentView(R.layout.activity_main);

        //setStatusBarColor
        setStatusColor(getWindow(), HEX_COLOR_WHITE);
        lightStatusBar(getWindow(), true);

        String uname = getIntent().getStringExtra("uname");
        initView();


        //tablayout
        tablayout.setupWithViewPager(viewpagerhome);
        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new NewRecipesFragment(), "NEW RECIPE");
        vpAdapter.addFragment(new FavoritesFragment(), "FAVORITE");
        vpAdapter.addFragment(new CategoriesFragment(), "CATEGORIES");
        viewpagerhome.setAdapter(vpAdapter);

        sessionManager = new SessionManager(this);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.updateUserLoginStatus(false);
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });


    }

    private void initView() {
        btnLogout = (Button) findViewById(R.id.btn_logout);

        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpagerhome = (ViewPager) findViewById(R.id.viewpagerhome);
    }//initview
}