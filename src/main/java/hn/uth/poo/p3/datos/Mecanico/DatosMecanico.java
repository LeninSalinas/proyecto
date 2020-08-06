/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.datos.Mecanico;

import hn.uth.poo.p3.datos.conexion.Conexion;
import hn.uth.poo.p3.recursos.clases.Marca;
import hn.uth.poo.p3.recursos.clases.Mecanico;
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
public class DatosMecanico {
    public static List<Mecanico> LeerMecanico(){
    List<Mecanico> Mecanico =new ArrayList<Mecanico>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT MECANICO, FROM MECANICO";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {                
                Mecanico mecanico=new Mecanico();            
                mecanico.setNumeroEmpleado(rs.getInt(1));
                Mecanico.add(mecanico);
            }
            cn.close();
        } catch (Exception e) {
        }
        return Mecanico;
    }
    public static String InsertarMecanico(Mecanico mecanico){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="INSERT INTO MECANICO VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1, mecanico.getNumeroEmpleado());
          
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String ActualizarMecanico(Mecanico mecanico){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="UPDATE MECANICO SET NUMERO EMPLEADO=? WHERE MECANICO=?";
            PreparedStatement ps=cn.prepareStatement(sql);
             ps.setInt(1, mecanico.getNumeroEmpleado());
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
    public static String EliminarMecanico(Mecanico mecanico){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="DELETE MARCA SET MARCA=? WHERE MARCA=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1, mecanico.getNumeroEmpleado());
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
    public static List<Mecanico> BuscarMecanico(Mecanico mecanico)throws SQLException{
        List<Mecanico> Mecanico=new ArrayList<Mecanico>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT MARCA FROM MARCA WHERE UPPER(MARCA) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            //ps.setString(1, "%"+carro.getMarca().toUpperCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                do {                    
                    Mecanico MecanicoObjeto=new Mecanico();
                    //carroObjeto.setNombre(rs.getString(6));
                    //carroObjeto.setId(rs.getInt(7));
                    Mecanico.add(MecanicoObjeto);
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
        
        return Mecanico;
    }
}
