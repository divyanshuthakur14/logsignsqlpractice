package com.example.logsignsqlpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class personaldetails extends AppCompatActivity {
    public EditText name, age,phonenumber, address1;
    public Button insert;
    DatabaseHelper3 DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaldetails);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        phonenumber = findViewById(R.id.phonenumber);
        address1 = findViewById(R.id.address1);

        insert = findViewById(R.id.saveb);
        DB = new DatabaseHelper3(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String ageTXT = age.getText().toString();
                String phonenumberTXT = phonenumber.getText().toString();
                String address1TXT = address1.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, ageTXT, phonenumberTXT, address1TXT);
                if (checkinsertdata == true) {
                    Toast.makeText(personaldetails.this, "new entry inserted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(personaldetails.this, "entry not inserted", Toast.LENGTH_SHORT).show();

            }}
        });
    }}


