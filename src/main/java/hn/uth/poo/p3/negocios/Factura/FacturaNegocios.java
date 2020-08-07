/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.negocios.Factura;

import hn.uth.poo.p3.datos.Factura.DatosFactura;
import hn.uth.poo.p3.recursos.clases.Factura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class FacturaNegocios {
        public List<Factura> Leer(){
            List<Factura> listaFactura = new ArrayList<>();
            try {
            listaFactura=DatosFactura.LeerFactura();
            
            
            
        } catch (Exception e) {
        }
        return listaFactura;
    }
        public String Insertar(Factura factura){
        String respuesta="Error ";
        try {
            if (factura.getRespuesto().isEmpty()) {
                throw new Exception("El Repuestos no debe estar vacio");
            }
             if (factura.getPrecioRepuesto()<0) {
                throw new Exception("Tiene que ser mayor a 0");
            }
              if (factura.getSubtotal()<0) {
                throw new Exception("Tiene que ser mayor a 0");
            }
               if (factura.getISV()<0) {
                throw new Exception("Tiene que ser mayor a 0");
            }
                if (factura.getDescuento()<0) {
                throw new Exception("Tiene que ser mayor a 0");
            }
              
               if (factura.getTotalPagar()<0) {
                throw new Exception("Tiene que ser mayor a 0");
            }
              
              
              
              
            
        
     respuesta=DatosFactura.InsertarFactura(factura);
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
        public void Actualizar(Factura factura) {
        try {
            DatosFactura.ActualizarFactura(factura);
        } catch (Exception e) {
        }
    }
    
    public void Eliminar(Factura factura) {
        try {
            DatosFactura.EliminarFactura(factura);
        } catch (Exception e) {
        }
    }
    
    public List<Factura> Buscar(Factura factura)throws Exception{
        List<Factura> listaFactura=new ArrayList<>();
        try {
            listaFactura=DatosFactura.BuscarFactura(factura);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaFactura;
    }
}
