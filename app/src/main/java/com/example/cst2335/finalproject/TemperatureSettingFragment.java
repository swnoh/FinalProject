package com.example.cst2335.finalproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 *
 * Displays the GUI for the Temperature setting and viewing.
 *
 * User able to set a time and temperature schedule by selecting a new time and new temperature and
 * inserting the selection into the database.
 *
 * User also able to delete a temperature schedule that they had created.
 *
 * User able to view a list of the created temperature schedule.
 ***********************************************************************************************/
public class TemperatureSettingFragment extends Fragment {

    /**
     * Atttributes
     ******************************************************************************************/
    protected static final String ACTIVITY_NAME = "TempSettingFragment";

    Button setTimeButton;
    Button setTempButton;
    Button addNewScheduleButton;
    Button viewTempScheduleButton;
    Button deleteTempButton;
    EditText deleteTempInput;
    String returnSelectedTemp = "";
    String returnSelectedTime = "";
    CoordinatorLayout snackBar;

    DBHelper dbHelper;
    ListView tempListView;
    ArrayList<String> tempArrayList;
    private ArrayAdapter<String> tempListAdapter;  //Array adapters tells the ListView what to display
    int deleteTemp;
    int deleteResult;

    /**
     * Default constructor
     *************************************************************/
    public TemperatureSettingFragment() {
    }// Required empty public constructor


