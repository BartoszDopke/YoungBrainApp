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

    TextView usernameView, rtsPointsView1, mcPointsView1, gPointsView1, fttPointsView1, dateView1, totalScoreView, myProgressView,
                            rtsPointsView2, mcPointsView2, gPointsView2, fttPointsView2, dateView2,
                            rtsPointsView3, mcPointsView3, gPointsView3, fttPointsView3, dateView3,
                            rtsPointsView4, mcPointsView4, gPointsView4, fttPointsView4, dateView4,
                            rtsPointsView5, mcPointsView5, gPointsView5, fttPointsView5, dateView5,
                            rtsPointsView6, mcPointsView6, gPointsView6, fttPointsView6, dateView6,
                            rtsPointsView7, mcPointsView7, gPointsView7, fttPointsView7, dateView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_progress);
        String user = getIntent().getStringExtra("username");
        usernameView = findViewById(R.id.username_myprogress);
        usernameView.setText("" + user);

        //region findViewById region
        rtsPointsView1 = findViewById(R.id.rts_score_1);
        mcPointsView1 = findViewById(R.id.mc_score_1);
        gPointsView1 = findViewById(R.id.g_score_1);
        fttPointsView1 = findViewById(R.id.ftt_score_1);
        dateView1 = findViewById(R.id.date);

        rtsPointsView2 = findViewById(R.id.rts_score_2);
        mcPointsView2 = findViewById(R.id.mc_score_2);
        gPointsView2= findViewById(R.id.g_score_2);
        fttPointsView2 = findViewById(R.id.ftt_score_2);
        dateView2 = findViewById(R.id.date2);

        rtsPointsView2 = findViewById(R.id.rts_score_2);
        mcPointsView2 = findViewById(R.id.mc_score_2);
        gPointsView2 = findViewById(R.id.g_score_2);
        fttPointsView2 = findViewById(R.id.ftt_score_2);
        dateView2 = findViewById(R.id.date2);

        rtsPointsView3 = findViewById(R.id.rts_score_3);
        mcPointsView3 = findViewById(R.id.mc_score_3);
        gPointsView3 = findViewById(R.id.g_score_3);
        fttPointsView3 = findViewById(R.id.ftt_score_3);
        dateView3 = findViewById(R.id.date3);

        rtsPointsView4 = findViewById(R.id.rts_score_4);
        mcPointsView4 = findViewById(R.id.mc_score_4);
        gPointsView4 = findViewById(R.id.g_score_4);
        fttPointsView4 = findViewById(R.id.ftt_score_4);
        dateView4 = findViewById(R.id.date4);

        rtsPointsView5 = findViewById(R.id.rts_score_5);
        mcPointsView5 = findViewById(R.id.mc_score_5);
        gPointsView5 = findViewById(R.id.g_score_5);
        fttPointsView5 = findViewById(R.id.ftt_score_5);
        dateView5 = findViewById(R.id.date5);

        rtsPointsView6 = findViewById(R.id.rts_score_6);
        mcPointsView6 = findViewById(R.id.mc_score_6);
        gPointsView6 = findViewById(R.id.g_score_6);
        fttPointsView6 = findViewById(R.id.ftt_score_6);
        dateView6 = findViewById(R.id.date6);

        rtsPointsView7 = findViewById(R.id.rts_score_7);
        mcPointsView7 = findViewById(R.id.mc_score_7);
        gPointsView7 = findViewById(R.id.g_score_7);
        fttPointsView7 = findViewById(R.id.ftt_score_7);
        dateView7 = findViewById(R.id.date7);

        totalScoreView = findViewById(R.id.totalScoreView);
        myProgressView = findViewById(R.id.myProgressView);

        // endregion findViewById region


        SharedPreferences preferences =  this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);
        int rts_score = preferences.getInt("rts_score",0);
        int mc_score = preferences.getInt("mc_score",0);
        int g_score = preferences.getInt("g_score",0);
        int ftt_score = preferences.getInt("ftt_score",0);
        int dailyChallengeScore = preferences.getInt("dailychallenge_score",0);
        int total_score = rts_score + mc_score + g_score + ftt_score + dailyChallengeScore;
        String rts_date = preferences.getString("date","-");

        AssetManager am = getApplicationContext().getAssets();
        Typeface logoFont = Typeface.createFromAsset(am, String.format(Locale.ENGLISH, "fonts/%s","FjallaOne-Regular.ttf"));
        Typeface myProgressFont = Typeface.createFromAsset(am, String.format(Locale.ENGLISH, "fonts/%s","Montserrat-Regular.ttf"));
        myProgressView.setTypeface(logoFont);
        myProgressView.setText("My Progress");

        //region setTypeface & setText

        rtsPointsView1.setTypeface(myProgressFont);
        rtsPointsView1.setText("" + rts_score);

        mcPointsView1.setTypeface(myProgressFont);
        mcPointsView1.setText("" + mc_score);

        gPointsView1.setTypeface(myProgressFont);
        gPointsView1.setText("" + g_score);

        fttPointsView1.setTypeface(myProgressFont);
        fttPointsView1.setText("" + ftt_score);

        dateView1.setTypeface(myProgressFont);
        dateView1.setText("" + rts_date);

        rtsPointsView2.setTypeface(myProgressFont);
        rtsPointsView2.setText("" + rts_score);

        mcPointsView2.setTypeface(myProgressFont);
        mcPointsView2.setText("" + mc_score);

        gPointsView2.setTypeface(myProgressFont);
        gPointsView2.setText("" + g_score);

        fttPointsView2.setTypeface(myProgressFont);
        fttPointsView2.setText("" + ftt_score);

        dateView2.setTypeface(myProgressFont);
        dateView2.setText("" + rts_date);

        rtsPointsView3.setTypeface(myProgressFont);
        rtsPointsView3.setText("" + rts_score);

        mcPointsView3.setTypeface(myProgressFont);
        mcPointsView3.setText("" + mc_score);

        gPointsView3.setTypeface(myProgressFont);
        gPointsView3.setText("" + g_score);

        fttPointsView3.setTypeface(myProgressFont);
        fttPointsView3.setText("" + ftt_score);

        dateView3.setTypeface(myProgressFont);
        dateView3.setText("" + rts_date);

        rtsPointsView4.setTypeface(myProgressFont);
        rtsPointsView4.setText("" + rts_score);

        mcPointsView4.setTypeface(myProgressFont);
        mcPointsView4.setText("" + mc_score);

        gPointsView4.setTypeface(myProgressFont);
        gPointsView4.setText("" + g_score);

        fttPointsView4.setTypeface(myProgressFont);
        fttPointsView4.setText("" + ftt_score);

        dateView4.setTypeface(myProgressFont);
        dateView4.setText("" + rts_date);

        rtsPointsView5.setTypeface(myProgressFont);
        rtsPointsView5.setText("" + rts_score);

        mcPointsView5.setTypeface(myProgressFont);
        mcPointsView5.setText("" + mc_score);

        gPointsView5.setTypeface(myProgressFont);
        gPointsView5.setText("" + g_score);

        fttPointsView5.setTypeface(myProgressFont);
        fttPointsView5.setText("" + ftt_score);

        dateView5.setTypeface(myProgressFont);
        dateView5.setText("" + rts_date);

        rtsPointsView6.setTypeface(myProgressFont);
        rtsPointsView6.setText("" + rts_score);

        mcPointsView6.setTypeface(myProgressFont);
        mcPointsView6.setText("" + mc_score);

        gPointsView6.setTypeface(myProgressFont);
        gPointsView6.setText("" + g_score);

        fttPointsView6.setTypeface(myProgressFont);
        fttPointsView6.setText("" + ftt_score);

        dateView6.setTypeface(myProgressFont);
        dateView6.setText("" + rts_date);

        rtsPointsView7.setTypeface(myProgressFont);
        rtsPointsView7.setText("" + rts_score);

        mcPointsView7.setTypeface(myProgressFont);
        mcPointsView7.setText("" + mc_score);

        gPointsView7.setTypeface(myProgressFont);
        gPointsView7.setText("" + g_score);

        fttPointsView7.setTypeface(myProgressFont);
        fttPointsView7.setText("" + ftt_score);

        dateView7.setTypeface(myProgressFont);
        dateView7.setText("" + rts_date);

        totalScoreView.setTypeface(logoFont);
        totalScoreView.setText("Total score: " + total_score);


        //endregion setTypeface & setText


    }
}
