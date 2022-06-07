package co.edu.ufps.gymproject.datos.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/gym";
    private final String USER = "root";
    private final String PASSWORD = "root";
    //private final static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public Connection getConexion(){
        Connection con = null;
        System.out.println("************PRUEBA************************");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("************PRUEBA BASEDEDATOS************************");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

}
