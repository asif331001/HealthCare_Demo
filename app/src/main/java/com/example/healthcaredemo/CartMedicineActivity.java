package com.example.healthcaredemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CartMedicineActivity extends AppCompatActivity {
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    TextView tvTotal, tvCart;
    ListView lst;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton, btnCheckout;

    private  String [] [] packages = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_medicine);

        tvTotal = findViewById(R.id.totalCostBMDTextView);
        tvCart = findViewById(R.id.cartBMDPackageId);
        dateButton = findViewById(R.id.buttonAppCartDate);
        timeButton = findViewById(R.id.buttonAppCartTime);
        btnCheckout = findViewById(R.id.checkoutBMDButtonId);
        lst = findViewById(R.id.cartBMDListviewId);

        SharedPreferences sharedPreferences = getSharedPreferences("share", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "").toString();

        Database db = new Database(getApplicationContext(), "healthCare", null, 3);

        float totalAmount = 0;
        ArrayList dbData = db.getCartData(email);

        packages = new String[dbData.size()][];
        for (int i = 0; i<packages.length; i++){
            packages[i] = new String[5];
        }

        for (int i=0; i<dbData.size(); i++){
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            packages[i][0] = strData[0];
            packages[i][4] = "Cost: "+strData[1]+"/-";
            totalAmount = totalAmount + Float.parseFloat(strData[1]);
        }
        tvTotal.setText("Total Cost: "+totalAmount);

        list = new ArrayList();
        for (int i =0;i<packages.length;i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", packages[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new  String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.lineAId, R.id.lineBId, R.id.lineCId, R.id.lineDId, R.id.lineEId});
        lst.setAdapter(sa);
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

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CartMedicineActivity.this,LabTestBookActivity.class);
                it.putExtra("price", tvTotal.getText());
                it.putExtra("date", dateButton.getText());
                it.putExtra("time", timeButton.getText());
                startActivity(it);
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