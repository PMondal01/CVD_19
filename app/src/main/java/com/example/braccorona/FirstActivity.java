package com.example.braccorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        editText=findViewById(R.id.edittext);
        button=findViewById(R.id.angry_btn);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent=new  Intent(FirstActivity.this, SecondActivity.class);
              //  intent.putExtra ( "age", editText.getText().toString() );
                startActivity(intent);


            }
        });


    }
}
