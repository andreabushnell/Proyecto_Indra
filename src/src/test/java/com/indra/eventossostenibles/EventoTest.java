package com.indra.eventossostenibles;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Before;

public class EventoTest {
    Evento evento;
    Usuario usuario;
    @Before
    public void init() {
        evento = new Evento("nombre", 0, "categoria", 
                            new Organizador("nombre", "000000000","email"), 
                            new Ubicacion("direccion", "tipo"), 
                            LocalDate.of(2023, 10, 1), 
                            LocalDateTime.of(2023, 10, 1, 10, 0), true);
        usuario = new Usuario("nombre", "email", "000000000");
    }
    @Test
    public void testCreacionEvento() {
        assertNotNull(evento);
        assertNotNull(evento.getNombre());
        assertNotNull(evento.getDuracion());
        assertNotNull(evento.getCategoria());
        assertNotNull(evento.getOrganizador()); 
        assertNotNull(evento.getUbicacion());
        assertNotNull(evento.getFecha());
        assertNotNull(evento.getHora());
        assertNotNull(evento.isActivo());
        assertNotNull(evento.getListaAsistentes());
    }   
    @Test
    public void testInscripcionParticipante() {
        assertNotNull(evento.inscribirParticipante(usuario));
    }
    @Test
    public void testCancelacionEvento() {
        assertTrue(evento.cancelarEvento());
    }
    @Test
    public void testCancelacionInscripcion() {
        assertNotNull(evento.cancelarInscripcion(usuario));
    }
}
