package com.example.braccorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserinfoActivity extends AppCompatActivity  {

    private Button button;
    private EditText editText_pin,editText_mobile,editText_address;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        databaseReference= FirebaseDatabase.getInstance().getReference("user_information");

        button=findViewById(R.id.angry_btn);
        editText_pin=findViewById(R.id.editpin);
        editText_mobile=findViewById(R.id.editmobile);
        editText_address=findViewById(R.id.editaddress);


        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent=new  Intent(UserinfoActivity.this, FinalActivity.class);
                saveData();
                startActivity(intent);
            }

            private void saveData() {


                String pin=editText_pin.getText().toString().trim();
                String mobile=editText_mobile.getText().toString().trim();
                String address=editText_address.getText().toString().trim();
                String key=databaseReference.push().getKey();

                UserInfo userInfo= new UserInfo(pin,mobile,address);
                databaseReference.child(key).setValue(userInfo);










            }
        });
    }
}

