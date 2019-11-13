package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pracainzynierska.inzynierka.R;

public class DailyChallengeActivity extends AppCompatActivity {

    Button showmeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_challenge);

        showmeButton = findViewById(R.id.showdailychallengebutton);
        showmeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DailyChallengeActivity.this, DailyChallengePopUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
