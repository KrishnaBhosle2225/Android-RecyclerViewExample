package com.krishna.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Input extends AppCompatActivity {
    TextView name,email,mob,address,dob;
    Button add;

    public Input() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        name=findViewById(R.id.pname);
        email=findViewById(R.id.pemail);
        mob=findViewById(R.id.pmob);
        address=findViewById(R.id.padd);
        dob=findViewById(R.id.pdob);
        add=findViewById(R.id.addDetails);
        add.setOnClickListener(new AddDetails());
    }
    class AddDetails implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            intent.putExtra("name",name.getText().toString());
            intent.putExtra("email",""+email.getText().toString());
            intent.putExtra("mob",""+mob.getText().toString());
            intent.putExtra("address",""+address.getText().toString());
            intent.putExtra("dob",""+dob.getText().toString());
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}