package com.pracainzynierska.inzynierka;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DailyChallengeActivity extends AppCompatActivity {

    public static final long START_TIME_IN_MILLIS=86400000;
    public TextView mTextViewCountDown, NickNameText, frontText;
    public Button mButtonStartPause;
    public Button mButtonReset, showDailyChallengeButton;

    public CountDownTimer mCountDownTimer;

    public boolean mTimerRunning;

    public long mTimeLeftInMillis;
    public long mEndTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_challenge);
        //Log.i("timer", "TimerRunning value: " + mTimerRunning);
        String username = getIntent().getStringExtra("username");
        NickNameText =  findViewById(R.id.usernameTextView);
        NickNameText.setVisibility(View.INVISIBLE);
        NickNameText.setText(username);



        AssetManager am = getApplicationContext().getAssets();
        Typeface logoFont = Typeface.createFromAsset(am, String.format(Locale.ENGLISH, "fonts/%s","FjallaOne-Regular.ttf"));
        frontText = findViewById(R.id.dailyChallengeTextView);
        frontText.setTypeface(logoFont);

        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mButtonStartPause = findViewById(R.id.imInButton);
        mButtonReset = findViewById(R.id.resetButton);
        mButtonReset.setVisibility(View.INVISIBLE);
        showDailyChallengeButton = findViewById(R.id.showdailychallengebutton);
        showDailyChallengeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DailyChallengeActivity.this, DailyChallengePopUpActivity.class);
                startActivity(intent);
            }
        });

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }

    private void startTimer() {
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                updateButtons();
            }
        }.start();

        mTimerRunning = true;
        updateButtons();
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateButtons();
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        updateButtons();
    }

    private void updateCountDownText() {
        //int hours = (int)
        //int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        //int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(mTimeLeftInMillis)%60,
                TimeUnit.MILLISECONDS.toMinutes(mTimeLeftInMillis)%60,
                TimeUnit.MILLISECONDS.toSeconds(mTimeLeftInMillis) % 60);

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    private void updateButtons() {
        if (mTimerRunning) {
            mButtonReset.setVisibility(View.INVISIBLE);
            showDailyChallengeButton.setEnabled(false);
            mButtonStartPause.setText("Pause");
        } else {
            mButtonStartPause.setText("Start");
            showDailyChallengeButton.setEnabled(true);

            if (mTimeLeftInMillis < 1000) {
                mButtonStartPause.setVisibility(View.INVISIBLE);
            } else {
                mButtonStartPause.setVisibility(View.VISIBLE);
            }

            if (mTimeLeftInMillis < START_TIME_IN_MILLIS) {
                mButtonReset.setVisibility(View.VISIBLE);
            } else {
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences prefs = getSharedPreferences("dailychallenge2_preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int dailyChallengeScore = prefs.getInt("dailychallenge_score",0);
        dailyChallengeScore = dailyChallengeScore + 100;
        editor.putInt("dailychallenge_score",dailyChallengeScore);
        editor.putLong("millisLeft", mTimeLeftInMillis);
        editor.putBoolean("timerRunning", mTimerRunning);
        editor.putLong("endTime", mEndTime);

        editor.apply();

        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = getSharedPreferences("dailychallenge2_preferences", MODE_PRIVATE);

        mTimeLeftInMillis = prefs.getLong("millisLeft", START_TIME_IN_MILLIS);
        mTimerRunning = prefs.getBoolean("timerRunning", false);

        updateCountDownText();
        updateButtons();

        if (mTimerRunning) {
            mEndTime = prefs.getLong("endTime", 0);
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();

            if (mTimeLeftInMillis < 0) {
                mTimeLeftInMillis = 0;
                mTimerRunning = false;
                updateCountDownText();
                updateButtons();
            } else {
                startTimer();
            }
        }
    }

}