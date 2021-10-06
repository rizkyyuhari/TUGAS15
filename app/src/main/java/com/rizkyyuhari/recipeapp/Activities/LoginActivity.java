package com.rizkyyuhari.recipeapp.Activities;

import static com.rizkyyuhari.recipeapp.Util.CONFIGUTIL.HEX_COLOR_BLACK;
import static com.rizkyyuhari.recipeapp.Util.Utility.lightStatusBar;
import static com.rizkyyuhari.recipeapp.Util.Utility.setStatusColor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.rizkyyuhari.recipeapp.API.ApiInterface;
import com.rizkyyuhari.recipeapp.API.RetroConfig;
import com.rizkyyuhari.recipeapp.R;
import com.rizkyyuhari.recipeapp.Util.SessionManager;
import com.rizkyyuhari.recipeapp.models.login.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    private Button btnLogin;
    private TextInputEditText tieUsername;
    private TextInputEditText tiePassword;

    private SessionManager sessionManager;


    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //set status bar and and set color to widget inside status bar
        setStatusColor(getWindow(), HEX_COLOR_BLACK);
        lightStatusBar(getWindow(), false);

        initView();

        sessionManager = new SessionManager(this);
        if (sessionManager.isUserLogin()) {
            String name = sessionManager.getNamaofUser();
            startActivity(new Intent(LoginActivity.this, MainActivity.class).putExtra("uname", name));

            finish();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = tieUsername.getText().toString();
                String pw = tiePassword.getText().toString();
                performLogin(uname, pw);
            }
        });


    }

    private void initView() {
        btnLogin = (Button) findViewById(R.id.btn_login);
        tieUsername = (TextInputEditText) findViewById(R.id.tie_username);
        tiePassword = (TextInputEditText) findViewById(R.id.tie_password);

    }


    //call to database using retrofit
    private void performLogin(String username, String password) {
        apiInterface = RetroConfig.retrofitConnect().create(ApiInterface.class);
        Call<Login> loginCall = apiInterface.loginResponse(username, password);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.code() == 200) {
                    if (response.body().getStatus().equals("ok")) {
                        if (response.body().getResultCode() == 1) {

                            String name = response.body().getUname();
                            sessionManager.updateUserLoginStatus(true);
                            sessionManager.saveNamedofUser(name);

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("uname", name);
                            startActivity(intent);

                            finish();
                        }
                    }
                    if (response.body().getStatus().equals("Username atau password tak ada")) {
                        Toast.makeText(LoginActivity.this, "Username atau password tak sesuai", Toast.LENGTH_SHORT).show();
                        tiePassword.setText("");
                        tieUsername.setText("");
                    }
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
