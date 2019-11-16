package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private Button button_login;
    TextView logoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssetManager am = getApplicationContext().getAssets();

        Typeface logoFont = Typeface.createFromAsset(am, String.format(Locale.ENGLISH, "fonts/%s","FjallaOne-Regular.ttf"));
        Typeface standardFont = Typeface.createFromAsset(am, String.format(Locale.ENGLISH, "fonts/%s","Montserrat-Regular.ttf"));

        button_login =  findViewById(R.id.button);
        button_login.setTypeface(standardFont);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });




        logoView = findViewById(R.id.logoView);
        logoView.setTypeface(logoFont);
        logoView.setText("Young Brain");

    }





    public void Login()
    {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

}
