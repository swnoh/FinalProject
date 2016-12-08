package com.example.cst2335.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Calls the TemperatureSettingFragment class
 *****************************************************************************************/
public class TemperatureSetting extends AppCompatActivity {

    /**
     * Attribute
     *********************************************************************************/
    protected static final String ACTIVITY_NAME = "TemperatureSetting";
    TemperatureSettingFragment tempSettingFrag;

    /**
     * Set view and calls the TemperatureSettingFragment class
     ********************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_setting);
        if(savedInstanceState == null){
            tempSettingFrag = new TemperatureSettingFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.activity_temperature_setting, tempSettingFrag).commit();
        }else{  //test if this works for fragment rotation
            tempSettingFrag = (TemperatureSettingFragment) getSupportFragmentManager().findFragmentByTag("TempSettingFragment");
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

}/******** END TemperatureSetting Class ********/

