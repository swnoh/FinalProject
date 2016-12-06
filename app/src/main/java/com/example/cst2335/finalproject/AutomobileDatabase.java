package com.example.cst2335.finalproject;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wanno on 2016-10-10.
 */

public class AutomobileDatabase extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "distanceCount";
    // All Static variables
    // Database Name
    private static final String DATABASE_NAME = "automobile.db";
    // Database Version
    private static final int VERSION_NUM = 1;
    // Table Columns names
    public static String KEY_ID = "_id";
    public static String KEY_MESSAGE = "messages";

    // Constructor
    public AutomobileDatabase(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CHAT_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_MESSAGE + " TEXT" +
                ")";
        db.execSQL(CREATE_CHAT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }
}
