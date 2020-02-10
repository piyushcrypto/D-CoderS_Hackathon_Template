package com.piyush.smitnewsapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profileactivity extends AppCompatActivity {
    Button addnews,viewalldata;
    sqllitehelper2 mydb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);
        TextView ptv1=findViewById(R.id.ptv1);
        TextView ptv2=findViewById(R.id.ptv2);
        String username1=getIntent().getStringExtra("name");
        String designation=getIntent().getStringExtra("desig");
        ptv1.setText(username1);
        ptv2.setText(designation);
        mydb2=new sqllitehelper2(this);
        addnews=findViewById(R.id.addnews);
        viewalldata=findViewById(R.id.viewalldata);
        addnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==addnews){
                    Intent intent=new Intent(getApplicationContext(),newsedit.class);
                    startActivity(intent);
                }
            }
        });
        viewall();

    }
    public void viewall(){
        viewalldata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Cursor res1= mydb2.getalldata();
               if (res1.getCount()==0) {
                   showmessages("Empty","NO NOTICES");
                   return;
               }
               else
               {
                   StringBuffer buffer=new StringBuffer();
                   while (res1.moveToNext())
                   {
                       buffer.append("news :"+ res1.getString(0)+"\n");
                       buffer.append("username11 :"+ res1.getString(0)+"\n");
                   }
                   showmessages("NOTICES:",buffer.toString());

            }
        }
    });

}
public void showmessages(String title,String message){
    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setCancelable(true);
    builder.setTitle(title);
    builder.setMessage(message);
    builder.show();
}
}