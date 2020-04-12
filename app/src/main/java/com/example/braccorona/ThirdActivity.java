package com.example.braccorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_yes,button_no;
    int third_ans=0;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        databaseReference= FirebaseDatabase.getInstance().getReference("third_response");
        button_yes=findViewById(R.id.angry_btn_yes);
        button_no=findViewById(R.id.angry_btn_no);

        button_yes.setOnClickListener(this);
        button_no.setOnClickListener(this);


    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.angry_btn_yes:
                third_ans=1;
                saveData();
                Intent intent=new  Intent(ThirdActivity.this, FourthActivity.class);
                startActivity(intent);
                break;
            case R.id.angry_btn_no:
                third_ans=0;
                saveData();
                 intent=new  Intent(ThirdActivity.this, FourthActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void saveData() {

        Third_response third_response=new Third_response(third_ans);
        String key=databaseReference.push().getKey();
        databaseReference.child(key).setValue(third_response);

    }
}
