package com.example.healthcaredemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderDetailsActivity extends AppCompatActivity {

    private String [][] order_details = {};

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        lst = findViewById(R.id.listViewOrderDetails);

        SharedPreferences sharedPreferences = getSharedPreferences("share", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "").toString();

        Database db = new Database(getApplicationContext(), "healthCare", null, 3);

        ArrayList dbData = db.getOrderData(email);

        order_details = new String[dbData.size()][];
        for (int i =0; i<order_details.length; i++){
            order_details[i] = new String[5];
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            order_details[i][0] = strData[0];
            order_details[i][1] = strData[1];
            if (strData[7].compareTo("lab")==0){
                order_details[i][3] = "Del: "+strData[4];
            }else {
                order_details[i][3] = "Del: "+strData[4] + " "+ strData[5];
            }
            order_details[i][2] = "Tk."+strData[6];
            }
        list = new ArrayList();
        for (int i = 0; i<order_details.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", order_details[i][0]);
            item.put("line2", order_details[i][1]);
            item.put("line3", order_details[i][2]);
            item.put("line4", order_details[i][3]);
            item.put("line5", order_details[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.lineAId, R.id.lineBId, R.id.lineCId, R.id.lineDId, R.id.lineEId});
        lst.setAdapter(sa);
        }
    }
