package com.example.cst2335.finalproject;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 *
 * Create a time list in listview, range from 1:00 - 24:00, for user to select.
 ***************************************************************************************/
public class TimeScheduleFragment extends Fragment {

    /**
     * Attribute
     **************************************************************************/
    protected static final String ACTIVITY_NAME = "TimeScheduleFragment";
    String selectedTime;
    ListView timeScheduleListView;
    private ArrayAdapter<String> listViewAdapter;  //Array adapters tells the ListView what to display

    /**
     * Default constructor
     *************************************************************************/
    public TimeScheduleFragment() {
    }// Required empty public constructor

    /**
     * Set view and inflate layout
     ***********************************************************************/
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
     *****************************************************************************/
    public void displayListView(View view){
        timeScheduleListView = (ListView) view.findViewById(R.id.timeScheduleListView);
        String[] scheduleTimeList = {"1:00","2:00","3:00","4:00","5:00","6:00","7:00","8:00","9:00","10:00","11:00",
                "12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","24:00"};
        listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,scheduleTimeList);
        timeScheduleListView.setAdapter(listViewAdapter);
    }//end displayListView()

    /**
     * Return listview action to parent activity based on listview item selection
     **********************************************************************************/
    public void clickListViewItem() {
        timeScheduleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //position is the index value of the array
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedTime = (String) timeScheduleListView.getItemAtPosition(position);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("Response", selectedTime);
                getActivity().setResult(Activity.RESULT_OK, resultIntent);
                getActivity().finish();
            }
        });
    }//end clickListViewItem()

}/***END  TimeScheduleFragment ****/
