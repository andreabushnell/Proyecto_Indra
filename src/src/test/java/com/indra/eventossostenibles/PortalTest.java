package com.indra.eventossostenibles;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

public class PortalTest {
    public Portal portal;
    public List<Usuario> listaUsuarios;
    public List<Evento> listaEventos;
    public List<Organizador> listaOrganizadores;
    public Evento evento;
    public Usuario usuario;
    public Organizador organizador;
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
        portal.altaUsuario(usuario);
        assertTrue(portal.bajaUsuario(usuario));
        portal.bajaUsuario(usuario); 
        assertFalse(portal.bajaUsuario(usuario)); 
    }

    @Test
    public void testAltaEvento() {
        assertNotNull(portal.altaEvento(evento));
    }

    @Test
    public void testBajaEvento() {
        portal.altaEvento(evento);
        assertTrue(portal.bajaEvento(evento));
    }

    @Test
    public void testAltaOrganizador() {
        assertNotNull(portal.altaOrganizador(organizador));
    }

    @Test
    public void testBajaOrganizador() {
        portal.altaOrganizador(organizador);
        assertTrue(portal.bajaOrganizador(organizador));
    }

}
