package com.mycompany.proyecto_sistema_recomendaciones;

import java.util.ArrayList;

/**
 * Clase Usuario que representa a un usuario del sistema con su información personal 
 */
public class Usuario {

    //Atributos 
    private String nombre;
    private String correo;
    private String password;
    private int id;
    private ArrayList<Perro> perrosAdoptados;

    /**
     * 
     */
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", password=" + password + ", perros Adoptado="
                + perrosAdoptados + "]";
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Perro> getPerrosAdoptados() {
        return perrosAdoptados;
    }

    public void setPerrosAdoptados(ArrayList<Perro> perrosAdoptados) {
        this.perrosAdoptados = perrosAdoptados;
    }
    
    public int sizePerrosAdoptados(){
        return perrosAdoptados.size();
    }
    
   

    /**
     * Constructor con parámetros que inicializa un usuario con su información básica y una lista de perros adoptados.
     * 
     * @param id El identificador único del usuario.
     * @param nombre El nombre del usuario.
     * @param correo El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @param perrosAdoptados Una lista de objetos Perro adoptados por el usuario.
     */
    public Usuario(int id, String nombre, String correo, String password, ArrayList<Perro> perrosAdoptados) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.perrosAdoptados = perrosAdoptados;
        this.id = id;
    }



}
