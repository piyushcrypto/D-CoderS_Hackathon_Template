package com.piyush.smitnewsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {



    private EditText username, password,desig1, mobilenumber;

    private String userName, passWord, mobileNumber;

    private Button submitBtn,cancel,signup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cancel = findViewById(R.id.cancel);
        signup2=findViewById(R.id.signup2);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == cancel) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
                final sqllitehelper mydb = new sqllitehelper(this);
                final SQLiteDatabase db = mydb.getReadableDatabase();

        username = findViewById(R.id.et_1);
        password = findViewById(R.id.et_2);
        cancel = findViewById(R.id.cancel);
        desig1=findViewById(R.id.desig);
        submitBtn = findViewById(R.id.submit);
        signup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==signup2){
                    Intent intent=new Intent(getApplicationContext(),signup.class);
                    startActivity(intent);
                }
            }
        });

        submitBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            String[] columns = {"name", "pass","desig"};
                            String[] cvalues = {username.getText().toString(), password.getText().toString(),desig1.getText().toString()};
                            Cursor cursor = db.query("newsuser_table", columns, "name = ? AND pass = ? AND desig = ? ", cvalues, null, null, null);
                            if (cursor != null) {
                                if (cursor.moveToFirst()) {
                                    Intent intent = new Intent(getApplicationContext(), profileactivity.class);
                                    Toast.makeText(getApplicationContext(), "login", Toast.LENGTH_LONG).show();
                                    intent.putExtra("name", username.getText().toString());
                                    intent.putExtra("desig", desig1.getText().toString());
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Wrong login", Toast.LENGTH_LONG).show();
                                }


      /*  cancel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(v==cancel)
                        {
                            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                    }
                }
        );



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userName = username.getText().toString().toLowerCase();
                passWord = password.getText().toString().toLowerCase();
                Intent intent =  new Intent(getApplicationContext(),volleyim.class);
                intent.putExtra("Username",userName);
                intent.putExtra("Password",passWord);

                startActivity(intent);
            }
        });*/
                        }
                    }

                }
        );


    }}

