package com.superio.mybudget.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kumar_thangaraj on 03/06/17.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "budgetDB";

    public DatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qryString = "create table expenses (id integer primary key, user text, date text, detail text, amount real)";
        db.execSQL(qryString);
        qryString = "create table atm (id integer primary key, user text, date text, bank text, amount real)";
        Log.d("Table Create: ","Expenses Table created ");
        db.execSQL(qryString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qryString = "drop table if exists expenses";
        Log.d("Drop: ","Before drop");
        db.execSQL(qryString);
        qryString = "drop table if exists atm";
        Log.d("Drop: ", "After drop");
        db.execSQL(qryString);
    }
}
