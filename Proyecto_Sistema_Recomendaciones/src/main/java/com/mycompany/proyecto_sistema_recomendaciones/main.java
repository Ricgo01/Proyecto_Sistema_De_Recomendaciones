/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_sistema_recomendaciones;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        
        System.out.println("¡Hola! Vamos a encontrar el perro perfecto para ti.");
        
        System.out.println("¿De qué color te gustaría que fuera el perro?");
        String color = scanner.nextLine();
        
        System.out.println("¿Qué tamaño prefieres para el perro? (pequeño, mediano, grande)");
        String tamaño = scanner.nextLine();
        
        System.out.println("¿Qué tipo de pelo te gusta en un perro? (corto, largo, mediano)");
        String pelo = scanner.nextLine();
        
        System.out.println("¿Qué tipo de personalidad te gustaría que tuviera el perro?");
        String personalidad = scanner.nextLine();
        
        System.out.println("¿Que tamaño tienes disponible para tu perro? (pequeño, mediano, grande)");
        String tamañoEspacio = scanner.nextLine();
        
        System.out.println("¿Cuántos años tienes?");
        int edad = scanner.nextInt();
        
        System.out.println("¿Vives solo? (si/no)");
        String viveSolo = scanner.nextLine(); 
        viveSolo = scanner.nextLine();
        
        System.out.println("¿Tienes alguna alergia? (si/no)");
        String alergia = scanner.nextLine();

    }

    
}