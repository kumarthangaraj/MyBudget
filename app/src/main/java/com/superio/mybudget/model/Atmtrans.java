package com.superio.mybudget.model;

import com.superio.mybudget.db.AtmtransTbl;
import com.superio.mybudget.db.DatabaseHandler;
import com.superio.mybudget.db.ExpensesTbl;

import java.util.Date;
import java.util.List;

/**
 * Created by kumar_thangaraj on 01/06/17.
 */
public class Atmtrans {
    int id;
    private Date date;
    private String bankId;
    private String userId;
    private float amount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Atmtrans(){

    }

    public Atmtrans(Date date, String bankId, float amount, String userId){
        this.amount = amount;
        this.bankId = bankId;
        this.userId = userId;
        this.date = date;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    public String toString() {
        return "UserId: " + this.userId + "; Date: " + this.date + "; BankId: " + this.bankId + "; Amount: " + this.amount + ";";
    }
    public void store(DatabaseHandler dbHandler){
        AtmtransTbl tbl = new AtmtransTbl();
        tbl.addRecord(this,dbHandler);
    }
    public List<Atmtrans> getAllRecords(DatabaseHandler dbHandler){
        AtmtransTbl tbl = new AtmtransTbl();
        return tbl.getAllRecords(this,dbHandler);
    }
    public List<Atmtrans> getRecords(DatabaseHandler dbHandler, String query){
        AtmtransTbl tbl = new AtmtransTbl();
        return tbl.getRecords(this,dbHandler,query);
    }
}
