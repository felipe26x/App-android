package com.example.splashscreenapp.usuarios;

public class Usuarios {
    String id,nombres,apellidos,nombreusuario,email,numero_telefono;



    public Usuarios() {
    }

    public Usuarios(String id, String nombres,String apellidos ,String nombreusuario ,String email, String numero_telefono) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nombreusuario = nombreusuario;
        this.email = email;
        this.numero_telefono = numero_telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    //public int getFecha_actual() {
      //  return fecha_actual;
    //}

    //public void setFecha_actual(int fecha_actual) {
    //this.fecha_actual = fecha_actual;
    //}


}
