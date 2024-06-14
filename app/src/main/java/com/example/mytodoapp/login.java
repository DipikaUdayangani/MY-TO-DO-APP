package com.example.mytodoapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class login extends AppCompatActivity {

    Button createOne, login, forget;

    TextInputLayout name, password;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createOne=findViewById(R.id.new_user);
        name=findViewById(R.id.txt_username);
        password=findViewById(R.id.password);
        forget=findViewById(R.id.txt_user_name);
        login=findViewById(R.id.btn_log_in);

        createOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,signup.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Objects.requireNonNull(name.getEditText()).getText().toString();
                String logPassword = Objects.requireNonNull(password.getEditText()).getText().toString();

                if (username.isEmpty() || logPassword.isEmpty()) {
                    Toast.makeText(login.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;

                }

                SharedPreferences sharedPreferences = getSharedPreferences("Userprefs", Context.MODE_PRIVATE);
                String registeredUser = sharedPreferences.getString("Email", "");
                String registeredPass = sharedPreferences.getString("Password", "");
                String registerUsername = sharedPreferences.getString("Username", "");

                if (username.equals(registeredUser) && logPassword.equals(registeredPass)) {
                    Toast.makeText(login.this, "Login successful", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("LoggedIn", true);
                    editor.apply();


                    Intent intent = new Intent(login.this, main_items.class);
                    intent.putExtra("Username", registerUsername);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(login.this, "Login successful", Toast.LENGTH_SHORT).show();
                }


                Intent intent = new Intent(login.this, main_items.class);
                startActivity(intent);
                finish();
            }


        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, forget.class);
                startActivity(intent);
                finish();

            }
        });




    }
}