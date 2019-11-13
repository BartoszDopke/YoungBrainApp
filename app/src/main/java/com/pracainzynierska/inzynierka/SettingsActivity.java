package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    Switch soundSwitch, notificationSwitch;
    Button changeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        changeButton = findViewById(R.id.nicknameChangeButton);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, ProfileEditActivity.class);
                startActivity(intent);
                finish();
            }
        });

        soundSwitch = findViewById(R.id.SoundSwitch);


        notificationSwitch = findViewById(R.id.NotificationSwitch);
    }
}
