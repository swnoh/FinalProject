package com.example.cst2335.finalproject;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class GarageDoorFragment extends Fragment implements View.OnClickListener {
    protected static final String ACTIVITY_NAME = "GarageDoorFragment";
    ImageView garageImage;
    ImageButton lightImageButton;
    Button openGarageButton;
    Button closeGarageButton;
    boolean garageDoorClosed = true;  //default
    boolean garageLightOff = true;  //default

    public GarageDoorFragment() {
        // Required empty public constructor
    }

    @Override  /* test to see if it fixed the rotation issue */
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }//end onActivityCreated()

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_garage_door, container, false);

        openGarageButton = (Button) view.findViewById(R.id.button);
        closeGarageButton = (Button) view.findViewById(R.id.button2);
        garageImage = (ImageView)view.findViewById(R.id.imageView);
        lightImageButton = (ImageButton)view.findViewById(R.id.imageButton3);
        lightImageButton.setImageResource(R.drawable.off);//turn garage light off by default

        openGarageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (garageDoorClosed) {
                    Toast.makeText(getActivity(), "Garage door is opening", Toast.LENGTH_SHORT).show();
                    garageDoorClosed = false;
                    garageImage.setImageResource(R.drawable.garage_door_open);
                    lightImageButton.setImageResource(R.drawable.onlight);
                }
                else
                    Toast.makeText(getActivity(), "Garage door is already opened", Toast.LENGTH_SHORT).show();
            }//end if
        });

        closeGarageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (garageDoorClosed)
                   Toast.makeText(getActivity(), "Garage door is already closed", Toast.LENGTH_SHORT).show();
               else {
                   Toast.makeText(getActivity(), "Garage door is closing", Toast.LENGTH_SHORT).show();
                   garageDoorClosed = true;
                   garageImage.setImageResource(R.drawable.garage_door_closed);
                   lightImageButton.setImageResource(R.drawable.off);
               }//end if
            }
        });

        lightImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (garageLightOff) { //turn the light on
                    lightImageButton.setImageResource(R.drawable.onlight);
                    Toast.makeText(getActivity(), "Garage light is on", Toast.LENGTH_SHORT).show();
                    garageLightOff = false;
                }
                else {  //turn the light off
                    lightImageButton.setImageResource(R.drawable.off);
                    Toast.makeText(getActivity(), "Garage light is off", Toast.LENGTH_SHORT).show();
                    garageLightOff = true;
                }//end if


            }
        });


            return view;
    }//end onCreateView()

    @Override
    public void onClick(View view) {

    }

}/****   END  GarageDoorFragment  ****/
