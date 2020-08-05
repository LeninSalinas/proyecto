/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.datos.carros;

import hn.uth.poo.p3.datos.conexion.Conexion;
import hn.uth.poo.p3.recursos.clases.Carros;
import hn.uth.poo.p3.recursos.clases.Color;
import hn.uth.poo.p3.recursos.clases.Marca;
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
 * @author Dell
 */
public class DatosCarros {
    public static List<Carros> LeerCarros(){
    List<Carros> Carros=new ArrayList<Carros>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT COLOR, MARCA, MODELO, AÑO, NUMMOTOR, PLACA FROM CARROS";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {                
                Carros carro=new Carros();
                carro.setColor((Color) rs.getObject(1));
                carro.setMarca((Marca) rs.getObject(2));
                carro.setModelo((Modelo) rs.getObject(3));
                carro.setAño(rs.getInt(4));
                carro.setNumeroMotor(rs.getInt(5));
                carro.setPlaca(rs.getInt(6));
                carro.setVIN(rs.getInt(7));
                Carros.add(carro);
            }
            cn.close();
        } catch (Exception e) {
        }
        return Carros;
    }
    public static String InsertarCarros(Carros carro){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="INSERT INTO CARROS VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setObject(1, carro.getColor());
            ps.setObject(2, carro.getMarca());
            ps.setObject(3, carro.getModelo());
            ps.setInt(4, carro.getAño());  
            ps.setInt(5, carro.getNumeroMotor());
            ps.setInt(6, carro.getPlaca()); 
            ps.setInt(7, carro.getVIN()); 
            ps.execute();
            ps.close();
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error "+ e.getMessage();
        }
        return null;
    }
    public static String ActualizarCarros(Carros carro){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="UPDATE CLIENTES SET IDENTIDAD=? WHERE NOMBRE=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setObject(1, carro.getColor());
            ps.setObject(2, carro.getMarca());
            ps.setObject(3, carro.getModelo());
            ps.setInt(4, carro.getAño());  
            ps.setInt(5, carro.getNumeroMotor());
            ps.setInt(6, carro.getPlaca()); 
            ps.setInt(7, carro.getVIN()); 
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
    public static String EliminarCarros(Carros carro){
        try {
            Connection cn=Conexion.ObtenerConexion();
            String sql="DELETE CARROS SET IDENTIDAD=? WHERE NOMBRE=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setObject(1, carro.getColor());
            ps.setObject(2, carro.getMarca());
            ps.setObject(3, carro.getModelo());
            ps.setInt(4, carro.getAño());  
            ps.setInt(5, carro.getNumeroMotor());
            ps.setInt(6, carro.getPlaca()); 
            ps.setInt(7, carro.getVIN()); 
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
    public static List<Carros> BuscarCarros(Carros carro)throws SQLException{
        List<Carros> carros=new ArrayList<Carros>();
        try {
            Connection cn=Conexion.ObtenerConexion();
            Statement st=cn.createStatement();
            String sql="SELECT MODELO, PLACA, COLOR FROM CARROS WHERE UPPER(MODELO) LIKE ?";
            PreparedStatement ps=cn.prepareStatement(sql);
            //ps.setString(1, "%"+carro.getMarca().toUpperCase()+"%");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                do {                    
                    Carros carroObjeto=new Carros();
                    //carroObjeto.setNombre(rs.getString(6));
                    //carroObjeto.setId(rs.getInt(7));
                    carros.add(carroObjeto);
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
        
        return carros;
    }
}
