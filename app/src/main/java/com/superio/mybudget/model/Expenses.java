package com.superio.mybudget.model;

import java.util.Date;

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
    public void setUser(String userId){
        this.userId = userId;
    }
    public Date getDate(){
        return this.date;
    }
    public String getUser(){
        return this.userId;
    }
    public float getAmout(){
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
}
