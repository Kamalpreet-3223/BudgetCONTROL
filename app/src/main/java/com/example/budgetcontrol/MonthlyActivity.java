package com.example.budgetcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MonthlyActivity extends AppCompatActivity {
    public static final String EXTRA_MONTH = "com.example.budgetcontrol.extra.MONTH";
    ListView listView;
    String [] months = {"January","February","March","April","May","June", "July", "August", "September", "October","November","December"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly);
        listView = findViewById(R.id.listView);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, months);
        listView.setAdapter(ad);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MonthlyActivity.this, MonthDays.class);
                startActivity(intent);
            }
        });

    }
}