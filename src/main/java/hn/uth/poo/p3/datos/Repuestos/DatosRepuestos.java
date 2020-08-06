/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.datos.Repuestos;

import hn.uth.poo.p3.datos.conexion.Conexion;
import hn.uth.poo.p3.recursos.clases.Repuestos;
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
public class DatosRepuestos {
        public static List<Repuestos> LeerRepuestos(){
    List<Repuestos> Repuestos =new ArrayList<Repuestos>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT REPUESTOS, FROM REPUESTOS";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {                
                Repuestos repuestos=new Repuestos();      
                  repuestos.setRepuestos(rs.getString(1));
              
                
                Repuestos.add(repuestos);
            }
            cn.close();
        } catch (Exception e) {
        }
        return Repuestos;
    }
    public static String InsertarRepuestos(Repuestos repuestos){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="INSERT INTO PERSONA VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, repuestos.getRepuestos());
          
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String ActualizarRepuestos(Repuestos repuestos){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="UPDATE ID SET NOMBRE=? WHERE PERSONA=?";
            PreparedStatement ps=cn.prepareStatement(sql);
        ps.setString(1, repuestos.getRepuestos());
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
    public static String EliminarRepuestos(Repuestos repuestos){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="DELETE ID SET NOMBRE=? WHERE PERSONA=?";
            PreparedStatement ps=cn.prepareStatement(sql);
             ps.setString(1, repuestos.getRepuestos());;
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
    public static List<Repuestos> BuscarRepuestos(Repuestos repuestos)throws SQLException{
        List<Repuestos> Repuestos=new ArrayList<Repuestos>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT ID FROM NOMBRE WHERE UPPER(PERSONA) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            //ps.setString(1, "%"+carro.getMarca().toUpperCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                do {                    
                    Repuestos RepuestosObjeto=new Repuestos();
                    //carroObjeto.setNombre(rs.getString(6));
                    //carroObjeto.setId(rs.getInt(7));
                    Repuestos.add(RepuestosObjeto);
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
        
        return Repuestos;
    }
}

