package com.superio.mybudget.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.util.Log;

import com.superio.mybudget.model.Expenses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kumar_thangaraj on 03/06/17.
 */
public class ExpensesTbl {
    private static final String USER = "User";
    private static final String DATE = "Date";
    private static final String DETAIL = "detail";
    private static final String AMOUNT = "Amount";
    private static final String TBL_NAME = "expenses";

    public String formQueryForDrop(){
        String qryString = "drop table if exists "+TBL_NAME;
        return qryString;
    }
    public String formQueryForCreate(){
        String qryString = "create table expenses (id integer primary key, user text, date text, detail text, amount real)";
        return qryString;
    }
    public void addRecord(Expenses expenses, DatabaseHandler db){
        SQLiteDatabase writter = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER,expenses.getUserId());
        values.put(DATE,expenses.getDate().toString());
        values.put(DETAIL,expenses.getDetail());
        values.put(AMOUNT,expenses.getAmount());
        writter.insert(TBL_NAME, null, values);
        writter.close();
    }
    public List<Expenses> getAllRecords(Expenses expense,DatabaseHandler handler){
        List<Expenses> expensesList = new ArrayList<Expenses>();
        SQLiteDatabase db = handler.getWritableDatabase();
        String selectQuery = "Select amount,detail,user from "+TBL_NAME;
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                Expenses expenses = new Expenses();
                Log.d("Fetched : ", cursor.getString(0));
                expenses.setAmount(Float.parseFloat(cursor.getString(0)));
                Log.d("Fetched : ", cursor.getString(1));
                expenses.setDetail(cursor.getString(1));
                Log.d("Fetched : ", cursor.getString(2));
                expenses.setUserId(cursor.getString(2));
                expensesList.add(expenses);
            }while(cursor.moveToNext());
        }
        return expensesList;
    }
    public List<Expenses> getRecords(Expenses expense,DatabaseHandler handler, String query){
        List<Expenses> expensesList = new ArrayList<Expenses>();
        SQLiteDatabase db = handler.getWritableDatabase();
        Log.d("Get :","Inside getRecords Expenses");
        Cursor cursor = db.query(TBL_NAME, new String[]{AMOUNT, DETAIL, USER}, "detail =?", new String[] {query}, null, null, null);
        if(cursor.moveToFirst()){
            do{
                Expenses expenses = new Expenses();
                Log.d("Fetched ** : ", cursor.getString(0));
                expenses.setAmount(Float.parseFloat(cursor.getString(0)));
                Log.d("Fetched ** : ", cursor.getString(1));
                expenses.setDetail(cursor.getString(1));
                Log.d("Fetched ** : ", cursor.getString(2));
                expenses.setUserId(cursor.getString(2));
                expensesList.add(expenses);
            }while(cursor.moveToNext());
        }
        return expensesList;
    }
}
