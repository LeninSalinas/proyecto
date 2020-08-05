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
public class Cliente extends Persona {
    
    private int Rtn;
    private String Licencia;
    private int telefono;
    private String correo;
    private String direccion;    

    public Cliente() {
    }

    public Cliente(int Rtn, String Licencia, int telefono, String correo, String direccion, int Id, String Nombre) {
        super(Id, Nombre);
        this.Rtn = Rtn;
        this.Licencia = Licencia;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public int getRtn() {
        return Rtn;
    }

    public void setRtn(int Rtn) {
        this.Rtn = Rtn;
    }

    public String getLicencia() {
        return Licencia;
    }

    public void setLicencia(String Licencia) {
        this.Licencia = Licencia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}

