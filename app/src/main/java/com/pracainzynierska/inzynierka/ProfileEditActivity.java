package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileEditActivity extends AppCompatActivity {

    EditText passwordTextView, newPasswordTextView;
    Button confirmButton;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        passwordTextView = findViewById(R.id.editProfilePassword);
        newPasswordTextView = findViewById(R.id.editProfileNewPassword);

        confirmButton = findViewById(R.id.editProfileConfirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordTextView.getText().toString().trim();
                String cnfPassword = newPasswordTextView.getText().toString().trim();

                if(cnfPassword.equals(password))
                {
                    long val = db.updateUser(password);
                    if(val > 0)
                    {
                        Toast.makeText(ProfileEditActivity.this,"Editing complete!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ProfileEditActivity.this, SignInActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(ProfileEditActivity.this,"Something went wrong, try again!",Toast.LENGTH_SHORT).show();
                    }
                }
                    Toast.makeText(ProfileEditActivity.this,"Passwords are not matching!",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
