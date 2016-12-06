package com.example.cst2335.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created to call the HouseSettingFragment Activity class
 **************************************************************************************/
public class HouseSetting extends AppCompatActivity {

    /**
     * Attributes
     ************************************************************************/
    protected static final String ACTIVITY_NAME = "HouseSetting";
    HouseSettingFragment houseSettingFrag;

    /**
     * Call HouseSettingFragment activity
     ****************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_setting);
        if(savedInstanceState == null){
            houseSettingFrag = new HouseSettingFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.activity_house_setting, houseSettingFrag).commit();
        }else{  //test if this works for fragment rotation
            houseSettingFrag = (HouseSettingFragment) getSupportFragmentManager().findFragmentByTag("HouseSettingFragment");
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

}/***  END HouseSetting Class  **/
