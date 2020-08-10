/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.datos.Factura;

import hn.uth.poo.p3.datos.conexion.Conexion;
import hn.uth.poo.p3.recursos.clases.Carros;
import hn.uth.poo.p3.recursos.clases.Cliente;
import hn.uth.poo.p3.recursos.clases.Detalles;
import hn.uth.poo.p3.recursos.clases.Factura;
import hn.uth.poo.p3.recursos.clases.Persona;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DatosFactura {
     public static List<Factura> LeerFactura(){
    List<Factura> Factura=new ArrayList<Factura>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT NOMBRE,RTN,TELEFONO, PLACA, RESPUESTOS, NUMEROREPUESTOS, SUBTOTAL,ISV, DESCUENTO, TOTALPAGAR FROM FACTURA";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {                
                Factura factura=new Factura();
                factura.setNombre((Cliente) rs.getObject(1));
                factura.setRtn((Cliente) rs.getObject(2));
                factura.setTelefono((Cliente) rs.getObject(3));
                factura.setPlaca((Carros) rs.getObject(4));
                factura.setRespuesto(rs.getString(5));
                factura.setNumeroRepuestos((ArrayList<Detalles>)rs.getArray(6));
                factura.setSubtotal(rs.getDouble(7));
               factura.setISV(rs.getDouble(8));
               factura.setDescuento(rs.getDouble(9));
               factura.setTotalPagar(rs.getDouble(10));
                Factura.add(factura);
            }
            cn.close();
        } catch (Exception e) {
        }
        return Factura;
    }
    public static String InsertarFactura(Factura factura){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="INSERT INTO FACTURA VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setObject(1, factura.getNombre());
            ps.setObject(2, factura.getRtn());
            ps.setObject(3, factura.getTelefono());
            ps.setObject(4, factura.getPlaca());  
            ps.setString(5, factura.getRespuesto());
            ps.setArray(6, (Array) factura.getNumeroRepuestos());
            ps.setDouble(7, factura.getSubtotal());
            ps.setDouble(8, factura.getISV());
            ps.setDouble(9, factura.getDescuento());
            ps.setDouble(10, factura.getTotalPagar());
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String ActualizarFactura(Factura factura){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="UPDATE FACTURA SET RTN=? WHERE NOMBRE=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setObject(1, factura.getNombre());
            ps.setObject(2, factura.getRtn());
            ps.setObject(3, factura.getTelefono());
            ps.setObject(4, factura.getPlaca());  
            ps.setString(5, factura.getRespuesto());
            ps.setArray(6, (Array) factura.getNumeroRepuestos());
            ps.setDouble(7, factura.getSubtotal());
            ps.setDouble(8, factura.getISV());
            ps.setDouble(9, factura.getDescuento());
            ps.setDouble(10, factura.getTotalPagar());
            ps.execute();
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String EliminarFactura(Factura factura){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="DELETE FACTURA SET RTN? WHERE NOMBRE=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setObject(1, factura.getNombre());
            ps.setObject(2, factura.getRtn());
            ps.setObject(3, factura.getTelefono());
            ps.setObject(4, factura.getPlaca());  
            ps.setString(5, factura.getRespuesto());
            ps.setArray(6, (Array) factura.getNumeroRepuestos());
            ps.setDouble(7, factura.getSubtotal());
            ps.setDouble(8, factura.getISV());
            ps.setDouble(9, factura.getDescuento());
            ps.setDouble(10, factura.getTotalPagar());
            ps.execute();
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static List<Factura> BuscarFactura(Factura factura)throws SQLException{
        List<Factura> Factura=new ArrayList<Factura>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT RTN, TELEFONO, PLACA RESPUESTO, SUBTOTAL, ISV FROM FACTURA WHERE UPPER(NOMBRE) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            //ps.setString(1, "%"+carro.getMarca().toUpperCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                do {                    
                    Factura facturaObjeto=new Factura();
                    //carroObjeto.setNombre(rs.getString(6));
                    //carroObjeto.setId(rs.getInt(7));
                    Factura.add(facturaObjeto);
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
        
        return Factura;
    }
}
