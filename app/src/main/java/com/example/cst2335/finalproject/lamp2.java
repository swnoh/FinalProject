package com.example.cst2335.finalproject;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;


// Created By Zobayed Abedin



public class lamp2 extends AppCompatActivity {





    private SeekBar seekBar;

    private int brightness;

    private ContentResolver cResolver;

    private Window window;

    TextView txtPerc;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp2);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        seekBar = (SeekBar) findViewById(R.id.seekBar);
        txtPerc = (TextView) findViewById(R.id.txtPercentage);
        cResolver =  getContentResolver();
        window = getWindow();


        BrightnessControl();
    }





    private void BrightnessControl() {
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(255);
        seekBar.setKeyProgressIncrement(1);
        try
        {
            brightness = Settings.System.getInt(cResolver, Settings.System.SCREEN_BRIGHTNESS);
            Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
        }
        catch (Settings.SettingNotFoundException e)
        {
            Log.e("Error", "Cannot access system brightness");
            e.printStackTrace();
        }
        seekBar.setProgress(brightness);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, brightness);
                WindowManager.LayoutParams layoutpars = window.getAttributes();
                layoutpars.screenBrightness = brightness / (float)255;
                window.setAttributes(layoutpars);
            }
            public void onStartTrackingTouch(SeekBar seekBar)
            {
            }
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                if(progress<=20)
                {
                    brightness=20;
                }
                else
                {
                    brightness = progress;
                }
                //Calculate the brightness percentage
                float perc = (brightness /(float)255)*100;
                txtPerc.setText((int)perc +" %");
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu m) {
        getMenuInflater().inflate(R.menu.main_toolbar, m);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem mi) {
        int id = mi.getItemId();

        switch (id) {
            case R.id.option_livingroom:
                Intent mainIntent = new Intent(lamp2.this, LivingRoom.class);
                startActivity(mainIntent);
                break;

            case R.id.option_kitchen:
                mainIntent = new Intent(lamp2.this, Kitchen.class);
                startActivity(mainIntent);
                break;

            case R.id.option_home:
                mainIntent = new Intent(lamp2.this, House.class);
                startActivity(mainIntent);
                break;

            case R.id.option_automobile:
                mainIntent = new Intent(lamp2.this, Automobile.class);
                startActivity(mainIntent);
                break;

            case R.id.option_about:
                CharSequence text = "Version 1.0, by Zobayed Abedin";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(lamp2.this, text, duration);
                toast.show();
                break;
        }
        return true;
    }



}