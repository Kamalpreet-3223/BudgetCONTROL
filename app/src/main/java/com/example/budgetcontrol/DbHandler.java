package com.example.budgetcontrol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {

    public DbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE budget (id INTEGER PRIMARY KEY AUTOINCREMENT, amt_paid DOUBLE, description TEXT, date TEXT, month TEXT, year TEXT)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(drop, new String[]{"budget"});
        onCreate(db);
    }

    public void addData(Budget budget){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("amt_paid", budget.getAmt_paid());
        values.put("description", budget.getDescription());
        values.put("date", budget.getDate());
        values.put("month", budget.getMonth());
        values.put("year", budget.getYear());
        long k = db.insert("budget", null, values);
        Log.d("mytag", Long.toString(k));
        db.close();
    }

    public void getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("budget", new String[]{"date", "month", "year", "id", "amt_paid", "description"},
                "id=?", new String[]{String.valueOf(id)}, null, null, null);
        if(cursor != null && cursor.moveToFirst()){
            Log.d("mytag id", cursor.getString(3));
            Log.d("mytag amt_paid", cursor.getString(4));
            Log.d("mytag description", cursor.getString(5));
            Log.d("mytag date", cursor.getString(0));
            Log.d("mytag month", cursor.getString(1));
            Log.d("mytag year", cursor.getString(2));
        }
        else{
            Log.d("mytag", "Some error occurred");
        }
    }
    public void getData(String month){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("budget", new String[]{"date", "month", "year", "id", "amt_paid", "description"},
                "month=?", new String[]{String.valueOf(month)}, null, null, null);
        if(cursor != null && cursor.moveToFirst()){
            Log.d("mytag id", cursor.getString(3));
            Log.d("mytag amt_paid", cursor.getString(4));
            Log.d("mytag description", cursor.getString(5));
            Log.d("mytag date", cursor.getString(0));
            Log.d("mytag month", cursor.getString(1));
            Log.d("mytag year", cursor.getString(2));
        }
        else{
            Log.d("mytag", "Some error occurred");
        }
    }
}
