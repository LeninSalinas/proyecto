/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.datos.Color;

import hn.uth.poo.p3.datos.conexion.Conexion;
import hn.uth.poo.p3.recursos.clases.Color;
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
public class DatosColor {
     public static List<Color> LeerColor(){
    List<Color> Color =new ArrayList<Color>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT COLOR, FROM COLOR";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {                
                Color color=new Color();            
                color.setColor(rs.getString(1));
                Color.add(color);
            }
            cn.close();
        } catch (Exception e) {
        }
        return Color;
    }
    public static String InsertarColor(Color color){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="INSERT INTO COLOR VALUES(?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, color.getColor());
          
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String ActualizarColor(Color color){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="UPDATE COLOR SET COLOR=? WHERE COLOR=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, color.getColor());
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
    public static String EliminarColor(Color color){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="DELETE COLOR SET COLOR=? WHERE NOMBRE=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, color.getColor());
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
    public static List<Color> BuscarColor(Color color)throws SQLException{
        List<Color> Color=new ArrayList<Color>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT COLOR FROM COLOR WHERE UPPER(COLOR) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            //ps.setString(1, "%"+carro.getMarca().toUpperCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                do {                    
                    Color colorObjeto=new Color();
                    //carroObjeto.setNombre(rs.getString(6));
                    //carroObjeto.setId(rs.getInt(7));
                    Color.add(colorObjeto);
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
        
        return Color;
    }
}
