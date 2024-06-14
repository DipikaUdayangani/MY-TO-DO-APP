package com.example.mytodoapp;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class naw_drawer extends AppCompatActivity {

    ImageButton back;

    TextView dash, user, developer, logout ;

    Dialog dialog;

    Button  btn_dialog_cancel, btn_dialog_ok;




    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naw_drawer);

        dialog = new Dialog(naw_drawer.this);
        dialog.setContentView(R.layout.custom_dialog_box);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_bg));
        dialog.setCancelable(false);

        btn_dialog_ok = dialog.findViewById(R.id.btn_dialog_ok);
        btn_dialog_cancel = dialog.findViewById(R.id.btn_dialog_cancel);


        btn_dialog_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_dialog_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(naw_drawer.this, welcome.class);
                startActivity(intent);
                finish();
         }
});

        back = findViewById(R.id.backBtn);




        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(naw_drawer.this,main_items.class);
                startActivity(intent);
                finish();
            }
        });
// go  dashboard
        dash =(TextView)findViewById(R.id.dashborad);
        dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(naw_drawer.this,main_items.class);
                startActivity(intent);

                Toast.makeText(naw_drawer.this, "You are in the dashboard", Toast.LENGTH_SHORT).show();
            }
        });

        //user profile
        user =(TextView)findViewById(R.id.profile);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(naw_drawer.this,UserInfo.class);
                startActivity(intent);
                finish();

                Toast.makeText(naw_drawer.this, "you are in the your profile", Toast.LENGTH_SHORT).show();
            }
        });

        //developer info
        developer =(TextView)findViewById(R.id.dev_pro);
        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(naw_drawer.this,dev_info.class);
                startActivity(intent);

                Toast.makeText(naw_drawer.this, "You are in the developer profile", Toast.LENGTH_SHORT).show();
            }
        });
//logout
        logout =(TextView)findViewById(R.id.out);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();



         }
});




    }



    }