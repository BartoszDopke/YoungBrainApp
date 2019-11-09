package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MathChainActivity extends AppCompatActivity {

    //dwie zmiennne. jedna, do której wrzuca liczbę użytkownik. Druga, którą nadpisuje komputer
    //po każdej wykonanej operacji. Te zmienne są przy każdym działaniu porównywane

    int resultUser, numberForComputing, resultComputer = 4, player_points=0;
    char operationSign;
    int[] numberForOperationArray = {1,2,3,4,5};
    String operationSignString = "+-*/";
    String cuttedOperationSign = "+-";

    TextView firstNumberView, mathOperationView, timerTextView, pointsView, usernameView;
    EditText resultUserEdit;
    public Button confirmButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_chain);

        firstNumberView = findViewById(R.id.first_number);
        mathOperationView = findViewById(R.id.math_operation);
        resultUserEdit = findViewById(R.id.userResult_field);
        confirmButton = findViewById(R.id.confirmButton);
        usernameView = findViewById(R.id.username_mathchain);
        String user = getIntent().getStringExtra("username");
        usernameView.setVisibility(View.INVISIBLE);
        usernameView.setText(""+ user);

        pointsView = findViewById(R.id.points_mathchain);
        pointsView.setText("" + player_points);

        timerTextView = findViewById(R.id.timerView);

        new CountDownTimer(60000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(""+ millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                saveScore();
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MathChainActivity.this);
                alertDialogBuilder
                        .setMessage("Congratulations! You did the second exercise! Your points: " + player_points)
                        .setCancelable(false)
                        .setPositiveButton("NEXT EXERCISE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), GeomemotryActivity.class);
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

        firstNumberView.setText("" + resultComputer);
        showAnotherOperation();



        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumberView.setVisibility(View.INVISIBLE);
                resultUser =  Integer.parseInt(resultUserEdit.getText().toString());
                checkResult();
                resultUserEdit.setText("");
            }
        });
    }

    private void saveScore() {
        SharedPreferences preferences = this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("mc_score",player_points);
        editor.commit();
    }

    private void checkResult() {
        Handler handler = new Handler();
        if (resultUser == resultComputer)
        {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    firstNumberView.setVisibility(View.INVISIBLE);
                }
            },1000);
            player_points+=10;
            pointsView.setText("" + player_points);
            firstNumberView.setText("Good answer!");
            firstNumberView.setVisibility(View.VISIBLE);
            showAnotherOperation();
        }
        else
        {

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    firstNumberView.setVisibility(View.INVISIBLE);
                }
            },1000);
            player_points-=10;
            pointsView.setText("" + player_points);
            firstNumberView.setText("Bad answer, try again!");
            firstNumberView.setVisibility(View.VISIBLE);
        }
    }

    private void showAnotherOperation() {

        Random r = new Random();
        if((resultComputer == Math.floor(resultComputer)) && !Float.isInfinite(resultComputer))
        {
            operationSign = operationSignString.charAt(r.nextInt(operationSignString.length()));
        }
        else
        {
            operationSign = cuttedOperationSign.charAt(r.nextInt(cuttedOperationSign.length()));
        }
        numberForComputing = new Random().nextInt(numberForOperationArray.length)+1;

        Log.i("number for computing", "numberForComputing in sAO: " + numberForComputing);

        if(numberForComputing == 0)
        {
            operationSign = '+';
        }
        if(resultComputer %2 != 0)
        {
            operationSign = '+';
        }
        if(resultComputer >= 30)
        {
            operationSign = '-';
        }

        mathOperationView.setText(" " + operationSign + numberForComputing);

        switch (operationSign)
            {
            case '+':
                resultComputer = resultComputer + numberForComputing;
                break;
            case '-':
                resultComputer = resultComputer - numberForComputing;
                break;

            case '*':
                resultComputer = resultComputer * numberForComputing;
                break;
            case '/':
                resultComputer = resultComputer / numberForComputing;
                break;
        }
        Log.i("resultComputer", "resultComputer: " + resultComputer);
    }
}