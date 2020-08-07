/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.negocios.Color;

import hn.uth.poo.p3.datos.Color.DatosColor;
import hn.uth.poo.p3.recursos.clases.Color;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ColorNegocios {
    public List<Color> Leer(){
            List<Color> listaColor = new ArrayList<>();
            try {
            listaColor=DatosColor.LeerColor();
            
            
            
        } catch (Exception e) {
        }
        return listaColor;
    }
        public String Insertar(Color color){
        String respuesta="Error ";
        try {
            if (color.getColor().isEmpty()) {
                throw new Exception("El color no debe estar vacio");
            }
        
     respuesta=DatosColor.InsertarColor(color);
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
        public void Actualizar(Color color) {
        try {
            DatosColor.ActualizarColor(color);
        } catch (Exception e) {
        }
    }
    
    public void Eliminar(Color color) {
        try {
            DatosColor.EliminarColor(color);
        } catch (Exception e) {
        }
    }
    
    public List<Color> Buscar(Color color)throws Exception{
        List<Color> listaColor=new ArrayList<>();
        try {
            listaColor=DatosColor.BuscarColor(color);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaColor;
    }
        
        
}