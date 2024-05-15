/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package Controlador;

import com.mycompany.proyecto_sistema_recomendaciones.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DriverUsuario {

    private ArrayList<Usuario> usuarios; // Lista para guardar los usuarios
    private Archivo archivo; // Manejador de archivos CSV
    private int indexUsuario; // Índice del usuario activo
    int globalid; // ID global para asignar a nuevos usuarios

    public DriverUsuario() {
        File file = new File("Usuario.csv");
        archivo = new Archivo("Usuario.csv", "Perros.csv");
        // Cargar usuarios si el archivo existe
        if (file.exists()) {
            try {
                usuarios = archivo.leerUsuariosCSV();
                HashMap<Integer, ArrayList<Perro>> perrosPorUsuario = archivo.leerPerrosCSV();
                // Asignar perros a sus respectivos usuarios
                for (Usuario usuario : usuarios) {
                    if (perrosPorUsuario.containsKey(usuario.getId())) {
                        usuario.setPerrosAdoptados(perrosPorUsuario.get(usuario.getId()));
                    }
                }
                // Establecer el último ID usado
                globalid = usuarios.get(usuarios.size() - 1).getId();
            } catch (Exception e) {
                System.out.println("Error al cargar información de usuarios!");
            }
        } else {
            // Inicializar valores si no hay archivo
            usuarios = new ArrayList<>();
            indexUsuario = 0;
            globalid = 0;
        }
    }

    // Método para validar y guardar un nuevo usuario
    public void validarUsuario(String mensaje, int idActual, String nombre, String correo, String contrasena, boolean nuevo) {
        if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacíos!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        guardarUsuario(mensaje, idActual, nombre, correo, contrasena, nuevo);
    }

    // Guardar o actualizar un usuario en la lista
    public void guardarUsuario(String mensaje, int idActual, String nombre, String correo, String contrasena, boolean nuevo) {
        Usuario usuario = new Usuario(globalid++, nombre, correo, contrasena, null);
        if (nuevo) {
            usuarios.add(usuario); // Añadir nuevo usuario
        } else {
            usuarios.set(indexUsuario, usuario); // Actualizar usuario existente
        }
        try{
            guardarArchivoUser();
        }catch(IOException e){
         JOptionPane.showMessageDialog(null, "Cuenta " + mensaje + " con éxito!");
            
        } catch (Exception ex) {
            Logger.getLogger(DriverUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Cuenta " + mensaje + " con éxito!");
    }

    // Iniciar sesión comprobando credenciales
    public boolean iniciarSesion(String user, String pass) {
        for (Usuario usuario : usuarios) {
            if (user.equals(usuario.getNombre()) && pass.equals(usuario.getPassword())) {
                indexUsuario = usuarios.indexOf(usuario);
                JOptionPane.showMessageDialog(null, "Credenciales correctas!");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Credenciales incorrectas!", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Guardar datos de usuarios y perros en archivos CSV
    public void guardarArchivoUser() throws IOException, Exception {
        archivo.guardarUsuariosCSV(usuarios);
    }

    public void guardarArchivoCont() throws IOException {
        archivo.guardarPerrosCSV(usuarios);
    }
}