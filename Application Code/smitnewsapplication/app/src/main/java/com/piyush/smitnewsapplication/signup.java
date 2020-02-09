package com.piyush.smitnewsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    private EditText name,username1, s1password,email, mobilenumber1,occupation,city;

    private String n,un,sp,csp,mbno,occ,cty;
    sqllitehelper mydb;

    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
         mydb=new sqllitehelper(this);


        username1=(EditText) findViewById(R.id.et1);
        s1password =(EditText) findViewById(R.id.et2);
        email = (EditText) findViewById(R.id.et3);
        mobilenumber1= (EditText)(findViewById(R.id.et4));
        submitBtn =(Button) findViewById(R.id.submitbtn);
        adddata();





    }
    public void adddata() {
        submitBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(v==submitBtn){
                            Intent intent=new Intent(getApplicationContext(),volleyim.class);
                            Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                      boolean success= mydb.insertdata(username1.getText().toString(),email.getText().toString(),mobilenumber1.getText().toString(),s1password.getText().toString());
                      if (success==true){
                          Toast.makeText(getApplicationContext()," Successful",Toast.LENGTH_LONG).show();

                          startActivity(intent);

                      }
                      else{
                          Toast.makeText(getApplicationContext(),"Un Successful",Toast.LENGTH_LONG).show();
                            startActivity(intent1);}
                    }}
                }
        );

    }
}
