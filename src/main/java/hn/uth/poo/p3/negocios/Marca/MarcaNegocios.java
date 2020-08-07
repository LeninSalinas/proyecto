/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.negocios.Marca;

import hn.uth.poo.p3.datos.Marca.DatosMarca;
import hn.uth.poo.p3.recursos.clases.Marca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class MarcaNegocios {
       public List<Marca> Leer(){
            List<Marca> listaMarca = new ArrayList<>();
            try {
            listaMarca=DatosMarca.LeerMarca();
            
            
            
        } catch (Exception e) {
        }
        return listaMarca;
    }
        public String Insertar(Marca marca){
        String respuesta="Error ";
        try {
            if (marca.getMarca().isEmpty()) {
                throw new Exception("El marca no debe estar vacio");
            }
        
     respuesta=DatosMarca.InsertarMarca(marca);
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
        public void Actualizar(Marca marca) {
        try {
            DatosMarca.ActualizarMarca(marca);
        } catch (Exception e) {
        }
    }
    
    public void Eliminar(Marca marca) {
        try {
            DatosMarca.EliminarMarca(marca);
        } catch (Exception e) {
        }
    }
    
    public List<Marca> Buscar(Marca marca)throws Exception{
        List<Marca> listaColor=new ArrayList<>();
        try {
            listaColor=DatosMarca.BuscarMarca(marca);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaColor;
    }
}
