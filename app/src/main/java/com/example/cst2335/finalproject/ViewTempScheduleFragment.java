package com.example.cst2335.finalproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Displays temperature schedule in a listview with three columns.
 * Used files: TemperatureSchedule.java, viewtempadapter.xml, ThreeColumnList.java, DBHelper.java
 */
public class ViewTempScheduleFragment extends Fragment {

    /**
     * Attribute
     *****************************************************************************/
    protected static final String ACTIVITY_NAME = "ViewTempSchedule_Fragment";
    DBHelper dbHelper;
    SQLiteDatabase sqliteDB;
    Cursor cursor;
    ListView tempListView;
    ArrayList<TemperatureSchedule> tempArrayList;
    TemperatureSchedule aTempSchedule;
    ThreeColumnList columnAdapter;

    /**
     * Default constructor
     ****************************************************************************/
    public ViewTempScheduleFragment() {
    }// Required empty public constructor

    /**
     * Set view and inflate layout
     **************************************************************************/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_temp_schedule, container, false);
        tempListView = (ListView) view.findViewById(R.id.tempListView);
        getDataFromDB(view);
    return view;
    }

    /**
     * Get data from database to populate in listview (columns)
     ****************************************************************************/
    public void getDataFromDB(View view){
        dbHelper = new DBHelper(getContext());
        SQLiteDatabase sqliteDB = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + dbHelper.TABLE_NAME;
        Cursor cursor = sqliteDB.rawQuery(selectQuery, null);
        tempArrayList = new ArrayList<>();

        /** TEST **/
        /*if (cursor.getCount()!= 0)     {
            Toast.makeText(getActivity(),"db not empty",Toast.LENGTH_SHORT).show();
        }else if(cursor.getCount()== 0)      {
            Toast.makeText(getActivity(),"db empty",Toast.LENGTH_SHORT).show();
        }*/

        aTempSchedule = new TemperatureSchedule(cursor.getColumnName(0),cursor.getColumnName(1),cursor.getColumnName(2));
        tempArrayList.add(aTempSchedule);

        if (cursor.getCount()!= 0) {
            if (cursor.moveToFirst()) {
                do {
                    aTempSchedule = new TemperatureSchedule(cursor.getString(cursor.getColumnIndex(dbHelper.KEY_ID)),
                            cursor.getString(cursor.getColumnIndex(dbHelper.KEY_TIME)),
                            cursor.getString(cursor.getColumnIndex(dbHelper.KEY_TEMPERATURE)));

                    tempArrayList.add(aTempSchedule);

                } while (cursor.moveToNext());

                ThreeColumnList columnAdapter = new ThreeColumnList(getContext(), R.layout.viewtempadapter, tempArrayList);
                tempListView.setAdapter(columnAdapter);
                // cursor.close();
                //sqliteDB.close();
            }//inner if stmt
        }//outer if stmt

    }//end getDataFromDB()

}/***** END ViewTempScheduleFragment Class ******/
