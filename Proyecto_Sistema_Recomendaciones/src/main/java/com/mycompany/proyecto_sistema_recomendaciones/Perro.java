/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_sistema_recomendaciones;

/**
 *
 * @author viankacastro
 */
public class Perro {
   
     private String color;
    private String tamaño;
    private String tipoPelo;
    private String personalidad;
    private String toleranciaClima; 

    // Constructor
    public Perro(String color, String tamaño, String tipoPelo, String personalidad, String toleranciaClima) {
        this.color = color;
        this.tamaño = tamaño;
        this.tipoPelo = tipoPelo;
        this.personalidad = personalidad;
        this.toleranciaClima = toleranciaClima;
    }

    // Getters y setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getTipoPelo() {
        return tipoPelo;
    }

    public void setTipoPelo(String tipoPelo) {
        this.tipoPelo = tipoPelo;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public String getToleranciaClima() {
        return toleranciaClima;
    }

    public void setToleranciaClima(String toleranciaClima) {
        this.toleranciaClima = toleranciaClima;
    }

    // Método para imprimir los detalles del perro
    @Override
    public String toString() {
        return "Perro{" +
                "color='" + color + '\'' +
                ", tamaño='" + tamaño + '\'' +
                ", tipoPelo='" + tipoPelo + '\'' +
                ", personalidad='" + personalidad + '\'' +
                ", toleranciaClima='" + toleranciaClima + '\'' +
                '}';
    }
}
