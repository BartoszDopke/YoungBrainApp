package com.pracainzynierska.inzynierka.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONObject;

public class SaveScoreInSharedPreference {



    public void saveScoreInSP(Context context,String fileName, int gameType, int score){
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        String todaysDate=DateTimeUtils.getDate();

        String jsonScore=getScoresJsonFromSP(context,fileName);

        try {
            JSONObject jsonObjectScores = new JSONObject();

            if (TextUtils.isEmpty(jsonScore)) {
                //First Game


                JSONObject jsonObjectNewGame=new JSONObject();
                jsonObjectNewGame.put(SharedPrefUtils.KEY_DATE, todaysDate);

                switch (gameType){
                    case 1:
                        jsonObjectNewGame.put(SharedPrefUtils.KEY_FIND_ALL_PAIRS_SCORE,score);
                        break;
                    case 2:
                        jsonObjectNewGame.put(SharedPrefUtils.KEY_GEO_MEMORY_SCORE,score);
                        break;
                    case 3:
                        jsonObjectNewGame.put(SharedPrefUtils.KEY_MATH_CHAIN_SCORE,score);
                        break;
                    case 4:
                        jsonObjectNewGame.put(SharedPrefUtils.KEY_FILL_THE_TEXT_SCORE,score);
                        break;
                }

                //Create a new JSON Array
                JSONArray jsonArrayScores=new JSONArray();
                jsonArrayScores.put(jsonObjectNewGame);

                //Add this JSON array to the scores json object
                jsonObjectScores.put(SharedPrefUtils.SCORES_KEY,jsonArrayScores);





            } else {
                jsonObjectScores = new JSONObject(jsonScore);
                JSONArray jsonArrayTodaysScores = jsonObjectScores.getJSONArray(SharedPrefUtils.SCORES_KEY);

                boolean dateFound=false;

                for (int i=0;i<jsonArrayTodaysScores.length();i++){
                    //Iterate over each json object and get todays date
                    JSONObject jsonObjectInnerScore=jsonArrayTodaysScores.getJSONObject(i);

                    //If todays date match the JSON Object, update the FindAllPairsScore
                    if (jsonObjectInnerScore.get(SharedPrefUtils.KEY_DATE).equals(todaysDate)){
                        dateFound=true;
                        switch (gameType){
                            case 1:
                                jsonObjectInnerScore.put(SharedPrefUtils.KEY_FIND_ALL_PAIRS_SCORE,score);
                                break;
                            case 2:
                                jsonObjectInnerScore.put(SharedPrefUtils.KEY_GEO_MEMORY_SCORE,score);
                                break;
                            case 3:
                                jsonObjectInnerScore.put(SharedPrefUtils.KEY_MATH_CHAIN_SCORE,score);
                                break;
                            case 4:
                                jsonObjectInnerScore.put(SharedPrefUtils.KEY_FILL_THE_TEXT_SCORE,score);
                                break;
                        }
                    }

                }

                //Check if todays data found or not
                if(!dateFound){
                    //No entry for today. Create a new game entry as first time

                    JSONObject jsonObjectNewGame=new JSONObject();
                    jsonObjectNewGame.put(SharedPrefUtils.KEY_DATE, todaysDate);

                    switch (gameType){
                        case 1:
                            jsonObjectNewGame.put(SharedPrefUtils.KEY_FIND_ALL_PAIRS_SCORE,score);
                            break;
                        case 2:
                            jsonObjectNewGame.put(SharedPrefUtils.KEY_GEO_MEMORY_SCORE,score);
                            break;
                        case 3:
                            jsonObjectNewGame.put(SharedPrefUtils.KEY_MATH_CHAIN_SCORE,score);
                            break;
                        case 4:
                            jsonObjectNewGame.put(SharedPrefUtils.KEY_FILL_THE_TEXT_SCORE,score);
                            break;
                    }

                    //Create a new JSON Array
                    jsonArrayTodaysScores.put(jsonObjectNewGame);
                }



            }

            //Save updated json in SP
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(SharedPrefUtils.PREF_JSON_SCORES,jsonObjectScores.toString());
            editor.apply();
        }catch(Exception e ){
            e.printStackTrace();
        }

    }

    public String getScoresJsonFromSP(Context context,String fileName){
        SharedPreferences preferences =  context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return preferences.getString(SharedPrefUtils.PREF_JSON_SCORES,"");
    }
}
