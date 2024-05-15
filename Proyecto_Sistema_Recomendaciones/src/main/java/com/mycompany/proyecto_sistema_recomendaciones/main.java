/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_sistema_recomendaciones;

public class main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.recomendarPerros("Negro", "Corto", "Tranquilo/Relajado", "Grande", "Frios");
        controlador.close();
        
    }
}