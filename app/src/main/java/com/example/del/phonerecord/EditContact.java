package com.example.del.phonerecord;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditContact extends AppCompatActivity {
    TextView textView,textView2;
    DbHelper dbHelper;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        textView=(TextView)findViewById(R.id.testname);
        textView2=(TextView)findViewById(R.id.testphone);
        button=(Button)findViewById(R.id.update);
        dbHelper=new DbHelper(this);
        Intent intent=getIntent();
        String a=intent.getStringExtra("name");
        String d=intent.getStringExtra("number");
        textView.setText(a);
        textView2.setText(d);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//
//                dbHelper.updateuser("id",cv);
//            }
//        });





    }
}
