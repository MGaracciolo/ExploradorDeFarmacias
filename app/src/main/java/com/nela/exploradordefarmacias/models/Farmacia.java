package com.nela.exploradordefarmacias.models;

import java.io.Serial;
import java.io.Serializable;

public class Farmacia implements Serializable {
    private String nombre;
    private String direccion;
    private String horarios;
    private int foto;
    private double lat;
    private double lon;

    public Farmacia(String nombre, String direccion, String horarios, int foto, double lat, double lon) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horarios = horarios;
        this.foto = foto;
        this.lat = lat;
        this.lon = lon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
