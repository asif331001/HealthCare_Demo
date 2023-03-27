package com.example.healthcaredemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    EditText appNameEd, appAddressEd, appNumberEd, appFeesEd;
    TextView titleTV;
    private Button dateButton, timeButton, bookNowButton;

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        titleTV = findViewById(R.id.appTitleTextViewId);
        appNameEd = findViewById(R.id.editTextAppFullName);
        appAddressEd = findViewById(R.id.editTextAppAddressId);
        appNumberEd = findViewById(R.id.editTextAppNumber);
        appFeesEd = findViewById(R.id.editTextAppFees);
        dateButton = findViewById(R.id.buttonAppDate);
        timeButton = findViewById(R.id.buttonAppTime);
        bookNowButton = findViewById(R.id.bookAppointmentButton);

        appNameEd.setKeyListener(null);
        appAddressEd.setKeyListener(null);
        appNumberEd.setKeyListener(null);
        appFeesEd.setKeyListener(null);

        Intent intentApp = getIntent();
        String title = intentApp.getStringExtra("text1");
        String fullName = intentApp.getStringExtra("text2");
        String address = intentApp.getStringExtra("text3");
        String contact = intentApp.getStringExtra("text4");
        String fees = intentApp.getStringExtra("text5");

        titleTV.setText(title);
        appNameEd.setText(fullName);
        appAddressEd.setText(address);
        appNumberEd.setText(contact);
        appFeesEd.setText(fees);

        //datePicker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        //timePicker
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });
    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                dateButton.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }

    private void initTimePicker(){

        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(i+":"+i1);

            }
        };

        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this,style,timeSetListener,hrs,min,true);
    }
}