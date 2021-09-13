package com.consumer.milktransactions;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    private static final String dbname="signup.db";
    public database(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      String  q="create table users(_id integer primary key autoincrement,rollNumber number,name text,address text,mobileNumber number,date number,liter number,price number,animal text)";
      sqLiteDatabase.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if  exists users");
        onCreate(sqLiteDatabase);
    }

    public boolean insert_data(String rollNumber, String name, String address, String mobileNumber, String date,String liter, String price, String animal)
        {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues c=new ContentValues();
            c.put("rollNumber",rollNumber);
            c.put("name",name);
            c.put("address",address);
            c.put("mobileNumber",mobileNumber);
            c.put("date",date);
            c.put("liter",liter);
            c.put("price",price);
            c.put("animal",animal);



            long r=db.insert("users",null,c);
            if (r==-1) return false;
            else
                return true;
        }
        public boolean delete_data(String rollNumber){
        SQLiteDatabase db=this.getWritableDatabase();
            Cursor cursor=db.rawQuery("select * from users  where rollNumber=?",new String[]{rollNumber});
            if (cursor.getCount()>0){

                long r=db.delete("users","rollNumber=?",new String[]{rollNumber});
                if (r==-1) return false;
                else
                    return true;
            }
            else
                return false;

        }

    public boolean update_data(String rollNumber, String name, String address, String mobileNumber, String date,String  liter, String price, String animal) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put("name",name);
        c.put("address",address);
        c.put("mobileNumber",mobileNumber);
        c.put("date",date);
        c.put("liter",liter);
        c.put("price",price);
        c.put("animal",animal);


        Cursor cursor=db.rawQuery("select * from users where rollNumber=?",new String[]{rollNumber});
        if (cursor.getCount()>0){
            long r=db.update("users",c,"rollNumber=?",new String[]{rollNumber});
            if (r==-1) return false;
            else
                return true;
        }
        return false;
    }
    public Cursor getinfo(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users",null);
        return cursor;
    }
}
