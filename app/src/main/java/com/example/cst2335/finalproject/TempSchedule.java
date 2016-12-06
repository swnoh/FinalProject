package com.example.cst2335.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Calls the TempScheduleFragment class
 *************************************************************************************/
public class TempSchedule extends AppCompatActivity {

    /**
     * Attribute
     *************************************************************************/
    protected static final String ACTIVITY_NAME = "TempSchedule_Activity";

    /**
     * Set view and calls teh TempScheduleFragment class
     ***********************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_schedule);
        TempScheduleFragment tempScheduleFrag = new TempScheduleFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.activity_temp_schedule, tempScheduleFrag).commit();
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

}/******** END TimeSchedule Class ********/


