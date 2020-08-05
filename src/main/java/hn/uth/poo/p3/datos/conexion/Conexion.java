/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.poo.p3.datos.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dell
 */
public class Conexion {
    private static final String USUARIO="uth";
    private static final String CLAVE="uth";
    
    public static Connection ObtenerConexion(){
        try {
            String URL="jdbc:derby://localhost:1527/POO202021";
            Connection cn=DriverManager.getConnection(URL, USUARIO, CLAVE);
            return cn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
