package com.pracainzynierska.inzynierka;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pracainzynierska.inzynierka.utils.SaveScoreInSharedPreference;
import com.pracainzynierska.inzynierka.utils.SharedPrefUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class ProgressActivity extends AppCompatActivity {

    public ListView list;
    TextView usernameView, myProgressView, totalScoreView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        totalScoreView = findViewById(R.id.totalScoreView);
        myProgressView = findViewById(R.id.myProgressView);

        //List <Integer> findAllPairsList = findAllPairsEasyActivity.getList();

        AssetManager am = getApplicationContext().getAssets();
        Typeface logoFont = Typeface.createFromAsset(am, String.format(Locale.ENGLISH, "fonts/%s","FjallaOne-Regular.ttf"));
        Typeface myProgressFont = Typeface.createFromAsset(am, String.format(Locale.ENGLISH, "fonts/%s","Montserrat-Regular.ttf"));
        myProgressView.setTypeface(logoFont);
        myProgressView.setText("My Progress");

        list =  findViewById(R.id.listView1);

        String user = getIntent().getStringExtra("username");
        usernameView = findViewById(R.id.username_progress);
        usernameView.setVisibility(View.INVISIBLE);
        usernameView.setText("" + user);

        String cars[] = {"Mercedes", "Fiat", "Ferrari", "Aston Martin", "Lamborghini", "Skoda", "Volkswagen", "Audi", "Citroen"};
        ArrayList<String> carL = new ArrayList<>();
        carL.addAll(Arrays.asList(cars));



//        refreshListView();

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_progress,R.id.listView1,cars);

//        SharedPreferences preferences =  this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);
//        int rts_score = preferences.getInt(SharedPrefUtils.KEY_FIND_ALL_PAIRS_SCORE,0);
//        int mc_score = preferences.getInt("mc_score",0);
//        int g_score = preferences.getInt("g_score",0);
//        int ftt_score = preferences.getInt("ftt_score",0);
//
//        //wait a moment. I probably still have somewhere silly method saveIntroScore(). It can messok
//
//
//
//        final int total_score = rts_score + mc_score + g_score + ftt_score;
//
//        final ArrayList<String> scoresList=fetchScoresFromSharedPreference();
//
//
//        //Checking if the scoresList is empty or not
//        if(scoresList!=null && scoresList.size()>0){
//            //Add data to the listadapter
//
//
//
//            final ArrayAdapter scoresAdapter = new ArrayAdapter(this, R.layout.list_scores_two_rows, R.id.txtListScoresRowFindAllPairs, scoresList) {
//                @NonNull
//                @Override
//                public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//                    View view = super.getView(position, convertView, parent);
//
//                    if (!TextUtils.isEmpty(scoresList.get(position))) {
//                        ((TextView) view.findViewById(R.id.txtListScoresRowFindAllPairs)).setText(scoresList.get(position));
//                    }
//
//                    return view;
//                }
//            };
//
//            list.setAdapter(scoresAdapter);
//
//
//        }else{
//            FindAllPairsEasyActivity findAllPairsEasyActivity = new FindAllPairsEasyActivity();
//            list.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,findAllPairsEasyActivity.getList()));
//
//        }




        //Log.i("list","ProgressActivity findAllPairsList: " + findAllPairsEasyActivity.getList()); // shows nothing

        totalScoreView.setTypeface(logoFont);
