/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_sistema_recomendaciones;


import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.*;

import java.util.ArrayList;
import java.util.List;


public class Neo4jConnection {
    
   public static void main(String[] args) {
        
    String uri = "neo4j+s://0503f9ee.databases.neo4j.io"; // O la dirección IP de tu servidor Neo4j
    String user = "neo4j";
    String password = "EPzLf4ZMyFJYAB-dr4bDr1rQ6B1M3aSpnpB6d9qHTPA";

    // Crear el Driver y la Sesión
    try (Driver driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
         Session session = driver.session()) {

        // Consulta Cypher para recuperar todos los nodos y relaciones
        String query = "MATCH (n) RETURN n";

        // Ejecutar la consulta y procesar los resultados
        Result result = session.run(query);
        while (result.hasNext()) {
            org.neo4j.driver.Record record = result.next();
            // Procesar cada nodo y sus propiedades
            Node node = record.get("n").asNode();
            System.out.println("Node ID: " + node.id() + ", Labels: " + node.labels());
            node.keys().forEach(key -> System.out.println(key + ": " + node.get(key)));
            System.out.println();
        }

    } catch (Exception e) {
        // Manejar la excepción
        e.printStackTrace();
    }
}
     // Método para obtener perros recomendados según las preferencias del usuario
    public List<Perro> obtenerPerrosRecomendados(String color, String tamaño, String pelo, String personalidad) {
        List<Perro> perrosRecomendados = new ArrayList<>();

        String uri = "neo4j+s://0503f9ee.databases.neo4j.io";
        String user = "neo4j";
        String password = "EPzLf4ZMyFJYAB-dr4bDr1rQ6B1M3aSpnpB6d9qHTPA";

        try (Driver driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
             Session session = driver.session()) {

            // Construir la consulta Cypher
            String query = "MATCH (p:Perro) " +
                           "WHERE p.color = $color " +
                           "AND p.tamaño = $tamaño " +
                           "AND p.tipoPelo = $pelo " +
                           "AND p.personalidad = $personalidad " +
                           //Falta aqui tolerancia al clima
                           "RETURN p";

            // Parámetros de la consulta
            Value parameters = Values.parameters(
                "color", color,
                "tamaño", tamaño,
                "pelo", pelo,
                "personalidad", personalidad
                //Falta aqui tolerancia al clima
            );

            // Ejecutar la consulta y procesar los resultados
            

        } catch (Exception e) {
            // Manejar la excepción
            e.printStackTrace();
        }

        return perrosRecomendados;
    }
    
    

}
    
