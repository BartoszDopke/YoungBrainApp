package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserPanelActivity extends AppCompatActivity {

    private Button settings_btn, progress_btn, dailychallenge_btn, premium_btn, logout_btn, training_btn;
    private TextView NickNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_panel);
        String username = getIntent().getStringExtra("username");

        NickNameText =  findViewById(R.id.nickname);
        NickNameText.setText(username);

        settings_btn = findViewById(R.id.settings_user_panel_button);
        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Settings();
            }
        });

        progress_btn = findViewById(R.id.progress_button);
        progress_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyProgress();
            }
        });

        dailychallenge_btn = findViewById(R.id.challenge_button);
        dailychallenge_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DailyChallenge();
            }
        });

        premium_btn = findViewById(R.id.premium_button);
        premium_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Premium();
            }
        });

        logout_btn = findViewById(R.id.logout_button);
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackToMenu();
                finish();
            }
        });

        training_btn = findViewById(R.id.start_freetraining_button);
        training_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Training();
            }
        });
        //String username = getIntent().getStringExtra("USERNAME");

        //final TextView textViewToChange = (TextView) findViewById(R.id.nickname);
        //textViewToChange.setText(username);








    }

    private void Training() {
        Intent intent = new Intent(this, MathChainActivity.class);
        startActivity(intent);
    }

    private void BackToMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void Premium() {
        Intent intent = new Intent(this,PremiumActivity.class);
        startActivity(intent);
    }

    private void DailyChallenge() {
        Intent intent = new Intent(this,DailyChallengeActivity.class);
        startActivity(intent);
    }

    private void MyProgress() {
        Intent intent = new Intent(this,MyProgressActivity.class);
        startActivity(intent);
    }

    private void Settings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

}
