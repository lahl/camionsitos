/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.clases;

import java.util.Date;

/**
 *
 * @author lahl_
 */
public class Driver {
    private int id;
    private String name;
    private String cel;
    private String license;
    private Date birthDate;
    private Date apSart;
    private Date apEnd;
    private String email;
    private Date contractDateStart;
    private Date contractDateEnd;
    private String addres;
    
    public Driver(){}
    public Driver(int id){ this.id = id; }
    public Driver(int id, String name, String cel, String license, Date birthDate, Date apSart, Date apEnd, String email, Date contractDateStart, Date contractDateEnd, String addres) {
        this.id = id;
        this.name = name;
        this.cel = cel;
        this.license = license;
        this.birthDate = birthDate;
        this.apSart = apSart;
        this.apEnd = apEnd;
        this.email = email;
        this.contractDateStart = contractDateStart;
        this.contractDateEnd = contractDateEnd;
        this.addres = addres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getApSart() {
        return apSart;
    }

    public void setApSart(Date apSart) {
        this.apSart = apSart;
    }

    public Date getApEnd() {
        return apEnd;
    }

    public void setApEnd(Date apEnd) {
        this.apEnd = apEnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getContractDateStart() {
        return contractDateStart;
    }

    public void setContractDateStart(Date contractDateStart) {
        this.contractDateStart = contractDateStart;
    }

    public Date getContractDateEnd() {
        return contractDateEnd;
    }

    public void setContractDateEnd(Date contractDateEnd) {
        this.contractDateEnd = contractDateEnd;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
    
}
