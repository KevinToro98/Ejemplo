package com.example;

import java.io.Serializable;

//Creo un clase publica con el nombre de Clima
public class Clima implements Serializable {

    // Creo una variable de tipo String llamada nome
    private String nome;
    // Creo una variable de tipo int llamada idConcello
    private int idConcello;
    // Creo una variable de tipo int llamada estadoCeo
    private int estadoCeo;
    // Creo una variable de tipo double llamada temperaturaMax
    private double temperaturaMax;
    // Creo una variable de tipo double llamada temperaturaMin
    private double temperaturaMin;
    // Creo una variable de tipo double llamada vento
    private double vento;
    // Creo una variable de tipo double llamada precipitacions
    private double precipitacions;
    // Creo una variable de tipo string llamada fecha
    private String fecha;

    // Creo un constructor para la clase con sus respectivos parametros,
    // inicializando de esta manera las variables al crear una instancia de Clima
    public Clima(String nome, int idConcello, int estadoCeo, double temperaturaMax, double temperaturaMin, double vento,
            double precipitacions, String fecha) {
        this.nome = nome;
        this.idConcello = idConcello;
        this.estadoCeo = estadoCeo;
        this.temperaturaMax = temperaturaMax;
        this.temperaturaMin = temperaturaMin;
        this.vento = vento;
        this.precipitacions = precipitacions;
        this.fecha = fecha;
    }
    // Creo los getters y setters de la clase Clima

    // Creo un método getNome para poder obtener el valor de la variable Nome
    public String getNome() {
        return nome;
    }
    // Creo un método setNome para poder obtener el valor de la variable Nome
    public void setNome(String nome) {
        this.nome = nome;
    }
    // Creo un método getIdConcello para poder obtener el valor de la variable IdConcello
    public int getIdConcello() {
        return idConcello;
    }
    // Creo un método se setIdConcello para poder asignarle un valor a la varible IdConcello
    public void setIdConcello(int idConcello) {
        this.idConcello = idConcello;
    }
    // Creo un método getEstadoCeo para poder obtener el valor de la variable estadoCeo
    public int getEstadoCeo() {
        return estadoCeo;
    }
    // Creo un método se setEstadoCeo para poder asignarle un valor a la varible estadoCeo
    public void setEstadoCeo(int estadoCeo) {
        this.estadoCeo = estadoCeo;
    }
    // Creo un método getTemperaturaMax para poder obtener el valor de la variable temperaturaMax
    public double getTemperaturaMax() {
        return temperaturaMax;
    }
    // Creo un método setTemperaturaMax para poder obtener el valor de la variable temperaturaMax
    public void setTemperaturaMax(double temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }
    // Creo un método getTemperaturaMin para poder obtener el valor de la variable temperaturaMin
    public double getTemperaturaMin() {
        return temperaturaMin;
    }
    // Creo un método getTemperaturaMin para poder obtener el valor de la variable temperaturaMin
    public void setTemperaturaMin(double temperaturaMin) {
        this.temperaturaMin = temperaturaMin;
    }
    // Creo un método getVento para poder obtener el valor de la variable vento
    public double getVento() {
        return vento;
    }
    // Creo un método setVento para poder asignarle un valor a la varible vento
    public void setVento(double vento) {
        this.vento = vento;
    }
    // Creo un método getPrecipitacions para poder obtener el valor de la variable precipitacions
    public double getPrecipitacions() {
        return precipitacions;
    }
    // Creo un método setPrecipitacions para poder asignarle un valor a la varible precipitacions
    public void setPrecipitacions(double precipitacions) {
        this.precipitacions = precipitacions;
    }
    // Creo un método getFecha para poder obtener el valor de la variable fecha
    public String getFecha() {
        return fecha;
    }
    // Creo un método setFecha para poder asignarle un valor a la varible fecha
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    @Override
    public String toString() {
        return "\tClima  \n" +
                "Ciudad: " + nome + "\n" +
                "Id del Concello: " + idConcello + "\n" +
                "Estado do ceo: " + estadoCeo + "\n" +
                "Temperatura Maxima: " + temperaturaMax + "\n" +
                "Temperatura Minima: " + temperaturaMin + "\n" +
                "Vento: " + vento + "\n" +
                "Precipitacions: " + precipitacions + "\n" +
                "Fecha de la prediccion: " + fecha;
    }

}
