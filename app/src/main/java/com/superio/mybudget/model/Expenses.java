package com.superio.mybudget.model;

import com.superio.mybudget.db.DatabaseHandler;
import com.superio.mybudget.db.ExpensesTbl;

import java.util.Date;
import java.util.List;

/**
 * Created by kumar_thangaraj on 01/06/17.
 */
public class Expenses {
    int id;
    Date date;
    String detail;
    float amount;
    String userId;

    public Expenses(){

    }
    public Expenses(Date date, String detail, float amount, String userId){
        this.amount = amount;
        this.detail = detail;
        this.userId = userId;
        this.date = date;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public void setDetail(String detail){
        this.detail = detail;
    }
    public void setAmount(float amount){
        this.amount = amount;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public Date getDate(){
        return this.date;
    }
    public String getUserId(){
        return this.userId;
    }
    public float getAmount(){
        return this.amount;
    }
    public String getDetail(){
        return this.detail;
    }
    public int getId(){
        return this.id;
    }
    public String toString(){
        return "UserId: "+this.userId+"; Date: "+this.date+"; Detail: "+this.detail+"; Amount: "+this.amount+";";
    }

    public void store(DatabaseHandler dbHandler){
        ExpensesTbl tbl = new ExpensesTbl();
        tbl.addRecord(this,dbHandler);
    }
    public List<Expenses> getAllRecords(DatabaseHandler dbHandler){
        ExpensesTbl tbl = new ExpensesTbl();
        return tbl.getAllRecords(this,dbHandler);
    }
    public List<Expenses> getRecords(DatabaseHandler dbHandler, String query){
        ExpensesTbl tbl = new ExpensesTbl();
        return tbl.getRecords(this, dbHandler,query);
    }
}
