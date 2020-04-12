package com.example.braccorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SevenActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_yes,button_no;
    int seventh_ans;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);
        databaseReference= FirebaseDatabase.getInstance().getReference("seventh_response");


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
                saveData();
                Intent intent=new  Intent(SevenActivity.this, EightActivity.class);
                startActivity(intent);
                break;
            case R.id.angry_btn_no:
                seventh_ans=0;
                saveData();
                intent=new  Intent(SevenActivity.this, EightActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void saveData() {

        Seventh_response  seventh_response=new Seventh_response(seventh_ans);
        String key=databaseReference.push().getKey();
        databaseReference.child(key).setValue(seventh_response);

    }
}
