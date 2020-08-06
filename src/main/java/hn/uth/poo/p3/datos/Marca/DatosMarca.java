/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.datos.Marca;

import hn.uth.poo.p3.datos.conexion.Conexion;
import hn.uth.poo.p3.recursos.clases.Marca;
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
public class DatosMarca {
    public static List<Marca> LeerMarca(){
    List<Marca> Marca =new ArrayList<Marca>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT Marca, FROM Marca";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {                
                Marca marca=new Marca();            
                marca.setMarca(rs.getString(1));
                Marca.add(marca);
            }
            cn.close();
        } catch (Exception e) {
        }
        return Marca;
    }
    public static String InsertarMarca(Marca marca){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="INSERT INTO MARCA VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, marca.getMarca());
          
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String ActualizarMarca(Marca marca){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="UPDATE COLOR SET COLOR=? WHERE COLOR=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, marca.getMarca());
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
    public static String EliminarMarca(Marca marca){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="DELETE MARCA SET MARCA=? WHERE MARCA=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, marca.getMarca());
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
    public static List<Marca> BuscarMarca(Marca marca)throws SQLException{
        List<Marca> Marca=new ArrayList<Marca>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT MARCA FROM MARCA WHERE UPPER(MARCA) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            //ps.setString(1, "%"+carro.getMarca().toUpperCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                do {                    
                    Marca marcaObjeto=new Marca();
                    //carroObjeto.setNombre(rs.getString(6));
                    //carroObjeto.setId(rs.getInt(7));
                    Marca.add(marcaObjeto);
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
        
        return Marca;
    }
}

