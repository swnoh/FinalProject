package com.example.cst2335.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.app.Activity;
import android.util.Log;

/**
 * Contain database information of the temperature schedule and process the creation, upgrade,
 * and downgrade of the database .
 ********************************************************************************/

public class DBHelper extends SQLiteOpenHelper {

    /**
     * Attribute
     *******************************************************************************************/
        protected static final String ACTIVITY_NAME = "DBHelper_Activity";
        protected static final String DATABASE_NAME = "TempSchedule.db";  //db file
        protected static final int DATABASE_VERSION = 4;
        protected static final String TABLE_NAME = "TempScheduleTable";

        /* Column names */
        protected static final String KEY_ID = "_id";
        protected static final String KEY_TIME = "time";
        protected static final String KEY_TEMPERATURE = "\u2103";

        // Database creation sql statement
        private static final String CREATE_DATABASE = "CREATE TABLE "
                + TABLE_NAME + "( " + KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_TIME + " TEXT NOT NULL," + KEY_TEMPERATURE + " TEXT NOT NULL" + ");";


        /**
        * Default Constructor
        ***************************************************************************/
//        public DBHelper() { }

        /**
         * Constructor
         ***************************************************************************/
        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }//end constructor

    /**
     * Execute the database
     **************************************************************/
        public void onCreate(SQLiteDatabase db){
            Log.i(ACTIVITY_NAME, "In onCreate");
            db.execSQL(CREATE_DATABASE);
        }//end onCreate()

    /**
     * Upgrade the database
     *****************************************************************/
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i(ACTIVITY_NAME, "Calling onUpgrade(), oldVersion=" + oldVersion + " newVersion=" + newVersion);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }//end onUpgrade()

        /**
         * Downgrade database
         *************************************************************/
        @Override
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
            Log.i(ACTIVITY_NAME, "Calling onDownGrade(), oldVersion=" + oldVersion + " newVersion=" + newVersion);
        }//end onDowngrade()

    }/***  END DBHelper Class ***/
