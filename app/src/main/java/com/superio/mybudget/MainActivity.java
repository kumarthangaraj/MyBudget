package com.superio.mybudget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.superio.mybudget.activtity.Home;
import com.superio.mybudget.db.DatabaseHandler;
import com.superio.mybudget.model.Atmtrans;
import com.superio.mybudget.model.Expenses;

import java.util.Date;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*DatabaseHandler db = new DatabaseHandler(this);
        Log.d("Insert: ", "Inserting ..");
        //db.onUpgrade(db.getWritableDatabase(),2,3);
        //db.onCreate(db.getWritableDatabase());
        Expenses expense = new Expenses(new Date(),"Ice Cream",(float)100.00,"kumar");
        Atmtrans atmtran = new Atmtrans(new Date(),"SBI",(float)100.00,"kumar");
        expense.store(db);
        atmtran.store(db);
        expense.getAllRecords(db);
        atmtran.getAllRecords(db);
        atmtran.getRecords(db,"Ice");
        expense.getRecords(db,"SBI");*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void nextBtnClick(View view){
        //Toast.makeText(getBaseContext(),"Next Clicked",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Home.class);
        EditText userId = (EditText)findViewById(R.id.userId);
        String userIdInput = userId.getText().toString();
        SharedPreferences pref = getSharedPreferences(getResources().getString(R.string.prefName), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("UserId",userIdInput).commit();
        startActivity(intent);
    }
}
