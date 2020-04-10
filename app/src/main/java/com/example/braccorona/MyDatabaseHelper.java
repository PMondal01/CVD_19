package com.example.braccorona;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME= "Corona.db";
    private static final String TABLE_NAME="corona_details";
    private static final int VERSION_NUMBER=1;

    private static final String ID="id";
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
}
