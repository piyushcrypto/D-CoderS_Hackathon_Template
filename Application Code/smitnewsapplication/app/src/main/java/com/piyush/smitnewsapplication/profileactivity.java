package com.piyush.smitnewsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class profileactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);
        TextView ptv1=findViewById(R.id.ptv1);
        String username1=getIntent().getStringExtra("name");
        ptv1.setText(username1);
    }
}
