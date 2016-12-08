package com.example.cst2335.finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *
 * Display a listview of the house setting features.
 *    Garage Door
 *    House Temperature
 *    Outside Temperature
 *    Help
 *********************************************************************************/
public class HouseFragment extends Fragment {

    /**
     * Attributes for the HouseFragment
     ***********************************************************************************/
    protected static final String ACTIVITY_NAME = "HouseFragment";
    ListView myListView;
    private ArrayAdapter<String> listViewAdapter;  //Array adapters tells the ListView what to display

    /**
     * Default constructor
     *********************************************************************************/
    public HouseFragment() { // Required empty public constructor
    }

    /**
     * Set the view and inflate layout
     *******************************************************************************************/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_house, container, false);
        displayListView(view);
        clickListViewItem();
        return view;
    }//end onCreateView()


    /**
     * Set Array Adaptor in order to display data to listview (house features)
     ************************************************************************************/
   public void displayListView(View view){
         myListView = (ListView) view.findViewById(R.id.HouseFragListView);
         String[] listItem = {"Garage Door", "House Temperature", "Outside Temperature", "Help"};
         listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,listItem);
         myListView.setAdapter(listViewAdapter);
    }//end displayListView()


    /**
     * Set listview action based on the house feature item selection
     ****************************************************************************/
   public void clickListViewItem() {
       myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           //position is the index value of the array
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if (position == 0) {
                   //Toast.makeText(getActivity(), "Clicked Garage Door item", Toast.LENGTH_SHORT).show();
                   Intent garageDoorIntent = new Intent(getActivity(), GarageDoor.class);
                   startActivity(garageDoorIntent);
               } else if (position == 1) {
                   //Toast.makeText(getActivity(), "Clicked House Temperature", Toast.LENGTH_SHORT).show();
                   Intent houseSettingIntent = new Intent(getActivity(), HouseSetting.class);
                    startActivity(houseSettingIntent);
               } else if (position == 2) {
                   //Toast.makeText(getActivity(), "Clicked Outside Temperature", Toast.LENGTH_SHORT).show();
                   Intent outsideWeatherIntent = new Intent(getActivity(), OutsideWeather.class);
                   startActivity(outsideWeatherIntent);
               } else if (position == 3) {
                   //Toast.makeText(getActivity(), "Clicked Help", Toast.LENGTH_SHORT).show();
                   createDiaglogue();
               }//end if stmt
           }
       });

    }//end clickListViewItem()

    /**
     * Create dialogue box to display help information
     ***************************************************************************/
    public void createDiaglogue(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        String author = "Author: My My Ngo";
        String version = "House Activity Version 1.0";
        String garagDoor_info = "Garage Door feature allows user to open and close the garage door and turn the garage light on and off.";
        String houseSetting_info = "House Setting Temperature feature allows user to set and view the house temperature. " +
                                    "Select new time and new temperature to add new schedule.";
        String outsideWeather_info = "Outside Weather feature allows user to check the outside weather temperature.";

        builder.setMessage(author + "\n\n" + version + "\n\n" + garagDoor_info + "\n\n" + houseSetting_info + "\n\n"
        + outsideWeather_info).setTitle("House Setting Feature")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) { // User click OK button
                    }//end onClick
                })//end setPositiveButton
                .show(); //display dialogue box

    }//end createDiaglogue()


}/***** END HouseFragment class *******/
