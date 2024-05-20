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
import org.neo4j.driver.Values;

public class Controlador {
    private Neo4jConnection dbConnection;

    public Controlador() {
        this.dbConnection = new Neo4jConnection("neo4j+s://0503f9ee.databases.neo4j.io", "neo4j", "EPzLf4ZMyFJYAB-dr4bDr1rQ6B1M3aSpnpB6d9qHTPA");
    }

    public ArrayList<String> recomendarPerros(String color, String pelo, String personalidad, String tamaño, String clima) {
        ArrayList<String> recomendados = new ArrayList<>();
        try (Session session = dbConnection.createSession()) {
            String query = "MATCH (p:Perro) " +
                           "OPTIONAL MATCH (p)-[:TIENE_COLOR]->(c:Color {name: $color}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_PELO]->(pl:Pelo {name: $pelo}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_PERSONALIDAD]->(ps:Personalidad {name: $personalidad}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_TAMANO]->(t:Tamano {name: $tamaño}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_CLIMA]->(cl:Clima {name: $clima}) " +
                           "RETURN p.nombre AS nombre " +
                           "ORDER BY (CASE WHEN c IS NULL THEN 1 ELSE 0 END + " +
                           "CASE WHEN pl IS NULL THEN 1 ELSE 0 END + " +
                           "CASE WHEN ps IS NULL THEN 1 ELSE 0 END + " +
                           "CASE WHEN t IS NULL THEN 1 ELSE 0 END + " +
                           "CASE WHEN cl IS NULL THEN 1 ELSE 0 END) ASC " +
                           "LIMIT 3";
            Result result = session.run(query, Values.parameters(
                "color", color, 
                "pelo", pelo, 
                "personalidad", personalidad, 
                "tamaño", tamaño, 
                "clima", clima
            ));

            while (result.hasNext()) {
                Record record = result.next();
                recomendados.add(record.get("nombre").asString());
            }
        }
        return recomendados;
    }
    
   public ArrayList<String> obtenerDetallesPerrosRecomendados(ArrayList<String> nombresPerros) {
    ArrayList<String> detallesPerros = new ArrayList<>();
    try (Session session = dbConnection.createSession()) {
        for (String nombre : nombresPerros) {
            String query = "MATCH (p:Perro {nombre: $nombre}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_COLOR]->(c:Color) " +
                           "OPTIONAL MATCH (p)-[:TIENE_PELO]->(pl:Pelo) " +
                           "OPTIONAL MATCH (p)-[:TIENE_PERSONALIDAD]->(ps:Personalidad) " +
                           "OPTIONAL MATCH (p)-[:TIENE_TAMANO]->(t:Tamano) " +
                           "OPTIONAL MATCH (p)-[:TIENE_CLIMA]->(cl:Clima) " +
                           "RETURN c.name AS color, pl.name AS pelo, " +
                           "ps.name AS personalidad, t.name AS tamaño, cl.name AS clima";
            Result result = session.run(query, Values.parameters("nombre", nombre));
            while (result.hasNext()) {
                Record record = result.next();
                String detalles = String.format(
                    "Color: %s\nPelo: %s\nPersonalidad: %s\nTamaño: %s\nClima: %s",
                    record.get("color").isNull() ? "N/A" : record.get("color").asString(),
                    record.get("pelo").isNull() ? "N/A" : record.get("pelo").asString(),
                    record.get("personalidad").isNull() ? "N/A" : record.get("personalidad").asString(),
                    record.get("tamaño").isNull() ? "N/A" : record.get("tamaño").asString(),
                    record.get("clima").isNull() ? "N/A" : record.get("clima").asString()
                );
                detallesPerros.add(detalles);
            }
        }
    }
    return detallesPerros;
}   
   public void eliminarPerro(String nombre) {
        try (Session session = dbConnection.createSession()) {
            String query = "MATCH (p:Perro {nombre: $nombre}) DETACH DELETE p";
            session.run(query, Values.parameters("nombre", nombre));
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