package com.example.healthcaredemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edSignUpName, edSignUpEmail, edSignUpPassword, edSignUpConfirmPassword;
    Button btnSignUp;
    TextView tvSignInHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edSignUpName = findViewById(R.id.editTextSignUpName);
        edSignUpEmail = findViewById(R.id.editTextSignUpEmail);
        edSignUpConfirmPassword = findViewById(R.id.editTextConfirmSignUpPassword);
        edSignUpPassword = findViewById(R.id.editTextSignUpPassword);
        btnSignUp = findViewById(R.id.SignUpButtonId);
        tvSignInHere = findViewById(R.id.signInHereTextViewId);


        tvSignInHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SignUpName = edSignUpName.getText().toString().trim();
                String SignUpEmail = edSignUpEmail.getText().toString().trim();
                String SignUpPassword = edSignUpPassword.getText().toString().trim();
                String SignUpConfirmPassword = edSignUpConfirmPassword.getText().toString().trim();

                if (SignUpName.isEmpty() || SignUpEmail.isEmpty() || SignUpPassword.isEmpty() || SignUpConfirmPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter All Data", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (!Patterns.EMAIL_ADDRESS.matcher(SignUpEmail).matches()) {
                        edSignUpEmail.setError("Enter a valid email address");
                        edSignUpEmail.requestFocus();
                        return;
                    } else {


                        if (SignUpPassword.compareTo(SignUpConfirmPassword) == 0) {
                            if (isPasswordValid(SignUpPassword)) {

                                Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));

                            } else {
                                edSignUpPassword.setError("Password Must Contain Minimum  8 Character,1 letter, 1 Digit & 1 Symbol");
                                edSignUpPassword.requestFocus();
                                return;

                            }
                        } else {
                            edSignUpConfirmPassword.setError("Password is not matched");
                            edSignUpConfirmPassword.requestFocus();
                            return;
                        }
                    }
                }
            }
        });
    }

    public static boolean isPasswordValid(String passwordHere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordHere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordHere.length(); p++) {
                if (Character.isLetter(passwordHere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordHere.length(); r++) {
                if (Character.isDigit(passwordHere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordHere.length(); s++) {
                char c = passwordHere.charAt(s);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }

            if (f1 == 1 && f2 == 1 && f3 == 1)
                return true;

            return false;
        }
    }
}