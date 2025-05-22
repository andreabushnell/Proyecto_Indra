package com.indra.eventossostenibles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nombre;
    private int duracion;
    private String categoria;
    private Organizador organizador;
    private Ubicacion ubicacion;
    private LocalDate fecha;
    private LocalDateTime hora;
    private List<Usuario> listaAsistentes;

    Evento(String nombre, int duracion, String categoria, Organizador organizador, Ubicacion ubicacion, LocalDate fecha,
            LocalDateTime hora) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.categoria = categoria;
        this.organizador = organizador;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.hora = hora;
        this.listaAsistentes = new ArrayList<Usuario>();
    }

    public void inscribirParticipante(Usuario u) {
        this.listaAsistentes.add(u);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public List<Usuario> getAsistentes() {
        return listaAsistentes;
    }

    public void setAsistentes(List<Usuario> asistentes) {
        this.listaAsistentes = asistentes;
    }

    @Override
    public String toString() {
        return "Evento [nombre=" + nombre + ", duracion=" + duracion + ", categoria=" + categoria + ", organizador="
                + organizador + ", ubicacion=" + ubicacion + ", fecha=" + fecha + ", hora=" + hora
                + ", listaAsistentes=" + listaAsistentes + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((organizador == null) ? 0 : organizador.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Evento other = (Evento) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (organizador == null) {
            if (other.organizador != null)
                return false;
        } else if (!organizador.equals(other.organizador))
            return false;
        return true;
    }

    

}
