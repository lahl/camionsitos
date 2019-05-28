/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.enumeradores;

/**
 *
 * @author lahl_
 */
public enum Sexo {
    HOMBRE ("Hombre", 1), MUJER ("Mujer", 2);

    private int valor = 0;
    private String strValor = "";
     
    Sexo  (String strValor, int valor) {  
        this.valor = valor;
        this.strValor = strValor;
    }

    public int getValor() { return this.valor; } 
    public String getStrValor(){ return this.strValor; }
}
