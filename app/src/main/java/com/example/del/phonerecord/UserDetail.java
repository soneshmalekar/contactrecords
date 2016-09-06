package com.example.del.phonerecord;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by del on 3/27/2016.
 */
public class UserDetail extends AppCompatActivity {
    DbHelper dbHelper;
    TextView textView,textview2;
    ImageView edit;
    Userinfo userinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetail);
        dbHelper=new DbHelper(this);
        userinfo=new Userinfo();
        edit=(ImageView)findViewById(R.id.edit);
        textView=(TextView)findViewById(R.id.name);
        textview2=(TextView)findViewById(R.id.number);
        final Intent intent=getIntent();
       final String b=intent.getStringExtra("name");
        final int e=intent.getIntExtra("id",0);
        final String c=intent.getStringExtra("number");
        textView.setText(b);

        textview2.setText(c);
//        String sql="select * from user where id="+b;
//        Toast.makeText(this,"id="+sql,Toast.LENGTH_LONG).show();
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent1=new Intent(UserDetail.this,EditContact.class);
                //yeta error cha,...
                intent1.putExtra("name",b);
                intent1.putExtra("number",c);
                intent1.putExtra("id",e);
                startActivity(intent1);
            }
        });

    }
}
