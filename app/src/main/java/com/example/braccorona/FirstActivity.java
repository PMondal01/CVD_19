package com.example.braccorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
   // DatabaseReference databaseReference;


    //FIREBASE
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);

      //  databaseReference= FirebaseDatabase.getInstance().getReference("first_response");
        myPreferences=MyPreferences.getPreferences(this);
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

            int age=Integer.parseInt(editText.getText().toString().trim());
            //WRITE DATA
                myPreferences.setAge(age);

                 /*   SharedPreferences sharedPreferences = getSharedPreferences("user_Response", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("age", age);
                    editor.commit();
                    editText.setText("");*/

                    // String key=databaseReference.push().getKey();
                    //  First_response first_response=new First_response(age);
                    // databaseReference.child(key).setValue(first_response);
                }


        });


    }
}
