/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enumeradores;

/**
 *
 * @author lahl_
 */
public enum TipoBoleto {
    VENDIDO ("Vendido", 1), CANCELADO ("Cancelado", 2), RESERVADO("Reservado", 3);

    private int valor = 0;
    private String strValor = "";
     
    TipoBoleto  (String strValor, int valor) {  
        this.valor = valor;
        this.strValor = strValor;
    }

    public int getValor() { return this.valor; } 
    public String getStrValor(){ return this.strValor; }
}
