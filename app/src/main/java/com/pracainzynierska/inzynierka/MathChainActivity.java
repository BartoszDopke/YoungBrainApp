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

    int resultUser, numberForComputing, resultComputer = 4;
    char operationSign;
    int[] numberForOperationArray = {1,2,3,4,5};
    String operationSignString = "+-*/";

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
        if (resultUser == resultComputer)
        {
            showAnotherOperation();
        }
        else
        {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    firstNumberView.setVisibility(View.INVISIBLE);
                }
            },2000);
            firstNumberView.setText("Bad answer, try again!");
            firstNumberView.setVisibility(View.VISIBLE);
        }
    }

    private void showAnotherOperation() {
        Random r = new Random();
        operationSign = operationSignString.charAt(r.nextInt(operationSignString.length()));
        do
        {
            numberForComputing = new Random().nextInt(numberForOperationArray.length);
        }
        while(numberForComputing % 2 != 0);

        mathOperationView.setText(" " + operationSign + numberForComputing);

        if(numberForComputing == 0)
        {
            operationSign = '+';
        }

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
    }
}