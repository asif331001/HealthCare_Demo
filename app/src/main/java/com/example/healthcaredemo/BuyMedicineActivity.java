package com.example.healthcaredemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

   private String[][] packages = {
            {"Uprise-03 1000IU Capsule", "", "", "", "$50"},
            {"Lyrical Tablet", "", "", "", "$20"},
            {"Omez Capsule", "", "", "", "$15"},
            {"Cetirizine Tablet", "", "", "", "$10"},
            {"Crocin Tablet", "", "", "", "$5"},
            {"Metformin Tablet", "", "", "", "$25"},
            {"Azithromycin Tablet", "", "", "", "$30"},
            {"Paracetamol Suspension", "", "", "", "$8"},
            {"Sodium Chloride IV Infusion", "", "", "", "$40"},
            {"Atorvastatin Tablet", "", "", "", "$22"}
    };

   private String[] package_details = {
            "This medication is a form of Vitamin D used to treat conditions such as rickets and osteomalacia.\n" + "It is also used to prevent and treat vitamin D deficiency in people who have low levels of the vitamin. ",
            "Lyrical Tablet is used to treat nerve pain caused by conditions such as diabetes, shingles, and spinal cord injury.\n" + "It is also used to treat certain types of seizures.",
            "Omez Capsule is used to treat gastroesophageal reflux disease (GERD), peptic ulcer disease, and other conditions caused by excess stomach acid.\n" + "It is also used to prevent ulcers from forming in people taking nonsteroidal anti-inflammatory drugs (NSAIDs).",
            "Cetirizine Tablet is an antihistamine medication used to treat symptoms such as:\n"+"Itching\n"+"Runny nose\n"+"Watery eyes and \n"+"Sneezing caused by allergies.",
            "Crocin Tablet is a pain reliever and fever reducer used to treat mild to moderate pain and fever.\n"+"It is also used to relieve symptoms of colds, flu, and headaches.",
            "Metformin Tablet is used to treat type 2 diabetes by reducing glucose production in the liver and improving insulin sensitivity.",
            "Azithromycin Tablet is an antibiotic medication used to treat a variety of bacterial infections such as: \n"+"Respiratory infections\n"+"Skin infections and\n"+"Ear infections.",
            "Paracetamol Suspension is a liquid form of paracetamol used to relieve mild to moderate pain and fever in children and adults.",
            "Sodium Chloride IV Infusion is a sterile solution used to replenish fluids and electrolytes in people who have lost fluids due to dehydration, surgery, or other medical conditions.",
            "Atorvastatin Tablet is used to treat high cholesterol and to reduce the risk of heart attack, stroke, and other complications in people with diabetes, coronary artery disease, and other conditions."
    };

   HashMap<String, String> item;
   ArrayList list;
   SimpleAdapter sa;
   ListView lstBM;
   Button btnGoToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lstBM = findViewById(R.id.ListViewBMLabTest);
        btnGoToCart = findViewById(R.id.ButtonBMDCartId);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Information is Stored", Toast.LENGTH_SHORT).show();
            }
        });

        list = new ArrayList();
        for (int i = 0;i<packages.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Price: "+ packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new  String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.lineAId, R.id.lineBId, R.id.lineCId, R.id.lineDId, R.id.lineEId});
        lstBM.setAdapter(sa);

        lstBM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BMDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }
}