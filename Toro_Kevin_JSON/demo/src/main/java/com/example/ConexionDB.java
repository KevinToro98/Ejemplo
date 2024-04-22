package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    // Campo estatico para la conexion a la base de datos
    public static Connection connection;

    // Método que crea la conexión a la base de datos H2
    public static Connection crearConexionDB() throws SQLException {

        // Comprueba si la conexión existe, y si no crea la conexión
        if (connection == null) {
            try {
                // Establece la conexión con la base de datos H2
                connection = DriverManager.getConnection("jdbc:h2:mem:test");
                // imprime que la conexión fue realizada
                System.out.println("Conexion a la base de datos creada.");
            } catch (SQLException e) {
                // Captura la excepcion en caso de que hubiera un error al establecer la
                // conexión con la base de datos
                System.out.println("Error al conectar con la base de datos: \n" + e.getMessage().toString());
            }
        }
        // Devuelve la conexión
        return connection;
    }

    // Método que cierra la conexión a la base de datos H2
    public static void cerrarConexion(Connection connection) {
        try {
            // Comprueba si la conexion no es nula
            if (connection != null) {
                // Cierra la conexión
                connection.close();
                // Imprime que la base de datos ha sido cerrada.
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
