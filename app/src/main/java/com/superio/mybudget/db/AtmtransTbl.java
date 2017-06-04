package com.superio.mybudget.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.superio.mybudget.model.Atmtrans;
import com.superio.mybudget.model.Expenses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumar_thangaraj on 03/06/17.
 */
public class AtmtransTbl {
    private static final String USER = "User";
    private static final String DATE = "Date";
    private static final String BANK = "bank";
    private static final String AMOUNT = "Amount";
    private static final String TBL_NAME = "ATM";
    public String formQueryForDrop(){
        String qryString = "drop table if exists "+TBL_NAME;
        return qryString;
    }
    public String formQueryForCreate(){
        String qryString = "create table atm (id integer primary key, user text, date text, bank text, amount real)";
        return qryString;
    }
    public void addRecord(Atmtrans atmTrans, DatabaseHandler db){
        SQLiteDatabase writter = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER,atmTrans.getUserId());
        values.put(DATE,atmTrans.getDate().toString());
        values.put(BANK,atmTrans.getBankId());
        values.put(AMOUNT,atmTrans.getAmount());
        writter.insert(TBL_NAME, null, values);
        writter.close();
    }
    public List<Atmtrans> getAllRecords(Atmtrans atmTran,DatabaseHandler handler){
        List<Atmtrans> atmTransList = new ArrayList<Atmtrans>();
        SQLiteDatabase db = handler.getWritableDatabase();
        Log.d("Get :","Inside getRecords Atmtrans");
        String selectQuery = "Select amount,bank,user from "+TBL_NAME;
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                Atmtrans atmTrans = new Atmtrans();
                Log.d("Fetched : ", cursor.getString(0));
                atmTrans.setAmount(Float.parseFloat(cursor.getString(0)));
                Log.d("Fetched : ", cursor.getString(1));
                atmTrans.setBankId(cursor.getString(1));
                Log.d("Fetched : ", cursor.getString(2));
                atmTrans.setUserId(cursor.getString(2));
                atmTransList.add(atmTrans);
            }while(cursor.moveToNext());
        }
        return atmTransList;
    }
    public List<Atmtrans> getRecords(Atmtrans atmTran,DatabaseHandler handler, String query){
        List<Atmtrans> atmTransList = new ArrayList<Atmtrans>();
        SQLiteDatabase db = handler.getWritableDatabase();
        Cursor cursor = db.query(TBL_NAME, new String[]{AMOUNT, BANK, USER}, "bank=?", new String[]{query}, null, null, null);
        if(cursor.moveToFirst()){
            do{
                Atmtrans atmTrans = new Atmtrans();
                Log.d("Fetched ** : ", cursor.getString(0));
                atmTrans.setAmount(Float.parseFloat(cursor.getString(0)));
                Log.d("Fetched ** : ", cursor.getString(1));
                atmTrans.setBankId(cursor.getString(1));
                Log.d("Fetched ** : ", cursor.getString(2));
                atmTrans.setUserId(cursor.getString(2));
                atmTransList.add(atmTrans);
            }while(cursor.moveToNext());
        }
        return atmTransList;
    }
}
