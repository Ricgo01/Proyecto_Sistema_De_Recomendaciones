/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_sistema_recomendaciones;
import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controlador controlador = new Controlador();
        
        System.out.println("Recomendando perros basados en criterios específicos:");
        ArrayList<String> recomendados = controlador.recomendarPerros("Negro", "Corto", "Tranquilo/Relajado", "Grande", "Frios");
        for (String perro : recomendados) {
            System.out.println("Perro recomendado: " + perro);
        }
        
        
        
        
        
        
        
        System.out.println("Agregar un nuevo perro a la base de datos.");
        System.out.print("Ingrese nombre del perro: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese raza del perro: ");
        String raza = scanner.nextLine();

        System.out.println("Seleccione el tamaño del perro:");
        System.out.println("1. Grande\n2. Mediano\n3. Pequeño");
        String tamaño = seleccionarTamaño(scanner.nextInt());
        scanner.nextLine(); // consume the leftover newline
        
        System.out.println("Seleccione el color del perro:");
        System.out.println("1. Negro\n2. Blanco\n3. Gris\n4. Marron\n5. Multicolor");
        String color = seleccionarColor(scanner.nextInt());
        scanner.nextLine(); // consume the leftover newline
        
        System.out.println("Seleccione el tipo de pelo del perro:");
        System.out.println("1. Corto\n2. Largo\n3. Rizado\n4. Sin Pelo");
        String pelo = seleccionarPelo(scanner.nextInt());
        scanner.nextLine(); // consume the leftover newline

        System.out.println("Seleccione la personalidad del perro:");
        System.out.println("1. Activo/Energetico\n2. Tranquilo/Relajado\n3. Sociable/Amigable\n4. Independiente/Reservado");
        String personalidad = seleccionarPersonalidad(scanner.nextInt());
        scanner.nextLine(); // consume the leftover newline
        
        System.out.println("Seleccione el clima ideal para el perro:");
        System.out.println("1. Calidos\n2. Frios\n3. Adaptable");
        String clima = seleccionarClima(scanner.nextInt());
        scanner.nextLine(); // consume the leftover newline

        controlador.agregarPerro(nombre, raza, color, tamaño, pelo, personalidad, clima);
        scanner.close();
        controlador.close();
    }

    // Selection methods for attributes
    private static String seleccionarTamaño(int opcion) {
        switch (opcion) {
            case 1: return "Grande";
            case 2: return "Mediano";
            case 3: return "Pequeño";
            default: return "Mediano";
        }
    }

    private static String seleccionarColor(int opcion) {
        switch (opcion) {
            case 1: return "Negro";
            case 2: return "Blanco";
            case 3: return "Gris";
            case 4: return "Marron";
            case 5: return "Multicolor";
            default: return "Blanco";
        }
    }

    private static String seleccionarPelo(int opcion) {
        switch (opcion) {
            case 1: return "Corto";
            case 2: return "Largo";
            case 3: return "Rizado";
            case 4: return "Sin Pelo";
            default: return "Corto";
        }
    }

    private static String seleccionarPersonalidad(int opcion) {
        switch (opcion) {
            case 1: return "Activo/Energetico";
            case 2: return "Tranquilo/Relajado";
            case 3: return "Sociable/Amigable";
            case 4: return "Independiente/Reservado";
            default: return "Sociable/Amigable";
        }
    }

    private static String seleccionarClima(int opcion) {
        switch (opcion) {
            case 1: return "Calidos";
            case 2: return "Frios";
            case 3: return "Adaptable";
            default: return "Adaptable";
        }
    }
}