package com.example.cst2335.finalproject;

/**
 * Used for the three columns in the view temperature schedule list.
 **************************************************************************/

public class TemperatureSchedule {
    private String id;
    private String time;
    private String temp;

    /**
     * Constructor - pass in three parameters: id, time, temp
     ********************************************************************/
    public TemperatureSchedule (String id, String time, String temp){
        this.id = id;
        this.time = time;
        this.temp = temp;
    }//end constructor

    /**
     * Get ID
     ****************************************************/
    public String getID(){
        return id;
    }

    /**
     * Get time
     **************************************************/
    public String getTime(){
        return time;
    }

    /**
     * Get temperature
     *************************************************/
    public String getTemp(){
        return temp;
    }

}/*** end com.example.cst2335.finalproject.TemperatureSchedule Class***/
