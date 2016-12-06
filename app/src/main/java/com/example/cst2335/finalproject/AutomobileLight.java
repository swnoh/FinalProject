package com.example.cst2335.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioGroup;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by wanno on 2016-12-05.
 */

public class AutomobileLight extends AppCompatActivity {

    private RadioGroup radioHeadlight;
    private RadioButton radioHeadlightRadio;
    private ToggleButton btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automobile_light);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        radioHeadlight = (RadioGroup) findViewById(R.id.a_radio_btn_group);
        btnDisplay = (ToggleButton) findViewById(R.id.a_radio_toggleButton);

        radioHeadlight.setEnabled(false);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if (btnDisplay.isChecked()) {
                    radioHeadlight.setEnabled(true);
                    // get selected radio button from radioGroup
                    int selectedId = radioHeadlight.getCheckedRadioButtonId();

                    // find the radiobutton by returned id
                    radioHeadlightRadio = (RadioButton) findViewById(selectedId);

                    Toast.makeText(AutomobileLight.this,
                            radioHeadlightRadio.getText(), Toast.LENGTH_SHORT).show();
                } else {
                    radioHeadlight.setEnabled(false);
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
                Intent mainIntent = new Intent(AutomobileLight.this, LivingRoom.class);
                startActivity(mainIntent);
                break;

            case R.id.option_kitchen:
                mainIntent = new Intent(AutomobileLight.this, Kitchen.class);
                startActivity(mainIntent);
                break;

            case R.id.option_home:
                mainIntent = new Intent(AutomobileLight.this, House.class);
                startActivity(mainIntent);
                break;

            case R.id.option_automobile:
                mainIntent = new Intent(AutomobileLight.this, Automobile.class);
                startActivity(mainIntent);
                break;

            case R.id.option_about:
                CharSequence text = "Version 1.0, by Seungwan Noh";
                int duration = Toast.LENGTH_SHORT; //= Toast.LENGTH_LONG if Off

                Toast toast = Toast.makeText(AutomobileLight.this, text, duration); //this is the ListActivity
                toast.show(); //display your message box
                break;
        }
        return true;
    }
}