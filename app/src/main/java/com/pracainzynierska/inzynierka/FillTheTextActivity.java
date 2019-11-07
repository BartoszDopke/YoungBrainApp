package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
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

    TextView TextToFill, answerCheck;
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
    String choosenSentence, sentenceToShow;
    int randomChoice, wordToFillNumber;
    String[] choosenSentenceArray;
    ArrayList<String> choosenSentenceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_the_text);

        TextToFill = findViewById(R.id.TextToFill);
        EditTextFilling = findViewById(R.id.EditTextFilling);
        answerCheck = findViewById(R.id.answer_check);
        answerCheck.setTextColor(Color.RED);

        randomChoice = new Random().nextInt(exampleTextArray.length);
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

        //Log.i("brakujace slowo create","brakujące słowo onCreate: " + wordToFill);

        confirmButton = findViewById(R.id.confirm_btn);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userResult = EditTextFilling.getText().toString().toLowerCase();
                Log.i("userResult","userResult: " + userResult);
                checkResult();
                EditTextFilling.setText("");
            }
        });
    }

    private void checkResult() {
        Handler handler = new Handler();
        if(userResult.equals(wordToFill))
        {
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
