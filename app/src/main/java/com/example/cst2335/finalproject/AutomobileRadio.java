package com.example.cst2335.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

/**
 * Created by wanno on 2016-12-05.
 */

public class AutomobileRadio extends AppCompatActivity {
    private Spinner spinner;
    private TextView radioChannel;
    private static final String[] radiolists = {"LIVE 88.5 (Alternative Rock)",
            "CBC Radio One Ottawa (National News)", "New Country 94 (Country)",
            "Unique FM (Community)", "Rebel 101.7 FM (Rock)", "KISS FM (Top 40/Pop)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automobile_radio);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        spinner = (Spinner) findViewById(R.id.a_radio_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AutomobileRadio.this,
                android.R.layout.simple_spinner_item, radiolists);

        radioChannel = (TextView) findViewById(R.id.a_radio_freq);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                switch (position) {
                    case 0:
                        radioChannel.setText("88.5");
                        break;
                    case 1:
                        radioChannel.setText("91.5");
                        break;
                    case 2:
                        radioChannel.setText("93.9");
                        break;
                    case 3:
                        radioChannel.setText("94.5");
                        break;
                    case 4:
                        radioChannel.setText("101.7");
                        break;
                    case 5:
                        radioChannel.setText("105.3");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
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
                Intent mainIntent = new Intent(AutomobileRadio.this, LivingRoom.class);
                startActivity(mainIntent);
                break;

            case R.id.option_kitchen:
                mainIntent = new Intent(AutomobileRadio.this, Kitchen.class);
                startActivity(mainIntent);
                break;

            case R.id.option_home:
                mainIntent = new Intent(AutomobileRadio.this, House.class);
                startActivity(mainIntent);
                break;

            case R.id.option_automobile:
                mainIntent = new Intent(AutomobileRadio.this, Automobile.class);
                startActivity(mainIntent);
                break;

            case R.id.option_about:
                CharSequence text = "Version 1.0, by Seungwan Noh";
                int duration = Toast.LENGTH_SHORT; //= Toast.LENGTH_LONG if Off

                Toast toast = Toast.makeText(AutomobileRadio.this, text, duration); //this is the ListActivity
                toast.show(); //display your message box
                break;
        }
        return true;
    }

}