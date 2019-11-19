package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class IntroductionActivity extends AppCompatActivity {

    String[] introTextArray = {
            "Welcome to the introduction test! Lucid Brain will test your current memory skills.",
            "First exercise is Find The Pairs. You have to find all pairs of images in 1 minute!",
            "Second exercise is MathChain. Random number appears on the top of the screen. Below number is an arithmetic operation" +
                    " and number for computing. Write your result below that and check if it's correct! You have 1 minute for this exercise!",
            "Third exercise is Geomemotry. Remember the previous shape. If it matches current, click 'YES'. If not, click 'NO'." +
                    "You have 1 minute for this exercise!",
            "Fourth exercise is Fill The Text. A sentence will appear for 3 seconds on the screen, then one of the words will disappear." +
                    "Type a missing word and check if you're right. You have 1 minute for this exercise!",
            "This program is made to improve your overall memory. Hope you'll get everything best from it. " +
                    "Wish you good luck and never stop learning and being better everyday!"
    };

    TextView introductionView, usernameView;
    ImageButton nextButton, previousButton;
    int textIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        introductionView = findViewById(R.id.introductionText);
        usernameView = findViewById(R.id.userintroduction);



        String username  = getIntent().getStringExtra("username");
        usernameView.setVisibility(View.INVISIBLE);
        usernameView.setText("" + username);

        introductionView.setText(introTextArray[textIndex]);


        nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIndex++;
                Log.i("text index", "textIndex value nextButton: " + textIndex);
                switch(textIndex)
                {
                    case 1:
                        introductionView.setText(introTextArray[textIndex]);
                        previousButton.setVisibility(View.VISIBLE);
                         break;
                    case 2:
                        introductionView.setText(introTextArray[textIndex]);
                         break;
                    case 3:
                        introductionView.setText(introTextArray[textIndex]);
                        break;
                    case 4:
                        introductionView.setText(introTextArray[textIndex]);
                        break;
                    case 5:
                        introductionView.setText(introTextArray[textIndex]);
                        break;
                    case 6:
                        Intent intent = new Intent(IntroductionActivity.this, RememberTheSequenceMediumActivity.class);
                        String user = usernameView.getText().toString();
                        intent.putExtra("username",user);
                        startActivity(intent);
                        finish();
                    default: textIndex = 0; break;
                }

            }
        });

        previousButton = findViewById(R.id.previousButton);
        previousButton.setVisibility(View.INVISIBLE);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textIndex--;
                Log.i("text index", "textIndex value previousButton: " + textIndex);
                switch (textIndex) {
                    case 0:
                        introductionView.setText(introTextArray[textIndex]);
                        previousButton.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        introductionView.setText(introTextArray[textIndex]);
                        break;
                    case 2:
                        introductionView.setText(introTextArray[textIndex]);
                        break;
                    case 3:
                        introductionView.setText(introTextArray[textIndex]);
                        break;
                    case 4:
                        introductionView.setText(introTextArray[textIndex]);
                        break;
                    default:
                        textIndex = 0;
                        break;
                }
            }
        });
    }
}
