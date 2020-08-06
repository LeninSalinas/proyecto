/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.datos.Modelo;

import hn.uth.poo.p3.datos.conexion.Conexion;
import hn.uth.poo.p3.recursos.clases.Modelo;
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
public class DatosModelo {
      public static List<Modelo> LeerModelo(){
    List<Modelo> Modelo =new ArrayList<Modelo>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT MODELO, FROM MODELO";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {                
                Modelo modelo=new Modelo();            
                modelo.setModelo(rs.getString(1));
                Modelo.add(modelo);
            }
            cn.close();
        } catch (Exception e) {
        }
        return Modelo;
    }
    public static String InsertarModelo(Modelo modelo){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="INSERT INTO MECANICO VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, modelo.getModelo());
          
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String ActualizarModelo(Modelo modelo){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="UPDATE MECANICO SET NUMERO EMPLEADO=? WHERE MECANICO=?";
            PreparedStatement ps=cn.prepareStatement(sql);
             ps.setString(1, modelo.getModelo());
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
    public static String EliminarModelo(Modelo modelo){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="DELETE MODELO SET MODELO=? WHERE MODELO=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, modelo.getModelo());
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
    public static List<Modelo> BuscarModelo(Modelo modelo)throws SQLException{
        List<Modelo> Modelo=new ArrayList<Modelo>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT MARCA FROM MARCA WHERE UPPER(MARCA) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            //ps.setString(1, "%"+carro.getMarca().toUpperCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                do {                    
                    Modelo modeloObjeto=new Modelo();
                    //carroObjeto.setNombre(rs.getString(6));
                    //carroObjeto.setId(rs.getInt(7));
                    Modelo.add(modeloObjeto);
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
        
        return Modelo;
    }
}
