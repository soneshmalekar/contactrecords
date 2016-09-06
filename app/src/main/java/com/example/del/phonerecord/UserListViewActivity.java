package com.example.del.phonerecord;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by del on 3/27/2016.
 */
public class UserListViewActivity extends AppCompatActivity {
    ListView listView;
    DbHelper dbHelper;
    ImageView add,search;
    Userinfo userinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewadapter);
        add=(ImageView)findViewById(R.id.add);
        search=(ImageView)findViewById(R.id.search);
        dbHelper=new DbHelper(this);

        userinfo=new Userinfo();
        listView=(ListView)findViewById(R.id.listview);
        listView.setAdapter(new UserListAdapterActivity(this, 0, dbHelper.getalluser()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                dbHelper.getsingleuser(id+"");
                userinfo = dbHelper.getsingleuser(id + "");
                Intent intent = new Intent(UserListViewActivity.this, UserDetail.class);
                intent.putExtra("name", userinfo.name);
                intent.putExtra("id", userinfo.id);
                intent.putExtra("number", userinfo.number);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserListViewActivity.this, InsertContact.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserListViewActivity.this, Search.class);
                startActivity(intent);
            }
        });


    }


}
