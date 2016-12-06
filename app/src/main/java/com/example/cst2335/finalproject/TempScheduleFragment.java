package com.example.cst2335.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 *
 * Create a temperature list in listview, range from 0-30 celsuis, for user
 * to select.
 *****************************************************************************/
public class TempScheduleFragment extends Fragment {

    /**
     * Attribute
     *******************************************************************************/
    protected static final String ACTIVITY_NAME = "TempScheduleFragment";
    String selectedTemperature;
    ListView tempScheduleListView;
    private ArrayAdapter<String> listViewAdapter;  //Array adapters tells the ListView what to display

    /**
     * Default constructor
     ******************************************************************************/
    public TempScheduleFragment() { // Required empty public constructor
    }

    /**
     * Set view and inflate layout
     ***************************************************************************/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_time_schedule, container, false);
        displayListView(view);
        clickListViewItem();
        return view;
    }//end onCreateView()

    /**
     * Set ListView and Array Adaptor in order to display the list
     *******************************************************************************/
    public void displayListView(View view){
        tempScheduleListView = (ListView) view.findViewById(R.id.timeScheduleListView);
        String[] scheduleTempList = {"0"+"\u2103","1"+"\u2103","2"+"\u2103","3"+"\u2103","4"+"\u2103","5"+"\u2103",
                "6"+"\u2103","7"+"\u2103","8"+"\u2103","9"+"\u2103","10"+"\u2103","11"+"\u2103","12"+"\u2103",
                "13"+"\u2103","14"+"\u2103","15"+"\u2103","16"+"\u2103","17"+"\u2103","18"+"\u2103","19"+"\u2103",
                "20"+"\u2103","21"+"\u2103","22"+"\u2103","23"+"\u2103","24"+"\u2103","25"+"\u2103","26"+"\u2103",
                "27"+"\u2103","28"+"\u2103","29"+"\u2103","30"+"\u2103"};
        listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,scheduleTempList);
        tempScheduleListView.setAdapter(listViewAdapter);
    }//end displayListView()

    /**
     * Return listview action to parent activity based on listview item selection
     ******************************************************************************************/
    public void clickListViewItem() {
        tempScheduleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //position is the index value of the array
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedTemperature = (String) tempScheduleListView.getItemAtPosition(position);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("Response", selectedTemperature);
                getActivity().setResult(Activity.RESULT_OK, resultIntent);
                getActivity().finish();
            }
        });
    }//end clickListViewItem()

}/***END TempScheduleFragment Class ****/
