/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.recursos.clases;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Factura {
    private Persona Nombre;
    private Cliente Rtn;
    private Cliente Telefono;
    private Carros Placa;
    private String Respuesto;
    private int precioRepuesto;
    private ArrayList<Detalles> numeroRepuestos;   
    private double subtotal;
    private double ISV;
    private double Descuento;
    private double totalPagar;

    public Factura() {
    }

    public Factura(Persona Nombre, Cliente Rtn, Cliente Telefono, Carros Placa, String Respuesto, int precioRepuesto, ArrayList<Detalles> numeroRepuestos, double subtotal, double ISV, double Descuento, double totalPagar) {
        this.Nombre = Nombre;
        this.Rtn = Rtn;
        this.Telefono = Telefono;
        this.Placa = Placa;
        this.Respuesto = Respuesto;
        this.precioRepuesto = precioRepuesto;
        this.numeroRepuestos = numeroRepuestos;
        this.subtotal = subtotal;
        this.ISV = ISV;
        this.Descuento = Descuento;
        this.totalPagar = totalPagar;
    }

    public Persona getNombre() {
        return Nombre;
    }

    public void setNombre(Persona Nombre) {
        this.Nombre = Nombre;
    }

    public Cliente getRtn() {
        return Rtn;
    }

    public void setRtn(Cliente Rtn) {
        this.Rtn = Rtn;
    }

    public Cliente getTelefono() {
        return Telefono;
    }

    public void setTelefono(Cliente Telefono) {
        this.Telefono = Telefono;
    }

    public Carros getPlaca() {
        return Placa;
    }

    public void setPlaca(Carros Placa) {
        this.Placa = Placa;
    }

    public String getRespuesto() {
        return Respuesto;
    }

    public void setRespuesto(String Respuesto) {
        this.Respuesto = Respuesto;
    }

    public int getPrecioRepuesto() {
        return precioRepuesto;
    }

    public void setPrecioRepuesto(int precioRepuesto) {
        this.precioRepuesto = precioRepuesto;
    }

    public ArrayList<Detalles> getNumeroRepuestos() {
        return numeroRepuestos;
    }

    public void setNumeroRepuestos(ArrayList<Detalles> numeroRepuestos) {
        this.numeroRepuestos = numeroRepuestos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getISV() {
        return ISV;
    }

    public void setISV(double ISV) {
        this.ISV = ISV;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

}

