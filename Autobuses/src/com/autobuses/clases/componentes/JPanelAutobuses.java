/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.clases.componentes;

import javax.swing.JPanel;

/**
 *
 * @author lahl_
 */
public class JPanelAutobuses extends JPanel {
    public JPanelAutobuses(){}
    public JPanelAutobuses(int asiento) {
        this.asiento = asiento;
    }
    
    private int asiento;
    private Boolean reservado = false;

    public Boolean getReservado() {
        return reservado;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    } 
    
    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }
    
}
