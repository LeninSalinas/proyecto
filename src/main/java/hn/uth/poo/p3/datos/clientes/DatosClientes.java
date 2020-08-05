/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.datos.clientes;

import hn.uth.poo.p3.datos.conexion.Conexion;
import hn.uth.poo.p3.recursos.clases.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class DatosClientes {
    public static List<Cliente> LeerClientes(){
    List<Cliente> Clientes=new ArrayList<Cliente>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT NOMBRE, IDENTIDAD, RTN, LICENCIA, TELEFONO, CORREO, DIRECCION FROM CLIENTE";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {                
                Cliente cliente=new Cliente();
                cliente.setNombre(rs.getString(1));
                cliente.setId(rs.getInt(2));
                cliente.setRtn(rs.getInt(3));
                cliente.setLicencia(rs.getString(4));
                cliente.setTelefono(rs.getInt(5));
                cliente.setCorreo(rs.getString(6));
                cliente.setDireccion(rs.getString(7));
                Clientes.add(cliente);
            }
            cn.close();
        } catch (Exception e) {
        }
        return Clientes;
    }
    public static String InsertarClientes(Cliente clientes){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="INSERT INTO CLIENTE VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, clientes.getNombre());
            ps.setInt(2, clientes.getId());
            ps.setInt(3, clientes.getRtn());
            ps.setString(4, clientes.getLicencia());  
            ps.setInt(5, clientes.getTelefono());
            ps.setString(6, clientes.getCorreo()); 
            ps.setString(7, clientes.getDireccion());
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String ActualizarClientes(Cliente clientes){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="UPDATE CLIENTES SET IDENTIDAD=? WHERE NOMBRE=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, clientes.getNombre());
            ps.setInt(2, clientes.getId());
            ps.setInt(3, clientes.getRtn());
            ps.setString(4, clientes.getLicencia());  
            ps.setInt(5, clientes.getTelefono());
            ps.setString(6, clientes.getCorreo()); 
            ps.setString(7, clientes.getDireccion());
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String EliminarCliente(Cliente clientes){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="DELETE CLIENTES SET IDENTIDAD=? WHERE NOMBRE=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, clientes.getNombre());
            ps.setInt(2, clientes.getId());
            ps.setInt(3, clientes.getRtn());
            ps.setString(4, clientes.getLicencia());  
            ps.setInt(5, clientes.getTelefono());
            ps.setString(6, clientes.getCorreo()); 
            ps.setString(7, clientes.getDireccion());
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static List<Cliente> BuscarClientes(Cliente clientes)throws SQLException{
        List<Cliente> cliente=new ArrayList<Cliente>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT NOMBRES, IDENTIDAD FROM CLIENTES WHERE UPPER(NOMBRE) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, "%"+clientes.getNombre().toUpperCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                do {                    
                    Cliente clienteObjeto=new Cliente();
                    clienteObjeto.setNombre(rs.getString(1));
                    clienteObjeto.setId(rs.getInt(2));
                    cliente.add(clienteObjeto);
                } while (rs.next());
            } 
            else{
                throw new SQLException("Error no se encontro coincidencia");
            }
            cn.close();
            rs.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        
        return cliente;
    }
}
