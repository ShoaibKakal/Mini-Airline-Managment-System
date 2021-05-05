package com.company.Assignment3;

import java.time.LocalDate;
import java.util.ArrayList;

public class TravelerInfo {
    private String CNIC;
    private String name;
    private String dateOfTravelling;
    private String source;
    private String destination;
    private Boolean isOneWay;
    private LocalDate dateOfBooking;
    private ArrayList<String> bookedSeats;


    public TravelerInfo() {
    }

    public TravelerInfo(String CNIC, String name, String dateOfTravelling, String source, String destination, Boolean isOneWay, LocalDate dateOfBooking, ArrayList<String> bookedSeats) {
        this.CNIC = CNIC;
        this.name = name;
        this.dateOfTravelling = dateOfTravelling;
        this.source = source;
        this.destination = destination;
        this.isOneWay = isOneWay;
        this.dateOfBooking = dateOfBooking;
        this.bookedSeats = bookedSeats;
    }


    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfTravelling() {
        return dateOfTravelling;
    }

    public void setDateOfTravelling(String dateOfTravelling) {
        this.dateOfTravelling = dateOfTravelling;
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

    public Boolean getOneWay() {
        return isOneWay;
    }

    public void setOneWay(Boolean oneWay) {
        isOneWay = oneWay;
    }

    public LocalDate getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(LocalDate dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public ArrayList<String> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(ArrayList<String> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
