package com.indra.eventossostenibles;

import java.util.ArrayList;
import java.util.List;

public class Portal {
    private List<Usuario> listaUsuarios;
    private List<Evento> listaEventos;
    private List<Organizador> listaOrganizadores;

    Portal() {
        this.listaUsuarios = new ArrayList<Usuario>();
        this.listaEventos = new ArrayList<Evento>();
        this.listaOrganizadores = new ArrayList<Organizador>();
    }

    public void añadirAListaUsuarios(Usuario usuario) {
        this.listaUsuarios.add(usuario);
    }

    public void añadirAListaEventos(Evento evento) {
        this.listaEventos.add(evento);
    }

    public void añadirAListaOrganizadores(Organizador organizador) {
        this.listaOrganizadores.add(organizador);
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Evento> getListaEventos() {
        return listaEventos;
    }

    public void setListaEventos(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }

    public List<Organizador> getListaOrganizadores() {
        return listaOrganizadores;
    }

    public void setListaOrganizadores(List<Organizador> listaOrganizadores) {
        this.listaOrganizadores = listaOrganizadores;
    }

    @Override
    public String toString() {
        return "Portal [listaUsuarios=" + listaUsuarios + ", listaEventos=" + listaEventos + ", listaOrganizadores="
                + listaOrganizadores + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((listaUsuarios == null) ? 0 : listaUsuarios.hashCode());
        result = prime * result + ((listaEventos == null) ? 0 : listaEventos.hashCode());
        result = prime * result + ((listaOrganizadores == null) ? 0 : listaOrganizadores.hashCode());
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
        Portal other = (Portal) obj;
        if (listaUsuarios == null) {
            if (other.listaUsuarios != null)
                return false;
        } else if (!listaUsuarios.equals(other.listaUsuarios))
            return false;
        if (listaEventos == null) {
            if (other.listaEventos != null)
                return false;
        } else if (!listaEventos.equals(other.listaEventos))
            return false;
        if (listaOrganizadores == null) {
            if (other.listaOrganizadores != null)
                return false;
        } else if (!listaOrganizadores.equals(other.listaOrganizadores))
            return false;
        return true;
    }

    

}
