package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    int resultUser, numberForComputing, resultComputer = 4, prevResultComputer;
    char operationSign;
    int[] numberForOperationArray = {1,2,3,4,5};
    String operationSignString = "+-*/";
    String cuttedOperationSign = "+-";

    TextView firstNumberView, mathOperationView;
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