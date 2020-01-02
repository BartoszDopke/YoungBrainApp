package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ProgressActivity extends AppCompatActivity {

    public ArrayAdapter<Integer> FindAllPairsList;
    public ListView list;
    TextView usernameView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        list =  findViewById(R.id.listView1);

        String user = getIntent().getStringExtra("username");
        usernameView = findViewById(R.id.username_progress);
        usernameView.setVisibility(View.INVISIBLE);
        usernameView.setText("" + user);

        SharedPreferences preferences =  this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);
        int rts_score = preferences.getInt("rts_score",0);
        int mc_score = preferences.getInt("mc_score",0);
        int g_score = preferences.getInt("g_score",0);

        String findAllPairsList[] = {Integer.toString(rts_score)};

        ArrayList<String> findAllPairsPoints = new ArrayList<>();
        findAllPairsPoints.add(Integer.toString(rts_score));


        String cars[] = {"Mercedes", "Fiat", "Ferrari", "Aston Martin", "Lamborghini", "Skoda", "Volkswagen", "Audi", "Citroen"};
        ArrayList<String> carL = new ArrayList<>();
        carL.addAll(Arrays.asList(cars));

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_progress,R.id.listView1,cars);

        list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,findAllPairsList));


    }
}
