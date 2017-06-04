package com.superio.mybudget.activtity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.superio.mybudget.R;
import com.superio.mybudget.model.Expenses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Home extends Activity {
    private String userId = "";
    private String date = "";
    private Expenses[] expensesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        getUserId();
        setDate();
        if(expensesList == null){
            Expenses locExpense = new Expenses();
            expensesList[0] = locExpense;
        }

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.list_view,expensesList);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getUserId(){
        SharedPreferences pref = getSharedPreferences(getResources().getString(R.string.prefName), Context.MODE_PRIVATE);
        userId = pref.getString("UserId","");
        //Toast.makeText(getApplicationContext(),"UserId Entered is "+userId,Toast.LENGTH_SHORT).show();
        TextView userIdView = (TextView)findViewById(R.id.userId);
        userIdView.setText(userId);
    }
    public void setDate(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy");
        date = format1.format(calendar.getTime());
        TextView dateView = (TextView)findViewById(R.id.date);
        dateView.setText(date);
    }
}
