/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.clases.utils;
 
import java.text.DecimalFormat; 
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale; 

/**
 *
 * @author lahl_
 */
public class Funciones {
    public static String convertToCurrency(double number){
        DecimalFormat format = (DecimalFormat)NumberFormat.getCurrencyInstance(Locale.US);
        String currency = format.format(number);
        return currency;
    }
    
    public static double convertToNumber(String number) throws ParseException{
        double numero = 0;
        String s1 = number = number.replaceAll(",", "");
        String s2 = s1.replaceAll("$", "");
        numero = Double.parseDouble(s2);
        return numero; 
    }
    
    public static String removerCaracteresEspeciales(String input){
        String output = input.replaceAll("[^a-zA-Z0-9]", "");
        return output;
    }
    
    public static Boolean isNullOrEmpty(String cadena){
        Boolean empty = false;
        if (cadena == null){
            empty = true;
        } else if (cadena.equals("")){
            empty = true;
        }
        return empty;
    }
}
