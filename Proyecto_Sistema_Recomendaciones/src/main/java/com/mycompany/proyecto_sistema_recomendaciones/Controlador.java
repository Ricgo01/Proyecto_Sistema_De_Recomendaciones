/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_sistema_recomendaciones;

import java.util.ArrayList;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.neo4j.driver.Result;
import org.neo4j.driver.Record;

public class Controlador {
    private Neo4jConnection dbConnection;

    public Controlador() {
        this.dbConnection = new Neo4jConnection("neo4j+s://0503f9ee.databases.neo4j.io", "neo4j", "EPzLf4ZMyFJYAB-dr4bDr1rQ6B1M3aSpnpB6d9qHTPA");
    }

   public void recomendarPerros(String color, String pelo, String personalidad, String tamaño, String clima) {
        Session session = dbConnection.createSession();
        try {
            String query = "MATCH (p:Perro) " +
                           "OPTIONAL MATCH (p)-[:TIENE_COLOR]->(c:Color {name: $color}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_PELO]->(pl:Pelo {name: $pelo}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_PERSONALIDAD]->(ps:Personalidad {name: $personalidad}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_TAMANO]->(t:Tamano {name: $tamaño}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_CLIMA]->(cl:Clima {name: $clima}) " +
                           "RETURN p.nombre AS nombre, " +
                           "(CASE WHEN c IS NOT NULL THEN 0 ELSE 1 END + " +
                           "CASE WHEN pl IS NOT NULL THEN 0 ELSE 1 END + " +
                           "CASE WHEN ps IS NOT NULL THEN 0 ELSE 1 END + " +
                           "CASE WHEN t IS NOT NULL THEN 0 ELSE 1 END + " +
                           "CASE WHEN cl IS NOT NULL THEN 0 ELSE 1 END) AS costo " +
                           "ORDER BY costo ASC";
            Result result = session.run(query, org.neo4j.driver.Values.parameters(
                "color", color, 
                "pelo", pelo, 
                "personalidad", personalidad, 
                "tamaño", tamaño, 
                "clima", clima
            ));
            System.out.println("Perros recomendados basados en costos de atributos:");
            while (result.hasNext()) {
                Record record = result.next();
                System.out.println("Perro: " + record.get("nombre").asString() + ", Costo: " + record.get("costo").asInt());
            }
        } finally {
            session.close();
        }       
      }
   
   public void agregarPerro(String nombre, String color, String size, String tipoPelo, String personalidad, String clima) {
        Session session = dbConnection.createSession();
        try {
            String query = "CREATE (p:Perro {nombre: $nombre, size: $size, tipoPelo: $tipoPelo, personalidad: $personalidad, clima: $clima}) " +
                           "WITH p " +
                           "MATCH (c:Color {value: $color}), " +
                                "(s:Size {value: $size}), " +
                                "(tp:Pelo {value: $tipoPelo}), " +
                                "(ps:Personalidad {value: $personalidad}), " +
                                "(cl:Clima {value: $clima}) " +
                           "MERGE (p)-[:TIENE_COLOR]->(c) " +
                                 "(p)-[:TIENE_SIZE]->(s) " +
                                 "(p)-[:TIENE_PELO]->(tp) " +
                                 "(p)-[:TIENE_PERSONALIDAD]->(ps) " +
                                 "(p)-[:TIENE_CLIMA]->(cl) " +
                           "RETURN p";
            Result result = session.run(query, org.neo4j.driver.Values.parameters(
                "nombre", nombre,
                "color", color,
                "size", size,
                "tipoPelo", tipoPelo,
                "personalidad", personalidad,
                "clima", clima
            ));
            if (result.hasNext()) {
                System.out.println("Perro agregado con éxito: " + result.single().get("p").asNode().get("nombre").asString());
            }
        } finally {
            session.close();
        }
    }
   
    public void agregarPerro(String nombre, String raza, String color, String tamaño, String pelo, String personalidad, String clima) {
     Session session = dbConnection.createSession();
     try {
         String query = "MERGE (p:Perro {nombre: $nombre, raza: $raza}) " +
                        "MERGE (c:Color {name: $color}) " +
                        "MERGE (sz:Tamano {name: $tamaño}) " +
                        "MERGE (pl:Pelo {name: $pelo}) " +
                        "MERGE (ps:Personalidad {name: $personalidad}) " +
                        "MERGE (cl:Clima {name: $clima}) " +
                        "CREATE (p)-[:TIENE_COLOR]->(c) " +
                        "CREATE (p)-[:TIENE_TAMANO]->(sz) " +
                        "CREATE (p)-[:TIENE_PELO]->(pl) " +
                        "CREATE (p)-[:TIENE_PERSONALIDAD]->(ps) " +
                        "CREATE (p)-[:TIENE_CLIMA]->(cl) ";
         session.run(query, org.neo4j.driver.Values.parameters(
             "nombre", nombre, 
             "raza", raza, 
             "color", color, 
             "tamaño", tamaño, 
             "pelo", pelo, 
             "personalidad", personalidad, 
             "clima", clima
         ));
         System.out.println("Perro agregado y conectado con sus atributos correctamente.");
     } finally {
         session.close();
     }       
 }

     
//Cierra esto
    public void close() {
        dbConnection.close();
    }
}