package com.pracainzynierska.inzynierka;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PopUpActivity extends AppCompatActivity {


    String[] randomHintArray = {
            "Did you know that you have to drink something hot to cool down?",
            "Did you know that the strongest muscle in your body is your jaw muscle?",
            "Did you know that optimism may help you live longer?",
            "Did you know that simplicity and consistency are the most important factors to success?",
            "Did you know that compound exercises like pull-ups, squats or deadlifts will get you the best results?",
            "Did you know that coffee improves body composition and elevates fat burning?",
            "Did you know that fish oil may help you lose body fat if you're overweight?",
            "Did you know that fish oil reduces joint pain, improves digestion and supports bone health?",
            "Did you know that brain comprises 60% of fat and is one of the fattest organs in the human body?",
            "Did you know that of the total blood and oxygen that is produced in our body, the brain gets 20% of it?",

    };

    private Button exit_btn;
    TextView randomFactView;
    int randomFactNumber;
    String randomFact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

        randomFactView = findViewById(R.id.randomFactView);

        randomFactNumber = new Random().nextInt(randomHintArray.length);
        randomFact = randomHintArray[randomFactNumber];
        randomFactView.setText("" + randomFact);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9), (int)(height*.5));

        exit_btn = findViewById(R.id.exit_btn);

        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
