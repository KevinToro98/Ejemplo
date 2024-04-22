package com.example;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DatosClimaJson {

    // Método para convertir un JSONObject en un objeto de tipo Clima
    public static Clima objetoDatosjson(JSONObject json) {

        // Obtenemos la lista de predicciones diarias para el concello
        JSONArray predDiaConcelloList = json.getJSONObject("predConcello").getJSONArray("listaPredDiaConcello");
        // Obtenemos la primera prediccion del concello
        JSONObject pred = predDiaConcelloList.getJSONObject(0);
        // Obtenemos el nombre de la ciudad
        String nome = json.getJSONObject("predConcello").getString("nome");
        // Obtenemos el id del Concello
        int idConcello = json.getJSONObject("predConcello").getInt("idConcello");
        // Obtenemos el estado del cielo en este caso en la mañana
        int estadoCeo = pred.getJSONObject("ceo").getInt("manha");
        // Obtenemos la temperatura máxima
        int temperaturaMax = pred.getInt("tMax");
        // Obtenemos la temperatura minima
        int temperaturaMin = pred.getInt("tMin");
        // Obtenemos el viento en este caso en la mañana
        int vento = pred.getJSONObject("vento").getInt("manha");
        // Obtenemos la precipitacion en este caso en la mañana
        int precipitacions = pred.getJSONObject("pchoiva").getInt("manha");
        // Obtenemos la fecha de la prediccion
        String fecha = pred.getString("dataPredicion");
        // Convierto la el String fecha a un objeto LocalDate 
        LocalDate fechaPred = LocalDate.parse(fecha, DateTimeFormatter.ISO_DATE_TIME);
        // Formateo la fecha 
        String fechaFormateada = fechaPred.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        // Creo y devuelvo un objeto de tipo Clima con la información anteriormente obtenida
        return new Clima(nome, idConcello, estadoCeo, temperaturaMax, temperaturaMin, vento, precipitacions, fechaFormateada);
    }

    //Método para obtener una lista de objetos de tipo Clima a partir de una lista de urls
    public static List<Clima> climaLista(List<String> urls) throws JSONException, IOException {

        // Creación de una lista para almacenar objetos de tipo Clima
        List<Clima> clima = new ArrayList<>();
        // Foreach para iterar cada url en la lista
        for (String url : urls) {
            // Solicitud HTTP a la url y obtenemos el objeto JSON como respuesta
            JSONObject json = PeticionApi.DatosAPI(url);
            // Convierto el objeto JSON a un objeto Clima y lo agrego a la lista
            clima.add(objetoDatosjson(json));
        }
        // Devuelvo la lista de objetos de tipo Clima
        return clima;
    }

    // Método para mostrar la información de una lista de objetos Clima
    public static void mostrarInfoClima(List<Clima> climas) {
        // Iterar cada objeto clima en la lista 
        for (Clima clima : climas) {
            // Llamo al metodo mostrarInformacionClima, imprimo la información del objeto Clima
            mostrarInformacionClima(clima);
            System.out.println("");
        }
    }
    // Método para mostrar la información de un objeto Clima
    public static void mostrarInformacionClima(Clima clima) {
        // Imprimo el toString del objeto CLima
        System.out.println(clima.toString());
    }
}
