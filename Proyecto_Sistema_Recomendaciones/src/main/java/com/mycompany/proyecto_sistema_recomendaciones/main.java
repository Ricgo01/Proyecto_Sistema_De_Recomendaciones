/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_sistema_recomendaciones;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("¿Deseas agregar una nueva raza de perro? (sí/no)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("sí")) {
            System.out.println("Ingrese el nombre de la raza:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el tamaño (Pequeño, Mediano, Grande):");
            String tamano = scanner.nextLine();

            System.out.println("Ingrese el color (Negro, Blanco, Gris, Marron, Multicolor):");
            String color = scanner.nextLine();

            System.out.println("Ingrese el tipo de pelo (Corto, Largo, Rizado, Sin pelo):");
            String pelo = scanner.nextLine();

            System.out.println("Ingrese la personalidad (Activo/Enérgico, Tranquilo/Relajado, Sociable/Amigable, Independiente/Reservado):");
            String personalidad = scanner.nextLine();

            System.out.println("Ingrese la tolerancia al clima (Climas Cálidos, Climas Frios, Adaptación a variedad de climas):");
            String toleranciaClima = scanner.nextLine();

            controlador.agregarRaza(nombre, tamano, color, pelo, personalidad, toleranciaClima);
            System.out.println("Raza de perro agregada exitosamente.");
        }

        System.out.println("Ingrese los criterios para recomendar perros:");
        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Pelo: ");
        String pelo = scanner.nextLine();

        System.out.print("Personalidad: ");
        String personalidad = scanner.nextLine();

        System.out.print("Tamaño: ");
        String tamano = scanner.nextLine();

        System.out.print("Clima: ");
        String clima = scanner.nextLine();

        controlador.recomendarPerros(color, pelo, personalidad, tamano, clima);

        controlador.close();
        scanner.close();
        
    }
}