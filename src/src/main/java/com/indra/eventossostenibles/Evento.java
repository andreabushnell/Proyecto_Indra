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
    private boolean activo;
    private List<Usuario> listaAsistentes;

    Evento(String nombre, int duracion, String categoria, Organizador organizador, Ubicacion ubicacion, LocalDate fecha,
            LocalDateTime hora, boolean activo) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.categoria = categoria;
        this.organizador = organizador;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.hora = hora;
        this.activo = activo;
        this.listaAsistentes = new ArrayList<Usuario>();
    }

    public Usuario inscribirParticipante(Usuario usuario) {
        if (!listaAsistentes.contains(usuario)) {
            listaAsistentes.add(usuario);
            return usuario;
        }
        return null;
    }

    public boolean cancelarEvento() {
        if (activo) {
            this.setActivo(false);
            return true;
        }
        return false;
    }

    public Usuario cancelarInscripcion(Usuario usuario) {
        if (listaAsistentes.contains(usuario)) {
            listaAsistentes.remove(usuario);
            return usuario;
        } return null;
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

    public boolean isActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Usuario> getListaAsistentes() {
        return listaAsistentes;
    }

    public void setListaAsistentes(List<Usuario> listaAsistentes) {
        this.listaAsistentes = listaAsistentes;
    }

    @Override
    public String toString() {
        return "Evento [nombre=" + nombre + ", duracion=" + duracion + ", categoria=" + categoria + ", organizador="
                + organizador + ", ubicacion=" + ubicacion + ", fecha=" + fecha + ", hora=" + hora + ", estado="
                + activo + ", listaAsistentes=" + listaAsistentes + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + duracion;
        result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
        result = prime * result + ((organizador == null) ? 0 : organizador.hashCode());
        result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((hora == null) ? 0 : hora.hashCode());
        result = prime * result + (activo ? 1231 : 1237);
        result = prime * result + ((listaAsistentes == null) ? 0 : listaAsistentes.hashCode());
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
        if (duracion != other.duracion)
            return false;
        if (categoria == null) {
            if (other.categoria != null)
                return false;
        } else if (!categoria.equals(other.categoria))
            return false;
        if (organizador == null) {
            if (other.organizador != null)
                return false;
        } else if (!organizador.equals(other.organizador))
            return false;
        if (ubicacion == null) {
            if (other.ubicacion != null)
                return false;
        } else if (!ubicacion.equals(other.ubicacion))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (hora == null) {
            if (other.hora != null)
                return false;
        } else if (!hora.equals(other.hora))
            return false;
        if (activo != other.activo)
            return false;
        if (listaAsistentes == null) {
            if (other.listaAsistentes != null)
                return false;
        } else if (!listaAsistentes.equals(other.listaAsistentes))
            return false;
        return true;
    }

}
