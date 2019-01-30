package com.accenture.cbzhou.myapplication;

import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SearchHandler extends FlightModel {

    //Initialize the FlightData list collection

    List<FlightModel> flight = new ArrayList<>();

    public void initData() {

        FlightModel flightModelOne = new FlightModel();
        flightModelOne.setDeparture("HKG");
        flightModelOne.setArrival("PEK");
        flightModelOne.setFlightNo("CX888");

        FlightModel flightModelTwo = new FlightModel();
        flightModelTwo.setDeparture("HKG");
        flightModelTwo.setArrival("JFK");
        flightModelTwo.setFlightNo("CX777");

        FlightModel flightModelThree = new FlightModel();
        flightModelThree.setDeparture("HKG");
        flightModelThree.setArrival("SIN");
        flightModelThree.setFlightNo("CX666");

        FlightModel flightModelFour = new FlightModel();
        flightModelFour.setDeparture("HKG");
        flightModelFour.setArrival("CUU");
        flightModelFour.setFlightNo("CX555");

        flight.add(flightModelOne);
        flight.add(flightModelTwo);
        flight.add(flightModelThree);
        flight.add(flightModelFour);
        }

    public int searchFlight() {

        initData();

        Gson gson = new Gson();
        String str = gson.toJson(flight);
        Log.d("Flight list Json data" , str);

        printAllFlight();

        int size = flight.size();
        System.out.println("Flight Data Size:"+size);
        return size;
    }

    public void printAllFlight() {

        System.out.println("console output info:");

        for (FlightModel attr : flight) {//Stronger loop
            System.out.println(attr);
        }
    }
}
