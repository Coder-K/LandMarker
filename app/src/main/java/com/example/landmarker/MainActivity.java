package com.example.landmarker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button GoLogin, GoRegister;
    private boolean permition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoLogin = findViewById(R.id.Login);
        GoRegister = findViewById(R.id.Register);

//        checkPermission ();

        Intent LoginPage = new Intent(MainActivity.this, LoginActivity.class);
        Intent RegisterPage = new Intent(MainActivity.this, RegisterActivity.class);

        GoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(RegisterPage);
            }
        });
        GoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(LoginPage);
            }
        });

    }
}