package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.share.widget.ShareDialog;
import com.pracainzynierska.inzynierka.R;



public class MyProgressActivity extends AppCompatActivity {

    TextView usernameView, rtsPointsView1, mcPointsView1, gPointsView1, fttPointsView1;

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


        SharedPreferences preferences =  this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);
        int rts_score1 = preferences.getInt("rts_score",0);
        int mc_score1 = preferences.getInt("mc_score",0);
        int g_score1 = preferences.getInt("g_score",0);
        int ftt_score1 = preferences.getInt("ftt_score",0);


        rtsPointsView1.setText("" + rts_score1);
        mcPointsView1.setText("" + mc_score1);
        gPointsView1.setText("" + g_score1);
        fttPointsView1.setText("" + ftt_score1);





    }
}
