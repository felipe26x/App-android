package com.example.splashscreenapp.model;

import java.io.Serializable;

public class ItemList implements Serializable {
    private String nombre;
    private String descripcion;
    private String precio;
    private String image;

    public ItemList(String nombre, String descripcion, String image, String precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.image = image;
    }

    public String getnombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getimageResource() {
        return image;
    }

    public String getprecio() {return precio;}
}

