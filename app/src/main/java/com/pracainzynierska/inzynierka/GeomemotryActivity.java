package com.pracainzynierska.inzynierka;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;


public class GeomemotryActivity extends AppCompatActivity {

    Button yes_btn, no_btn;
    ImageView shape;
    TextView points;

    int[] images = {R.drawable.circle,R.drawable.square,R.drawable.star,R.drawable.star6, R.drawable.triangle};
    int[] shapesArray = {0,1,2,3,4,5};
    Random rand = new Random();
    //int star6, circle, square, star, triangle;
    int player_points = 0;
    int imgPrev, imgActual, imgSecond;

    //int firstShape, secondShape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geomemotry);
        shape = findViewById(R.id.shape);

        yes_btn = findViewById(R.id.yes_btn);
        no_btn = findViewById(R.id.no_btn);
        points = findViewById(R.id.geo_points);

        points.setTextColor(Color.RED);

        //this line sets random image in the beginning
        imgPrev = new Random().nextInt(images.length);
        shape.setImageResource(images[imgPrev]);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imgSecond = new Random().nextInt(images.length);
                shape.setImageResource(images[imgSecond]);
                imgActual = imgSecond;
            }
        },2000);

        Log.i("imgPrev onCreate","imgPrev onCreate " + imgPrev);
        Log.i("imgSecond onCreate","imgSecond onCreate " + imgSecond);
        Log.i("imgActual onCreate","imgActual onCreate " + imgActual);


        //there's a problem
        yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imgPrev == imgActual)
                {
                    player_points+=10;
                    points.setText("Points: " + player_points);
                }
                else
                {
                    points.setText("Points: " + player_points);
                }
                Log.i("imgPrev in yes_btn: ", "imgPrev in yes_btn: " + imgPrev);
                Log.i("imgActual in yes_btn: ", "imgActual in yes_btn: " + imgActual);
                imgPrev = imgActual;
                Log.i("imgPrev przypis yes: ", "imgPrev przypis yes: " + imgPrev);
                imgActual = getRandomImageId();
                Log.i("imgActual przypis yes: ", "imgActual przypis yes: " + imgActual);
                showShape(shape, imgActual);

            }
        });

        no_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imgPrev != imgActual)
                {
                    player_points+=10;
                    points.setText("Points: " + player_points);
                }
                else
                {
                    points.setText("Points: " + player_points);
                }
                Log.d("imgPrev in no_btn: ", "imgPrev in no_btn: " + imgPrev);
                Log.d("imgActual in no_btn: ", "imgActual in no_btn: " + imgActual);
                imgPrev = imgActual;
                Log.d("imgPrev przypis no: ", "imgPrev przypis no: " + imgPrev);
                imgActual = getRandomImageId();
                Log.i("imgActual przypis no: ", "imgActual przypis no: " + imgActual);
                showShape(shape, imgActual);

            }
        });

    }


    //there's a problem

   //probably something's wrong there as well
   private void showShape(ImageView iv, int choice) {
       if (shapesArray[choice] == 0) {
           iv.setImageResource(images[0]);
       } else if (shapesArray[choice] == 1) {
           iv.setImageResource(images[1]);
       } else if (shapesArray[choice] == 2) {
           iv.setImageResource(images[2]);
       } else if (shapesArray[choice] == 3) {
           iv.setImageResource(images[3]);
       } else if (shapesArray[choice] == 4) {
           iv.setImageResource(images[4]);
       }
       else if (shapesArray[choice]==5)
       {
           iv.setImageResource(images[5]);
       }
   }

    private Integer getRandomImageId() {
        return rand.nextInt(images.length);
    }
}
