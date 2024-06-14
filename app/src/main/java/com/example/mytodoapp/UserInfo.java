package com.example.mytodoapp;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfo extends AppCompatActivity {

    private TextView usernameTextView, emailTextView;


    private Dialog dialog;
    private Button btnEdit, btnDialogCancel, btnDialogOk;
    private EditText editUsername, editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

        usernameTextView = findViewById(R.id.txt_username);
        emailTextView = findViewById(R.id.txt_email);
        btnEdit = findViewById(R.id.btnEdit_info);

        dialog = new Dialog(UserInfo.this);
        dialog.setContentView(R.layout.custom_dialog_edit_info);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        editUsername = dialog.findViewById(R.id.edit_username7);
        editEmail = dialog.findViewById(R.id.edit_email);
        btnDialogCancel = dialog.findViewById(R.id.btn_dialog_cancel);
        btnDialogOk = dialog.findViewById(R.id.btn_dialog_ok);





        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        btnDialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnDialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUsername = editUsername.getText().toString().trim();
                String newEmail = editEmail.getText().toString().trim();

                if (!newUsername.isEmpty()) {
                    usernameTextView.setText("User name: " + newUsername);
                }

                if (!newEmail.isEmpty()) {
                    emailTextView.setText("Email: " + newEmail);
                }

                dialog.dismiss();
            }
   });
    }


}