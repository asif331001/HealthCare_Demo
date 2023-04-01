package com.example.healthcaredemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Package 1: Full Body Checkup", "", "", "", "950"},
            {"Package 2: Blood Glucose Fasting", "", "", "", "300"},
            {"Package 3: COVID-19 Antibody", "", "", "", "500"},
            {"Package 4: Thyroid Check", "", "", "", "800"},
            {"Package 5: Immunity Check", "", "", "", "400"}
    };

   private String[] package_details = {
           "Full Body Checkup\n" +
                   "Complete Hemogram\n" + "Lipid Profile\n" + "Liver Function Test\n" +
                   "Kidney Function Test\n" + "Thyroid Function Test\n" + "HbA1c Test\n" + "Iron Studies",
           "Blood Glucose Fasting",
           "COVID-19 Antibody",
           "Thyroid Profile-Total(T3, t$, & TSH Ultra-sensitive)",
           "Immunity Check\n"+
                   "Complete Blood Count (CBC)\n" + "Immunoglobulin A (IgA)\n" +
                   "Immunoglobulin G (IgG)\n" + "Immunoglobulin M (IgM)\n" +
                   "Complement Components (C3 and C4)\n" + "C-reactive Protein (CRP)\n" +
                   "Erythrocyte Sedimentation Rate (ESR)\n" +
                   "Natural Killer (NK) Cell Count and Activity\n" +
                   "Lymphocyte Subpopulation Analysis\n" +
                   "Delayed Hypersensitivity Skin Test (Mantoux Test)\n" +
                   "Quantiferon-TB Gold Test\n" + "HIV Antibody Test\n" +
                   "Hepatitis B and C Antibody Test\n"

   };

   HashMap<String, String> item;
   ArrayList list;
   SimpleAdapter sa;
   Button goToCartButton;
   ListView testListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
        goToCartButton = findViewById(R.id.ButtonBMDCartId);
        testListView = findViewById(R.id.ListViewOrderDetails);

        list = new ArrayList();
        for (int i = 0;i<packages.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost: $"+ packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new  String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.lineAId, R.id.lineBId, R.id.lineCId, R.id.lineDId, R.id.lineEId});
        testListView.setAdapter(sa);

        testListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });

        goToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LabTestActivity.this, CartLabActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LabTestActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}