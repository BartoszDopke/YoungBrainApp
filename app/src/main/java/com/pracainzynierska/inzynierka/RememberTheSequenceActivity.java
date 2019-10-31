package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class RememberTheSequenceActivity extends AppCompatActivity {
    TextView points;

    ImageView iv_11,iv_12,iv_13,iv_14,iv_15,iv_16,iv_17,iv_18,iv_19,iv_20,iv_21,iv_22;

    //array for the images
    Integer[] cardArray = {101,102,103,104,105,106,107,108,109,110,111,112};
    int image101, image102,image103,image104,image105,image106,image107,image108,image109,image110,
            image111,image112;

    int firstCard,secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;
    int player_points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_the_sequence);
        points = findViewById(R.id.points);

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

        //load the card images
        frontofCardsResources();

        Collections.shuffle(Arrays.asList(cardArray));

        points.setTextColor(Color.RED);

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
        else if(cardArray[card]==109)
        {
            iv.setImageResource(image109);
        }
        else if(cardArray[card]==110)
        {
            iv.setImageResource(image110);
        }
        else if(cardArray[card]==111)
        {
            iv.setImageResource(image111);
        }
        else if(cardArray[card]==112)
        {
            iv.setImageResource(image112);
        }

        //check which image is selected and save it to temp variable
        if(cardNumber==1)
        {
            firstCard = cardArray[card];
            if(firstCard > 106) {
                firstCard = firstCard - 6;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if(cardNumber==2)
        {
            secondCard = cardArray[card];
            if(secondCard > 106)
            {
                secondCard = secondCard - 6;
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

            player_points++;
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
                iv_22.getVisibility()== View.INVISIBLE)
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RememberTheSequenceActivity.this);
            alertDialogBuilder
                    .setMessage("Congratulations! You did the first exercise! Your points: " + player_points)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), RememberTheSequenceActivity.class);
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

    private void frontofCardsResources() {

        image101 = R.drawable.bear;
        image102 = R.drawable.panda;
        image103 = R.drawable.rabbit;
        image104 = R.drawable.tiger;
        image105 = R.drawable.pig;
        image106 = R.drawable.dog;
        image107 = R.drawable.bear;
        image108 = R.drawable.panda;
        image109 = R.drawable.rabbit;
        image110 = R.drawable.tiger;
        image111 = R.drawable.pig;
        image112 = R.drawable.dog;
    }
}
