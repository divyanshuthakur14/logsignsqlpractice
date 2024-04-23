package com.example.logsignsqlpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.logsignsqlpractice.databinding.ActivityPersonaldetailsBinding;
import com.example.logsignsqlpractice.databinding.ActivityRentitBinding;


public class personaldetails extends AppCompatActivity {

    public Button saveb;

    ActivityPersonaldetailsBinding binding3;
    DatabaseHelper3 databaseHelper3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personaldetails);



        saveb=findViewById(R.id.saveb);
        saveb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(personaldetails.this,homeFragment.class);
                startActivity(intent);
            }
        });
        binding3 = ActivityPersonaldetailsBinding.inflate(getLayoutInflater());
        setContentView(binding3.getRoot());

        databaseHelper3 = new DatabaseHelper3(this);

        binding3.saveb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding3.nameEditText.getText().toString();
                String age = binding3.ageEditText.getText().toString();
                String phonenumber = binding3.emailte.getText().toString();
                String address = binding3.addressEditText.getText().toString();


                if(name.equals("")||age.equals("")|| phonenumber.equals("") ||address.equals("")  )
                    Toast.makeText(personaldetails.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkCredentials = databaseHelper3.checknameage(name, age,phonenumber,address);
                    Boolean insert = databaseHelper3.insertData(name, age,phonenumber,address);
                    if(insert == true){
                        Toast.makeText(personaldetails.this, "Shared Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),homeFragment.class);
                        startActivity(intent);
                    }

                    if(checkCredentials == true){
                        Toast.makeText(personaldetails.this, "Shared Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), homeFragment.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(personaldetails.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        binding3.saveb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(personaldetails.this, homeFragment.class);
                startActivity(intent);
            }
        });

    }
}
