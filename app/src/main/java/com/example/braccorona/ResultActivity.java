package com.example.braccorona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textView_1,textView_2,textView_3,textView_4,textView_5,textView_6,textView_7,textView_8,textView_9,textView_p,textView_m,textView_a;
    MyPreferences myPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        myPreferences=MyPreferences.getPreferences(this);
        textView_1=findViewById(R.id.age);
        textView_2=findViewById(R.id.first);
        textView_3=findViewById(R.id.second);
        textView_4=findViewById(R.id.third);
        textView_5=findViewById(R.id.fourth);
        textView_6=findViewById(R.id.fifth);
        textView_7=findViewById(R.id.six);
        textView_8=findViewById(R.id.seven);
        textView_p=findViewById(R.id.pin);
        textView_m=findViewById(R.id.mobile);
        textView_a=findViewById(R.id.address);


       /* int value=  myPreferences.getSecond();
        int age=myPreferences.getAge();
        textView.setText(String.valueOf(age));*/

        int age=myPreferences.getAge();
        //textView_1.setText(age);
        textView_1.setText(String.valueOf(age));

        int s=myPreferences.getSecond();
        textView_2.setText(String.valueOf(s));

        int t=myPreferences.getThird();
        textView_3.setText(String.valueOf(t));

        int four=myPreferences.getFourth();
        textView_4.setText(String.valueOf(four));

        int fifth=myPreferences.getFifth();
        textView_5.setText(String.valueOf(fifth));

        int six=myPreferences.getSixth();
        textView_6.setText(String.valueOf(six));

        int sev=myPreferences.getSeven();
        textView_7.setText(String.valueOf(sev));

        int eight=myPreferences.getEight();
        textView_8.setText(String.valueOf(eight));

        String pin=myPreferences.getPin();
        textView_p.setText(String.valueOf(pin));

        String mob=myPreferences.getMobile();
        textView_m.setText(String.valueOf(mob));

        String add=myPreferences.getAddress();
        textView_a.setText(String.valueOf(add));



    }
}
