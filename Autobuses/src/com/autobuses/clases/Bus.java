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
public class Bus {
    private int id;
    private String enrollment;
    private String details;
    private int seating;
    private String photo;
    private String unidNum;  
    public Bus(){}
    public Bus(int id){ this.id = id; }
    public Bus(int id, String enrollment, String details, int seating, String photo, String unidNum) {
        this.id = id;
        this.enrollment = enrollment;
        this.details = details;
        this.seating = seating;
        this.photo = photo;
        this.unidNum = unidNum;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getSeating() {
        return seating;
    }

    public void setSeating(int seating) {
        this.seating = seating;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUnidNum() {
        return unidNum;
    }

    public void setUnidNum(String unidNum) {
        this.unidNum = unidNum;
    }
}
