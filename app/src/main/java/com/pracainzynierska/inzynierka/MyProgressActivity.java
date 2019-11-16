package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.pracainzynierska.inzynierka.R;

import java.util.Locale;


public class MyProgressActivity extends AppCompatActivity {

    TextView usernameView, rtsPointsView1, mcPointsView1, gPointsView1, fttPointsView1, dateView1, totalScoreView, myProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_progress);
        String user = getIntent().getStringExtra("username");
        usernameView = findViewById(R.id.username_myprogress);
        usernameView.setText("" + user);

        rtsPointsView1 = findViewById(R.id.rts_score_1);
        mcPointsView1 = findViewById(R.id.mc_score_1);
        gPointsView1 = findViewById(R.id.g_score_1);
        fttPointsView1 = findViewById(R.id.ftt_score_1);
        dateView1 = findViewById(R.id.date1);
        totalScoreView = findViewById(R.id.totalScoreView);
        myProgressView = findViewById(R.id.myProgressView);




        SharedPreferences preferences =  this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);
        int rts_score1 = preferences.getInt("rts_score",0);
        int mc_score1 = preferences.getInt("mc_score",0);
        int g_score1 = preferences.getInt("g_score",0);
        int ftt_score1 = preferences.getInt("ftt_score",0);
        int dailyChallengeScore = preferences.getInt("dailychallenge_score",0);
        int total_score = rts_score1 + mc_score1 + g_score1 + ftt_score1 + dailyChallengeScore;
        String rts_date1 = preferences.getString("date","-");

        AssetManager am = getApplicationContext().getAssets();
        Typeface logoFont = Typeface.createFromAsset(am, String.format(Locale.ENGLISH, "fonts/%s","FjallaOne-Regular.ttf"));
        Typeface myProgressFont = Typeface.createFromAsset(am, String.format(Locale.ENGLISH, "fonts/%s","Montserrat-Regular.ttf"));
        myProgressView.setTypeface(logoFont);
        myProgressView.setText("My Progress");
        rtsPointsView1.setTypeface(myProgressFont);
        rtsPointsView1.setText("" + rts_score1);

        mcPointsView1.setTypeface(myProgressFont);
        mcPointsView1.setText("" + mc_score1);

        gPointsView1.setTypeface(myProgressFont);
        gPointsView1.setText("" + g_score1);

        fttPointsView1.setTypeface(myProgressFont);
        fttPointsView1.setText("" + ftt_score1);

        dateView1.setTypeface(myProgressFont);
        dateView1.setText("" + rts_date1);

        totalScoreView.setTypeface(logoFont);
        totalScoreView.setText("Total score: " + total_score);





    }
}
