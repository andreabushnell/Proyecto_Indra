package com.indra.eventossostenibles;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

public class PortalTest {
    Portal portal;
    List<Usuario> listaUsuarios;
    List<Evento> listaEventos;
    List<Organizador> listaOrganizadores;
    Evento evento;
    Usuario usuario;
    Organizador organizador;
    @Before
    public void init() {
        portal = new Portal();
        listaUsuarios = new ArrayList<Usuario>();
        listaEventos = new ArrayList<Evento>();
        listaOrganizadores = new ArrayList<Organizador>();
        evento = new Evento("nombre", 0, "categoria", 
                            new Organizador("nombre", "000000000","email"), 
                            new Ubicacion("direccion", "tipo"), 
                            LocalDate.of(2023, 10, 1), 
                            LocalDateTime.of(2023, 10, 1, 10, 0), true);
        usuario = new Usuario("nombre", "email", "000000000");
        organizador = new Organizador("nombre", "000000000","email");
    }

    @Test
    public void testAltaUsuario() {
        assertNotNull(portal.altaUsuario(usuario));
    }

    @Test
    public void testBajaUsuario() {
        assertNotNull(portal.bajaUsuario(usuario));
    }

    @Test
    public void testAltaEvento() {
        assertNotNull(portal.altaEvento(evento));
    }

    @Test
    public void testBajaEvento() {
        assertNotNull(portal.bajaEvento(evento));
    }

    @Test
    public void testAltaOrganizador() {
        assertNotNull(portal.altaOrganizador(organizador));
    }

    @Test
    public void testBajaOrganizador() {
        assertNotNull(portal.bajaOrganizador(organizador));
    }

}
