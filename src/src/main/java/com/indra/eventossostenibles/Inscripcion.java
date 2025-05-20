package com.indra.eventossostenibles;


public class Inscripcion {
    private Usuario usuario;
    private Evento evento;

    public Inscripcion(Usuario usuario, Evento evento) {
        this.usuario = usuario;
        this.evento = evento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
/* 
    Usuario y Evento -> tabla Inscripciones
    Almacenar inscripciones en: ArrayList, TreeMap?
    Ordenar por: evento
 */