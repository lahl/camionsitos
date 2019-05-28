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
public enum LugarCompra {
    SUCURSAL (1), PUEBLO (2);

    private int valor = 0;
    private String strValor = "";
     
    LugarCompra  (int valor) {  
        this.valor = valor;
        switch(valor){
            case 1: this.strValor = "Sucursal"; break;
            case 2: this.strValor = "Pueblo"; break; 
            default:;
        }
    }

    public int getValor() { return this.valor; } 
    public String getStrValor(){ return this.strValor; }
    public static LugarCompra getOpcion(int valor){ 
        LugarCompra opcion = null;
        switch(valor){
            case 1: opcion = LugarCompra.SUCURSAL; break;
            case 2: opcion = LugarCompra.PUEBLO; break;
            default:;
        }
        return opcion;
    }
}
