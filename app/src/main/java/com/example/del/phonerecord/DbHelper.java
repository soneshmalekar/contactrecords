package com.example.del.phonerecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

/**
 * Created by del on 3/26/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    static String dbname="contacts";
    static int versions=1;
    String tbl_name="CREATE TABLE if not exists`user` ( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT, `number` NUMERIC )";
    public DbHelper(Context context) {
        super(context, dbname, null, versions);
        getWritableDatabase().execSQL(tbl_name);
    }
    public void datainsert(ContentValues cv)
    {
        getWritableDatabase().insert("user", "", cv);
    }
   public ArrayList<Userinfo> getalluser()
   {
       ArrayList<Userinfo> list=new ArrayList<Userinfo>();
       String sql="select * from user";
      Cursor c= getWritableDatabase().rawQuery(sql, null);
      while(c.moveToNext())
           {
                Userinfo userinfo=new Userinfo();
               userinfo.name=c.getString(c.getColumnIndex("name"));
               userinfo.number=c.getString(c.getColumnIndex("number"));
               list.add(userinfo);
           }
       c.close();
       return list;
   }
    public Userinfo getsingleuser(String id)
    {
        String sql="select * from user where id="+id;
        Cursor c= getWritableDatabase().rawQuery(sql, null);
        Userinfo userinfo=new Userinfo();
        while(c.moveToNext())
        {

            userinfo.name=c.getString(c.getColumnIndex("name"));
            userinfo.number=c.getString(c.getColumnIndex("number"));

        }
        c.close();
        return userinfo;
    }

    public boolean isUserAlreadyExisted(String name1)
    {
        String sql="select count(*) from user where name='"+name1+"' ";
        SQLiteStatement stm=getWritableDatabase().compileStatement(sql);
        long l=stm.simpleQueryForLong();
        if(l==0)
        {
            return true;

        }
        else
            return false;



    }
    public void updateuser(String id,ContentValues cv)
    {


        getWritableDatabase().update("users",cv,"id="+id,null);
    }
//    public void searchcontact()
//    {
//        String sql="Select * from user where name like=%id"
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
