package com.superio.mybudget.model;

import java.util.Date;

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
}
