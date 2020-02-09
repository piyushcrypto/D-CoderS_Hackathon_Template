package com.piyush.smitnewsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, gallery1,ecm, mmenu, noa;
    private WebView wv1;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        //btn5=findViewById(R.id.btn5);
        ecm=findViewById(R.id.ecm       );
        gallery1 = findViewById(R.id.gallery1);
        noa = findViewById(R.id.noa);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        //  btn5.setOnClickListener(this);
        ecm.setOnClickListener(this);
        gallery1.setOnClickListener(this);
        noa.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == btn1) {
            String value = btn1.getText().toString();
            Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), login.class);
            intent.putExtra("GettingBtnValue", value);
            startActivity(intent);
        } else if (v == btn2) {
            String value = btn2.getText().toString();
            Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), signup.class);
            intent.putExtra("GettingBtnValue", value);
            startActivity(intent);
        } else if (v == gallery1) {
            String value = gallery1.getText().toString();
            Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), webview.class);
            intent.putExtra("GettingBtnValue", value);
            startActivity(intent);
        } else if (v == btn3) {
            String value = btn3.getText().toString();
            Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), volleyim.class);
            intent.putExtra("GettingBtnValue", value);
            startActivity(intent);
        }
        else if(v==btn4)
        {
            String value = noa.getText().toString();
            Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),webview2.class);
            intent.putExtra("GettingBtnValue",value);
            startActivity(intent);
        }
        else if(v==ecm)
        {
            String value = ecm.getText().toString();
            Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),ecampus.class);
            intent.putExtra("GettingBtnValue",value);
            startActivity(intent);
        }
        }
    }
