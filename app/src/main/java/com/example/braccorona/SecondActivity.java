package com.example.braccorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_yes,button_no;
    int second_ans=0;
    TextView textView;
    MyPreferences myPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myPreferences = MyPreferences.getPreferences(this);
        setContentView(R.layout.activity_second);
        button_yes=findViewById(R.id.angry_btn_yes);
        button_no=findViewById(R.id.angry_btn_no);
        button_yes.setOnClickListener(this);
        button_no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.angry_btn_yes:
                second_ans=1;
                myPreferences.setSecond(second_ans);
                Intent intent=new  Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
                break;
            case R.id.angry_btn_no:
                second_ans=0;
                myPreferences.setSecond(second_ans);
                intent=new  Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
                break;
        }
    }
}
