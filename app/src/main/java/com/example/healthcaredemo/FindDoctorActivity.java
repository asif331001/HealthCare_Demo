package com.example.healthcaredemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView familyPhysician = findViewById(R.id.cardFDFamilyPhysician);
        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorsDetailsActivity.class);
                intent.putExtra("title", "Family Physician");
                startActivity(intent);
            }
        });
     CardView surgeon = findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorsDetailsActivity.class);
                intent.putExtra("title", "Surgeon");
                startActivity(intent);
            }
        });
     CardView cardiologists = findViewById(R.id.cardFDCardiologists);
        cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorsDetailsActivity.class);
                intent.putExtra("title", "Cardiologists");
                startActivity(intent);
            }
        });
     CardView dietitian = findViewById(R.id.cardFDDietitian);
        dietitian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorsDetailsActivity.class);
                intent.putExtra("title", "Dietitian");
                startActivity(intent);
            }
        });
     CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorsDetailsActivity.class);
                intent.putExtra("title", "Dentist");
                startActivity(intent);
            }
        });
     CardView medicine = findViewById(R.id.cardFDMedicine);
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this,DoctorsDetailsActivity.class);
                intent.putExtra("title", "Medicine");
                startActivity(intent);
            }
        });
    }
}