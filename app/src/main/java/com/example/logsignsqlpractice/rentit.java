package com.example.logsignsqlpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.logsignsqlpractice.databinding.ActivityRentitBinding;

public class rentit extends AppCompatActivity {

    public Button saveButton2;

    ActivityRentitBinding binding1;
    DatabaseHelper2 databaseHelper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentit);
        saveButton2=findViewById(R.id.save);
        saveButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(rentit.this,homeFragment.class);
                startActivity(intent);
            }
        });
        binding1 = ActivityRentitBinding.inflate(getLayoutInflater());
        setContentView(binding1.getRoot());

        databaseHelper2 = new DatabaseHelper2(this);

        binding1.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = binding1.address.getText().toString();
                String spaceedittext = binding1.spaceedittext.getText().toString();
                String vehiclepreference = binding1.vehiclepreference.getText().toString();
                String dates = binding1.dates.getText().toString();
                String timingofavail = binding1.timingofavail.getText().toString();
                String amount = binding1.amount.getText().toString();

                if(address.equals("")||spaceedittext.equals("")|| vehiclepreference.equals("") ||dates.equals("") ||timingofavail.equals("")  ||amount.equals("")  )
                    Toast.makeText(rentit.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkCredentials = databaseHelper2.checkaddressspace(address, spaceedittext,vehiclepreference,dates,timingofavail,amount);

                    if(checkCredentials == true){
                        Toast.makeText(rentit.this, "Shared Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), homeFragment.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(rentit.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        binding1.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rentit.this, homeFragment.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
