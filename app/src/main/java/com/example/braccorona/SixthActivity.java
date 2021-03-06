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

public class SixthActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_yes,button_no;
    int sixth_ans;
    MyPreferences myPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
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
                sixth_ans=1;
               myPreferences.setSixth(sixth_ans);
                Intent intent=new  Intent(SixthActivity.this, SevenActivity.class);
                startActivity(intent);
                break;
            case R.id.angry_btn_no:
                sixth_ans=0;
                myPreferences.setSixth(sixth_ans);
                intent=new  Intent(SixthActivity.this, SevenActivity.class);
                startActivity(intent);
                break;
        }
    }
}
