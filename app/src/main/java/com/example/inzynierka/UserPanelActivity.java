package com.example.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserPanelActivity extends AppCompatActivity {

    private Button settings_btn, progress_btn, dailychallenge_btn, premium_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_panel);

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
