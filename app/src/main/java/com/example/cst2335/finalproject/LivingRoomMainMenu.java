package com.example.cst2335.finalproject;


import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.Fragment;



// Created By Zobayed Abedin




public class LivingRoomMainMenu extends ListFragment {


    boolean landscape;
    int cursor = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String [] menuItems = {
                "Lamp # 1",
                "Lamp # 2",
                "Lamp # 3",
                "Television Remote",
                "Blinds"};


        ArrayAdapter<String> connectArrayToListView = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_activated_1,
                menuItems);


        setListAdapter(connectArrayToListView);
        if (savedInstanceState != null) {
            cursor = savedInstanceState.getInt("curChoice", 0);
        }
        if (landscape) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(cursor);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curSelection", cursor);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }

    void showDetails(int index) {
        cursor = index;



            if (cursor == 0) { // Lamp # 1
                Intent intent = new Intent();
                intent.setClass(getActivity(), lamp1.class);
                startActivity(intent);

            } else if (cursor == 1){ // Lamp # 2
                Intent intent = new Intent();
                intent.setClass(getActivity(), lamp2.class);
                startActivity(intent);

            } else if (cursor == 2){ // Lamp # 3
                Intent intent = new Intent();
                intent.setClass(getActivity(), lamp3.class);
                startActivity(intent);

            } else if (cursor == 3){ // TV
                Intent intent = new Intent();
                intent.setClass(getActivity(), tvremote.class);
                startActivity(intent);

            } else if (cursor == 4){ // Blinds
                Intent intent = new Intent();
                intent.setClass(getActivity(), blinds.class);
                startActivity(intent);


            }

    }
}