//        totalScoreView.setText("Total score: " + 0);
    }


    @Override
    protected void onResume() {
        super.onResume();
        refreshListView();
    }

    private void refreshListView() {

        String jsonScore=new SaveScoreInSharedPreference().getScoresJsonFromSP(this,usernameView.getText().toString());



        if(TextUtils.isEmpty(jsonScore)){
            //No Data Found
            Toast.makeText(this, "No Scores Found", Toast.LENGTH_SHORT).show();
            return;
        }

try {
    JSONObject jsonObjectScores = new JSONObject(jsonScore);

    final JSONArray jsonArrayScores = jsonObjectScores.getJSONArray(SharedPrefUtils.SCORES_KEY);
    int totalScore=0;
    final ArrayList<String> dummy=new ArrayList<>();
    for (int i=0;i<jsonArrayScores.length();i++){
        JSONObject jsonObjectInerScore=jsonArrayScores.getJSONObject(i);
        dummy.add(jsonObjectInerScore.get(SharedPrefUtils.KEY_DATE).toString());

        int score_1=jsonObjectInerScore.optInt(SharedPrefUtils.KEY_FIND_ALL_PAIRS_SCORE,0);
        int score_2=jsonObjectInerScore.optInt(SharedPrefUtils.KEY_MATH_CHAIN_SCORE,0);
        int score_3=jsonObjectInerScore.optInt(SharedPrefUtils.KEY_GEO_MEMORY_SCORE,0);
        int score_4=jsonObjectInerScore.optInt(SharedPrefUtils.KEY_FILL_THE_TEXT_SCORE,0);

        totalScore+=score_1+score_2+score_3+score_4;
        Log.d("Score",totalScore+"");

        totalScoreView.setText("Total score: " + totalScore);

    }

    final ArrayAdapter scoresAdapter = new ArrayAdapter(this, R.layout.list_scores_two_rows, R.id.txtListScoresRowFindAllPairs, dummy) {

                @NonNull
                @Override
                public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                    View view = super.getView(position, convertView, parent);

                    if (!TextUtils.isEmpty(dummy.get(position))) {

                        try {
                            JSONObject jsonObjectInerScore=jsonArrayScores.getJSONObject(position);
                            ((TextView) view.findViewById(R.id.txtListScoresRowDate)).setText("Date: "+jsonObjectInerScore.optString(SharedPrefUtils.KEY_DATE));
                            ((TextView) view.findViewById(R.id.txtListScoresRowFindAllPairs)).setText("Find Pairs: "+jsonObjectInerScore.optInt(SharedPrefUtils.KEY_FIND_ALL_PAIRS_SCORE));
                            ((TextView) view.findViewById(R.id.txtListScoresRowMathChain)).setText("Math Chain: "+jsonObjectInerScore.optInt(SharedPrefUtils.KEY_MATH_CHAIN_SCORE));
                            ((TextView) view.findViewById(R.id.txtListScoresRowGeomemotry)).setText("Geo Memory: "+jsonObjectInerScore.optInt(SharedPrefUtils.KEY_GEO_MEMORY_SCORE));
                            ((TextView) view.findViewById(R.id.txtListScoresRowFillTheText)).setText("Fill the Text: "+jsonObjectInerScore.optInt(SharedPrefUtils.KEY_FILL_THE_TEXT_SCORE));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }

                    return view;
                }
            };



            list.setAdapter(scoresAdapter);



}catch (Exception e){
    e.printStackTrace();
}
        Log.d("ProgressActivity",jsonScore);



    }


    private ArrayList<String> fetchScoresFromSharedPreference(){
        SharedPreferences preferences =  this.getSharedPreferences(usernameView.getText().toString(), Context.MODE_PRIVATE);

        ArrayList<String> scoresList=new ArrayList<>();

        //Iterating to a max 100 count
        for (int i=1;i<100;i++){
            if (preferences.contains(SharedPrefUtils.KEY_FIND_ALL_PAIRS_SCORE+i)){
                String score=String.valueOf(preferences.getInt(SharedPrefUtils.KEY_FIND_ALL_PAIRS_SCORE+i, 0));
//                Log.d("ProgressActivity", score);
                scoresList.add(score);
            }else{
                //Stopping loop to prevent scanning all 100 possibilities, This loop will keep adding data until the rts_scores are being found
                break;
            }

        }
        return scoresList;

    }


}
//Open notepad for communication