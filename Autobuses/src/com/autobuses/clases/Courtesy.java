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
public class Courtesy {
    private int id;
    private String code;
    private Boolean available;
    
    public Courtesy(){}

    public Courtesy(int id, String code, Boolean available) {
        this.id = id;
        this.code = code;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
    
}
