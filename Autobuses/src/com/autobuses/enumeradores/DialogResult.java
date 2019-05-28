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
public enum DialogResult {
    OK (1), CANCEL (2), ERROR(3), DEFAULT(4);

    private int valor = 0; 
    private String strValor = "";
    
    DialogResult  (int valor) {  
        this.valor = valor;
        switch(valor){
            case 1: this.strValor = "Ok"; break;
            case 2: this.strValor = "Cancelado"; break;
            case 3: this.strValor = "Error"; break; 
            case 4: this.strValor = "Default"; break; 
            default:;
        }
    }
    public int getValor() { return this.valor; }  
    public static DialogResult getOpcion(int valor){ 
        DialogResult opcion = null;
        switch(valor){
            case 1: opcion = DialogResult.OK; break;
            case 2: opcion = DialogResult.CANCEL; break;
            case 3: opcion = DialogResult.ERROR; break;
            case 4: opcion = DialogResult.DEFAULT; break;
            default:;
        }
        return opcion;
    }
}
