package com.autobuses.enumeradores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 

/**
 *
 * @author lahl_
 */
public enum Sexo {
    HOMBRE (1), MUJER (2);

    private int valor = 0;
    private String strValor = "";
     
    Sexo  (int valor) {  
        this.valor = valor;
        switch(valor){
            case 1: this.strValor = "Hombre"; break;
            case 2: this.strValor = "Mujer"; break;
            default:;
        }
    }

    public int getValor() { return this.valor; } 
    public String getStrValor(){ return this.strValor; }
    public static Sexo getOpcion(int valor){ 
        Sexo opcion = null;
        switch(valor){
            case 1: opcion = Sexo.HOMBRE; break;
            case 2: opcion = Sexo.MUJER; break;
            default:;
        }
        return opcion;
    }
}
