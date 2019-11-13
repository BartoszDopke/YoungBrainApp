package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

public class SignInActivity extends AppCompatActivity {
    private TextView register_text;
    public static CallbackManager callbackManager;
    DatabaseHelper db;

   // public String f_name,l_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new DatabaseHelper(this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        //Button facebookLoginButton = findViewById(R.id.login_fbbutton);

        //AccessToken accessToken = AccessToken.getCurrentAccessToken();
        //boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
        usernameEditText.requestFocus();
        register_text = findViewById(R.id.register_text);

        register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(SignInActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
        /*
        facebookLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(SignInActivity.this,Arrays.asList("email", "public_profile"));
            }
        });
        */


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usernameEditText.getText().toString().trim();
                String pwd = passwordEditText.getText().toString().trim();
                Boolean res = db.checkUser(user,pwd);
                if(res == true)
                {
                    SharedPreferences preferences = getSharedPreferences(user,MODE_PRIVATE);
                    Intent intent = new Intent(SignInActivity.this,UserPanelActivity.class);
                    Intent intentPopUp = new Intent(SignInActivity.this, PopUpActivity.class);
                    intent.putExtra("username",user);
                    startActivity(intent);
                    startActivity(intentPopUp);
                    Toast.makeText(SignInActivity.this,"Welcome " + user + "!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(SignInActivity.this,"There is a problem with singing in!", Toast.LENGTH_SHORT).show();
                    usernameEditText.setText("");
                    passwordEditText.setText("");
                    usernameEditText.requestFocus();
                }

            }
        });
        /*
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Profile profile = Profile.getCurrentProfile();
                if(profile != null){

                    f_name=profile.getFirstName();
                    l_name=profile.getLastName();
                }
                String nickName = f_name + " " + l_name;
                SharedPreferences preferences = getSharedPreferences(nickName, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username",nickName);
                editor.commit();

                Intent intent = new Intent(SignInActivity.this,UserPanelActivity.class);
                intent.putExtra("username",nickName);
                startActivity(intent);



            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(SignInActivity.this, "Facebook login went wrong!", Toast.LENGTH_SHORT).show();
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
    */
    }



}
