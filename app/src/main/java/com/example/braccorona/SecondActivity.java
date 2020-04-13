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
    private Button button_load;
    int second_ans=0;
    TextView textView;
    MyPreferences myPreferences;
    // DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  databaseReference= FirebaseDatabase.getInstance().getReference("second_response");
          myPreferences = MyPreferences.getPreferences(this);

        setContentView(R.layout.activity_second);

        button_yes=findViewById(R.id.angry_btn_yes);
        button_no=findViewById(R.id.angry_btn_no);
      //  button_load=findViewById(R.id.load);

        button_yes.setOnClickListener(this);
        button_no.setOnClickListener(this);
       // button_load.setOnClickListener(this);
        textView=findViewById(R.id.textload);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.angry_btn_yes:
                second_ans=1;
               /* SharedPreferences sharedPreferences = getSharedPreferences("user_Response", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("second_ans", second_ans);
                editor.apply();*/
                myPreferences.setSecond(second_ans);
                //saveData();
                Intent intent=new  Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
                break;
            case R.id.angry_btn_no:

                second_ans=0;
                myPreferences.setSecond(second_ans);
               /* sharedPreferences = getSharedPreferences("user_Response", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences.edit();
                editor1.putInt("second_ans", second_ans);
                editor1.apply();*/

               // saveData();
                intent=new  Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
                break;

           /* case R.id.load:

                 int value=  myPreferences.getSecond();
                 int age=myPreferences.getAge();
                 textView.setText(String.valueOf(age));*/


        }
    }

   /* private void saveData() {

        Second_response second_response=new Second_response(second_ans);
        String key=databaseReference.push().getKey();
        databaseReference.child(key).setValue(second_response);


    }*/
}
