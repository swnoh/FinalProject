package com.example.cst2335.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;



// Created By Zobayed Abedin



public class lamp1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);



        final Switch switch1 = (Switch)findViewById(R.id.bulb);
        final ImageView imageView = (ImageView)findViewById(R.id.imageView1);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked == true) {

                   Toast toast =  Toast.makeText(getApplicationContext()," Lamp is now on !",Toast.LENGTH_LONG);

                    toast.show();

                    imageView.setImageResource(R.drawable.bulbon);

                }

                if (isChecked == false) {

                   Toast toast =  Toast.makeText(getApplicationContext()," Lamp is now off !",Toast.LENGTH_LONG);

                    toast.show();
                    imageView.setImageResource(R.drawable.bulboff);
                }
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
                Intent mainIntent = new Intent(lamp1.this, LivingRoom.class);
                startActivity(mainIntent);
                break;

            case R.id.option_kitchen:
                mainIntent = new Intent(lamp1.this, Kitchen.class);
                startActivity(mainIntent);
                break;

            case R.id.option_home:
                mainIntent = new Intent(lamp1.this, House.class);
                startActivity(mainIntent);
                break;

            case R.id.option_automobile:
                mainIntent = new Intent(lamp1.this, Automobile.class);
                startActivity(mainIntent);
                break;

            case R.id.option_about:
                CharSequence text = "Version 1.0, by Zobayed Abedin";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(lamp1.this, text, duration);
                toast.show();
                break;
        }
        return true;
    }
}
