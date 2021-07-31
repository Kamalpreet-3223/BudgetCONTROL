package com.example.budgetcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TodayActivity extends AppCompatActivity {
    EditText amount;
    EditText desc;
    Button addTodayEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        DbHandler handler = new DbHandler(this, "budgetControl6", null, 1);

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        String [] dateParts = date.split("-");
        String year = dateParts[0];
        String month = dateParts[1];
        String day = dateParts[2];

        amount = findViewById(R.id.amount);
        desc = findViewById(R.id.desc);
        addTodayEntry = findViewById(R.id.addTodayEntry);

        addTodayEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amt2 = amount.getText().toString();
                Double amt = Double.parseDouble(amt2);
                String description = desc.getText().toString();
                handler.addData(new Budget(year,month,day,amt,description));
//                handler.getData(1);
                Toast.makeText(TodayActivity.this, "Your Entry of " + amt + " has been added", Toast.LENGTH_SHORT).show();
                amount.setText("");
                desc.setText("");
            }
        });

    }
}