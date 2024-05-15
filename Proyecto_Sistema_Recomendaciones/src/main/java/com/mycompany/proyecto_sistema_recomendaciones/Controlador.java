/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_sistema_recomendaciones;

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
                           "RETURN p.nombre AS nombre, " +
                           "   (CASE WHEN EXISTS ((p)-[:TIENE_COLOR]->(:Color {name: $color})) THEN 1 ELSE 0 END + " +
                           "    CASE WHEN EXISTS ((p)-[:TIENE_PELO]->(:Pelo {name: $pelo})) THEN 1 ELSE 0 END + " +
                           "    CASE WHEN EXISTS ((p)-[:TIENE_PERSONALIDAD]->(:Personalidad {name: $personalidad})) THEN 1 ELSE 0 END + " +
                           "    CASE WHEN EXISTS ((p)-[:TIENE_TAMANO]->(:Size {name: $tamaño})) THEN 1 ELSE 0 END + " +
                           "    CASE WHEN EXISTS ((p)-[:TIENE_CLIMA]->(:Clima {name: $clima})) THEN 1 ELSE 0 END) AS score " +
                           "ORDER BY score DESC";
            Result result = session.run(query, org.neo4j.driver.Values.parameters(
                "color", color, "pelo", pelo, "personalidad", personalidad, "tamaño", tamaño, "clima", clima
            ));
            System.out.println("Perros recomendados basados en las preferencias:");
            while (result.hasNext()) {
                Record record = result.next();
                System.out.println("Perro: " + record.get("nombre").asString() + ", Puntuación: " + record.get("score").asInt());
            }
        } finally {
            session.close();
        }
    }

    public void close() {
        dbConnection.close();
    }
}