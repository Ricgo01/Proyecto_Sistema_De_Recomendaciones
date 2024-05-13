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

public class main {
    public static void main(String[] args) {
        String uri = "neo4j+s://0503f9ee.databases.neo4j.io";
        String user = "neo4j";
        String password = "EPzLf4ZMyFJYAB-dr4bDr1rQ6B1M3aSpnpB6d9qHTPA";
        
        // Crear el driver y abrir una sesión
        try (Driver driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
             Session session = driver.session()) {
             
            // Consulta para obtener solo los nombres de los perros
            String query = "MATCH (d:Perro) RETURN d.nombre AS nombre";
            Result result = session.run(query);
            
            // Imprimir los nombres de los perros
            System.out.println("Nombres de los perros en la base de datos:");
            while (result.hasNext()) {
                var record = result.next();
                System.out.println(record.get("nombre").asString());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}