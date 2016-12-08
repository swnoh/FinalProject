package com.example.cst2335.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Calls the ViewTempScheduleFragment class
 **********************************************************************************************/
public class ViewTempSchedule extends AppCompatActivity {

    /**
     * Attribute
     ******************************************************************************/
    protected static final String ACTIVITY_NAME = "ViewTempSchedule_Act";
    ViewTempScheduleFragment ViewTempScheduleFrag;

    /**
     * Set view and calls the ViewTempScheduleFragment class
     ****************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_temp_schedule);
        if(savedInstanceState == null){
            ViewTempScheduleFragment ViewTempScheduleFrag = new ViewTempScheduleFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.activity_view_temp_schedule, ViewTempScheduleFrag).commit();
        }else{  //test if this works for fragment rotation
            ViewTempScheduleFrag = (ViewTempScheduleFragment) getSupportFragmentManager().findFragmentByTag("ViewTempScheduleFragment");
        }
    }//end onCreate()

    /**
     *  Lifecyle - onResume()
     ****************************************************************************/
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }//end onResume()

    /**
     *  Lifecyle - onPause()
     ****************************************************************************/
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }//end onPause()

    /**
     *  Lifecyle - onStop()
     ****************************************************************************/
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }//end onStop()

    /**
     *  Lifecyle - onDestroy()
     ****************************************************************************/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");

    }//end onDestroy()

}/******** END House Class ********/

