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

public class EightActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_yes,button_no;
    int eighth_ans;
  //  DatabaseReference databaseReference;
    MyPreferences myPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);
        myPreferences=MyPreferences.getPreferences(this);

      //  databaseReference= FirebaseDatabase.getInstance().getReference("eighth_response");

        button_yes=findViewById(R.id.angry_btn_yes);
        button_no=findViewById(R.id.angry_btn_no);

        button_yes.setOnClickListener(this);
        button_no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.angry_btn_yes:
                eighth_ans=1;
              //  saveData();
                myPreferences.setEight(eighth_ans);
                Intent intent=new  Intent(EightActivity.this, UserinfoActivity.class);
                startActivity(intent);
                break;
            case R.id.angry_btn_no:
                eighth_ans=0;
                myPreferences.setEight(eighth_ans);
               // saveData();
                intent=new  Intent(EightActivity.this, UserinfoActivity.class);
                startActivity(intent);
                break;
        }

    }

  /*  private void saveData() {

        Eighth_response eighth_response=new Eighth_response(eighth_ans);
        String key=databaseReference.push().getKey();
        databaseReference.child(key).setValue(eighth_response);
    }*/
}
