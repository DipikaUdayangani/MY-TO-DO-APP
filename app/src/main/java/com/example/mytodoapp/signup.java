package com.example.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class signup extends AppCompatActivity {

    TextInputLayout userName,password,confirmPassword,email;
    Button create, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        login=findViewById(R.id.btnCreate1);
        email=findViewById(R.id.edit_email);
        userName=findViewById(R.id.edit_name);
        password=findViewById(R.id.edit_password);
        confirmPassword=findViewById(R.id.edit_confirmPassword);
        create=findViewById(R.id.btnCreate);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signup.this,login.class);
                startActivity(intent);
                finish();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = Objects.requireNonNull(userName.getEditText()).getText().toString();
                String pass = Objects.requireNonNull(password.getEditText()).getText().toString();
                String confirmPass = Objects.requireNonNull(confirmPassword.getEditText()).getText().toString();
                String mail = Objects.requireNonNull(email.getEditText()).getText().toString();

                if (user.isEmpty() || pass.isEmpty() || confirmPass.isEmpty() || mail.isEmpty()) {
                    Toast.makeText(signup.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!pass.equals(confirmPass)) {
                    Toast.makeText(signup.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Save user data to SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Username", user);
                editor.putString("Password", pass);
                editor.putString("Email", mail);
                editor.apply();

                Toast.makeText(signup.this, "User registered successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);
                finish();
            }

        });
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(signup.this,login.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}