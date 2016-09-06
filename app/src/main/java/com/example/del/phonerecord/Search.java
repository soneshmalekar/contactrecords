package com.example.del.phonerecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Search extends AppCompatActivity {
    EditText ed;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ed=(EditText)findViewById(R.id.edit);
        search=(Button)findViewById(R.id.search);

//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
////            public void onClick(View v) {
////                String sql="Select "
////            }
//        });
//
//



    }

}
