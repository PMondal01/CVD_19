package com.example.braccorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirstActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    MyPreferences myPreferences;
    String message;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);

        myPreferences=MyPreferences.getPreferences(this);
        setContentView(R.layout.activity_first);

        editText=findViewById(R.id.edittext);
        button=findViewById(R.id.angry_btn);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent=new  Intent(FirstActivity.this, SecondActivity.class);


                if (editText.getText().toString().trim().length() > 0){
                    int age=Integer.parseInt(editText.getText().toString().trim());
                    myPreferences.setAge(age);
                    startActivity(intent);
                }else {
                    Toast.makeText(FirstActivity.this,
                            "Enter your age", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
