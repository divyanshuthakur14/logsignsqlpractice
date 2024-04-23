package com.example.logsignsqlpractice;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class homeFragment extends Fragment {



    public Button personaldetails;

    public Button rentit;

    public Button parkingspot;

    public Button logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        personaldetails=view.findViewById(R.id.personaldetails);
        personaldetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),personaldetails.class);
                startActivity(intent);
            }
        });

        rentit=view.findViewById(R.id.rentit);
        rentit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),rentit.class);
                startActivity(intent);
            }
        });

        parkingspot=view.findViewById(R.id.parkingspot);
        parkingspot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),parkspot.class);
                startActivity(intent);
            }
        });

        logout=view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),activity_login.class);
                startActivity(intent);
            }
        });



        return view;
    }
}