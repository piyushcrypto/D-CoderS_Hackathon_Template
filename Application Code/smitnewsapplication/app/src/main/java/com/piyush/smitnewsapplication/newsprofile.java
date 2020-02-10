package com.piyush.smitnewsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class newsprofile extends AppCompatActivity {

    private ImageView userProfile;
    private TextView nameofuser1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsprofile);

        userProfile = findViewById(R.id.userProfile);
        nameofuser1 = findViewById(R.id.nameofuser1);

        Intent intent=getIntent();
        String imageurl=intent.getStringExtra("Image");
        String nameurl=intent.getStringExtra("username11");



        Glide.with(getApplicationContext()).load(imageurl).into(userProfile);
        nameofuser1.setText(nameurl);


    }
}
