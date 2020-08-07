/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.negocios.Persona;

import hn.uth.poo.p3.datos.Persona.DatosPersona;
import hn.uth.poo.p3.recursos.clases.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class PersonaNegocios {
    public List<Persona> Leer(){
            List<Persona> listaPersona = new ArrayList<>();
            try {
            listaPersona=DatosPersona.LeerPersona();
            
            
            
        } catch (Exception e) {
        }
        return listaPersona;
    }
        public String Insertar(Persona persona){
        String respuesta="Error ";
        try {
            if (persona.getId()<0) {
                throw new Exception("El ID debe de ser mayor a 0");
            }
             if (persona.getNombre().isEmpty()) {
                throw new Exception("Debe de llenar nombre");
            }
              
              
              
              
            
        
     respuesta=DatosPersona.InsertarPersona(persona);
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
        public void Actualizar(Persona persona) {
        try {
            DatosPersona.ActualizarPersona(persona);
        } catch (Exception e) {
        }
    }
    
    public void Eliminar(Persona persona) {
        try {
            DatosPersona.EliminarPersona(persona);
        } catch (Exception e) {
        }
    }
    
    public List<Persona> Buscar(Persona persona)throws Exception{
        List<Persona> listaPersona=new ArrayList<>();
        try {
            listaPersona=DatosPersona.BuscarPersona(persona);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaPersona;
    }
}
