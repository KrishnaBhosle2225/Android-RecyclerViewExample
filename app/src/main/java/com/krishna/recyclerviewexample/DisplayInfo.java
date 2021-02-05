package com.krishna.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayInfo extends AppCompatActivity {

    TextView Name,Email,Mobile,Address,DOB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        Name = findViewById(R.id.tname);
        Email = findViewById(R.id.temail);
        Mobile = findViewById(R.id.tmobile);
        Address = findViewById(R.id.taddress);
        DOB = findViewById(R.id.tDOB);

//        Intent intent = getIntent();
//        String myName = intent.getStringExtra("mName");
//        String myEmail = intent.getStringExtra("mEmail");
//        String myMobile = intent.getStringExtra("mMobile");
//        String myAddress = intent.getStringExtra("mAddress");
//        String myDOB = intent.getStringExtra("mDOB");


        DetailsModelCls detailsModelCls = (DetailsModelCls) getIntent().getSerializableExtra("data");

        Name.setText(detailsModelCls.getName());
        Email.setText(detailsModelCls.getEmail());
        Mobile.setText(detailsModelCls.getMob());
        Address.setText(detailsModelCls.getAddress());
        DOB.setText(detailsModelCls.getDob());


    }
}