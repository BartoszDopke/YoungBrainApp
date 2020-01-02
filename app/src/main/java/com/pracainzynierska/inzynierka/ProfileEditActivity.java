package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileEditActivity extends AppCompatActivity {

    EditText passwordTextView, newPasswordTextView, oldPasswordTextView;
    Button confirmButton;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        db = new DatabaseHelper(this);

        passwordTextView = findViewById(R.id.editProfilePassword);
        newPasswordTextView = findViewById(R.id.editProfileNewPassword);
        oldPasswordTextView = findViewById(R.id.oldPasswordTextView);

        confirmButton = findViewById(R.id.editProfileConfirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPassword = oldPasswordTextView.getText().toString().trim();

                String password = passwordTextView.getText().toString().trim();
                String cnfPassword = newPasswordTextView.getText().toString().trim();

                Boolean res = db.checkPassword(oldPassword);
                if (res) {

                    if (cnfPassword.equals(password)) {
                        long val = db.updatePassword(password);
                        if (val > 0) {
                            Toast.makeText(ProfileEditActivity.this, "Password has been changed!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ProfileEditActivity.this, SignInActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(ProfileEditActivity.this, "Something went wrong, try again!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(ProfileEditActivity.this, "Passwords are not matching!", Toast.LENGTH_SHORT).show();
                        passwordTextView.setText("");
                        newPasswordTextView.setText("");
                    }
                } else
                {
                    Toast.makeText(ProfileEditActivity.this, "Wrong old password!", Toast.LENGTH_SHORT).show();
                    oldPasswordTextView.setText("");
                    passwordTextView.setText("");
                    newPasswordTextView.setText("");
                }
            }
        });
    }
}
