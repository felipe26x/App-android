package com.example.splashscreenapp;

public class Videojuegos {
    private int imagen;
    private String nombre;
    private int precio;

    public Videojuegos(int imagen, String nombre, int precio) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getprecio() {
        return precio;
    }

    public void setprecio(int precio) {
        this.precio = precio;
    }
}