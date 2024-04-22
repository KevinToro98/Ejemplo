package com.example;

import java.io.FileWriter;
import java.util.List;
import com.opencsv.CSVWriter;

public class EscrituraCSV {
    // Método para generar el fichero CSV, pasandole como parametro un nombre y una lista de objetos Clima
    public static void generarCSV(String nombreFichero, List <Clima> climaCon){

        // Apertura para escribir en un fichero CSV
        try (CSVWriter escritura = new CSVWriter(new FileWriter(nombreFichero, false))) {
            // Defino el encabezado del archivo CSV
            String[] header = {"Ciudad", "Id del Concello", "Estado do ceo","Temperatura Maxima","Temperatura Minima","Vento","Precipitacions","Fecha de la prediccion"};
            // Escribo el encabezado en el archivo CSV
            escritura.writeNext(header);
            // Foreach que Itera sobre la lista de objetos Clima y escribe la información en el archivo CSV
            for (Clima climaConcello : climaCon){
                String[] info = {
                    String.valueOf(climaConcello.getNome()),
                    String.valueOf(climaConcello.getIdConcello()),
                    String.valueOf(climaConcello.getEstadoCeo()),
                    String.valueOf(climaConcello.getTemperaturaMax()),
                    String.valueOf(climaConcello.getTemperaturaMin()),
                    String.valueOf(climaConcello.getVento()),
                    String.valueOf(climaConcello.getPrecipitacions()),
                    String.valueOf(climaConcello.getFecha()),
                };
                // Escribo la información del objeto Clima en una nueva línea del archivo CSV
                escritura.writeNext(info);
            }
            // Imprimo un mensaje indicando que el fichero CSV se ha creado correctamente
            System.out.println(nombreFichero + ". Fichero CSV creado correctamente.");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
     
}
