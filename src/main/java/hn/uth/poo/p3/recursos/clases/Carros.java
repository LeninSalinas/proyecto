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
public class Carros {
     private Color Color;
    private Marca Marca;
    private Modelo Modelo;
    private int Año;
    private int numeroMotor;
    private int VIN; 
    private int Placa;

    public Carros() {
    }

    public Carros(Color Color, Marca Marca, Modelo Modelo, int Año, int numeroMotor, int VIN, int Placa) {
        this.Color = Color;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Año = Año;
        this.numeroMotor = numeroMotor;
        this.VIN = VIN;
        this.Placa = Placa;
    }

    public Color getColor() {
        return Color;
    }

    public void setColor(Color Color) {
        this.Color = Color;
    }

    public Marca getMarca() {
        return Marca;
    }

    public void setMarca(Marca Marca) {
        this.Marca = Marca;
    }

    public Modelo getModelo() {
        return Modelo;
    }

    public void setModelo(Modelo Modelo) {
        this.Modelo = Modelo;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public int getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(int numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public int getPlaca() {
        return Placa;
    }

    public void setPlaca(int Placa) {
        this.Placa = Placa;
    }
    
}

