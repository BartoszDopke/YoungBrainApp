package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FillTheTextActivity extends AppCompatActivity {

    TextView TextToFill, answerCheck, timerTextView, pointsView, usernameView;
    EditText EditTextFilling;
    Button confirmButton;
    String[] exampleTextArray = {
            "The lake is a long way from here.",
            "This is the last random sentence I will be writing and I am going to stop mid-sent",
            "We have never been to Asia, nor have we visited Africa.",
            "The stranger officiates the meal.",
            "He ran out of money, so he had to stop playing poker.",
            "The mysterious diary records the voice.",
            "We need to rent a room for our party.",
        "Where do random thoughts come from?"};
    String userResult, wordToFill;
    String choosenSentence;
    int randomChoice, player_points=0;
    String[] choosenSentenceArray;
    ArrayList<String> choosenSentenceList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_the_text);

        TextToFill = findViewById(R.id.TextToFill);
        EditTextFilling = findViewById(R.id.EditTextFilling);
        usernameView = findViewById(R.id.username_fillthetext);
        String user = getIntent().getStringExtra("username");
        usernameView.setVisibility(View.INVISIBLE);
        usernameView.setText(""+ user);

        answerCheck = findViewById(R.id.answer_check);
        answerCheck.setTextColor(Color.RED);

        randomChoice = new Random().nextInt(exampleTextArray.length);
        choosenSentence = exampleTextArray[randomChoice];
        choosenSentenceArray = choosenSentence.split(" ");
        choosenSentenceList = new ArrayList<>(Arrays.asList(choosenSentenceArray));
        wordToFill = choosenSentenceArray[new Random().nextInt(choosenSentenceArray.length)];
        wordToFill = wordToFill.toLowerCase();

        pointsView = findViewById(R.id.points_fillthetext);
        pointsView.setText("" + player_points);

        timerTextView = findViewById(R.id.timerView2);

        new CountDownTimer(60000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(""+ millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                saveScore();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FillTheTextActivity.this);
                alertDialogBuilder
                        .setMessage("Congratulations! You did the last exercise! Your points: " + player_points)
                        .setCancelable(false)
                        .setPositiveButton("BACK TO MENU", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), UserPanelActivity.class);
                                intent.putExtra("username",usernameView.getText().toString());
                                startActivity(intent);
                                finish();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        }.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                choosenSentenceList.remove(wordToFill);
                TextToFill.setText("" + choosenSentenceList.toString().replace("[","").replace("]","").replace(",", ""));
            }
        },3000);
        TextToFill.setText("" + choosenSentenceList.toString().replace("[","").replace("]","").replace(",", ""));

        //Log.i("brakujace slowo create","brakujące słowo onCreate: " + wordToFill);

        confirmButton = findViewById(R.id.confirm_btn);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userResult = EditTextFilling.getText().toString().toLowerCase();
                //Log.i("userResult","userResult: " + userResult);
                checkResult();
                EditTextFilling.setText("");
            }
        });
    }

    private void saveScore() {
        SharedPreferences preferences = this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("ftt_score",player_points);
        editor.commit();
    }

    private void checkResult() {
        Handler handler = new Handler();
        if(userResult.equals(wordToFill))
        {
            player_points +=10;
            pointsView.setText("" + player_points);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    answerCheck.setVisibility(View.INVISIBLE);

                }
            },1000);

            answerCheck.setText("Correct answer!");
            answerCheck.setVisibility(View.VISIBLE);

        }
        else {
            player_points -=10;
            pointsView.setText("" + player_points);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    answerCheck.setVisibility(View.INVISIBLE);
                }
            },1000);

            answerCheck.setText("That's not correct answer!");
            answerCheck.setVisibility(View.VISIBLE);
        }
        showAnotherText();
    }

    private void showAnotherText() {

        randomChoice = new Random().nextInt(exampleTextArray.length);
        TextToFill.setText(exampleTextArray[randomChoice]);

        choosenSentence = exampleTextArray[randomChoice];
        choosenSentenceArray = choosenSentence.split(" ");

        choosenSentenceList = new ArrayList<>(Arrays.asList(choosenSentenceArray));

        wordToFill = choosenSentenceArray[new Random().nextInt(choosenSentenceArray.length)];
        wordToFill = wordToFill.toLowerCase();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                choosenSentenceList.remove(wordToFill);
                TextToFill.setText("" + choosenSentenceList.toString().replace("[","").replace("]","").replace(",", ""));
            }
        },3000);
        TextToFill.setText("" + choosenSentenceList.toString().replace("[","").replace("]","").replace(",", ""));

        //Log.i("brakujace slowo showat","brakujące słowo showAnotherText: " + wordToFill);
    }


}
