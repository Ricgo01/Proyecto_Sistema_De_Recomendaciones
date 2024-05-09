/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_sistema_recomendaciones;
import java.util.Scanner;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;

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

     @SuppressWarnings("deprecation")
        Driver driver = GraphDatabase.driver(
                "bolt://localhost:7687",
                AuthTokens.basic(
                        "neo4j",
                        "MarR3-18"

                        ));

        try (Session session = driver.session()) {

            session.writeTransaction(tx -> {
                tx.run("CREATE (user:Raza {name:'Chihuaha'})");
                tx.run("CREATE (user:Tamaño {name:'pequeño'})");
                tx.run("CREATE (user:Pelo {name:'liso'})");
                tx.run("CREATE (user:Personalidad {name:'Protector'})");
                tx.run("CREATE (user:color {name:'cafe'})");
                return null;
            });

            Result result = session.run("MATCH (n) RETURN n.name AS name");
            while (result.hasNext()) {
                Record record = result.next();
                String name = record.get("name").asString();
                System.out.println("Name: " + name);
            }

            result = session.run("""
                    MATCH (p:Raza {name:"Name"}), (t:Tamaño {name:"pequeño"})
                    MERGE (p)-[e:WATCH]-(a)
                    RETURN p.name, e, a.name
                    """
            );


            while (result.hasNext()) {
                Record record = result.next();
                System.out.println(record);
            }


            result = session.run("MATCH (n) RETURN n.name AS name");
            while (result.hasNext()) {
                Record record = result.next();
                String name = record.get("name").asString();
                System.out.println("Name: " + name);
            }

 

        } finally {
            driver.close();
        }
    }
}