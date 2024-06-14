package com.example.mytodoapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class forget extends AppCompatActivity {

    TextInputLayout userName,password,confirmPassword,email;
    Button saveBtn;

    ImageButton back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);


       email=findViewById(R.id.edit_email7);
        userName=findViewById(R.id.edit_name7);
        password=findViewById(R.id.edit_password7);
        confirmPassword=findViewById(R.id.edit_confirmPassword7);
        saveBtn=findViewById(R.id.btnSave7);
        back=findViewById(R.id.backBtn1);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(forget.this,login.class);
                startActivity(intent);
                finish();

                String user = Objects.requireNonNull(userName.getEditText()).getText().toString();
                String pass = Objects.requireNonNull(password.getEditText()).getText().toString();
                String confirmPass = Objects.requireNonNull(confirmPassword.getEditText()).getText().toString();
                String mail = Objects.requireNonNull(email.getEditText()).getText().toString();

                if (user.isEmpty() || pass.isEmpty() || confirmPass.isEmpty() || mail.isEmpty()) {
                    Toast.makeText(forget.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!pass.equals(confirmPass)) {
                    Toast.makeText(forget.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Save user data to SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Username", user);
                editor.putString("Password", pass);
                editor.putString("Email", mail);
                editor.apply();

                Toast.makeText(forget.this, "User registered successfully", Toast.LENGTH_SHORT).show();




            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(forget.this,login.class);
                startActivity(intent);
                finish();
            }
        });


    }
}