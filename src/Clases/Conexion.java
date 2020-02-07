/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.*;

/**
 *
 * @author ANGEL
 */
public class Conexion {

    public static String usu, psw, db, host;

    public ResultSet resul = null;
    public Statement stat = null;
    public static Connection conec = null;

    public Conexion() {
        try {
            usu = "root";
            psw = "";
            db = "proyecto";
            host = "localhost";
            String url = "jdbc:mysql://" + host + "/" + db;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conec = DriverManager.getConnection(url, usu, psw);
            System.out.println("conexion_proyecto");
        } catch (Exception e) {
            System.out.println("Error Conexion!");
        }
    }
}
