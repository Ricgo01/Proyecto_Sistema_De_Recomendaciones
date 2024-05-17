package com.mycompany.proyecto_sistema_recomendaciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Archivo {

    private File archivoUsuarios;
    private File archivoPerros;

    
    public Archivo(String nombreUsuarios, String nombrePerros) {
        archivoUsuarios = new File(nombreUsuarios);
        archivoPerros = new File(nombrePerros);
    }

    public void guardarUsuariosCSV(ArrayList<Usuario> usuarios) throws Exception {
        FileWriter fileWriter = new FileWriter(archivoUsuarios);
        PrintWriter escritor = new PrintWriter(fileWriter);
        int idCounter = usuarios.stream().mapToInt(Usuario::getId).max().orElse(0) + 1;


        String encabezados = "id,nombre,correo,password";
        escritor.println(encabezados);

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == 0) {  // Asignar un nuevo ID si el usuario no tiene uno
                usuario.setId(idCounter++);
            }
            int id = usuario.getId();
            String nombre = usuario.getNombre();
            String correo = usuario.getCorreo();
            String password = usuario.getPassword();

            String linea = id + "," + nombre + "," + correo + "," + password;
            escritor.println(linea);
        }

        escritor.close();
    }

    public ArrayList<Usuario> leerUsuariosCSV() throws FileNotFoundException, IOException {
        ArrayList<Usuario> usuariosTemp = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios));
        String linea;
        br.readLine(); // Saltar la línea de encabezados

        while ((linea = br.readLine()) != null) {
            String[] datosUsuario = linea.split(",");
            int id = Integer.parseInt(datosUsuario[0]);
            String nombre = datosUsuario[1];
            String correo = datosUsuario[2];
            String password = datosUsuario[3];

            Usuario usuario = new Usuario(id, nombre, correo, password, new ArrayList<>());
            usuariosTemp.add(usuario);
        }

        br.close();
        return usuariosTemp;
    }

    public void guardarPerrosCSV(ArrayList<Usuario> usuarios) throws IOException {
     try (FileWriter fw = new FileWriter(archivoPerros)) {
         fw.write("idUsuario,nombrePerro\n");
         for (Usuario usuario : usuarios) {
             if (usuario != null && usuario.getPerrosAdoptados() != null) {
                 for (Perro perro : usuario.getPerrosAdoptados()) {
                     if (perro != null) {
                         String linea = usuario.getId() + "," + perro.getNombre() + "\n";
                         fw.write(linea);
                     }
                 }
             }
         }
     }
 }

    public HashMap<Integer, ArrayList<Perro>> leerPerrosCSV() throws IOException {
        HashMap<Integer, ArrayList<Perro>> perrosPorUsuario = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(archivoPerros));
        String linea;
        br.readLine(); // Saltar la línea de encabezados

        while ((linea = br.readLine()) != null) {
            String[] datosPerro = linea.split(",");
            int idUsuario = Integer.parseInt(datosPerro[0]);
            String nombrePerro = datosPerro[1];

            Perro perro = new Perro(nombrePerro,"");
            perrosPorUsuario.putIfAbsent(idUsuario, new ArrayList<>());
            perrosPorUsuario.get(idUsuario).add(perro);
        }

        br.close();
        return perrosPorUsuario;
    }
}
