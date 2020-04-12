package com.example.braccorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirstActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databaseReference= FirebaseDatabase.getInstance().getReference("first_response");
        setContentView(R.layout.activity_first);

        editText=findViewById(R.id.edittext);
        button=findViewById(R.id.angry_btn);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent=new  Intent(FirstActivity.this, SecondActivity.class);
                saveData();
                startActivity(intent);
            }

            private void saveData() {

            String age=editText.getText().toString().trim();
            String key=databaseReference.push().getKey();

            Age age1=new Age(age);
            databaseReference.child(key).setValue(age1);

            }
        });


    }
}
