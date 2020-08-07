/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.recursos.clases;

/**
 *
 * @author DELL
 */
public class Detalles {
    private String Impacto;
    private boolean pintura;
    private int numeroRepuestos;

    public Detalles() {
    }

    public Detalles(String Impacto, boolean pintura, int numeroRepuestos) {
        this.Impacto = Impacto;
        this.pintura = pintura;
        this.numeroRepuestos = numeroRepuestos;
    }

    public String getImpacto() {
        return Impacto;
    }

    public void setImpacto(String Impacto) {
        this.Impacto = Impacto;
    }

    public boolean isPintura() {
        return pintura;
    }

    public void setPintura(boolean pintura) {
        this.pintura = pintura;
    }

    public int getNumeroRepuestos() {
        return numeroRepuestos;
    }

    public void setNumeroRepuestos(int numeroRepuestos) {
        this.numeroRepuestos = numeroRepuestos;
    }
    
    
    
    
}

