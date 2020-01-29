package com.pracainzynierska.inzynierka;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.pracainzynierska.inzynierka.utils.SaveScoreInSharedPreference;

import java.util.Random;


public class GeomemotryActivity extends AppCompatActivity {

    Button yes_btn, no_btn;
    ImageView shape;
    TextView points, show_text, timerTextView, usernameView;

    int[] imagesEasy = {R.drawable.circle,R.drawable.square,R.drawable.star, R.drawable.triangle};
    int[] imagesMedium = {R.drawable.circle,R.drawable.square,R.drawable.star,R.drawable.star6, R.drawable.triangle, R.drawable.square2 };
    int[] imagesHard = {R.drawable.circle,R.drawable.square,R.drawable.star,R.drawable.star6, R.drawable.triangle, R.drawable.square2, R.drawable.triangle2,R.drawable.circle2};

    int[] shapesArrayEasy = {0,1,2,3};
    int[] shapesArrayMedium = {0,1,2,3,4,5};
    int[] shapesArrayHard = {0,1,2,3,4,5,6,7};
    Random rand = new Random();
    int player_points = 0;
    int imgPrev, imgActual, imgSecond;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geomemotry);
        shape = findViewById(R.id.shape);

        yes_btn = findViewById(R.id.yes_btn);
        no_btn = findViewById(R.id.no_btn);
        show_text = findViewById(R.id.show_text);
        usernameView = findViewById(R.id.username_geomemotry);
        String user = getIntent().getStringExtra("username");
        usernameView.setVisibility(View.INVISIBLE);
        usernameView.setText(""+ user);

        points = findViewById(R.id.geo_points);

        points.setText("" + player_points);

        final Animation animSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);

        SharedPreferences preferences = this.getSharedPreferences(usernameView.getText().toString(),Context.MODE_PRIVATE);
        final String isDoneString =  preferences.getString("done","-");
        final int introScore = preferences.getInt("g_score",0);

        if(introScore > 0 && introScore < 800)
        {
            //TODO: easy
            imgPrev = new Random().nextInt(imagesEasy.length);
            shape.setImageResource(imagesEasy[imgPrev]);
        }
        else if(introScore>800 && introScore<=1200)
        {
            //TODO: medium
            imgPrev = new Random().nextInt(imagesMedium.length);
            shape.setImageResource(imagesMedium[imgPrev]);
        }
        else if(introScore>1200)
        {
            //TODO:hard
            imgPrev = new Random().nextInt(imagesHard.length);
            shape.setImageResource(imagesHard[imgPrev]);
        }
        else
        {
            imgPrev = new Random().nextInt(imagesMedium.length);
            shape.setImageResource(imagesMedium[imgPrev]);
        }


        //this line sets random image in the beginning


        timerTextView = findViewById(R.id.timerView3);

        new CountDownTimer(20000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(""+ millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                if(isDoneString == "done")
                {
                    saveScore();
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GeomemotryActivity.this);
                    alertDialogBuilder
                            .setMessage("Congratulations! You did the third exercise! Your points: " + player_points)
                            .setCancelable(false)
                            .setPositiveButton("NEXT EXERCISE", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(getApplicationContext(), FillTheTextActivity.class);
                                    intent.putExtra("username",usernameView.getText().toString());
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intentBack = new Intent(getApplicationContext(), UserPanelActivity.class);
                                    startActivity(intentBack);
                                    finish();
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
                else
                {
                    saveScore();
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GeomemotryActivity.this);
                    alertDialogBuilder
                            .setMessage("Congratulations! You did the third introduction exercise! Your points: " + player_points)
                            .setCancelable(false)
                            .setPositiveButton("CONTINUE INTRODUCTION TEST", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(getApplicationContext(), IntroductionActivity.class);
                                    intent.putExtra("username",usernameView.getText().toString());
                                    intent.putExtra("textIndex",4);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intentBack = new Intent(getApplicationContext(), UserPanelActivity.class);
                                    startActivity(intentBack);
                                    finish();
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }
            }.start();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(introScore > 0 && introScore < 800)
                {
                    //TODO: easy
                    imgSecond = new Random().nextInt(imagesEasy.length);
                    shape.setImageResource(imagesEasy[imgSecond]);
                    shape.startAnimation(animSlide);
                }
                else if(introScore>800 && introScore<=1200)
                {
                    //TODO: medium
                    imgSecond = new Random().nextInt(imagesMedium.length);
                    shape.setImageResource(imagesMedium[imgSecond]);
                    shape.startAnimation(animSlide);
                }
                else if(introScore>1200)
                {
                    //TODO:hard
                    imgSecond = new Random().nextInt(imagesHard.length);
                    shape.setImageResource(imagesHard[imgSecond]);
                    shape.startAnimation(animSlide);
                }
                else
                {
                    imgSecond = new Random().nextInt(imagesMedium.length);
                    shape.setImageResource(imagesMedium[imgSecond]);
                    shape.startAnimation(animSlide);
                }
                imgActual = imgSecond;
            }
        },2000);


        yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                if(imgPrev == imgActual)
                {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            show_text.setVisibility(View.INVISIBLE);
                        }
                    },500);
                    player_points+=10;
                    points.setText("" + player_points);
                    show_text.setTextColor(Color.GREEN);
                    show_text.setText("Correct!");
                    show_text.setVisibility(View.VISIBLE);

                }
                else
                {

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            show_text.setVisibility(View.INVISIBLE);
                        }
                    },500);
                    player_points-=10;
                    points.setText("" + player_points);
                    show_text.setTextColor(Color.RED);
                    show_text.setText("That's not correct answer!");
                    show_text.setVisibility(View.VISIBLE);

                }
                imgPrev = imgActual;
                shape.startAnimation(animSlide);
                if(introScore > 0 && introScore < 800)
                {
                    //TODO: easy
                    imgActual = getRandomImageId(shapesArrayEasy);

                }
                else if(introScore>800 && introScore<=1200)
                {
                    //TODO: medium
                    imgActual = getRandomImageId(shapesArrayMedium);
                }
                else if(introScore>1200)
                {
                    //TODO:hard
                    imgActual = getRandomImageId(shapesArrayHard);
                }
                else
                {
                    imgActual = getRandomImageId(shapesArrayMedium);

                }


                if(introScore > 0 && introScore < 800)
                {
                    //TODO: easy
                    showShapeEasy(shape, imgActual);
                }
                else if(introScore>800 && introScore<=1200)
                {
                    //TODO: medium
                    showShapeMedium(shape, imgActual);
                }
                else if(introScore>1200)
                {
                    //TODO:hard
                    showShapeHard(shape, imgActual);
                }
                else
                {
                    showShapeMedium(shape, imgActual);
                }


            }
        });

        no_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                if(imgPrev != imgActual)
                {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            show_text.setVisibility(View.INVISIBLE);
                        }
                    },500);
                    show_text.setText("Correct!");
                    show_text.setVisibility(View.VISIBLE);

                    player_points+=10;
                    points.setText("" + player_points);
                }
                else
                {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            show_text.setVisibility(View.INVISIBLE);
                        }
                    },500);
                    show_text.setText("That's not correct answer!");
                    show_text.setVisibility(View.VISIBLE);
                    player_points-=10;
                    points.setText("" + player_points);
                }
                imgPrev = imgActual;
                shape.startAnimation(animSlide);
                if(introScore > 0 && introScore < 800)
                {
                    //TODO: easy
                    imgActual = getRandomImageId(shapesArrayEasy);
                }
                else if(introScore>800 && introScore<=1200)
                {
                    //TODO: medium
                    imgActual = getRandomImageId(shapesArrayMedium);
                }
                else if(introScore>1200)
                {
                    //TODO:hard
                    imgActual = getRandomImageId(shapesArrayHard);
                }
                else
                {
                    imgActual = getRandomImageId(shapesArrayMedium);
                }

                if(introScore > 0 && introScore < 800)
                {
                    //TODO: easy
                    showShapeEasy(shape, imgActual);
                }
                else if(introScore>800 && introScore<=1200)
                {
                    //TODO: medium
                    showShapeMedium(shape, imgActual);
                }
                else if(introScore>1200)
                {
                    //TODO:hard
                    showShapeHard(shape, imgActual);
                }
                else
                {
                    showShapeMedium(shape, imgActual);
                }

            }
        });
    }



    private void showShapeEasy(ImageView iv, int choice) {
       if (shapesArrayEasy[choice] == 0) {
           iv.setImageResource(imagesEasy[0]);
       } else if (shapesArrayEasy[choice] == 1) {
           iv.setImageResource(imagesEasy[1]);
       } else if (shapesArrayEasy[choice] == 2) {
           iv.setImageResource(imagesEasy[2]);
       } else if (shapesArrayEasy[choice] == 3) {
           iv.setImageResource(imagesEasy[3]);
       }
   }

    private void showShapeMedium(ImageView iv, int choice) {
        if (shapesArrayMedium[choice] == 0) {
            iv.setImageResource(imagesMedium[0]);
        } else if (shapesArrayMedium[choice] == 1) {
            iv.setImageResource(imagesMedium[1]);
        } else if (shapesArrayMedium[choice] == 2) {
            iv.setImageResource(imagesMedium[2]);
        } else if (shapesArrayMedium[choice] == 3) {
            iv.setImageResource(imagesMedium[3]);
        } else if (shapesArrayMedium[choice] == 4) {
            iv.setImageResource(imagesMedium[4]);
        } else if (shapesArrayMedium[choice]==5) {
            iv.setImageResource(imagesMedium[5]);
        }
    }

    private void showShapeHard(ImageView iv, int choice) {
        if (shapesArrayHard[choice] == 0) {
            iv.setImageResource(imagesHard[0]);
        } else if (shapesArrayHard[choice] == 1) {
            iv.setImageResource(imagesHard[1]);
        } else if (shapesArrayHard[choice] == 2) {
            iv.setImageResource(imagesHard[2]);
        } else if (shapesArrayHard[choice] == 3) {
            iv.setImageResource(imagesHard[3]);
        } else if (shapesArrayHard[choice] == 4) {
            iv.setImageResource(imagesHard[4]);
        } else if (shapesArrayHard[choice]==5) {
            iv.setImageResource(imagesHard[5]);
        } else if (shapesArrayHard[choice]==6) {
            iv.setImageResource(imagesHard[6]);
        } else if (shapesArrayHard[choice]==7) {
            iv.setImageResource(imagesHard[7]);
        }
    }



    private Integer getRandomImageId(int[] array) {
        return rand.nextInt(array.length);
    }

    private void saveScore() {


        new SaveScoreInSharedPreference().saveScoreInSP(this, usernameView.getText().toString(),2,player_points);

        SharedPreferences preferences = this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int totalScore = preferences.getInt("totalScore",0);
        totalScore = totalScore + player_points;
        editor.putInt("total_score", totalScore);
        editor.apply();

        /*
        SharedPreferences preferences = this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);

        counter=preferences.getInt("counter", 0);
        counter++;

        SharedPreferences.Editor editor = preferences.edit();
        int totalScore = preferences.getInt("totalScore",0);
        totalScore = totalScore + player_points;
        editor.putInt("g_score",player_points);

        editor.putInt("counter",counter);
        editor.putInt("g_score_"+counter,player_points);

        editor.putInt("total_score", totalScore);
        editor.commit();

         */


    }

    private void saveIntroScore() {
        /*
        SharedPreferences preferences = this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int totalScore = preferences.getInt("totalScore",0);
        totalScore = totalScore + player_points;
        editor.putInt("g_score", player_points);
        editor.putInt("total_score",totalScore);
        editor.commit();

         */
    }
}
