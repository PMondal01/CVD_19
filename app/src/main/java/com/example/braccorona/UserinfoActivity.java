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
                saveData();
                int age=myPreferences.getAge();
                int second=myPreferences.getSecond();
                int third=myPreferences.getThird();
                int four=myPreferences.getFourth();
                int fifth=myPreferences.getFifth();
                int six=myPreferences.getSixth();
                int seven=myPreferences.getSeven();
                int total=second+third+four+fifth+six+seven;
                //age
                int age_value=0;
                if(age<55){
                    age_value=0;
                }else {
                    age_value=1;
                }
                //symptom
                int q2q3_value=0;
                if (second==0 && third==0) {
                        q2q3_value=0;
                } else if (second==0 && third==1) {
                        q2q3_value=2;
                } else if (second==1 && third==0){
                        q2q3_value=2;
                }else {
                        q2q3_value=2;
                }
                //Epidomik
                int q4q5_value=0;
                if (four==0 && fifth==0) {
                    q4q5_value=0;
                } else if (four==0 && fifth==1) {
                    q4q5_value=1;
                } else if (four==1 && fifth==0){
                    q4q5_value=2;
                }else {
                    q4q5_value=2;
                }
                //history
                int history_value=0;
                if(seven==0){
                    history_value=0;
                }else {
                    history_value=1;
                }



                if(total>=4)
                {
                    Intent intent = new Intent(UserinfoActivity.this, SickActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(UserinfoActivity.this, HealthyActivity.class);
                    startActivity(intent);
                }

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
              //  int eight=myPreferences.getEight();
                String pin_no=myPreferences.getPin();
                String mob=myPreferences.getMobile();
                String add=myPreferences.getAddress();

                String key=databaseReference.push().getKey();
                MyPreferences myPreferences=new MyPreferences(age,second,third,four,fifth,six,seven,pin_no,mob,add);
                databaseReference.child(key).setValue(myPreferences);
                }


        });
    }
}

