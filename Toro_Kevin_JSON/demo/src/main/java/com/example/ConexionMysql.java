package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMysql {

    // Constantes para la configuración de la conexión de la base de datos Mysql
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String ddbb = "jdbc:mysql://localhost:3306/lolete";
    private static final String user = "root";
    private static final String passw = "abc123.";

    // Campo estatico para la conexion a la base de datos
    private static Connection conex;

    // Método que crea la conexión a la base de datos Mysql
    public static Connection crearConexion() throws ClassNotFoundException {
        // Comprueba si la conexión existe, y si no crea la conexión
        if (conex == null) {
            try {
                // Se carga el driver de Mysql
                Class.forName(driver);
                // Se establece la conexión utilizando la URL de la base datos, el usuario y
                // contraseña
                conex = DriverManager.getConnection(ddbb, user, passw);
                // Imprime que la conexión a la base de datos Mysql fue creada.
                System.out.println("Conexion a la base de datos creada.");

            } catch (SQLException e) {
                // Captura la posible excepción si se produjera un error al conectar con la base
                // de datos
                System.out.println("Error al conectar con la base de datos. \n" + e.getMessage().toString());
            }
        }
        // Devuelve la conexión
        return conex;
    }

    // Método que cierra la conexión a la base de datos Mysql
    public static void cerrarConexion(Connection conex) {
        try {
            // Compruibea si la conexion no es nula
            if (conex != null) {
                // Cierra la conexión
                conex.close();
                // imprime que la base de datos ha sido cerrada.
                System.out.println("Conexion a la base de datos cerrada.");
            } else {
                // Si la conexión en nula imprime que la conexión ya estaba cerrada
                System.out.println("La conexión ya estaba cerrada.");
            }
        } catch (Exception e) {
            // Captura la excepción en caso de que hubiera un error al cerrar la conexión
            System.out.println("Error al cerrar la base de datos: \n" + e.getMessage().toString());
        }
    }

}
