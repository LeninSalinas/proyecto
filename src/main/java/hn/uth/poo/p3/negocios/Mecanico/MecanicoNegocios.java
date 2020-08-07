/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.negocios.Mecanico;

import hn.uth.poo.p3.datos.Mecanico.DatosMecanico;
import hn.uth.poo.p3.recursos.clases.Mecanico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class MecanicoNegocios {
           public List<Mecanico> Leer(){
            List<Mecanico> listaMecanico = new ArrayList<>();
            try {
            listaMecanico=DatosMecanico.LeerMecanico();
            
            
            
        } catch (Exception e) {
        }
        return listaMecanico;
    }
        public String Insertar(Mecanico mecanico){
        String respuesta="Error ";
        try {
            if (mecanico.getNumeroEmpleado()<0) {
                throw new Exception("El numero de mecanico tiene que ser mayor a 0");
            }
        
     respuesta=DatosMecanico.InsertarMecanico(mecanico);
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
        public void Actualizar(Mecanico mecanico) {
        try {
            DatosMecanico.ActualizarMecanico(mecanico);
        } catch (Exception e) {
        }
    }
    
    public void Eliminar(Mecanico mecanico) {
        try {
            DatosMecanico.EliminarMecanico(mecanico);
        } catch (Exception e) {
        }
    }
    
    public List<Mecanico> Buscar(Mecanico mecanico)throws Exception{
        List<Mecanico> listaMecanico=new ArrayList<>();
        try {
            listaMecanico=DatosMecanico.BuscarMecanico(mecanico);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaMecanico;
    }
}

