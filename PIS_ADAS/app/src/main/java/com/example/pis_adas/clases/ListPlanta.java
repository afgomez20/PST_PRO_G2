package com.example.pis_adas.clases;

import java.io.Serializable;

public class ListPlanta implements Serializable {
    public String nombre;
    public float tempMin;
    public float humMin;
    public boolean automatic;
    public boolean manual;
    public int imagen;

    public ListPlanta(String nombre, float tempMin, float humMin, int imagen) {
        this.nombre = nombre;
        this.tempMin = tempMin;
        this.humMin = humMin;
        this.imagen = imagen;
        this.automatic = false;
        this.manual = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public float getHumMin() {
        return humMin;
    }

    public void setHumMin(float humMin) {
        this.humMin = humMin;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
