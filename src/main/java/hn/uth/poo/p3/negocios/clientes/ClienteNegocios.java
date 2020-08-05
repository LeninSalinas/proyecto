/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.negocios.clientes;

import hn.uth.poo.p3.datos.clientes.DatosClientes;
import hn.uth.poo.p3.recursos.clases.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ClienteNegocios {

    public List<Cliente> Leer(){
    List<Cliente> listaClientes=new ArrayList<>();
        try {
            listaClientes=DatosClientes.LeerClientes();
        } catch (Exception e) {
        }
        return listaClientes;
    }
    public String Insertar(Cliente clientes){
        String respuesta="Error ";
        try {
            if (clientes.getId()<=0) {
            throw new Exception("Error: el No. de identidad no debe ser menor o igual a 0");                
            }
            if (clientes.getNombre().isEmpty()) {
                throw new Exception("El nombre no debe estar vacio");
            }
            if (clientes.getRtn()<0) {
                throw new Exception("El RTN no debe ser menor o igual a 0");
            }
            if (clientes.getTelefono()<0) {
                throw new Exception("El No. de telefono no debe ser menor a 0");
            }
            if (clientes.getCorreo().isEmpty()) {
                throw new Exception("El Correo no debe estar vacio");
            }
            if (clientes.getDireccion().isEmpty()) {
                throw new Exception("La direccion no debe estar vacia");
            }
            if (clientes.getLicencia().isEmpty()) {
                throw new Exception("La licencia no debe estar vacia");
            }
            respuesta=DatosClientes.InsertarClientes(clientes);
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

    public void Actualizar(Cliente clientes) {
        try {
            DatosClientes.ActualizarClientes(clientes);
        } catch (Exception e) {
        }
    }
    
    public void Eliminar(Cliente clientes) {
        try {
            DatosClientes.EliminarCliente(clientes);
        } catch (Exception e) {
        }
    }
    
    public List<Cliente> Buscar(Cliente clientes)throws Exception{
        List<Cliente> listaClientes=new ArrayList<>();
        try {
            listaClientes=DatosClientes.BuscarClientes(clientes);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaClientes;
    }
}
