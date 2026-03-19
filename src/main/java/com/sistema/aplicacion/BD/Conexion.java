package com.sistema.aplicacion.BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    //Ruta de conexion y credenciales

    public static final String URL = "jdbc:mysql://localhost:3306/bd_sb";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    // Retorna la conexion lista para usar
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
