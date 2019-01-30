package com.accenture.cbzhou.myapplication;

public class FlightModel {
    private String departure;
    private String arrival;
    private String flightNo;

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "FlightModel{" +
                "departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", flightNo='" + flightNo + '\'' +
                '}';
    }
}
