/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_sistema_recomendaciones;


import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;


public class Neo4jConnection {
    
    public static void main(String[] args) {
        
        String uri = "neo4j+s://0503f9ee.databases.neo4j.io"; // O la dirección IP de tu servidor Neo4j
        String user = "neo4j";
        String password = "EPzLf4ZMyFJYAB-dr4bDr1rQ6B1M3aSpnpB6d9qHTPA";

        // Crear el Driver y la Sesión
        Driver driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
        try (Session session = driver.session()) {
            System.out.println("Total nodes in database:0 " );
            String result = session.writeTransaction(tx -> {
                var queryResult = tx.run("MATCH (n) RETURN count(n) AS nodeCount");
                return queryResult.single().get("nodeCount").toString();
            });
            System.out.println("Total nodes in database: " + result);
        } finally {
            driver.close();
        }
    }
}
    
