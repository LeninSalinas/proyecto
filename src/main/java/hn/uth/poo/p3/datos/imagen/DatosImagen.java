/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.datos.imagen;

import hn.uth.poo.p3.datos.conexion.Conexion;
import hn.uth.poo.p3.recursos.clases.Imagen;
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
public class DatosImagen {
    public static List<Imagen> LeerImagen(){
    List<Imagen> Imagen=new ArrayList<Imagen>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT FOTO FROM IMAGEN";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {                
                Imagen foto=new Imagen();
                foto.setFoto(rs.getBytes(1));
                Imagen.add(foto);
            }
            cn.close();
        } catch (Exception e) {
        }
        return Imagen;
    }
    public static String InsertarImagen(Imagen foto){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="INSERT INTO Imagen VALUES(?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setObject(1, foto.getFoto());
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String ActualizarImagen(Imagen foto){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="UPDATE IMAGEN SET FOTO=? WHERE IMAGEN=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setObject(1, foto.getFoto());
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
    public static String EliminarImagen(Imagen foto){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="DELETE CARROS SET IDENTIDAD=? WHERE NOMBRE=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setObject(1, foto.getFoto());
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
    public static List<Imagen> BuscarImagen(Imagen foto)throws SQLException{
        List<Imagen> imagen=new ArrayList<Imagen>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT MODELO, PLACA, COLOR FROM CARROS WHERE UPPER(MODELO) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            //ps.setString(1, "%"+carro.getMarca().toUpperCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                do {                    
                    Imagen fotoObjeto=new Imagen();
                    //carroObjeto.setNombre(rs.getString(6));
                    //carroObjeto.setId(rs.getInt(7));
                    imagen.add(fotoObjeto);
                } while (rs.next());
            } 
            else{
                throw new SQLException("Error No imagen");
            }
            cn.close();
            rs.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        
        return imagen;
    }

}
