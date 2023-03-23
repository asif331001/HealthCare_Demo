package com.example.healthcaredemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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
            {"Name: Dr. Ethan Martinez" , "Hospital: Brigham and Women's Hospital" ,"Exp: 10 Years" , "Contact: (567) 890-1234" , "Fees: $325"}
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_details);

        ddTitleTextView = findViewById(R.id.ddTitleTextView);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        ddTitleTextView.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctorList = doctorList1;
        else
            if (title.compareTo("Dietitian")==0)
            doctorList = doctorList2;
        else
            if (title.compareTo("Dentist")==0)
            doctorList = doctorList3;
        else
            if (title.compareTo("Surgeon")==0)
            doctorList = doctorList4;
        else
            if (title.compareTo("Cardiologists")==0)
            doctorList = doctorList5;
        else
            if (title.compareTo("Medicine")==0)
            doctorList = doctorList6;

    }
}