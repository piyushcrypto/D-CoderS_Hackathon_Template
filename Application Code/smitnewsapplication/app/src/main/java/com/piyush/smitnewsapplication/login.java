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



    private EditText username, password, mobilenumber;

    private String userName, passWord, mobileNumber;

    private Button submitBtn,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cancel = findViewById(R.id.cancel);
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
        submitBtn = findViewById(R.id.submit);
        submitBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (v == submitBtn) {
                            String[] columns = {"name", "pass"};
                            String[] cvalues = {username.getText().toString(), password.getText().toString()};
                            Cursor cursor = db.query("student_table", columns, "name = ? AND pass = ?", cvalues, null, null, null);
                            if (cursor != null) {
                                if (cursor.moveToFirst()) {
                                    Intent intent = new Intent(getApplicationContext(), profileactivity.class);
                                    Toast.makeText(getApplicationContext(), "login", Toast.LENGTH_LONG).show();
                                    intent.putExtra("name", username.getText().toString());
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Wrong login", Toast.LENGTH_LONG).show();
                                }
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

