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
                tx.run("CREATE CONSTRAINT IF NOT EXISTS ON (t:Tamano) ASSERT t.name IS UNIQUE");
                tx.run("CREATE CONSTRAINT IF NOT EXISTS ON (c:Color) ASSERT c.name IS UNIQUE");
                tx.run("CREATE CONSTRAINT IF NOT EXISTS ON (p:Pelo) ASSERT p.name IS UNIQUE");
                tx.run("CREATE CONSTRAINT IF NOT EXISTS ON (pers:Personalidad) ASSERT pers.name IS UNIQUE");
                tx.run("CREATE CONSTRAINT IF NOT EXISTS ON (clima:ToleranciaClima) ASSERT clima.name IS UNIQUE");

                
                tx.run("CREATE (t:Tamano {name: 'Pequeño'})");
                tx.run("CREATE (t:Tamano {name: 'Mediano'})");
                tx.run("CREATE (t:Tamano {name: 'Grande'})");
                
                tx.run("CREATE (c:Color {name: 'Negro'})");
                tx.run("CREATE (c:Color {name: 'Blanco'})");
                tx.run("CREATE (c:Color {name: 'Gris'})");
                tx.run("CREATE (c:Color {name: 'Marron'})");
                tx.run("CREATE (c:Color {name: 'Multicolor'})");
                
                tx.run("CREATE (p:Pelo {name: 'Corto'})");
                tx.run("CREATE (p:Pelo {name: 'Largo'})");
                tx.run("CREATE (p:Pelo {name: 'Rizado'})");
                tx.run("CREATE (p:Pelo {name: 'Sin pelo'})");
                
                tx.run("CREATE (pers:Personalidad {name: 'Activo/Enérgico'})");
                tx.run("CREATE (pers:Personalidad {name: 'Tranquilo/Relajado'})");
                tx.run("CREATE (pers:Personalidad {name: 'Sociable/Amigable'})");
                tx.run("CREATE (pers:Personalidad {name: 'Independiente/Reservado'})");
                
                tx.run("CREATE (clima:ToleranciaClima {name: 'Climas Cálidos'})");
                tx.run("CREATE (clima:ToleranciaClima {name: 'Climas Frios'})");
                tx.run("CREATE (clima:ToleranciaClima {name: 'Adaptación a variedad de climas'})");
                
                tx.commit();
            }
        }
    }

    public void agregarPerro(String nombrePerro, String raza, String tamano, String color, String pelo, String personalidad, String toleranciaClima) {
        try (Session session = dbConnection.createSession()) {
            try (Transaction tx = session.beginTransaction()) {
                tx.run("CREATE (p:Perro {nombre: $nombrePerro, raza: $raza}) " +
                       "MERGE (t:Tamano {name: $tamano}) " +
                       "MERGE (c:Color {name: $color}) " +
                       "MERGE (pel:Pelo {name: $pelo}) " +
                       "MERGE (pers:Personalidad {name: $personalidad}) " +
                       "MERGE (clima:ToleranciaClima {name: $toleranciaClima}) " +
                       "MERGE (p)-[:TIENE_TAMANO]->(t) " +
                       "MERGE (p)-[:TIENE_COLOR]->(c) " +
                       "MERGE (p)-[:TIENE_PELO]->(pel) " +
                       "MERGE (p)-[:TIENE_PERSONALIDAD]->(pers) " +
                       "MERGE (p)-[:TIENE_TOLERANCIA_CLIMA]->(clima)",
                       org.neo4j.driver.Values.parameters(
                           "nombrePerro", nombrePerro,
                           "raza", raza,
                           "tamano", tamano,
                           "color", color,
                           "pelo", pelo,
                           "personalidad", personalidad,
                           "toleranciaClima", toleranciaClima));
                tx.commit();
            }
        }
    }

    
    public void recomendarPerros(String color, String pelo, String personalidad, String tamano, String clima) {
        try (Session session = dbConnection.createSession()) {
            String query = "MATCH (p:Perro) " +
                           "OPTIONAL MATCH (p)-[:TIENE_COLOR]->(c:Color {name: $color}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_PELO]->(pl:Pelo {name: $pelo}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_PERSONALIDAD]->(ps:Personalidad {name: $personalidad}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_TAMANO]->(t:Tamano {name: $tamano}) " +
                           "OPTIONAL MATCH (p)-[:TIENE_TOLERANCIA_CLIMA]->(cl:ToleranciaClima {name: $clima}) " +
                           "RETURN p.nombre AS nombre, p.raza AS raza, " +
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
                "tamano", tamano,
                "clima", clima
            ));
            System.out.println("Perros recomendados basados en costos de atributos:");
            while (result.hasNext()) {
                Record record = result.next();
                System.out.println("Perro: " + record.get("nombre").asString() + " (Raza: " + record.get("raza").asString() + "), Costo: " + record.get("costo").asInt());
            }
        }
    }


   
    public void close() {
        dbConnection.close();
    }
}