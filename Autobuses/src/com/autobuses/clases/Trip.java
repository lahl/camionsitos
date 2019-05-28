/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.clases;

import java.sql.Time;
import java.util.Date; 

/**
 *
 * @author lahl_
 */
public class Trip {
    private int id;
    private Driver driver;
    private Bus bus;
    private Route route;
    private Date dateDeparture;
    private Date dateArrival;
    private Time hourDeparture;
    private Time hourArrival;

    public Trip(){}
    public Trip(int id){ this.id = id; }
    public Trip(int id, Driver driver, Bus bus, Route route, Date dateDeparture, Date dateArrival, Time hourDeparture, Time hourArrival) {
        this.id = id;
        this.driver = driver;
        this.bus = bus;
        this.route = route;
        this.dateDeparture = dateDeparture;
        this.dateArrival = dateArrival;
        this.hourDeparture = hourDeparture;
        this.hourArrival = hourArrival;
    }
    public Trip(int id, int driver, int bus, int route, Date dateDeparture, Date dateArrival, Time hourDeparture, Time hourArrival) {
        this.id = id;
        this.driver = new Driver(driver);
        this.bus = new Bus(bus);
        this.route = new Route(route);
        this.dateDeparture = dateDeparture;
        this.dateArrival = dateArrival;
        this.hourDeparture = hourDeparture;
        this.hourArrival = hourArrival;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Date getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(Date dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public Date getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(Date dateArrival) {
        this.dateArrival = dateArrival;
    }

    public Time getHourDeparture() {
        return hourDeparture;
    }

    public void setHourDeparture(Time hourDeparture) {
        this.hourDeparture = hourDeparture;
    }

    public Time getHourArrival() {
        return hourArrival;
    }

    public void setHourArrival(Time hourArrival) {
        this.hourArrival = hourArrival;
    } 
}
