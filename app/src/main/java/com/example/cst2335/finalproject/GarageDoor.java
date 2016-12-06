package com.example.cst2335.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GarageDoor extends AppCompatActivity {
    GarageDoorFragment garageDoorFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_door);
        if(savedInstanceState == null){
             garageDoorFrag = new GarageDoorFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.activity_garage_door, garageDoorFrag).commit();
        }else{  //test if this works for fragment rotation
            garageDoorFrag = (GarageDoorFragment) getSupportFragmentManager().findFragmentByTag("GarageDoorFragment");
        }

    }//end onCreate()

}/**  END GarageDoor Class ***/
