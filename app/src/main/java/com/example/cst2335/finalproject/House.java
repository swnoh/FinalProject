package com.example.cst2335.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Displays the list of house features by calling the house fragment.
 ********************************************************************************/
public class House extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "House_Activity";
    HouseFragment houseFrag;

    /**
     * Set view and calls the house fragment activity
     ****************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);
        if(savedInstanceState == null){
            houseFrag = new HouseFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.activity_house, houseFrag).commit();
        }else{  //test if this works for fragment rotation
            houseFrag = (HouseFragment) getSupportFragmentManager().findFragmentByTag("HouseFragment");
        }

    }//end onCreate()

    /**
     * Inflate navigation menu bar
     * ****************************************************************/
    public boolean onCreateOptionsMenu (Menu m) {
        getMenuInflater().inflate(R.menu.main_toolbar, m);
        return true;
    }

    /**
     * Options in the navigation menu bar
     * ****************************************************************/
    public boolean onOptionsItemSelected (MenuItem mi) {
        int id = mi.getItemId();

        switch (id) {
            case R.id.option_livingroom:
                Intent mainIntent = new Intent(this, LivingRoom.class);
                startActivity(mainIntent);
                break;

            case R.id.option_kitchen:
                mainIntent = new Intent(this, Kitchen.class);
                startActivity(mainIntent);
                break;

            case R.id.option_home:
                mainIntent = new Intent(this, House.class);
                startActivity(mainIntent);
                break;

            case R.id.option_automobile:
                mainIntent = new Intent(this, Automobile.class);
                startActivity(mainIntent);
                break;
        }
        return true;
    }


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
