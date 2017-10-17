package com.flylimitless.flylimitless;


public class FlightDetails {

    private String source;
    private String destination;
    private String flightNo;
    private String arrivalTime;
    private String departureTime;
    private String price;

    public FlightDetails() {

    }

    public FlightDetails(String source, String destination, String departureTime, String arrivalTime, String price, String flightNo) {
        this.source = source;
        this.destination = destination;
        this.flightNo = flightNo;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.price= price;
    }



    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price= price;
    }

}
