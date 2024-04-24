package com.example.logsignsqlpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class rentit extends AppCompatActivity {
    public EditText address, space,vehiclepreference, dates,timingofavail,amount;
    public Button insert;
    DatabaseHelper2 DaB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentit);
        address = findViewById(R.id.address);
        space = findViewById(R.id.space);
        vehiclepreference = findViewById(R.id.vehiclepreference);
        dates= findViewById(R.id.dates);
        timingofavail = findViewById(R.id.timingofavail);
        amount = findViewById(R.id.amount);

        insert = findViewById(R.id.save);
        DaB = new DatabaseHelper2(this);
        

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addressTXT = address.getText().toString();
                String spaceTXT = space.getText().toString();
                String vehiclepreferenceTXT = vehiclepreference.getText().toString();
                String datesTXT = dates.getText().toString();
                String timingofavailTXT = timingofavail.getText().toString();
                String amountTXT = amount.getText().toString();

                Boolean checkinsertdata = DaB.insertuserdata(addressTXT, spaceTXT, vehiclepreferenceTXT, datesTXT,timingofavailTXT,amountTXT);
                if (checkinsertdata == true) {
                    Toast.makeText(rentit.this, "new entry inserted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    String data1 = address.getText().toString().trim();
                    String data2 = space.getText().toString().trim();
                    String data3 = vehiclepreference.getText().toString().trim();
                    String data4 = dates.getText().toString().trim();
                    String data5 = timingofavail.getText().toString().trim();
                    String data6 = amount.getText().toString().trim();

                    intent.putExtra("data1", data1);
                    intent.putExtra("data2", data2);
                    intent.putExtra("data3", data3);
                    intent.putExtra("data4", data4);
                    intent.putExtra("data5", data5);
                    intent.putExtra("data6", data6);
                    startActivity(intent);
                } else{
                    Toast.makeText(rentit.this, "entry not inserted", Toast.LENGTH_SHORT).show();

                }}
        });
    }}


