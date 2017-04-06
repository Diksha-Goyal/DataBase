package com.example.student.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by student on 3/21/2017.
 */

public class DBConnection {

    private DataBase myDB;
    public static final String TAG="State";

    private SQLiteDatabase sql;

    public DBConnection(Context context) {
        myDB = new DataBase(context);
        sql = myDB.getWritableDatabase();
        Log.d(TAG, "DBConnection Created");
    }
    public boolean insertData(int id, String name, int price, int qty){
        boolean flag=false;
        ContentValues contentValues= new ContentValues();
        contentValues.put(myDB.TABLECOLUMN_ID,id);
        contentValues.put(myDB.TABLECOLUMN_NAME,name);
        contentValues.put(myDB.TABLECOLUMN_PRICE,price);
        contentValues.put(myDB.TABLECOLUMN_QTY,qty);
        long row= sql.insert(myDB.TABLENAME,null,contentValues);

        if(row>0)
        {
            flag=true;
            Log.d(TAG, "Data inserted");
        }
        else
        {
            Log.d(TAG, "Data is not inserted");
        }
        return flag;
    }
    String ColName[] = {myDB.TABLECOLUMN_ID,myDB.TABLECOLUMN_NAME,myDB.TABLECOLUMN_PRICE,myDB.TABLECOLUMN_QTY};

    public String[] display()
    {
        Cursor cur= sql.query(myDB.TABLENAME,ColName,null,null,null,null,null);
        if(cur.getCount()>0)
        {
            cur.moveToFirst();
        }
        String [] str = {cur.getString(0)+""+cur.getString(1)+""+cur.getString(2)+""+cur.getString(3)};

        return str;
    }
    //return null;
}
