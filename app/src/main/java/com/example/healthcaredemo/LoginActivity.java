package com.example.healthcaredemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edUserName, edPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUserName = findViewById(R.id.editTextLoginUserName);
        edPassword = findViewById(R.id.editTextLoginUserName);
        btn = findViewById(R.id.LoginButtonId);
        tv = findViewById(R.id.signUpHereTextViewId);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
            }
        });
    }
}