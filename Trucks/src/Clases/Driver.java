/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author lalon
 */
public class Driver {
    
    int id;
    String name;
    String license;
    String cel;
    String addres;
    String email;
    Date birthDate;
    Date apStart;
    Date apEnd;
    Date contractDateStart;
    Date contractDateEnd;
    
    public Driver(int id){ this.id = id; }
    public Driver(){}
    
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

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getApStart() {
        return apStart;
    }

    public void setApStart(Date apStart) {
        this.apStart = apStart;
    }

    public Date getApEnd() {
        return apEnd;
    }

    public void setApEnd(Date apEnd) {
        this.apEnd = apEnd;
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
    
    
    
    
    
    
    
}
