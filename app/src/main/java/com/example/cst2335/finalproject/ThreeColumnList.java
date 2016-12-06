package com.example.cst2335.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created to display the data into three columns
 *******************************************************/

public class ThreeColumnList extends ArrayAdapter<TemperatureSchedule> {

    /**
     * Attribute
     ********************************************************************/
    private LayoutInflater inflater;
    private ArrayList<TemperatureSchedule> tempScheduleList;
    private int viewSourceID;

    /**
     * Constructor - set view and layout
     ***************************************************************************/
    public ThreeColumnList(Context context, int textViewResourceID, ArrayList<TemperatureSchedule> tempScheduleList) {
        super(context, textViewResourceID, tempScheduleList);
        this.tempScheduleList = tempScheduleList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewSourceID = textViewResourceID;
    }//end constructor

    /**
     * Get and return a view. Set values in the columns from passed in parameters
     **********************************************************************************/
    public View getView(int position, View convertView, ViewGroup parents){
        convertView = inflater.inflate(viewSourceID, null);
        TemperatureSchedule aTempSchedule = tempScheduleList.get(position);

        if(aTempSchedule != null){
            TextView textID = (TextView) convertView.findViewById(R.id.text_ID);
            TextView texttTime = (TextView) convertView.findViewById(R.id.text_Time);
            TextView textTemp = (TextView) convertView.findViewById(R.id.text_Temp);

            if(textID != null){
                textID.setText(aTempSchedule.getID());
            }

            if(texttTime != null){
                texttTime.setText(aTempSchedule.getTime());
            }

            if(textTemp != null){
                textTemp.setText(aTempSchedule.getTemp());
            }
        }//end outer if

        return convertView;

    }//end getView

}/*** END com.example.cst2335.finalproject.ThreeColumnList Class***/