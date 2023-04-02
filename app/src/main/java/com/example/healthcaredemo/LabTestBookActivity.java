package com.example.healthcaredemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {

    EditText edFullName, edAddress, edPhnNumber;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        edFullName = findViewById(R.id.editTextLTPFullName);
        edAddress = findViewById(R.id.editTextLTPAddress);
        edPhnNumber = findViewById(R.id.editTextLTPPhnNumber);
        btnBooking = findViewById(R.id.bookCartLTPButton);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences("share", Context.MODE_PRIVATE);
                String email = sharedPreferences.getString("email", "").toString();

                Database db = new Database(getApplicationContext(), "healthCare", null, 3);

                db.addOrder(edFullName.getText().toString(), email,
                        edAddress.getText().toString(),edPhnNumber.getText().toString(),
                        date.toString(),time.toString(),
                        Float.parseFloat(price[1].toString()));
                db.removeCart(email);

                Toast.makeText(getApplicationContext(),"Your Order is done Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestBookActivity.this,HomeActivity.class));
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LabTestBookActivity.this, CartLabActivity.class);
        startActivity(intent);
    }
}