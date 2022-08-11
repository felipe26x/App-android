package com.example.splashscreenapp.Productos;


public class Productos {
    String id,nombre,precio,informacion_de_produccion,descripcion;

    public Productos() {
    }

    public Productos(String id, String nombre,String precio, String informacion_de_produccion, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.informacion_de_produccion = informacion_de_produccion;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getInformacion_de_produccion() {
        return informacion_de_produccion;
    }

    public void setInformacion_de_produccion(String informacion_de_produccion) {
        this.informacion_de_produccion = informacion_de_produccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
