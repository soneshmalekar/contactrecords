package com.example.del.phonerecord;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InsertContact extends AppCompatActivity {
    EditText name,number;
    Button save,all;
    int id;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_contact);
        name=(EditText)findViewById(R.id.txtname);
        number=(EditText)findViewById(R.id.txtphone);
        save=(Button)findViewById(R.id.savebtn);
        all=(Button)findViewById(R.id.alldata);

        dbHelper=new DbHelper(this);
        if(id!=0)
        {
            Userinfo userinfo=dbHelper.getsingleuser(id + "");
            name.setText(userinfo.name);
            number.setText(userinfo.number);


        }
//
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertinfo();
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InsertContact.this,UserListViewActivity.class);
                startActivity(intent);
            }
        });



    }

    public void insertinfo()
    {     boolean validation=true;
        String contactname=name.getText().toString();
        String contactnumber=number.getText().toString();
        if(contactname.length()==0)
                {name.setError("enter the name");

                    validation=false;
                }

        if(validation)
        {
            ContentValues cv = new ContentValues();
            cv.put("name", contactname);
            cv.put("number", contactnumber);
            if(id==0) {
                if (dbHelper.isUserAlreadyExisted(contactname)) {
                    dbHelper.datainsert(cv);
                    Toast.makeText(this, "Contact Saved", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "name already Exist", Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                dbHelper.updateuser("id",cv);
                Toast.makeText(this, "updated sucessfully", Toast.LENGTH_LONG).show();

            }

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.save) {
            insertinfo();
        }

        return super.onOptionsItemSelected(item);
    }


}
