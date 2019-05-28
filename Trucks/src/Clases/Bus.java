/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author lalon
 */
public class Bus {
    
    int id;
    String enrollment;
    String details;
    int seating;
    String photo;
    String unidNum;
    
    public Bus(int id){ this.id = id; }
    public Bus(){}
    public void setId(int id){
        this.id=id;
    }
    
    public int getId(){
        return id;
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
