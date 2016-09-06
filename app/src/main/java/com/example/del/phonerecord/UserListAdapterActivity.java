package com.example.del.phonerecord;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapterActivity extends ArrayAdapter<Userinfo> {

    Context context;
    public UserListAdapterActivity(Context context, int resource, ArrayList<Userinfo> list) {
        super(context,resource,list);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Userinfo info=getItem(position);


        View view = LayoutInflater.from(context).inflate(R.layout.userlist,null);
        TextView username=(TextView)view.findViewById(R.id.name);
        TextView useraddress=(TextView)view.findViewById(R.id.number);

        username.setText(info.name);

        useraddress.setText(info.number);


        return view;

    }
}
