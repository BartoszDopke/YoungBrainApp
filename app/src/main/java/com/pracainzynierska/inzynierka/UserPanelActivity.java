package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class UserPanelActivity extends AppCompatActivity {

    private Button settings_btn, progress_btn, dailychallenge_btn, premium_btn, logout_btn, training_btn;
    private TextView NickNameText, rankText, isDoneText;

    String[] rankArray = {
            "Sahelanthropus",
            "Orrorin",
            "Ardipithecus",
            "Australopithecus",
            "Paranthopus",
            "Homo habilis",
            "Homo erectus",
            "Homo neanderthalensis",
            "Homo sapiens"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_panel);
        rankText = findViewById(R.id.rank);

        String username = getIntent().getStringExtra("username");
        NickNameText =  findViewById(R.id.nickname);
        NickNameText.setText(username);

        SharedPreferences preferences =  this.getSharedPreferences(NickNameText.getText().toString(), Context.MODE_PRIVATE);

        String isDoneString = preferences.getString("done","-");
        isDoneText = findViewById(R.id.isDoneText);
        isDoneText.setVisibility(View.INVISIBLE);
        isDoneText.setText("" + isDoneString);

        int totalScore = preferences.getInt("total_score",0);

        if(totalScore <= 2000)
        {
            rankText.setText(rankArray[0]);
        }
        else if (totalScore > 2000 && totalScore <= 5000)
        {
            rankText.setText(rankArray[1]);
        }
        else if (totalScore > 5000 && totalScore <= 10000)
        {
            rankText.setText(rankArray[2]);
        }
        else if (totalScore > 10000 && totalScore <= 20000)
        {
            rankText.setText(rankArray[3]);
        }
        else if (totalScore > 20000 && totalScore <= 40000)
        {
            rankText.setText(rankArray[4]);
        }
        else if (totalScore > 40000 && totalScore <= 60000)
        {
            rankText.setText(rankArray[5]);
        }
        else if (totalScore > 60000 && totalScore <= 80000)
        {
            rankText.setText(rankArray[6]);
        }
        else if (totalScore > 80000 && totalScore <= 100000)
        {
            rankText.setText(rankArray[7]);
        }
        else if (totalScore > 100000)
        {
            rankText.setText(rankArray[8]);
        }





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


    }

    public void Training() {
        String isDoneString = isDoneText.getText().toString();
        SharedPreferences preferences =  this.getSharedPreferences(NickNameText.getText().toString(), Context.MODE_PRIVATE);
        int totalScore = preferences.getInt("total_score",0);
        if(isDoneString.equals("done"))
        {
            if(totalScore > 0 && totalScore <= 2000)
            {
                Intent intent = new Intent(this, RememberTheSequenceEasyActivity.class);
                String user = NickNameText.getText().toString();
                intent.putExtra("username",user);
                startActivity(intent);
            }
            else if(totalScore > 2000 && totalScore <= 5000)
            {
                Intent intent = new Intent(this, RememberTheSequenceMediumActivity.class);
                String user = NickNameText.getText().toString();
                intent.putExtra("username",user);
                startActivity(intent);
            }
            else if(totalScore > 5000)
            {
                Intent intent = new Intent(this, RememberTheSequenceHardActivity.class);
                String user = NickNameText.getText().toString();
                intent.putExtra("username",user);
                startActivity(intent);
            }
        }
        else
        {
            Intent intent = new Intent(this, IntroductionActivity.class);
            String user = NickNameText.getText().toString();
            intent.putExtra("username",user);
            startActivity(intent);
        }
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
        String user = NickNameText.getText().toString();
        intent.putExtra("username",user);
        startActivity(intent);
    }

    private void Settings() {
        Intent intent = new Intent(this, SettingsActivity.class);

        startActivity(intent);
    }

}