    /**
     * Set view and inflate layout
     ***********************************************************************************************/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_temperature_setting, container, false);
        viewTempList(view);
        return view;
    }//end onCreateView()

    /**
     * Handle rotation issue
     * *******************************************************************/
    @Override /* test to see if it fixed the rotation issue */
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    /**
     * Initialize all widgets.
     ************************************************************************************/
    public void viewTempList(View view) {
        setTimeButton = (Button) view.findViewById(R.id.setTimeButton);
        setTempButton = (Button) view.findViewById(R.id.setTempButton);
        addNewScheduleButton = (Button) view.findViewById(R.id.addNewSchedule);
        viewTempScheduleButton = (Button) view.findViewById(R.id.viewTempSchedule);
        deleteTempButton = (Button) view.findViewById(R.id.deleteButton);
        deleteTempInput = (EditText) view.findViewById(R.id.deleteInput);
        tempListView = (ListView) view.findViewById(R.id.tempListView);
        snackBar = (CoordinatorLayout) view.findViewById(R.id.snackBar);

        /**
         * User select a time from listivew
         *****************************************************************************/
        dbHelper = new DBHelper(getContext());  //pass in Context object which is the current activity
        setTimeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent timeScheduleIntent = new Intent(v.getContext(), TimeSchedule.class);
                startActivityForResult(timeScheduleIntent, 1); //pass in a 1 as an identifier flag when returned
            }
        });

        /**
         * User select a temperature from listivew
         *****************************************************************************/
        setTempButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tempScheduleIntent = new Intent(v.getContext(), TempSchedule.class);
                startActivityForResult(tempScheduleIntent, 2); //pass in a 2 as an identifier flag when returned
            }
        });

        /**
         * Put time and temp selection into DB - Displays snackbar when successful
         **********************************************************************/
        addNewScheduleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(returnSelectedTime.length() == 0 || returnSelectedTemp.length() == 0){
                    Toast.makeText(getActivity(), "Please select time and temperature to add a schedule.",Toast.LENGTH_SHORT).show();
                }

                if(returnSelectedTime.length() != 0 && returnSelectedTemp.length() != 0){
                    dbHelper = new DBHelper(getContext());
                    SQLiteDatabase sqliteDB = dbHelper.getWritableDatabase();
                    ContentValues newValues = new ContentValues();
                    newValues.put(dbHelper.KEY_TIME, returnSelectedTime);
                    newValues.put(dbHelper.KEY_TEMPERATURE, returnSelectedTemp);
                    sqliteDB.insert(dbHelper.TABLE_NAME, null, newValues);
                    sqliteDB.close();
                    //dbHelper.close();
                    returnSelectedTime = "";
                    returnSelectedTemp = "";
                    Snackbar snackbar_addedtemp = Snackbar
                            .make(snackBar, "New temperature schedule added to database.", Snackbar.LENGTH_LONG);
                   /* Changes the colour of the text in the snackbar */
                    View snackbarView = snackbar_addedtemp.getView();
                    snackbarView.setBackgroundColor(Color.DKGRAY);
                    TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);
                    snackbar_addedtemp.show();

                }//end if*/
            }//end onClick()
        });

        /**
         * Read from DB and display in a listview with three columns.
         *************************************************************************/
        viewTempScheduleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent viewTempListIntent = new Intent(getActivity(), ViewTempSchedule.class);
                startActivity(viewTempListIntent);
            }
        });

        /**
         * Delete a temperature schedule based on user input from the SQLite database.
         * Delete record where _id = id_input
         *************************************************************************************/
        deleteTempButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase sqliteDB = dbHelper.getWritableDatabase();
                //deleteTemp = deleteTempDiaglogue();
                //Toast.makeText(getActivity(),"deleteTemp "+deleteTemp,Toast.LENGTH_SHORT).show();
                //if (deleteTemp == 1) { //if user click OK in dialogue box
                    deleteResult = sqliteDB.delete(dbHelper.TABLE_NAME, "_id = ?", new String[]{deleteTempInput.getText().toString()});
                    //Toast.makeText(getActivity(),"Called DB, response"+deleteResult,Toast.LENGTH_SHORT).show();
                    if (deleteResult > 0) {  //record found in db
                        Snackbar snackbar_tempRemoved = Snackbar
                                .make(snackBar, "Temperature schedule is now removed from the database.", Snackbar.LENGTH_LONG);
                        /* Changes the colour of the text in the snackbar */
                        View snackbarView = snackbar_tempRemoved.getView();
                        snackbarView.setBackgroundColor(Color.DKGRAY);
                        TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextColor(Color.YELLOW);
                        snackbar_tempRemoved.show();
                        deleteTempInput.setText("");
                    } else { //record not found  (deleteResult == 0)
                        deleteTempInput.setText("");
                        Snackbar snackbar_tempUnfound = Snackbar
                                .make(snackBar, "Record unfound in the database.", Snackbar.LENGTH_LONG);
                        /* Changes the colour of the text in the snackbar */
                        View snackbarView = snackbar_tempUnfound.getView();
                        snackbarView.setBackgroundColor(Color.DKGRAY);
                        TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextColor(Color.YELLOW);
                        snackbar_tempUnfound.show();
                    }
                /*}else  if (deleteTemp == 2) {
                    deleteTempInput.setText("");
                }*/
            }
        });//end deleteTempButton.clickListener()

    }//end setTempSettingScreen()

    /**
     * Return result of selected option from a specific listview (Time listview or Temperrature listview).
     **********************************************************************************************************/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1) {
            Log.i(ACTIVITY_NAME, "Returned from TimeSchedule");
            if(resultCode == Activity.RESULT_OK)   {
                returnSelectedTime = data.getStringExtra("Response");
                Toast toast = Toast.makeText(getActivity(), "Selected time schedule: " + returnSelectedTime, Toast.LENGTH_LONG);
                toast.show();
            }//end if
        }
        else if(requestCode == 2){
            Log.i(ACTIVITY_NAME, "Returned from TempSchedule");
            if(resultCode == Activity.RESULT_OK)   {
                returnSelectedTemp = data.getStringExtra("Response");
                Toast toast = Toast.makeText(getActivity(), "Selected temperature schedule: " + returnSelectedTemp, Toast.LENGTH_LONG);
                toast.show();
            }//end if
        }//end if

    }//end onActivityResult()


    //Create dialogue box to display help information.
    //Return integer to check selected response.
    /*public Integer deleteTempDiaglogue(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        String author = "Are you sure you want to delete this temperature schedule?";

        builder.setMessage(author).setTitle("Temperature Schedule Removal")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) { // User click OK button
                        id = 1;
                        deleteTemp = id;
                       //Toast.makeText(getActivity(),"Clicked OK",Toast.LENGTH_SHORT).show();
                    }//end onClick
                })//end setPositiveButton
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        id = 2;
                        deleteTemp = id;
                       // Toast.makeText(getActivity(),"Clicked Cancel",Toast.LENGTH_SHORT).show();
                    }//end onClick
                })//end setNegativeButton
                .show(); //display dialogue box
        return deleteTemp;
        //Toast.makeText(getActivity(),"Returning"+deleteTemp,Toast.LENGTH_SHORT).show();

    }//end createDiaglogue*/

}/***** END TemperatureSettingFragment Class *****/
