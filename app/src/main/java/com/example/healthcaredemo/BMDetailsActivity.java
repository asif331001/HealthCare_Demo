package com.example.healthcaredemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMDetailsActivity extends AppCompatActivity {

    TextView tvBMDPackageName, tvBMDTotalCost;
    EditText edBMDDetails;

    Button btnBMDCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmdetails);



        tvBMDPackageName = findViewById(R.id.MedicineBMDTextView);
        tvBMDTotalCost = findViewById(R.id.totalCostBMDTextView);
        edBMDDetails = findViewById(R.id.EditTextBMDMultilineText);
        btnBMDCart = findViewById(R.id.ButtonBMDCartId);

        btnBMDCart.setKeyListener(null);

        Intent intent = getIntent();
        tvBMDPackageName.setText(intent.getStringExtra("text1"));
        edBMDDetails.setText(intent.getStringExtra("text2"));
        tvBMDTotalCost.setText("Total Cost: "+intent.getStringExtra("text3")+"/-");

        btnBMDCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Information is Stored", Toast.LENGTH_SHORT).show();
            }
        });
    }
}