package com.example.cst2335.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 *
 * Displays default house temperature and a temperature setting button.
 ****************************************************************************/
public class HouseSettingFragment extends Fragment {

    /**
     * Attributes
     **********************************************************************/
    protected static final String ACTIVITY_NAME = "HouseSettingFragment";
    TextView temperatureValue;
    int temperatureDefault = 20;
    ImageButton upArrowImageButton;
    ImageButton downArrowImageButton;
    Button tempSettingButton;

    /**
     * Default constructor
     ************************************************/
    public HouseSettingFragment() {
    }// Required empty public constructor

    /**
     * Set view and inflate layout
     ************************************************************/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_house_setting, container, false);
        setTempDisplay(view);
        return view;

    }//end onCreateView()

    /**
     * Handle rotation
     *******************************************************************/
    @Override  /* test to see if it fixed the rotation issue */
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }//end onActivityCreated()

    /**
     * Initialize the widgets and set listen handlers.
     * Up and down temperature buttons that will change the house temperature.
     * Temperature Setting button that will call another activity to process its feature
     *****************************************************************************************/
    public void setTempDisplay(View view){
        temperatureValue = (TextView) view.findViewById(R.id.temperature);
        temperatureValue.setText((temperatureDefault) + "\u2103"); ;
        upArrowImageButton = (ImageButton) view.findViewById(R.id.upArrowImageButton);
        downArrowImageButton = (ImageButton) view.findViewById(R.id.downArrowImageButton);
        tempSettingButton = (Button) view.findViewById(R.id.tempSettingButton);

        upArrowImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperatureDefault++;
                temperatureValue.setText((temperatureDefault) + "\u2103");
            }//end onClick()
        });

        downArrowImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperatureDefault--;
                temperatureValue.setText((temperatureDefault) + "\u2103");
            }//end onClick()
        });

        tempSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tempSettingIntent = new Intent(getActivity(), TemperatureSetting.class);
                startActivity(tempSettingIntent);
            }//end onClick()
        });

    }//end setTempGUI()

}/***  END HouseSettingFragment Class  ***/
