package com.superio.mybudget.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.superio.mybudget.R;
import com.superio.mybudget.model.Expenses;

import java.util.ArrayList;

/**
 * Created by kumar_thangaraj on 04/06/17.
 */
public class ExpensesAdapter extends ArrayAdapter<Expenses> {
    private ArrayList<Expenses> dataSet;
    Context mContext;
    public ExpensesAdapter(ArrayList<Expenses> data,Context context){
        super(context, R.layout.list_view,data);
        this.dataSet = data;
        this.mContext = context;
    }

}
