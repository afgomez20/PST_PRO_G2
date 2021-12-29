package com.example.pis_adas.clases;

import java.io.Serializable;

public class Usuario implements Serializable {
    public String user;
    public String clave;
    public String nombre;
    public String correo;

    public Usuario(String user, String clave, String nombre, String correo) {
        this.user = user;
        this.clave = clave;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

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
}
