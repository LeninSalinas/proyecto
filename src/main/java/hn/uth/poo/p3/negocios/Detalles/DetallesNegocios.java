/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.negocios.Detalles;

import hn.uth.poo.p3.datos.Detalles.DatosDetalles;
import hn.uth.poo.p3.recursos.clases.Detalles;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DetallesNegocios {
        public List<Detalles> Leer(){
            List<Detalles> listaDetalles = new ArrayList<>();
            try {
            listaDetalles=DatosDetalles.LeerDetalles();
            
            
            
        } catch (Exception e) {
        }
        return listaDetalles;
    }
        public String Insertar(Detalles detalles){
        String respuesta="Error ";
        try {
            if (detalles.getImpacto().isEmpty()) {
                throw new Exception("El impacto no debe estar vacio");
            }
            if (detalles.isPintura()) {
                throw new Exception("Selecciona una opcion ");
            }
            if (detalles.getNumeroRepuestos()<0) {
                
            throw new Exception("El No. de Repuestos no debe de estar vacio");
            }
        
     respuesta=DatosDetalles.InsertarDetalles(detalles);
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
        public void Actualizar(Detalles detalles) {
        try {
            DatosDetalles.ActualizarDetalles(detalles);
        } catch (Exception e) {
        }
    }
    
    public void Eliminar(Detalles detalles) {
        try {
            DatosDetalles.EliminarDetalles(detalles);
        } catch (Exception e) {
        }
    }
    
    public List<Detalles> Buscar(Detalles detalles)throws Exception{
        List<Detalles> listaDetalles=new ArrayList<>();
        try {
            listaDetalles=DatosDetalles.BuscarDetalles(detalles);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaDetalles;
    }
    
}
