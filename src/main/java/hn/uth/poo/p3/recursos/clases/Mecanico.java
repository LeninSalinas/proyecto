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
public class Mecanico extends Persona{
    private int numeroEmpleado;   

    public Mecanico() {
    }
    

    public Mecanico(int numeroEmpleado, int Id, String Nombre) {
        super(Id, Nombre);
        this.numeroEmpleado = numeroEmpleado;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }
    
     
}
