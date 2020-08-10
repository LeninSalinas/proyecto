/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.negocios.imagen;

import hn.uth.poo.p3.datos.imagen.DatosImagen;
import hn.uth.poo.p3.recursos.clases.Imagen;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Dell
 */
public class ImagenNegocios {
    public List<Imagen> Leer(){
    List<Imagen> listaClientes=new ArrayList<>();
        try {
            listaClientes=DatosImagen.LeerImagen();
        } catch (Exception e) {
        }
        return listaClientes;
    }
    public String Insertar(Imagen foto){
        String respuesta="Error ";
        try {
            respuesta=DatosImagen.InsertarImagen(foto);
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

    public void Actualizar(Imagen foto) {
        try {
            DatosImagen.ActualizarImagen(foto);
        } catch (Exception e) {
        }
    }
    
    public void Eliminar(Imagen foto) {
        try {
            DatosImagen.EliminarImagen(foto);
        } catch (Exception e) {
        }
    }
    
    public List<Imagen> Buscar(Imagen foto)throws Exception{
        List<Imagen> listaImagen=new ArrayList<>();
        try {
            listaImagen=DatosImagen.BuscarImagen(foto);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaImagen;
    
    }
}
