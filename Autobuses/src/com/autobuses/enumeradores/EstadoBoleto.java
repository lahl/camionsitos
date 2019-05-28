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
public enum EstadoBoleto {
    VENDIDO (1), CANCELADO (2), RESERVADO(3), CORTESIA(4);

    private int valor = 0;
    private String strValor = "";
     
    EstadoBoleto  (int valor) {  
        this.valor = valor;
        switch(valor){
            case 1: this.strValor = "Vendido"; break;
            case 2: this.strValor = "Cancelado"; break;
            case 3: this.strValor = "Reservado"; break;
            case 4: this.strValor = "Cortesía"; break;
            default:;
        }
    }

    public int getValor() { return this.valor; } 
    public String getStrValor(){ return this.strValor; }
    public static EstadoBoleto getOpcion(int valor){ 
        EstadoBoleto opcion = null;
        switch(valor){
            case 1: opcion = EstadoBoleto.VENDIDO; break;
            case 2: opcion = EstadoBoleto.CANCELADO; break;
            case 3: opcion = EstadoBoleto.RESERVADO; break;
            case 4: opcion = EstadoBoleto.CORTESIA; break;
            default:;
        }
        return opcion;
    }
}
