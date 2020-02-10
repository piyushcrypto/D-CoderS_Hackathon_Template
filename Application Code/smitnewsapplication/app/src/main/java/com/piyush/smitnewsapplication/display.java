package com.piyush.smitnewsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class display extends AppCompatActivity {
        Button pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        pro=findViewById(R.id.pro);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==pro){
                    Intent intent=new Intent(getApplicationContext(),profileactivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
