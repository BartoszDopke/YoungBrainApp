package com.pracainzynierska.inzynierka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText mail_address;
    EditText username;
    EditText password;
    EditText cnf_password;
    Button ButtonRegister;
    TextView login_text;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        mail_address = findViewById(R.id.mail_register);
        username = findViewById(R.id.username_register);
        password = findViewById(R.id.password_register);
        cnf_password = findViewById(R.id.cnf_password_register);
        ButtonRegister = findViewById(R.id.signup);
        login_text = findViewById(R.id.login_text);

        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                String cnf_pwd = cnf_password.getText().toString().trim();
                String mail = mail_address.getText().toString().trim();

                if (pwd.length() >= 7) {
                    if (pwd.equals(cnf_pwd)) {
                        if (mail.contains("@")) {
                            long val = db.addUser(user, pwd, mail);
                            if (val > 0) {
                                Toast.makeText(RegisterActivity.this, "Registration complete!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, SignInActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegisterActivity.this, "Registration error!", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(RegisterActivity.this, "Wrong e-mail address!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Passwords are not matching!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Password should contain at least 8 characters!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

