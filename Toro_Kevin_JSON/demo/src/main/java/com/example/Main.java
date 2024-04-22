package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.json.JSONException;

public class Main {
    public static void main(String[] args) throws JSONException, IOException, SQLException, ClassNotFoundException {

        // Defino las urls que necesito de los concellos
        String url1 = "https://servizos.meteogalicia.gal/mgrss/predicion/jsonPredConcellos.action?idConc=15030&request_locale=gl";
        String url2 = "https://servizos.meteogalicia.gal/mgrss/predicion/jsonPredConcellos.action?idConc=27028&request_locale=gl";
        String url3 = "https://servizos.meteogalicia.gal/mgrss/predicion/jsonPredConcellos.action?idConc=36038&request_locale=gl";
        String url4 = "https://servizos.meteogalicia.gal/mgrss/predicion/jsonPredConcellos.action?idConc=36057&request_locale=gl";
        String url5 = "https://servizos.meteogalicia.gal/mgrss/predicion/jsonPredConcellos.action?idConc=15036&request_locale=gl";
        String url6 = "https://servizos.meteogalicia.gal/mgrss/predicion/jsonPredConcellos.action?idConc=32054&request_locale=gl";
        String url7 = "https://servizos.meteogalicia.gal/mgrss/predicion/jsonPredConcellos.action?idConc=15078&request_locale=gl";

        // Almaceno dichas urls en una lista
        List<String> links = List.of(
                url1, url2, url3, url4, url5, url6, url7);

        // Creación de una lista para almacenar los objetos de tipo Clima
        List<Clima> climas;

        // Obtención de los datos metereológicos y luego almacenarlos en la lista de
        // objetos Clima
        climas = DatosClimaJson.climaLista(links);

        // Mostrar la información metereológica de la lista de objetos Clima
        // DatosClimaJson.mostrarInfoClima(climas);

        // Creo un objeto de tipo fecha, que es la fecha actual
        // Date fechaActual = new Date(0);

        // Creo el formato de la fecha
        // SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        // Creo el nombre que tendra el fichero creado de CSV
        // String nombreFichero = formatoFecha.format(fechaActual) + "-galicia.csv";

        // Genero el fichero CSV, pasandole el nombreFichero que contendría la fecha y
        // la lista de objetos de tipo Clima
        // EscrituraCSV.generarCSV(nombreFichero, climas);

        // Variable que almacena la opción seleccionada
        int opcion;
        // Objeto de tipo scanner para leer la entrada
        Scanner scan = new Scanner(System.in);

        // Inicialización de la conexión H2 como nula al principio
        Connection connectionH2 = null;
        // Inicialización de la conexión MySQL como nula al principio
        Connection connectionMysql = null;

        do {
            // Muestra el menu y se obtiene la opción seleccionada
            opcion = printMenu(scan);

            // Bloque switch para manjerar las opciones del menú
            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado conectar con la Base de datos H2. \n");
                    // Verifica si la conexión H2 ya existe y sino la crea
                    if (connectionH2 == null) {
                        connectionH2 = ConexionDB.crearConexionDB();
                    }
                    break;
                case 2:
                    System.out.println("Ha seleccionado crear tabla en la Base de datos H2 \n");
                    // Crea la tabla en la base de datos H2
                    ManejoDB.CrearTabla(connectionH2);
                    break;
                case 3:
                    System.out.println("Ha seleccionado insertar datos en la tabla Clima de la base de datos H2. \n");
                    // Recorre la lista de objetos clima e inserta los datos en la base de datos H2
                    for (Clima clima : climas) {
                        ManejoDB.InsertarDatos(connectionH2, clima);
                    }
                    break;
                case 4:
                    System.out.println("Ha seleccionado visualizar información de la tabla en la base de datos H2. \n");
                    // Muestra los datos de la tabla en la base de datos H2
                    ManejoDB.MostrarDatos(connectionH2);
                    break;
                case 5:
                    System.out.println("Ha seleccionado cerrar conexion con la base de datos H2. \n");
                    // Se cierra la conexión con la base de datos H2
                    ConexionDB.cerrarConexion(connectionH2);
                    break;
                case 6:
                    System.out.println("Ha seleccionado conectar con la Base de datos Mysql. \n");
                    // Verifica si la conexión Mysql ya existe y sino la crea
                    if (connectionMysql == null) {
                        connectionMysql = ConexionMysql.crearConexion();
                    }
                    break;
                case 7:
                    System.out.println("Ha seleccionado crear tabla en la Base de datos Mysql. \n");
                    // Crea la tabla en la base de datos Mysql
                    ManejoDB.CrearTabla(connectionMysql);
                    break;
                case 8:
                    System.out
                            .println("Ha seleccionado insertar datos en la tabla Clima de la base de datos Mysql. \n");
                    // Recorre la lista de objetos clima e inserta los datos en la base de datos
                    // Mysql
                    for (Clima clima : climas) {
                        ManejoDB.InsertarDatos(connectionMysql, clima);
                    }
                    break;
                case 9:
                    System.out.println(
                            "Ha seleccionado visualizar información de la tabla en la base de datos Mysql. \n");
                    // Muestra los datos de la tabla en la base de datos Mysql
                    ManejoDB.MostrarDatos(connectionMysql);
                    break;
                case 10:
                    System.out.println("Ha seleccionado cerrar conexion con la base de datos Mysql. \n");
                    // Se cierra la conexión con la base de datos Mysql
                    ConexionMysql.cerrarConexion(connectionMysql);
                    break;
                default:
                    break;
            }

            // El bucle continua mientras la opción seleccionada no sea 11
        } while (opcion != 11);
        // Cuando sea igual a 11, opción de salida, imprime despedida
        System.out.println("Hasta luego.");
        // Se cierra el objeto scanner
        scan.close();

    }

    // Método para mostrar el menú y obtener la opción seleccionada
    public static int printMenu(Scanner scan) {
        // Muestra las opciones por pantalla
        System.out.println("");
        System.out.println("\t\t\tMenu");
        System.out.println("1.- Establecer conexion con la base de datos H2.");
        System.out.println("2.- Crear tabla en la base de datos H2.");
        System.out.println("3.- Insertar datos en la tabla de la base de datos H2.");
        System.out.println("4.- Visualizar informacion en la tabla de la base de datos H2.");
        System.out.println("5.- Cerrar conexion con la base de datos H2.");
        System.out.println("6.- Establecer conexion con la base de datos Mysql.");
        System.out.println("7.- Crear tabla en la base de datos Mysql.");
        System.out.println("8.- Insertar datos en la tabla de la base de datos Mysql.");
        System.out.println("9.- Visualizar informacion en la tabla de la base de datos Mysql.");
        System.out.println("10.- Cerrar conexion con la base de datos Mysql.");
        System.out.println("11.- Salir");

        // Lee la opción seleccionada
        int opcion = scan.nextInt();

        scan.nextLine();

        // Devuelve la opción seleccionada
        return opcion;
    }

}
