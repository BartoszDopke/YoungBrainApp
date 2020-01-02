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
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class FindAllPairsHardActivity extends AppCompatActivity {

    TextView points, usernameView, timerView;
    CountDownTimer countDown;
    ImageView iv_11,iv_12,iv_13,iv_14,iv_15,iv_16,iv_17,iv_18,iv_19,iv_20,iv_21,iv_22,iv_23,iv_24,iv_25,iv_26;

    //array for the images
    Integer[] cardArray = {101,102,103,104,105,106,107,108,201,202,203,204,205,206,207,208};
    int image101, image102,image103,image104,image105,image106,image107,image108,image109,image110,
            image111,image112,image113,image114,image115,image116;

    int firstCard,secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    int player_points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_all_pairs_hard);
        String username = getIntent().getStringExtra("username");
        points = findViewById(R.id.points);
        usernameView = findViewById(R.id.username_rememberthesequence);
        usernameView.setVisibility(View.INVISIBLE);
        usernameView.setText("" + username);

        timerView = findViewById(R.id.rtsTimerView);

        SharedPreferences preferences = this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);
        final String isDoneString =  preferences.getString("done","-");


        iv_11 = findViewById(R.id.iv_11);
        iv_12 = findViewById(R.id.iv_12);
        iv_13 = findViewById(R.id.iv_13);
        iv_14 = findViewById(R.id.iv_14);
        iv_15 = findViewById(R.id.iv_15);
        iv_16 = findViewById(R.id.iv_16);
        iv_17 = findViewById(R.id.iv_17);
        iv_18 = findViewById(R.id.iv_18);
        iv_19 = findViewById(R.id.iv_19);
        iv_20 = findViewById(R.id.iv_20);
        iv_21 = findViewById(R.id.iv_21);
        iv_22 = findViewById(R.id.iv_22);
        iv_23 = findViewById(R.id.iv_23);
        iv_24 = findViewById(R.id.iv_24);
        iv_25 = findViewById(R.id.iv_25);
        iv_26 = findViewById(R.id.iv_26);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_15.setTag("4");
        iv_16.setTag("5");
        iv_17.setTag("6");
        iv_18.setTag("7");
        iv_19.setTag("8");
        iv_20.setTag("9");
        iv_21.setTag("10");
        iv_22.setTag("11");
        iv_23.setTag("12");
        iv_24.setTag("13");
        iv_25.setTag("14");
        iv_26.setTag("15");

        //load the card images
        frontofCardsResources();

        Collections.shuffle(Arrays.asList(cardArray));

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_11,theCard);
            }
        });

        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_12,theCard);
            }
        });

        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_13,theCard);
            }
        });

        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_14,theCard);
            }
        });

        iv_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_15,theCard);
            }
        });

        iv_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_16,theCard);
            }
        });

        iv_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_17,theCard);
            }
        });

        iv_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_18,theCard);
            }
        });
        iv_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_19,theCard);
            }
        });
        iv_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_20,theCard);
            }
        });
        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_21,theCard);
            }
        });

        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_22,theCard);
            }
        });
        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_23,theCard);
            }
        });
        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_24,theCard);
            }
        });
        iv_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_25,theCard);
            }
        });
        iv_26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_26,theCard);
            }
        });

        countDown =  new CountDownTimer(60000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                timerView.setText(""+ millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                if(isDoneString == "done")
                {
                    cancel();
                    saveScore();
                }

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FindAllPairsHardActivity.this);
                alertDialogBuilder
                        .setMessage("Congratulations! You did the first exercise! Your points: " + player_points)
                        .setCancelable(false)
                        .setPositiveButton("NEXT EXERCISE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), MathChainActivity.class);
                                intent.putExtra("username",usernameView.getText().toString());
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        }.start();




    }

    private void doStuff(ImageView iv, int card) {
        //set the correct image

        if(cardArray[card]==101)
        {
            iv.setImageResource(image101);
        }
        else if(cardArray[card]==102)
        {
            iv.setImageResource(image102);
        }
        else if(cardArray[card]==103)
        {
            iv.setImageResource(image103);
        }
        else if(cardArray[card]==104)
        {
            iv.setImageResource(image104);
        }
        else if(cardArray[card]==105)
        {
            iv.setImageResource(image105);
        }
        else if(cardArray[card]==106)
        {
            iv.setImageResource(image106);
        }
        else if(cardArray[card]==107)
        {
            iv.setImageResource(image107);
        }
        else if(cardArray[card]==108)
        {
            iv.setImageResource(image108);
        }
        else if(cardArray[card]==201)
        {
            iv.setImageResource(image109);
        }
        else if(cardArray[card]==202)
        {
            iv.setImageResource(image110);
        }
        else if(cardArray[card]==203)
        {
            iv.setImageResource(image111);
        }
        else if(cardArray[card]==204)
        {
            iv.setImageResource(image112);
        }
        else if(cardArray[card]==205)
        {
            iv.setImageResource(image113);
        }
        else if(cardArray[card]==206)
        {
            iv.setImageResource(image114);
        }
        else if(cardArray[card]==207)
        {
            iv.setImageResource(image115);
        }
        else if(cardArray[card]==208)
        {
            iv.setImageResource(image116);
        }

        //check which image is selected and save it to temp variable
        if(cardNumber==1)
        {
            firstCard = cardArray[card];
            if(firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if(cardNumber==2)
        {
            secondCard = cardArray[card];
            if(secondCard > 200)
            {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_15.setEnabled(false);
            iv_16.setEnabled(false);
            iv_17.setEnabled(false);
            iv_18.setEnabled(false);
            iv_19.setEnabled(false);
            iv_20.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_25.setEnabled(false);
            iv_26.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check if selected images are equal
                    calculate();
                }
            }, 1000);

        }
    }

    private void calculate() {
        //if images are equal, remove them and add point
        if(firstCard==secondCard)
        {
            if(clickedFirst==0)
            {
                iv_11.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst==1)
            {
                iv_12.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst==2)
            {
                iv_13.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst==3)
            {
                iv_14.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst==4)
            {
                iv_15.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst==5)
            {
                iv_16.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst==6)
            {
                iv_17.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst==7)
            {
                iv_18.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst==8)
            {
                iv_19.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst==9)
            {
                iv_20.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst==10)
            {
                iv_21.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst==11)
            {
                iv_22.setVisibility(View.INVISIBLE);
            }
            else if(clickedFirst==12)
            {
                iv_23.setVisibility(View.INVISIBLE);
            }

            else if(clickedFirst==13)
            {
                iv_24.setVisibility(View.INVISIBLE);
            }

            else if(clickedFirst==14)
            {
                iv_25.setVisibility(View.INVISIBLE);
            }

            else if(clickedFirst==15)
            {
                iv_26.setVisibility(View.INVISIBLE);
            }


            if(clickedSecond==0)
            {
                iv_11.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond==1)
            {
                iv_12.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond==2)
            {
                iv_13.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond==3)
            {
                iv_14.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond==4)
            {
                iv_15.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond==5)
            {
                iv_16.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond==6)
            {
                iv_17.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond==7)
            {
                iv_18.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond==8)
            {
                iv_19.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond==9)
            {
                iv_20.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond==10)
            {
                iv_21.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond==11)
            {
                iv_22.setVisibility(View.INVISIBLE);
            }
            else if(clickedSecond==12)
            {
                iv_23.setVisibility(View.INVISIBLE);
            }

            else if(clickedSecond==13)
            {
                iv_24.setVisibility(View.INVISIBLE);
            }

            else if(clickedSecond==14)
            {
                iv_25.setVisibility(View.INVISIBLE);
            }

            else if(clickedSecond==15)
            {
                iv_26.setVisibility(View.INVISIBLE);
            }

            player_points+=10;
            points.setText("Points: " + player_points);
        } else
        {
            iv_11.setImageResource(R.drawable.question);
            iv_12.setImageResource(R.drawable.question);
            iv_13.setImageResource(R.drawable.question);
            iv_14.setImageResource(R.drawable.question);
            iv_15.setImageResource(R.drawable.question);
            iv_16.setImageResource(R.drawable.question);
            iv_17.setImageResource(R.drawable.question);
            iv_18.setImageResource(R.drawable.question);
            iv_19.setImageResource(R.drawable.question);
            iv_20.setImageResource(R.drawable.question);
            iv_21.setImageResource(R.drawable.question);
            iv_22.setImageResource(R.drawable.question);
            iv_23.setImageResource(R.drawable.question);
            iv_24.setImageResource(R.drawable.question);
            iv_25.setImageResource(R.drawable.question);
            iv_26.setImageResource(R.drawable.question);
        }
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_15.setEnabled(true);
        iv_16.setEnabled(true);
        iv_17.setEnabled(true);
        iv_18.setEnabled(true);
        iv_19.setEnabled(true);
        iv_20.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_25.setEnabled(true);
        iv_26.setEnabled(true);


        //check if game's over
        checkEnd();
    }

    private void checkEnd()
    {
        if(iv_11.getVisibility()== View.INVISIBLE &&
                iv_12.getVisibility()== View.INVISIBLE &&
                iv_13.getVisibility()== View.INVISIBLE &&
                iv_14.getVisibility()== View.INVISIBLE &&
                iv_15.getVisibility()== View.INVISIBLE &&
                iv_16.getVisibility()== View.INVISIBLE &&
                iv_17.getVisibility()== View.INVISIBLE &&
                iv_18.getVisibility()== View.INVISIBLE &&
                iv_19.getVisibility()== View.INVISIBLE &&
                iv_20.getVisibility()== View.INVISIBLE &&
                iv_21.getVisibility()== View.INVISIBLE &&
                iv_22.getVisibility()== View.INVISIBLE &&
                iv_23.getVisibility()== View.INVISIBLE &&
                iv_24.getVisibility()== View.INVISIBLE &&
                iv_25.getVisibility()== View.INVISIBLE &&
                iv_26.getVisibility()== View.INVISIBLE)
        {
            countDown.cancel();
            saveScore();
            //saveIntroScore();

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FindAllPairsHardActivity.this);
            alertDialogBuilder
                    .setMessage("Congratulations! You did the first exercise! Your points: " + player_points)
                    .setCancelable(false)
                    .setPositiveButton("NEXT EXERCISE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), MathChainActivity.class);
                            intent.putExtra("username",usernameView.getText().toString());
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    private void saveScore() {
        SharedPreferences preferences = this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int totalScore = preferences.getInt("totalScore",0);
        editor.putInt("rts_score",player_points);
        editor.putInt("total_score",totalScore);
        editor.commit();
    }

    private void frontofCardsResources() {

        image101 = R.drawable.shape1;
        image102 = R.drawable.shape2;
        image103 = R.drawable.shape3;
        image104 = R.drawable.shape4;
        image105 = R.drawable.shape5;
        image106 = R.drawable.shape6;
        image107 = R.drawable.shape7;
        image108 = R.drawable.shape8;
        image109 = R.drawable.shape1;
        image110 = R.drawable.shape2;
        image111 = R.drawable.shape3;
        image112 = R.drawable.shape4;
        image113 = R.drawable.shape5;
        image114 = R.drawable.shape6;
        image115 = R.drawable.shape7;
        image116 = R.drawable.shape8;
    }
}
