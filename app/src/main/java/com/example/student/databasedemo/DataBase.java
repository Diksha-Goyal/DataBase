package com.example.student.databasedemo;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by student on 3/21/2017.
 */

public class DataBase extends SQLiteOpenHelper {

    public static final String DBName="android.db";
   public static final int DbVersion = 1;
    public static final String TAG="State";


    public DataBase(Context con) {
        super(con,DBName,null,DbVersion);
    }



    public static final String TABLENAME="product";
    public static final String TABLECOLUMN_NAME="pname";
    public static final String TABLECOLUMN_ID="pid";
    public static final String TABLECOLUMN_PRICE="pprice";
    public static final String TABLECOLUMN_QTY="pqty";

    public String QUERY="create table"+TABLENAME+"("+TABLECOLUMN_ID+" int primary key, "
            +TABLECOLUMN_NAME+"TEXT"+TABLECOLUMN_PRICE+" int, "+TABLECOLUMN_QTY+" int )";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(QUERY);
            Log.d(TAG, "Table Created");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            Log.d(TAG, " "+e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
