package com.piyush.smitnewsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newsedit extends AppCompatActivity {
    EditText et11,et22;
    Button submit3;
    sqllitehelper2 mydb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsedit);
        mydb1=new sqllitehelper2(this);

        et11=(EditText) findViewById(R.id.et11);
        et22=(EditText) findViewById(R.id.et22);
        submit3=findViewById(R.id.submit3);
        adddata1();

    }
    public void adddata1()
    {
        submit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==submit3){
                    Intent intent=new Intent(getApplicationContext(),display.class);
                    boolean success= mydb1.insertdata11(et11.getText().toString(),et22.getText().toString());
                    if (success==true){
                        Toast.makeText(getApplicationContext()," Successful",Toast.LENGTH_LONG).show();

                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Un Successful",Toast.LENGTH_LONG).show();
                        startActivity(intent);}
                }}
                                   }
        );

    }
}

