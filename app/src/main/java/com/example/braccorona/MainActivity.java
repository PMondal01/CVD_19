package com.example.braccorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView_H,textView_F;
    private Button button;
    private Typeface typeface_H,typeface_F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.angry_btn);
        textView_H=findViewById(R.id.text_header);
        textView_F=findViewById(R.id.text_footer);
        typeface_H=Typeface.createFromAsset(getAssets(),"font/kalpurush _ANSI.ttf");
        textView_H.setTypeface(typeface_H);
        typeface_F=Typeface.createFromAsset(getAssets(),"font/kalpurush _ANSI.ttf");
        textView_F.setTypeface(typeface_F);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent=new  Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }
}
