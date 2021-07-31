package com.example.budgetcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

        DbHandler handler = new DbHandler(this, "budgetControl6", null, 1);
        Toast.makeText(this, "Your app is working", Toast.LENGTH_SHORT).show();
        //handler.addData(new Budget(85.89,"Treat to Guri",currentDateTimeString));
        //handler.getData(1);
        handler.close();

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        String [] dateParts = date.split("-");
        String year = dateParts[0];
        String month = dateParts[1];
        String day = dateParts[2];

    }

    public void TodayActivity(View v){
        Toast.makeText(this, "Add Today's Entry", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, TodayActivity.class);
        startActivity(intent);
    }

    public void MonthlyActivity(View v){
        Toast.makeText(this, "See your Month's Expenses", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MonthlyActivity.class);
        startActivity(intent);
    }
}