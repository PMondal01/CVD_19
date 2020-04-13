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

public class FifthActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_yes,button_no;
    int fifth_ans;
  //  DatabaseReference databaseReference;
    MyPreferences myPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

   //     databaseReference= FirebaseDatabase.getInstance().getReference("fifth_response");
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
                fifth_ans=1;
               // saveData();
               /* SharedPreferences sharedPreferences = getSharedPreferences("user_Response", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("fifth_ans", fifth_ans);
                editor.apply();*/
               myPreferences.setFifth(fifth_ans);

                Intent intent=new  Intent(FifthActivity.this, SixthActivity.class);
                startActivity(intent);
                break;
            case R.id.angry_btn_no:
                fifth_ans=0;
             //   saveData();
              /*  sharedPreferences = getSharedPreferences("user_Response", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putInt("fifth_ans", fifth_ans);
                editor1.apply();*/
                myPreferences.setFifth(fifth_ans);
                intent=new  Intent(FifthActivity.this, SixthActivity.class);
                startActivity(intent);
                break;
        }
    }

  /*  private void saveData() {

        Fifth_response fifth_response=new Fifth_response(fifth_ans);
        String key=databaseReference.push().getKey();
        databaseReference.child(key).setValue(fifth_response);
    }*/
}
