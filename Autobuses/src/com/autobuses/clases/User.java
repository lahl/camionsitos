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
public class User {
    private int id;
    private String phone;
    private String userName;
    private String password;
    private String branch;
    private String level;
    private String name;
    private Boolean active;
    
    public User(){}
    public User(int id){ this.id = id; }
    public User(int id, String phone, String userName, String password, String branch, String level, String name, Boolean active) {
        this.id = id;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
        this.branch = branch;
        this.level = level;
        this.name = name;
        this.active = active;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
    @Override
    public String toString(){
        String strUser = "";
        strUser = "Id: " + this.id + "\n";
        strUser += "UserName: " + this.userName + "\n";
        strUser += "Password: " + this.password + "\n";
        strUser += "Branch: " + this.branch + "\n";
        strUser += "Level: " + this.level + "\n";
        strUser += "Name: " + this.name + "\n";
        strUser += "Active: " + this.active;
        System.out.println("User: \n" + strUser);
        return strUser;
    }
}
