package com.example.cst2335.finalproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Calls the OutsideWeatherFragment class.
 **********************************************************************************/
public class OutsideWeather extends AppCompatActivity {

    /**
     * Attribute
     *****************************************************************************/
    protected static final String ACTIVITY_NAME = "Forecast_Activity";

    /**
     * Set view and calls the OutsideWeatherFragment class
     * **************************************************************************/
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_outside_weather);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        OutsideWeatherFragment outsideWeatherFrag = new OutsideWeatherFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.activity_outside_weather, outsideWeatherFrag).commit();
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

}/******** END OutsideWeather Class ********/

