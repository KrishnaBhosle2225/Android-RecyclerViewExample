package com.krishna.recyclerviewexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String name,email,mob,address,dob;
    RecyclerView recyclerView;
    List<DetailsModelCls> detailList;
    DetailsModelCls detailsModelCls;
    DetailsAdapter detailsAdapter;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        recyclerView=findViewById(R.id.rv);
        b1.setOnClickListener(new Add());
        detailList = new ArrayList<>();
        detailsAdapter = new DetailsAdapter(MainActivity.this, detailList);
        recyclerView.setAdapter(detailsAdapter);
    }
    class Add implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent1=new Intent(MainActivity.this,Input.class);
            startActivityForResult(intent1,1);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                Log.d("gg","data = "+data);
                name=data.getStringExtra("name");
                email=data.getStringExtra("email");
                mob=data.getStringExtra("mob");
                address=data.getStringExtra("address");
                dob=data.getStringExtra("dob");
                Log.d("gg","name = "+email);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                detailsModelCls = new DetailsModelCls();
                detailsModelCls.setName(name);
                detailsModelCls.setEmail(email);
                detailsModelCls.setMob(mob);
                detailsModelCls.setAddress(address);
                detailsModelCls.setDob(dob);
                Log.d("gg","dmc = "+detailsModelCls);
                detailList.add(detailsModelCls);
                detailsAdapter.notifyDataSetChanged();

            }
        }
    }
}