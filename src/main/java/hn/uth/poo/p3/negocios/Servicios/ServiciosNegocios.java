/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.negocios.Servicios;

import hn.uth.poo.p3.datos.Servicios.DatosServicios;
import hn.uth.poo.p3.recursos.clases.Servicios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ServiciosNegocios {
     public List<Servicios> Leer(){
            List<Servicios> listaServicios = new ArrayList<>();
            try {
            listaServicios=DatosServicios.LeerServicios();
            
            
            
        } catch (Exception e) {
        }
        return listaServicios;
    }
        public String Insertar(Servicios servicios){
        String respuesta="Error ";
        try {
            if (servicios.getNombre().isEmpty()) {
                throw new Exception("Debes de llenar la casilla de Nombre");
            }
             if (servicios.getPrecio()<0) {
                throw new Exception("Debe ser mayor a 0");
            }
             if (servicios.getCodigo()<0) {
                throw new Exception("Debe ser mayor a 0");
            }
             
              
              
              
              
            
        
     respuesta=DatosServicios.InsertarServicios(servicios);
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
        public void Actualizar(Servicios servicios) {
        try {
            DatosServicios.ActualizarServicios(servicios);
        } catch (Exception e) {
        }
    }
    
    public void Eliminar(Servicios servicios) {
        try {
            DatosServicios.EliminarServicios(servicios);
        } catch (Exception e) {
        }
    }
    
    public List<Servicios> Buscar(Servicios servicios)throws Exception{
        List<Servicios> listaServicios=new ArrayList<>();
        try {
            listaServicios=DatosServicios.BuscarServicios(servicios);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaServicios;
    }
}

