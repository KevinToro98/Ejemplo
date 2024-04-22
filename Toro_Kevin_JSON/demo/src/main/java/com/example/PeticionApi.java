package com.example;

// Importes necesarios para desarrollar la clase
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class PeticionApi {

    // Método para realizar una solicitud HTTP GET y devolver la respuesta como objeto JSONObject
    public static JSONObject DatosAPI(String url) throws IOException, JSONException {

        // Creación de una URL que por parametro se le pasa la String url
        URL urls = new URL(url);
        // Apertura de la conexión HTTP a la URL
        HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
        // Realización de la solicitud para obetener información de la url
        conn.setRequestMethod("GET");

        // Creación de un BufferedReader para leer la respuesta de la url, luego convertir esa respuesta en caracteres legibles
        BufferedReader rea = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        // Creación de un StringBuilder para guardar la respuesta de la url
        StringBuilder res = new StringBuilder();

        String linea;
        // Leemos línea por línea hasta que no hayan mas lineas por leer
        while ((linea = rea.readLine()) != null) {
            //se agrega al StringBuilder res
            res.append(linea);
        }
        // Se cierra el BufferedReader después de haber leido toda la información
        rea.close();

        // Creación de un objeto de tipo JSONObject, que contiene la respuesta de la url como un String
        JSONObject jsonObject = new JSONObject(res.toString());

        // Devuelve el objeto JSONObject, que tiene la respuesta de la url en formato JSON
        return jsonObject;
    }
}
