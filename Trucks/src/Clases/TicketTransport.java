/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
  
import com.autobuses.enumeradores.Sexo;
import java.util.Date;

/**
 *
 * @author lahl_
 */
public class TicketTransport {
    public TicketTransport(){}
    
    private int id;
    private String idViaje;
    private String vendedor;
    private String nombreBoleto;
    private double precio;
    private String fechaCompra;
    private String sucursalVenta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(String idViaje) {
        this.idViaje = idViaje;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getNombreBoleto() {
        return nombreBoleto;
    }

    public void setNombreBoleto(String nombreBoleto) {
        this.nombreBoleto = nombreBoleto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getSucursalVenta() {
        return sucursalVenta;
    }

    public void setSucursalVenta(String sucursalVenta) {
        this.sucursalVenta = sucursalVenta;
    }
    
}
