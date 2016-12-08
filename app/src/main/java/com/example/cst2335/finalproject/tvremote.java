package com.example.cst2335.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



// Created By Zobayed Abedin



public class tvremote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        Button goButton = (Button)findViewById(R.id.button2);

        final EditText channelNumber = (EditText)findViewById(R.id.editText);

        TextView showChannel = (TextView)findViewById(R.id.textView4);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText channelNumber = (EditText)findViewById(R.id.editText);

                TextView showChannel = (TextView)findViewById(R.id.textView4);

                showChannel.setText(channelNumber.getText().toString());

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
                Intent mainIntent = new Intent(tvremote.this, LivingRoom.class);
                startActivity(mainIntent);
                break;

            case R.id.option_kitchen:
                mainIntent = new Intent(tvremote.this, Kitchen.class);
                startActivity(mainIntent);
                break;

            case R.id.option_home:
                mainIntent = new Intent(tvremote.this, House.class);
                startActivity(mainIntent);
                break;

            case R.id.option_automobile:
                mainIntent = new Intent(tvremote.this, Automobile.class);
                startActivity(mainIntent);
                break;

            case R.id.option_about:
                CharSequence text = "Version 1.0, by Zobayed Abedin";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(tvremote.this, text, duration);
                toast.show();
                break;
        }
        return true;
    }
}
