package com.example.budgetcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MonthDays extends AppCompatActivity {
    ListView listView;
    String [] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_days);
        listView = findViewById(R.id.listView);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, days);
        listView.setAdapter(ad);
    }
}