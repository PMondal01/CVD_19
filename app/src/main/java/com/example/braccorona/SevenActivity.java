package com.example.braccorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SevenActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_yes,button_no;
    int seventh_ans;
    MyPreferences myPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);
        myPreferences=MyPreferences.getPreferences(this);
        button_yes=findViewById(R.id.angry_btn_yes);
        button_no=findViewById(R.id.angry_btn_no);
        button_yes.setOnClickListener(this);
        button_no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.angry_btn_yes:
                seventh_ans=1;
                myPreferences.setSeven(seventh_ans);
                Intent intent=new  Intent(SevenActivity.this, UserinfoActivity.class);
                startActivity(intent);
                break;
            case R.id.angry_btn_no:
                seventh_ans=0;
                myPreferences.setSeven(seventh_ans);
                intent=new  Intent(SevenActivity.this, UserinfoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
