package com.stress.salsii1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText Username;
    EditText Password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Username.getText().toString().equals("user") && Password.getText().toString().equals("1234")){
                    Toast.makeText(login.this, "Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(login.this, "login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}