package com.pracainzynierska.inzynierka;

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
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.pracainzynierska.inzynierka.utils.SaveScoreInSharedPreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FillTheTextActivity extends AppCompatActivity {

    TextView TextToFill, answerCheck, timerTextView, pointsView, usernameView;
    EditText EditTextFilling;
    Button confirmButton;
    String[] introTextArray = {
            "the lake is a long way from here",
            "this is the last random sentence I will be writing and I am going to stop mid-sent",
            "lets all be unique together until we realise we are all the same",
            "the stranger officiates the meal",
            "he ran out of money so he had to stop playing poker",
            "last Friday in three weeks time I saw a spotted striped blue worm shake hands with a legless lizard",
            "we need to rent a room for our party",
            "the body may perhaps compensates for the loss of a true metaphysics"};

    String[] textArrayEasy = {
            "please wait outside of the house",
            "lets all be unique together until we realise we are all the same",
            "rock music approaches at high velocity",
            "i hear that nancy is very pretty",
            "he told us a very exciting adventure story",
            "the mysterious diary records the voice"
    };

    String[] textArrayMedium = {
            "i would have gotten the promotion, but my attendance was not good enough",
            "this is the last random sentence I will be writing and I am going to stop mid-sent",
            "he turned in the research paper on friday; otherwise he would have not passed the class",
            "the body may perhaps compensates for the loss of a true metaphysics",
            "she did not cheat on the test, for it was not the right thing to do",
            "i think I will buy the red car or I will lease the blue one"

    };

    String[] textArrayHard = {
            "i was very proud of my nickname throughout high school but today I could not be any different to what my nickname was",
            "sometimes all you need to do is completely make an ass of yourself and laugh it off to realise that life isn’t so bad after all",
            "if the easter bunny and the tooth fairy had babies would they take your teeth and leave chocolate for you?",
            "last friday in three weeks time I saw a spotted striped blue worm shake hands with a legless lizard",
            "sometimes it is better to just walk away from things and go back to them later when you’re in a better frame of mind",
            "a purple pig and a green donkey flew a kite in the middle of the night and ended up sunburnt"
    };

    String userResult, wordToFill;
    String choosenSentence;
    int randomChoice, player_points=0;
    String[] choosenSentenceArray;
    ArrayList<String> choosenSentenceList;

    String isDoneString = "not done";

    private int counter = 0;


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

        SharedPreferences preferences = this.getSharedPreferences(usernameView.getText().toString(),Context.MODE_PRIVATE);
        //int ftt_introscore = preferences.getInt("ftt_introscore",0);



        answerCheck = findViewById(R.id.answer_check);
        answerCheck.setTextColor(Color.RED);
        /*
        if(ftt_introscore > 0 && ftt_introscore <=50)
        {
            randomChoice = new Random().nextInt(textArrayEasy.length);
            choosenSentence = textArrayEasy[randomChoice];
        }
        else if(ftt_introscore > 50 && ftt_introscore < 100)
        {
            randomChoice = new Random().nextInt(textArrayMedium.length);
            choosenSentence = textArrayMedium[randomChoice];
        }
        else if (ftt_introscore > 100)
        {
            randomChoice = new Random().nextInt(textArrayHard.length);
            choosenSentence = textArrayHard[randomChoice];
        }
        else
        {
            randomChoice = new Random().nextInt(introTextArray.length);
            choosenSentence = introTextArray[randomChoice];
        }

         */
            randomChoice = new Random().nextInt(textArrayEasy.length);
            choosenSentence = textArrayEasy[randomChoice];
            choosenSentenceArray = choosenSentence.split(" ");
            choosenSentenceList = new ArrayList<>(Arrays.asList(choosenSentenceArray));
            wordToFill = choosenSentenceArray[new Random().nextInt(choosenSentenceArray.length)];
            wordToFill = wordToFill.toLowerCase().trim();


        pointsView = findViewById(R.id.points_fillthetext);
        pointsView.setText("" + player_points);

        timerTextView = findViewById(R.id.timerView2);

        new CountDownTimer(20000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(""+ millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                isDoneString = "done";
                saveScore();
                checkIfIntroDone();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FillTheTextActivity.this);
                alertDialogBuilder
                        .setMessage("Congratulations! You did the last exercise! Your points: " + player_points)
                        .setCancelable(false)
                        .setPositiveButton("BACK TO MENU", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), IntroductionActivity.class);
                                intent.putExtra("username",usernameView.getText().toString());
                                intent.putExtra("textIndex",5);
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
        },5000);
        TextToFill.setText("" + choosenSentenceList.toString().replace("[","").replace("]","").replace(",", ""));

        Log.i("brakujace slowo create","brakujące słowo onCreate: " + wordToFill);

        confirmButton = findViewById(R.id.confirm_btn);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userResult = EditTextFilling.getText().toString().toLowerCase().trim();
                if(userResult.isEmpty()) {
                    Toast.makeText(FillTheTextActivity.this, "No word typed!", Toast.LENGTH_SHORT).show();
                }
                checkResult();
                EditTextFilling.setText("");
            }
        });
    }


    private void checkIfIntroDone()
    {
        SharedPreferences preferences = this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("done",isDoneString);
        editor.apply();
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
            answerCheck.setTextColor(Color.GREEN);
            answerCheck.setText("Correct answer!");
            answerCheck.setVisibility(View.VISIBLE);

        }
        else {
            if(player_points==0) {
                player_points = 0;
            } else {
                player_points -=10;
            }
            pointsView.setText("" + player_points);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    answerCheck.setVisibility(View.INVISIBLE);
                }
            },1000);
            answerCheck.setTextColor(Color.RED);
            answerCheck.setText("That's not correct answer!");
            answerCheck.setVisibility(View.VISIBLE);
        }
        showAnotherText();
    }

    private void showAnotherText() {
        SharedPreferences preferences = this.getSharedPreferences(usernameView.getText().toString(),Context.MODE_PRIVATE);
        int ftt_introscore = preferences.getInt("ftt_introscore",0);

        if(ftt_introscore > 0 && ftt_introscore <=50)
        {
            randomChoice = new Random().nextInt(textArrayEasy.length);
            TextToFill.setText(textArrayEasy[randomChoice]);

            choosenSentence = textArrayEasy[randomChoice];
        }
        else if(ftt_introscore > 50 && ftt_introscore < 100)
        {
            randomChoice = new Random().nextInt(textArrayMedium.length);
            TextToFill.setText(textArrayMedium[randomChoice]);

            choosenSentence = textArrayMedium[randomChoice];
        }
        else if (ftt_introscore > 100)
        {
            randomChoice = new Random().nextInt(textArrayHard.length);
            TextToFill.setText(textArrayHard[randomChoice]);

            choosenSentence = textArrayHard[randomChoice];
        }
        else
        {
            randomChoice = new Random().nextInt(introTextArray.length);
            TextToFill.setText(introTextArray[randomChoice]);

            choosenSentence = introTextArray[randomChoice];
        }


        choosenSentenceArray = choosenSentence.split(" ");

        choosenSentenceList = new ArrayList<>(Arrays.asList(choosenSentenceArray));

        wordToFill = choosenSentenceArray[new Random().nextInt(choosenSentenceArray.length)];
        wordToFill = wordToFill.toLowerCase().trim();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try{
                    choosenSentenceList.remove(wordToFill);
                    TextToFill.setText("" + choosenSentenceList.toString().replace("[","").replace("]","").replace(",", ""));
                } finally {
                    choosenSentenceList.remove(wordToFill);
                    TextToFill.setText("" + choosenSentenceList.toString().replace("[","").replace("]","").replace(",", ""));
                }

            }
        },5000);
        TextToFill.setText("" + choosenSentenceList.toString().replace("[","").replace("]","").replace(",", ""));

        Log.i("brakujace slowo showat","brakujące słowo showAnotherText: " + wordToFill);
    }

    private void saveScore() {

        new SaveScoreInSharedPreference().saveScoreInSP(this, usernameView.getText().toString(),4,player_points);

        SharedPreferences preferences = this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int totalScore = preferences.getInt("totalScore",0);
        totalScore = totalScore + player_points;
        editor.putInt("total_score", totalScore);
        editor.apply();
    }


}
