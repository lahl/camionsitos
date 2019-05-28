/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.autobuses.clases;

import com.autobuses.enumeradores.EstadoBoleto;
import com.autobuses.enumeradores.LugarCompra;
import java.util.Date; 
import com.autobuses.enumeradores.Sexo;
/**
 *
 * @author lahl_
 */
public class Ticket {
    public Ticket(){}
    public Ticket(int id, int trip, int user, int discount, String codigoCortesia, String descuentoNom, String folio, String nombre, String telefono, int genero, double subtotal, double total, int asiento, Date fechaCompra, int lugarCompra, int estado, Date fechaPago) {
        this.id = id;
        this.trip = new Trip(trip);
        this.User = new User(user);
        this.Discount = new Discount(discount);
        this.codigoCortesia = codigoCortesia;
        this.descuentoNom = descuentoNom;
        this.folio = folio;
        this.nombre = nombre;
        this.telefono = telefono;
        this.genero = Sexo.getOpcion(genero);
        this.subtotal = subtotal;
        this.total = total;
        this.asiento = asiento;
        this.fechaCompra = fechaCompra;
        this.lugarCompra = LugarCompra.getOpcion(lugarCompra);
        this.estado = EstadoBoleto.getOpcion(estado);
        this.fechaPago = fechaPago;
    }
    
    private int id; 
    private Trip trip;
    private User User;
    private Discount Discount;
    private String codigoCortesia;
    private String descuentoNom;
    private String folio;
    private String nombre;
    private String telefono;
    private Sexo genero;
    private double subtotal;
    private double total;
    private int asiento;
    private Date fechaCompra;
    private LugarCompra lugarCompra;
    private EstadoBoleto estado;
    private Date fechaPago;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public Discount getDiscount() {
        return Discount;
    }

    public void setDiscount(Discount Discount) {
        this.Discount = Discount;
    }

    public String getCodigoCortesia() {
        return codigoCortesia;
    }

    public void setCodigoCortesia(String codigoCortesia) {
        this.codigoCortesia = codigoCortesia;
    }

    public String getDescuentoNom() {
        return descuentoNom;
    }

    public void setDescuentoNom(String descuentoNom) {
        this.descuentoNom = descuentoNom;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Sexo getGenero() {
        return genero;
    }

    public void setGenero(Sexo genero) {
        this.genero = genero;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    } 
    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public LugarCompra getLugarCompra() {
        return lugarCompra;
    }

    public void setLugarCompra(LugarCompra lugarCompra) {
        this.lugarCompra = lugarCompra;
    }

    public EstadoBoleto getEstado() {
        return estado;
    }

    public void setEstado(EstadoBoleto estado) {
        this.estado = estado;
    }
    
    
}
