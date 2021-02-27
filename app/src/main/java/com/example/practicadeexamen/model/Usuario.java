package com.example.practicadeexamen.model;

import java.io.Serializable;

public class Usuario implements Serializable {
    //id int primary key, nombre text, edad int, rol text, cantidadLogin real
    private int id;
    private String nombre;
    private int edad;
    private String rol;
    private int cantidadLogin;

    public Usuario() {
    }

    public Usuario(int id, String nombre, int edad, String rol, int cantidadLogin) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.rol = rol;
        this.cantidadLogin = cantidadLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getCantidadLogin() {
        return cantidadLogin;
    }

    public void setCantidadLogin(int cantidadLogin) {
        this.cantidadLogin = cantidadLogin;
    }
}
