/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.datos.Servicios;

import hn.uth.poo.p3.datos.conexion.Conexion;
import hn.uth.poo.p3.recursos.clases.Servicios;
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
public class DatosServicios {
     public static List<Servicios> LeerServicios(){
    List<Servicios> Servicios =new ArrayList<Servicios>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT NOMBRE, PRECIO,CODIGO FROM SERVICIOS";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {                
                Servicios servicios=new Servicios();      
                  servicios.setNombre(rs.getString(1));
                  servicios.setPrecio(rs.getDouble(2));
                  servicios.setCodigo(rs.getInt(3));
                
                Servicios.add(servicios);
            }
            cn.close();
        } catch (Exception e) {
        }
        return Servicios;
    }
    public static String InsertarServicios(Servicios servicios){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="INSERT INTO SERVICIOS VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, servicios.getNombre());
            ps.setDouble(2, servicios.getPrecio());
            ps.setInt(3, servicios.getCodigo());
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String ActualizarServicios(Servicios servicios){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="UPDATE CODIGO SET NOMBRE=? WHERE SERVICIOS=?";
            PreparedStatement ps=cn.prepareStatement(sql);
        ps.setString(1, servicios.getNombre());
            ps.setDouble(2, servicios.getPrecio());
            ps.setInt(3, servicios.getCodigo());
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
    public static String EliminarServicios(Servicios servicios){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="DELETE ID SET NOMBRE=? WHERE SERVICIOS=?";
            PreparedStatement ps=cn.prepareStatement(sql);
             ps.setString(1, servicios.getNombre());
            ps.setDouble(2, servicios.getPrecio());
            ps.setInt(3, servicios.getCodigo());
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
    public static List<Servicios> BuscarServicios(Servicios servicios)throws SQLException{
        List<Servicios> Servicios=new ArrayList<Servicios>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT ID FROM NOMBRE WHERE UPPER(SERVICIOS) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            //ps.setString(1, "%"+carro.getMarca().toUpperCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                do {                    
                    Servicios ServiciosObjeto=new Servicios();
                    //carroObjeto.setNombre(rs.getString(6));
                    //carroObjeto.setId(rs.getInt(7));
                    Servicios.add(ServiciosObjeto);
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
        
        return Servicios;
    }
}
