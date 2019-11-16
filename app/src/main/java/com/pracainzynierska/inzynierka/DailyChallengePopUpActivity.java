package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import java.util.Locale;

import java.net.URI;
import java.util.Random;

public class DailyChallengePopUpActivity extends AppCompatActivity {

    public static String PACKAGE_NAME;



    Button exit_btn, imInButton;
    ImageButton play_btn, stop_btn;
    VideoView dailyChallengeVideoView;
    TextView dailyChallengeTextView, CountDownView, NickNameText;

    String[] dailyChallengeTextArrray = {
            "Do 30 push-ups during a day!",
            "Run 5km!",
            "Ride 10km by bike!",
            "Juggle for 10 minutes!",
            "Do 30 minutes long stretching session in the evening to release all tension in your body!",
            "Make 5000 steps today! Download an app for it to track your progress!"
    };

    int[] videos = {
            R.raw.pushup,
            R.raw.running,
            R.raw.bike,
            R.raw.juggling,
            R.raw.stretching,
            R.raw.walking
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_challenge_pop_up);
        PACKAGE_NAME = getApplicationContext().getPackageName();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .8));




        dailyChallengeVideoView = findViewById(R.id.dailyChallengeVideoView);

        final int randomVideo = new Random().nextInt(videos.length);
        String videoString = "";

        if (randomVideo == 0) {
            //pushup
            videoString = dailyChallengeTextArrray[0];
        } else if (randomVideo == 1) {
            //running
            videoString = dailyChallengeTextArrray[1];
        } else if (randomVideo == 2) {
            //bike
            videoString = dailyChallengeTextArrray[2];
        } else if (randomVideo == 3) {
            //juggling
            videoString = dailyChallengeTextArrray[3];
        } else if (randomVideo == 4) {
            //stretching
            videoString = dailyChallengeTextArrray[4];
        } else if (randomVideo == 5) {
            //walking
            videoString = dailyChallengeTextArrray[5];
        }


        dailyChallengeTextView = findViewById(R.id.dailyChallengeTextView);
        dailyChallengeTextView.setText("" + videoString);

        exit_btn = findViewById(R.id.exit_btn2);
        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        play_btn = findViewById(R.id.playButton);
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + videos[randomVideo]);
                dailyChallengeVideoView.setVideoURI(uri);
                dailyChallengeVideoView.start();
            }
        });

        stop_btn = findViewById(R.id.stopButton);
        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dailyChallengeVideoView.stopPlayback();
            }
        });


    }
}
