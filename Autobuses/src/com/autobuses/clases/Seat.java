/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.clases;

/**
 *
 * @author lahl_
 */
public class Seat {
    private int id;
    private Trip trip;
    private String numSeat;
    private Boolean available;
    public Seat(){}

    public Seat(int id, Trip trip, String numSeat, Boolean available) {
        this.id = id;
        this.trip = trip;
        this.numSeat = numSeat;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getNumSeat() {
        return numSeat;
    }

    public void setNumSeat(String numSeat) {
        this.numSeat = numSeat;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
    
}
