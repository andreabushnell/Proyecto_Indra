package com.indra.eventossostenibles;

public class Evento {
    private String nombre;
    private String fecha;
    private String hora;
    private String ubicacion;
    private String organizador;

    public Evento(String nombre, String fecha, String hora, String ubicacion, String organizador) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.ubicacion = ubicacion;
        this.organizador = organizador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

}
