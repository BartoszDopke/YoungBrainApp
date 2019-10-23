package com.example.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.inzynierka.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private Button button_login, button_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_login =  findViewById(R.id.button);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        button_signup = findViewById(R.id.button2);
        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Settings();
            }
        });
    }

    public void Login()
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void Settings()
    {
        Intent intent = new Intent(this,SettingsActivity.class);
        startActivity(intent);
    }
}
