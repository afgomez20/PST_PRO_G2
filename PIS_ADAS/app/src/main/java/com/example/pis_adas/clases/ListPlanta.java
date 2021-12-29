package com.example.pis_adas.clases;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Objects;

public class ListPlanta implements Serializable {
    public int id;
    public String nombre;
    public float tempMin;
    public float humMin;
    public boolean automatic;
    public boolean manual;
    public int imagen;
    public static int contador = 1;

    public ListPlanta(String nombre, float tempMin, float humMin, int imagen) {
        this.id =contador;
        this.nombre = nombre;
        this.tempMin = tempMin;
        this.humMin = humMin;
        this.imagen = imagen;
        this.automatic = false;
        this.manual = false;
        contador+=1;
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListPlanta that = (ListPlanta) o;
        return id == that.id;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
