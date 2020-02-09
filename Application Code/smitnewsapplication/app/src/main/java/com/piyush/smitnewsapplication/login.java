package com.piyush.smitnewsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {



    private EditText username, password, mobilenumber;

    private String userName, passWord, mobileNumber;

    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        username = findViewById(R.id.et_1);
        password = findViewById(R.id.et_2);
       // mobilenumber = findViewById(R.id.et_3);
        submitBtn = findViewById(R.id.submit);



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userName = username.getText().toString().toLowerCase();
                passWord = password.getText().toString().toLowerCase();
               // mobileNumber = mobilenumber.getText().toString().toLowerCase();


                Intent intent =  new Intent(getApplicationContext(),volleyim.class);//after adding json edit this part
                intent.putExtra("Username",userName);
                intent.putExtra("Password",passWord);
               // intent.putExtra("Mobile",mobileNumber);
                startActivity(intent);
            }
        });
    }
}
