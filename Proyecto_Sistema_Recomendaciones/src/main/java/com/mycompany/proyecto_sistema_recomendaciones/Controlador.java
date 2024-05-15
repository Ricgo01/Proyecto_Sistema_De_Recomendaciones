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
import org.neo4j.driver.Transaction;

public class Controlador {
    private Neo4jConnection dbConnection;

    public Controlador() {
        this.dbConnection = new Neo4jConnection("neo4j+s://0503f9ee.databases.neo4j.io", "neo4j", "EPzLf4ZMyFJYAB-dr4bDr1rQ6B1M3aSpnpB6d9qHTPA");
        initializeDatabase();
    }
    
    private void initializeDatabase() {
        try (Session session = dbConnection.createSession()) {
            try (Transaction tx = session.beginTransaction()) {
                tx.run("CREATE (p:Perro {nombre: 'Chihuahua'}) " +
                       "MERGE (t:Tamano {name: 'Pequeño'}) " +
                       "MERGE (pel:Pelo {name: 'Liso'}) " +
                       "MERGE (tp:TamañoPelo {name: 'Corto'}) " +
                       "MERGE (c:Color {name: 'Café'}) " +
                       "MERGE (pers:Personalidad {name: 'Juguetón'}) " +
                       "MERGE (p)-[:TIENE_TAMANO]->(t) " +
                       "MERGE (p)-[:TIENE_PELO]->(pel) " +
                       "MERGE (p)-[:TIENE_TAMAÑO_PELO]->(tp) " +
                       "MERGE (p)-[:TIENE_COLOR]->(c) " +
                       "MERGE (p)-[:TIENE_PERSONALIDAD]->(pers)");
                tx.run("CREATE (p:Perro {nombre: 'Schnauzer'}) " +
                       "MERGE (t:Tamano {name: 'Mediano'}) " +
                       "MERGE (pel:Pelo {name: 'Ondulado'}) " +
                       "MERGE (tp:TamañoPelo {name: 'Mediano'}) " +
                       "MERGE (c:Color {name: 'Gris'}) " +
                       "MERGE (pers:Personalidad {name: 'Protector'}) " +
                       "MERGE (p)-[:TIENE_TAMANO]->(t) " +
                       "MERGE (p)-[:TIENE_PELO]->(pel) " +
                       "MERGE (p)-[:TIENE_TAMAÑO_PELO]->(tp) " +
                       "MERGE (p)-[:TIENE_COLOR]->(c) " +
                       "MERGE (p)-[:TIENE_PERSONALIDAD]->(pers)");
                tx.run("CREATE (p:Perro {nombre: 'Pastor Aleman'}) " +
                       "MERGE (t:Tamano {name: 'Grande'}) " +
                       "MERGE (pel:Pelo {name: 'Liso'}) " +
                       "MERGE (tp:TamañoPelo {name: 'Largo'}) " +
                       "MERGE (c:Color {name: 'Negro'}) " +
                       "MERGE (pers:Personalidad {name: 'Cuidadoso'}) " +
                       "MERGE (p)-[:TIENE_TAMANO]->(t) " +
                       "MERGE (p)-[:TIENE_PELO]->(pel) " +
                       "MERGE (p)-[:TIENE_TAMAÑO_PELO]->(tp) " +
                       "MERGE (p)-[:TIENE_COLOR]->(c) " +
                       "MERGE (p)-[:TIENE_PERSONALIDAD]->(pers)");
                tx.run("CREATE (p:Perro {nombre: 'Husky'}) " +
                       "MERGE (t:Tamano {name: 'Grande'}) " +
                       "MERGE (pel:Pelo {name: 'Ondulado'}) " +
                       "MERGE (tp:TamañoPelo {name: 'Largo'}) " +
                       "MERGE (c:Color {name: 'Blanco'}) " +
                       "MERGE (pers:Personalidad {name: 'Tranquilo'}) " +
                       "MERGE (p)-[:TIENE_TAMANO]->(t) " +
                       "MERGE (p)-[:TIENE_PELO]->(pel) " +
                       "MERGE (p)-[:TIENE_TAMAÑO_PELO]->(tp) " +
                       "MERGE (p)-[:TIENE_COLOR]->(c) " +
                       "MERGE (p)-[:TIENE_PERSONALIDAD]->(pers)");
                tx.run("CREATE (p:Perro {nombre: 'Shih Tzu'}) " +
                       "MERGE (t:Tamano {name: 'Pequeño'}) " +
                       "MERGE (pel:Pelo {name: 'Liso'}) " +
                       "MERGE (tp:TamañoPelo {name: 'Largo'}) " +
                       "MERGE (c:Color {name: 'Blanco'}) " +
                       "MERGE (pers:Personalidad {name: 'Dormilón'}) " +
                       "MERGE (p)-[:TIENE_TAMANO]->(t) " +
                       "MERGE (p)-[:TIENE_PELO]->(pel) " +
                       "MERGE (p)-[:TIENE_TAMAÑO_PELO]->(tp) " +
                       "MERGE (p)-[:TIENE_COLOR]->(c) " +
                       "MERGE (p)-[:TIENE_PERSONALIDAD]->(pers)");
                tx.commit();
            }
        }
    }
    
   public void recomendarPerros(String color, String pelo, String personalidad, String tamaño, String clima) {
        Session session = dbConnection.createSession();
        try {
            String query = "MATCH (p:Perro) " +
                           "OPTIONAL MATCH (p)-[:TIENE_COLOR]->(c:Color {name: $color}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_PELO]->(pl:Pelo {name: $pelo}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_PERSONALIDAD]->(ps:Personalidad {name: $personalidad}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_TAMANO]->(t:Size {name: $tamaño}) " +
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

     
//Cierra esto
    public void close() {
        dbConnection.close();
    }
}