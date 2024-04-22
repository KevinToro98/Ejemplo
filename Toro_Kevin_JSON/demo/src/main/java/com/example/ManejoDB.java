package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManejoDB {

    // Campo estático que representa la conexión a la base de datos
    public static Connection connection;

    // Método que crea una tabla en la base de datos, pasandole como parametro una
    // conexión
    public static void CrearTabla(Connection connection) throws SQLException {

        // Sentencia preparada para crear la tabla clima
        try (PreparedStatement createTableStmt = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS clima (idConcello INT PRIMARY KEY, ciudad VARCHAR(25), estadoCeo INT, temperaturaMax DECIMAL, temperaturaMin DECIMAL, vento DECIMAL, precipitacions DECIMAL, fecha VARCHAR(25))")) {
            // Ejecuta la sentencia SQL para poder crear la tabla
            createTableStmt.execute();

            // Imprime que la tabla ha sido creada
            System.out.println("Tabla creada correctamente.");
        } catch (SQLException e) {
            // Captura la excepción en caso de que hubiera un error durante la creación de
            // la tabla
            System.out.println("Error al crear la tabla introducida: \n" + e.getMessage().toString());
        }

    }

    // Método que introduce los datos en la tabla creada anteriormente, pasandole
    // por parametro, una conexión y un objeto de tipo clima
    public static void InsertarDatos(Connection connection, Clima clima) throws SQLException {
        // Sentencia preparada para insertar los datos en la tabla clima
        try (PreparedStatement insertStmt = connection.prepareStatement(
                "INSERT INTO clima (idConcello, ciudad, estadoCeo, temperaturaMax, temperaturaMin, vento, precipitacions, fecha) VALUES (?,?,?,?,?,?,?,?)")) {

            // Valores de los parametros de la sentencia preparada
            insertStmt.setInt(1, clima.getIdConcello());
            insertStmt.setString(2, clima.getNome());
            insertStmt.setInt(3, clima.getEstadoCeo());
            insertStmt.setDouble(4, clima.getTemperaturaMax());
            insertStmt.setDouble(5, clima.getTemperaturaMin());
            insertStmt.setDouble(6, clima.getVento());
            insertStmt.setDouble(7, clima.getPrecipitacions());
            insertStmt.setString(8, clima.getFecha());
            insertStmt.execute();

            // Imprime que los datos han sido insertados correctamente
            System.out.println("Datos introducidos correctamente");

        } catch (SQLException e) {
            // Captura la excepción que pueda producirse al introducir datos en la tabla
            System.out.println("Error al introducir los datos en la tabla: \n" + e.getMessage().toString());
        }
    }

    // Método que muestra los datos de la tabla clima pasandole como parametro una
    // conexion
    public static void MostrarDatos(Connection connection) {
        // Sentencia preparada para seleccionar los datos que se desean que se muestren
        try (PreparedStatement selectStmt = connection.prepareStatement("SELECT * FROM clima")) {
            // Ejecuta la consulta y se obtienen un conjunto de resultados
            ResultSet resultSet = selectStmt.executeQuery();

            // Bucle que itera sobre los resultados
            while (resultSet.next()) {
                // Se obtienen los valores de las columnas para cada fila correspondiente
                int idConcello = resultSet.getInt("idConcello");
                String ciudad = resultSet.getString("ciudad");
                int estadoCeo = resultSet.getInt("estadoCeo");
                Double temperaturaMax = resultSet.getDouble("temperaturaMax");
                Double temperaturaMin = resultSet.getDouble("temperaturaMin");
                Double vento = resultSet.getDouble("vento");
                Double precipitacions = resultSet.getDouble("precipitacions");
                String fecha = resultSet.getString("fecha");

                // Se imprimen los datos obtenidos
                System.out.println("Id: " + idConcello + ", Ciudad: " + ciudad + ", EstadoCeo: " + estadoCeo +
                        ", TemperaturaMax: " + temperaturaMax + ", TemperaturaMin: " + temperaturaMin +
                        ", Vento: " + vento + ", Precipitacions: " + precipitacions + ", Fecha: " + fecha);
            }
        } catch (SQLException e) {
            // Captura de excepción que pudiera producirse durante la consulta de mostrar
            // los datos
            System.out.println("Error al mostrar los datos: \n" + e.getMessage().toString());
        }
    }

}
