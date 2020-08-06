/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.datos.Persona;

import hn.uth.poo.p3.datos.conexion.Conexion;
import hn.uth.poo.p3.recursos.clases.Persona;
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
public class DatosPersona {
    public static List<Persona> LeerPersona(){
    List<Persona> Persona =new ArrayList<Persona>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT NOMBRE, FROM PERSONA";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {                
                Persona persona=new Persona();      
                  persona.setId(rs.getInt(1));
                  persona.setNombre(rs.getString(2));
              
                
                Persona.add(persona);
            }
            cn.close();
        } catch (Exception e) {
        }
        return Persona;
    }
    public static String InsertarPersona(Persona persona){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="INSERT INTO PERSONA VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1, persona.getId());
            ps.setString(2, persona.getNombre());
          
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String ActualizarPersona(Persona persona){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="UPDATE ID SET NOMBRE=? WHERE PERSONA=?";
            PreparedStatement ps=cn.prepareStatement(sql);
             ps.setInt(1, persona.getId());
            ps.setString(2, persona.getNombre());
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
    public static String EliminarPersona(Persona persona){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="DELETE ID SET NOMBRE=? WHERE PERSONA=?";
            PreparedStatement ps=cn.prepareStatement(sql);
             ps.setInt(1, persona.getId());
            ps.setString(1, persona.getNombre());
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
    public static List<Persona> BuscarPersona(Persona persona)throws SQLException{
        List<Persona> Persona=new ArrayList<Persona>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT ID FROM NOMBRE WHERE UPPER(PERSONA) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            //ps.setString(1, "%"+carro.getMarca().toUpperCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                do {                    
                    Persona personaObjeto=new Persona();
                    //carroObjeto.setNombre(rs.getString(6));
                    //carroObjeto.setId(rs.getInt(7));
                    Persona.add(personaObjeto);
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
        
        return Persona;
    }
}
