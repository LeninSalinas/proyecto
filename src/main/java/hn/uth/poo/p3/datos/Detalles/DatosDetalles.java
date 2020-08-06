/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.datos.Detalles;

import hn.uth.poo.p3.datos.conexion.Conexion;

import hn.uth.poo.p3.recursos.clases.Detalles;
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
public class DatosDetalles {
    public static List<Detalles> LeerDetalles(){
    List<Detalles> Detalles =new ArrayList<Detalles>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT IMPACTO,PINTURA, NUMEROREPUESTOS FROM DETALLES";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {                
                Detalles detalles=new Detalles();            
                detalles.setImpacto(rs.getString(1));
                detalles.setPintura(rs.getBoolean(2));
                detalles.setNumeroRepuestos(rs.getInt(3));
                
                Detalles.add(detalles);
            }
            cn.close();
        } catch (Exception e) {
        }
        return Detalles;
    }
    public static String InsertarDetalles(Detalles detalles){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="INSERT INTO COLOR VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, detalles.getImpacto());
            ps.setBoolean(2, detalles.isPintura());
             ps.setInt(3, detalles.getNumeroRepuestos());
            
          
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String ActualizarDetalles(Detalles detalles){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="UPDATE DETALLES SET IMPACTO=? WHERE NUMEROREPUESTOS=?";
            PreparedStatement ps=cn.prepareStatement(sql);
           ps.setString(1, detalles.getImpacto());
            ps.setBoolean(2, detalles.isPintura());
             ps.setInt(3, detalles.getNumeroRepuestos());
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
    public static String EliminarDetalles(Detalles detalles){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="DELETE IMPACTO SET PINTURA=? WHERE NUMEROREPUESTOS=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, detalles.getImpacto());
            ps.setBoolean(2, detalles.isPintura());
             ps.setInt(3, detalles.getNumeroRepuestos());
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
    public static List<Detalles> BuscarDetalles(Detalles detalles)throws SQLException{
        List<Detalles> Detalles=new ArrayList<Detalles>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT IMPACTO FROM PINTURA WHERE UPPER(NUMEROREPUESTOS) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            //ps.setString(1, "%"+carro.getMarca().toUpperCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                do {                    
                    Detalles detallesObjeto=new Detalles();
                    //carroObjeto.setNombre(rs.getString(6));
                    //carroObjeto.setId(rs.getInt(7));
                    Detalles.add(detallesObjeto);
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
        
        return Detalles;
    }
}

