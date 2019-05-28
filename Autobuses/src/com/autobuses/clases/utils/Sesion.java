/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.clases.utils;

/**
 *
 * @author lahl_
 */
public class Sesion {
    private static int id;
    private static String level;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Sesion.id = id;
    }

    public static String getLevel() {
        return level;
    }

    public static void setLevel(String level) {
        Sesion.level = level;
    }
}
