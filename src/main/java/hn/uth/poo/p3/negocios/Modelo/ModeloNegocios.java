/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.negocios.Modelo;

import hn.uth.poo.p3.datos.Modelo.DatosModelo;
import hn.uth.poo.p3.recursos.clases.Modelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ModeloNegocios {
    public List<Modelo> Leer(){
            List<Modelo> listaModelo = new ArrayList<>();
            try {
            listaModelo=DatosModelo.LeerModelo();
            
            
            
        } catch (Exception e) {
        }
        return listaModelo;
    }
        public String Insertar(Modelo modelo){
        String respuesta="Error ";
        try {
            if (modelo.getModelo().isEmpty()) {
                throw new Exception("El modelo no debe estar vacio");
            }
        
     respuesta=DatosModelo.InsertarModelo(modelo);
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
        public void Actualizar(Modelo modelo) {
        try {
            DatosModelo.ActualizarModelo(modelo);
        } catch (Exception e) {
        }
    }
    
    public void Eliminar(Modelo modelo) {
        try {
            DatosModelo.EliminarModelo(modelo);
        } catch (Exception e) {
        }
    }
    
    public List<Modelo> Buscar(Modelo modelo)throws Exception{
        List<Modelo> listaModelo=new ArrayList<>();
        try {
            listaModelo=DatosModelo.BuscarModelo(modelo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaModelo;
    }
}

