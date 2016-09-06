package com.example.del.phonerecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {
    DbHelper dbHelper;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        dbHelper=new DbHelper(this);
        linearLayout=(LinearLayout)findViewById(R.id.holder);
        populatelist();
    }
    public void populatelist()
    {
        ArrayList<Userinfo> list=dbHelper.getalluser();
        for (int i=0;i<list.size();i++)
        {
            final Userinfo info=list.get(i);
//            TextView textView=new TextView(this);
//            textView.setText(info.name);


//arko view ma haleko
            View view =LayoutInflater.from(this).inflate(R.layout.userlist,null);
            TextView username=(TextView)view.findViewById(R.id.name);
            TextView useraddress=(TextView)view.findViewById(R.id.number);

            username.setText(info.name);

            useraddress.setText(info.number);

            linearLayout.addView(view);
        }
    }
}
