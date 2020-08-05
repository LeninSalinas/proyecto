/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.negocios.carros;

import hn.uth.poo.p3.datos.carros.DatosCarros;
import hn.uth.poo.p3.recursos.clases.Carros;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class CarrosNegocios {
    public List<Carros> Leer(){
    List<Carros> listaCarros=new ArrayList<>();
        try {
            listaCarros=DatosCarros.LeerCarros();
        } catch (Exception e) {
        }
        return listaCarros;
    }
    public String Insertar(Carros carros){
        String respuesta="Error ";
        try {
            if (carros.getAño()<=0) {
            throw new Exception("Error: el No. de añio no debe ser menor o igual a 0");                
            }
            if (carros.getNumeroMotor()<0) {
                throw new Exception("El NO. de motor no debe ser menor 0");
            }
            if (carros.getPlaca()<0) {
                throw new Exception("El No. de placa no debe ser menor a 0");
            }
            if (carros.get()<0) {
                throw new Exception("El Correo no debe estar vacio");
            }
            if (clientes.getDireccion().isEmpty()) {
                throw new Exception("La direccion no debe estar vacia");
            }
            if (clientes.getLicencia().isEmpty()) {
                throw new Exception("La licencia no debe estar vacia");
            }
            respuesta=DatosCarros.InsertarCarros(carros);
            if (respuesta==null) {
                respuesta="Guardado exitosamente";
            }
        } catch (Exception e) {
            respuesta=e.getMessage();
        }
        finally{
            return respuesta;
        }
    }

    public void Actualizar(Carros carros) {
        try {
            DatosCarros.ActualizarCarros(carros);
        } catch (Exception e) {
        }
    }
    
    public void Eliminar(Carros carros) {
        try {
            DatosCarros.EliminarCarros(carros);
        } catch (Exception e) {
        }
    }
    
    public List<Carros> Buscar(Carros carros)throws Exception{
        List<Carros> listaCarros=new ArrayList<>();
        try {
            listaCarros=DatosCarros.BuscarCarros(carros);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaCarros;
    }
}
