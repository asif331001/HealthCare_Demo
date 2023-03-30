package com.example.healthcaredemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorsDetailsActivity extends AppCompatActivity {

    private String[][] doctorList1 = {
            {"Name: Dr. Sarah Johnson" , "Hospital: Memorial Hospital" ,"Exp: 5 Years" ,"Contact: (234) 567-8901" , "Fees: $200"},
            {"Name: Dr. Michael Brown" , "Hospital: Mercy Hospital" ,"Exp: 8 Years" , "Contact: (345) 678-9012" , "Fees: $250"},
            {"Name: Dr. Emily Davis" , "Hospital: University Hospital" ,"Exp: 10 Years" , "Contact: (456) 789-0123" , "Fees: $300"},
            {"Name: Dr. David Lee" , "Hospital: Children's Hospital" ,"Exp: 3 Years" , "Contact: (567) 890-1234" , "Fees: $175"},
            {"Name: Dr. Jessica Nguyen" , "Hospital: VA Hospital" ,"Exp: 6 Years" , "Contact: (678) 901-2345" , "Fees: $225"},
            {"Name: Dr. William Chen" , "Hospital: General Hospital" ,"Exp: 4 Years" , "Contact: (789) 012-3456" , "Fees: $190"}
    };

    private String[][] doctorList2 = {
            {"Name: Dr. Elizabeth Kim" , "Hospital: Mount Sinai Hospital" ,"Exp: 7 Years" ,"Contact: (890) 123-4567" , "Fees: $275"},
            {"Name: Dr. Jacob Martinez" , "Hospital: Mayo Clinic" ,"Exp: 12 Years" , "Contact: (901) 234-5678" , "Fees: $350"},
            {"Name: Dr. Samantha Wilson" , "Hospital: Cleveland Clinic" ,"Exp: 9 Years" , "Contact: (012) 345-6789" , "Fees: $325"},
            {"Name: Dr. Benjamin Rodriguez" , "Hospital: Beth Israel Hospital" ,"Exp: 5 Years" , "Contact: (123) 456-7890" , "Fees: $200"},
            {"Name: Dr. Olivia Brown" , "Hospital: Baptist Hospital" ,"Exp: 3 Years" , "Contact: (234) 567-8901" , "Fees: $175"},
            {"Name: Dr. Ethan Lee" , "Hospital: Kaiser Permanente" ,"Exp: 6 Years" , "Contact: (345) 678-9012" , "Fees: $225"}
    };

    private String[][] doctorList3 = {
            {"Name: Dr. Michaela Chen" , "Hospital: NYU Langone Health" ,"Exp: 11 Years" ,"Contact: (456) 789-0123" , "Fees: $325"},
            {"Name: Dr. Andrew Davis" , "Hospital: Cedars-Sinai Medical Center" ,"Exp: 8 Years" , "Contact: (567) 890-1234" , "Fees: $250"},
            {"Name: Dr. Sophia Kim" , "Hospital: New York-Presbyterian Hospital" ,"Exp: 15 Years" , "Contact: (678) 901-2345" , "Fees: $400"},
            {"Name: Dr. Noah Rodriguez" , "Hospital: Johns Hopkins Hospital" ,"Exp: 4 Years" , "Contact: (789) 012-3456" , "Fees: $190"},
            {"Name: Dr. Ashley Martinez" , "Hospital: Massachusetts General Hospital" ,"Exp: 7 Years" , "Contact: (890) 123-4567" , "Fees: $275"},
            {"Name: Dr. Ryan Wilson" , "Hospital: Stanford Health Care" ,"Exp: 10 Years" , "Contact: (901) 234-5678" , "Fees: $350"}
    };
    private String[][] doctorList4 = {
            {"Name: Dr. Isabella Nguyen" , "Hospital: Northwestern Memorial Hospital" ,"Exp: 9 Years" ,"Contact: (012) 345-6789" , "Fees: $325"},
            {"Name: Dr. Liam Kim" , "Hospital: Barnes-Jewish Hospital" ,"Exp: 6 Years" , "Contact: (123) 456-7890" , "Fees: $225"},
            {"Name: Dr. Emma Rodriguez" , "Hospital: Houston Methodist Hospital" ,"Exp: 12 Years" , "Contact: (234) 567-8901" , "Fees: $350"},
            {"Name: Dr. Alexander Brown" , "Hospital: Duke University Hospital" ,"Exp: 5 Years" , "Contact: (345) 678-9012" , "Fees: $200"},
            {"Name: Dr. Ava Lee" , "Hospital: UCLA Medical Center" ,"Exp: 7 Years" , "Contact: (456) 789-0123" , "Fees: $250"},
            {"Name: Dr. Ethan Martinez" , "Hospital: Brigham and Women's Hospital" ,"Exp: 10 Years" , "Contact: (567) 890-1234" , "Fees: $325"},
            {"Name: Dr. Grace Lee" , "Hospital: Columbia University Irving Medical Center" ,"Exp: 10 Years" ,"Contact: (234) 567-8901" , "Fees: $300"},
            {"Name: Dr. Lucas Martinez" , "Hospital: Ronald Reagan UCLA Medical Center" ,"Exp: 7 Years" , "Contact: (345) 678-9012" , "Fees: $250"},
            {"Name: Dr. Samantha Kim" , "Hospital: Johns Hopkins Hospital" ,"Exp: 12 Years" , "Contact: (456) 789-0123" , "Fees: $350"},
            {"Name: Dr. Ethan Rodriguez" , "Hospital: Cleveland Clinic" ,"Exp: 5 Years" , "Contact: (567) 890-1234" , "Fees: $200"},
            {"Name: Dr. Emily Brown" , "Hospital: University of Michigan Hospitals-Michigan Medicine" ,"Exp: 8 Years" , "Contact: (678) 901-2345" , "Fees: $275"},
            {"Name: Dr. Benjamin Davis" , "Hospital: Duke University Hospital" ,"Exp: 11 Years" , "Contact: (789) 012-3456" , "Fees: $325"},
            {"Name: Dr. Olivia Davis" , "Hospital: Thomas Jefferson University Hospitals" ,"Exp: 8 Years" ,"Contact: (678) 901-2345" , "Fees: $275"},
            {"Name: Dr. Benjamin Kim" , "Hospital: Mayo Clinic" ,"Exp: 13 Years" , "Contact: (789) 012-3456" , "Fees: $375"},
            {"Name: Dr. Sophia Rodriguez" , "Hospital: Cleveland Clinic" ,"Exp: 11 Years" , "Contact: (890) 123-4567" , "Fees: $350"},
            {"Name: Dr. Noah Brown" , "Hospital: NYU Langone Health" ,"Exp: 6 Years" , "Contact: (901) 234-5678" , "Fees: $225"},
            {"Name: Dr. Ashley Nguyen" , "Hospital: Massachusetts General Hospital" ,"Exp: 9 Years" , "Contact: (012) 345-6789" , "Fees: $300"},
            {"Name: Dr. Ryan Kim" , "Hospital: Stanford Health Care" ,"Exp: 12 Years" , "Contact: (123) 456-7890" , "Fees: $350"},
            {"Name: Dr. Elizabeth Kim" , "Hospital: Mount Sinai Hospital" ,"Exp: 7 Years" ,"Contact: (890) 123-4567" , "Fees: $275"},
            {"Name: Dr. Jacob Martinez" , "Hospital: Mayo Clinic" ,"Exp: 12 Years" , "Contact: (901) 234-5678" , "Fees: $350"},
            {"Name: Dr. Samantha Wilson" , "Hospital: Cleveland Clinic" ,"Exp: 9 Years" , "Contact: (012) 345-6789" , "Fees: $325"},
            {"Name: Dr. Benjamin Rodriguez" , "Hospital: Beth Israel Hospital" ,"Exp: 5 Years" , "Contact: (123) 456-7890" , "Fees: $200"},
            {"" , "" ,"" , "" , ""},
            {"" , "" ,"" , "" , ""}
    };

    private String[][] doctorList5 = {
            {"Name: Dr. Olivia Davis" , "Hospital: Thomas Jefferson University Hospitals" ,"Exp: 8 Years" ,"Contact: (678) 901-2345" , "Fees: $275"},
            {"Name: Dr. Benjamin Kim" , "Hospital: Mayo Clinic" ,"Exp: 13 Years" , "Contact: (789) 012-3456" , "Fees: $375"},
            {"Name: Dr. Sophia Rodriguez" , "Hospital: Cleveland Clinic" ,"Exp: 11 Years" , "Contact: (890) 123-4567" , "Fees: $350"},
            {"Name: Dr. Noah Brown" , "Hospital: NYU Langone Health" ,"Exp: 6 Years" , "Contact: (901) 234-5678" , "Fees: $225"},
            {"Name: Dr. Ashley Nguyen" , "Hospital: Massachusetts General Hospital" ,"Exp: 9 Years" , "Contact: (012) 345-6789" , "Fees: $300"},
            {"Name: Dr. Ryan Kim" , "Hospital: Stanford Health Care" ,"Exp: 12 Years" , "Contact: (123) 456-7890" , "Fees: $350"}
    };
    private String[][] doctorList6 = {
            {"Name: Dr. Grace Lee" , "Hospital: Columbia University Irving Medical Center" ,"Exp: 10 Years" ,"Contact: (234) 567-8901" , "Fees: $300"},
            {"Name: Dr. Lucas Martinez" , "Hospital: Ronald Reagan UCLA Medical Center" ,"Exp: 7 Years" , "Contact: (345) 678-9012" , "Fees: $250"},
            {"Name: Dr. Samantha Kim" , "Hospital: Johns Hopkins Hospital" ,"Exp: 12 Years" , "Contact: (456) 789-0123" , "Fees: $350"},
            {"Name: Dr. Ethan Rodriguez" , "Hospital: Cleveland Clinic" ,"Exp: 5 Years" , "Contact: (567) 890-1234" , "Fees: $200"},
            {"Name: Dr. Emily Brown" , "Hospital: University of Michigan Hospitals-Michigan Medicine" ,"Exp: 8 Years" , "Contact: (678) 901-2345" , "Fees: $275"},
            {"Name: Dr. Benjamin Davis" , "Hospital: Duke University Hospital" ,"Exp: 11 Years" , "Contact: (789) 012-3456" , "Fees: $325"}
    };

    TextView ddTitleTextView;
    String[][] doctorList = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_details);

        ddTitleTextView = findViewById(R.id.ltldDeliveryLocationBMTextView);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        ddTitleTextView.setText(title);

        if (title.compareTo("Family Physician")==0){
            doctorList = doctorList1;
        }
        else
            if (title.compareTo("Dietitian")==0){
                doctorList = doctorList2;
            }
        else
            if (title.compareTo("Dentist")==0){
                doctorList = doctorList3;
            }
        else
            if (title.compareTo("Surgeon")==0){
                doctorList = doctorList4;
            }
        else
            if (title.compareTo("Cardiologists")==0){
                doctorList = doctorList5;
            }
        else
            if (title.compareTo("Medicine")==0){
                doctorList = doctorList6;
            }

            list = new ArrayList();
            for (int i = 0; i<doctorList.length; i++){
                item = new HashMap<String, String>();
                item.put("line1", doctorList[i][0]);
                item.put("line2", doctorList[i][1]);
                item.put("line3", doctorList[i][2]);
                item.put("line4", doctorList[i][3]);
                item.put("line5", doctorList[i][4]);
                list.add(item);
            }

            sa = new SimpleAdapter(this, list, R.layout.multi_lines, new String[]{"line1","line2","line3","line4","line5"},
                    new int[]{R.id.lineAId, R.id.lineBId, R.id.lineCId, R.id.lineDId, R.id.lineEId});
        ListView lst = findViewById(R.id.ListViewOrderDetails);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorsDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctorList[i][0]);
                it.putExtra("text3", doctorList[i][1]);
                it.putExtra("text4", doctorList[i][3]);
                it.putExtra("text5", doctorList[i][4]);


                startActivity(it);
            }
        });
    }
}