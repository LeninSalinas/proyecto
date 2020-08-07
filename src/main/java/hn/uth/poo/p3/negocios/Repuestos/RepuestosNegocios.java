/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.negocios.Repuestos;

import hn.uth.poo.p3.datos.Repuestos.DatosRepuestos;
import hn.uth.poo.p3.recursos.clases.Repuestos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class RepuestosNegocios {
    public List<Repuestos> Leer(){
            List<Repuestos> listaRepuestos = new ArrayList<>();
            try {
            listaRepuestos=DatosRepuestos.LeerRepuestos();
            
            
            
        } catch (Exception e) {
        }
        return listaRepuestos;
    }
        public String Insertar(Repuestos repuestos){
        String respuesta="Error ";
        try {
            if (repuestos.getRepuestos().isEmpty()) {
                throw new Exception("El Repuestos no debe estar vacio");
            }
        
     respuesta=DatosRepuestos.InsertarRepuestos(repuestos);
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
        public void Actualizar(Repuestos repuestos) {
        try {
            DatosRepuestos.ActualizarRepuestos(repuestos);
        } catch (Exception e) {
        }
    }
    
    public void Eliminar(Repuestos repuestos) {
        try {
            DatosRepuestos.EliminarRepuestos(repuestos);
        } catch (Exception e) {
        }
    }
    
    public List<Repuestos> Buscar(Repuestos repuestos)throws Exception{
        List<Repuestos> listaRepuestos=new ArrayList<>();
        try {
            listaRepuestos=DatosRepuestos.BuscarRepuestos(repuestos);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaRepuestos;
    }
}

