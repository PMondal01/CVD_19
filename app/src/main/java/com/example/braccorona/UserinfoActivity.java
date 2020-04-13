package com.example.braccorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserinfoActivity extends AppCompatActivity  {

    private Button button;
    private EditText editText_pin,editText_mobile,editText_address;
    DatabaseReference databaseReference;
    MyPreferences myPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);
        databaseReference= FirebaseDatabase.getInstance().getReference("user_responses");
        myPreferences=MyPreferences.getPreferences(this);

        button=findViewById(R.id.angry_btn);
        editText_pin=findViewById(R.id.editpin);
        editText_mobile=findViewById(R.id.editmobile);
        editText_address=findViewById(R.id.editaddress);




        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new  Intent(UserinfoActivity.this, ResultActivity.class);
                saveData();

                startActivity(intent);
            }

            private void saveData() {
                String pin=editText_pin.getText().toString().trim();
                String mobile=editText_mobile.getText().toString().trim();
                String address=editText_address.getText().toString().trim();

                myPreferences.setPin(pin);
                myPreferences.setMobile(mobile);
                myPreferences.setAddress(address);

                editText_pin.setText("");
                editText_mobile.setText("");
                editText_address.setText("");

                int age=myPreferences.getAge();
                int second=myPreferences.getSecond();
                int third=myPreferences.getThird();
                int four=myPreferences.getFourth();
                int fifth=myPreferences.getFifth();
                int six=myPreferences.getSixth();
                int seven=myPreferences.getSeven();
                int eight=myPreferences.getEight();
                String pin_no=myPreferences.getPin();
                String mob=myPreferences.getMobile();
                String add=myPreferences.getAddress();

                String key=databaseReference.push().getKey();
                MyPreferences myPreferences=new MyPreferences(age,second,third,four,fifth,six,seven,eight,pin_no,mob,add);
                databaseReference.child(key).setValue(myPreferences);

            //   UserInfo userInfo= new UserInfo(pin,mobile,address);




                    // String key=databaseReference.push().getKey();
                    //  First_response first_response=new First_response(age);
                    // databaseReference.child(key).setValue(first_response);
                }

        });
    }
}

