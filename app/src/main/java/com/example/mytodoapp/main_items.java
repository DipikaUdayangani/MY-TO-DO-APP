package com.example.mytodoapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytodoapp.databinding.ActivityMainItemsBinding;

import java.util.ArrayList;


public class main_items extends AppCompatActivity {

    ActivityMainItemsBinding binding;
    listAdapter listAdapter;

    ArrayList<todoData> dataArrayList = new ArrayList<>();

    sharedPreferences sharedPrefManager;

    ImageButton more;




    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainItemsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String email= getIntent().getStringExtra("Email");
        String registerUsername = getIntent().getStringExtra("Username");

        more=findViewById(R.id.more);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(main_items.this,naw_drawer.class);
                startActivity(intent);
                finish();
            }
        });


        sharedPrefManager = new sharedPreferences(this);

        ArrayList<String> savedItems = sharedPrefManager.getTodoList();
        for (String item : savedItems) {
            todoData todoData = new todoData(item, R.drawable.edit, R.drawable.delete);
            dataArrayList.add(todoData);
        }

        listAdapter = new listAdapter(main_items.this,dataArrayList);
        binding.todoitemlistview.setAdapter(listAdapter);
        binding.todoitemlistview.setClickable(false);

        binding.imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {showAddItemDialog();
            }
        });



    }


    private void showAddItemDialog() {
        // Create an AlertDialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomAlertDialog);

        // Inflate the custom layout/view
        final View customLayout = getLayoutInflater().inflate(R.layout.additemdialog, null);
        builder.setView(customLayout);

        // Set the title
        builder.setTitle("Add an item");

        // Add action buttons
        builder.setPositiveButton("Add", (dialog, which) -> {
            // Get the input from EditText
            EditText editTextItem = customLayout.findViewById(R.id.edit_text);
            String item = editTextItem.getText().toString();

            if (!item.isEmpty()) {

                ArrayList<String> currentList = sharedPrefManager.getTodoList();
                currentList.add(item);
                sharedPrefManager.saveTodoList(currentList);

                // Update the ListView
                todoData newTodoData = new todoData(item, R.drawable.edit, R.drawable.delete);
                dataArrayList.add(newTodoData);
                listAdapter.notifyDataSetChanged();

                Toast.makeText(this, "Item added: " + item, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Item cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {
            // Handle the "Cancel" button click
            dialog.cancel();
        });

        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();

        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.dialogTitleColor));
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setBackground(getResources().getDrawable(R.drawable.rounded_rectangle));
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.dialogTitleColor));
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setBackground(getResources().getDrawable(R.drawable.rounded_rectangle));


    }





}