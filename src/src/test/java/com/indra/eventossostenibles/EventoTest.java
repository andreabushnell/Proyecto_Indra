package com.indra.eventossostenibles;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;

public class EventoTest {
    public Evento evento;
    public Usuario usuario;
    public List<Usuario> listaAsistentes;

    @Before
    public void init() {
        evento = new Evento("nombre", 0, "categoria",
                new Organizador("nombre", "000000000", "email"),
                new Ubicacion("direccion", "tipo"),
                LocalDate.of(2023, 10, 1),
                LocalDateTime.of(2023, 10, 1, 10, 0), true);
        usuario = new Usuario("nombre", "email", "000000000");
    }

    @Test
    public void testSettersAndGetters() {
        evento.setNombre("nuevoNombre");
        assertTrue(evento.getNombre().equals("nuevoNombre"));

        evento.setDuracion(120);
        assertTrue(evento.getDuracion() == 120);

        evento.setCategoria("nuevaCategoria");
        assertTrue(evento.getCategoria().equals("nuevaCategoria"));

        Organizador nuevoOrganizador = new Organizador("otro", "111111111", "otro@email.com");
        evento.setOrganizador(nuevoOrganizador);
        assertTrue(evento.getOrganizador().equals(nuevoOrganizador));

        Ubicacion nuevaUbicacion = new Ubicacion("otraDireccion", "otroTipo");
        evento.setUbicacion(nuevaUbicacion);
        assertTrue(evento.getUbicacion().equals(nuevaUbicacion));

        LocalDate nuevaFecha = LocalDate.of(2024, 1, 1);
        evento.setFecha(nuevaFecha);
        assertTrue(evento.getFecha().equals(nuevaFecha));

        LocalDateTime nuevaHora = LocalDateTime.of(2024, 1, 1, 12, 0);
        evento.setHora(nuevaHora);
        assertTrue(evento.getHora().equals(nuevaHora));

        evento.setActivo(false);
        assertFalse(evento.isActivo());
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
        evento.inscribirParticipante(usuario);
        assertTrue(evento.inscribirParticipante(usuario) == null);
    }

    @Test
    public void testCancelacionEvento() {
        evento.setActivo(true);
        assertTrue(evento.cancelarEvento());
        evento.setActivo(false);
        assertFalse(evento.cancelarEvento());
    }

    @Test
    public void testCancelacionInscripcion() {
        evento.inscribirParticipante(usuario);
        assertTrue(evento.cancelarInscripcion(usuario));
        evento.cancelarInscripcion(usuario);
        assertFalse(evento.cancelarInscripcion(usuario));
    }

    @Test
    public void testToString() {
        String expected = "Evento [nombre=nombre, duracion=0, categoria=categoria, "
                + "organizador=Organizador [nombre=nombre, telefono=000000000, correo=email], "
                + "ubicacion=Ubicacion [direccion=direccion, tipo=tipo], "
                + "fecha=2023-10-01, hora=2023-10-01T10:00, activo=true, listaAsistentes=[]]";
        assertEquals(expected, evento.toString());
    }

    @Test
    public void testEqualsWithSameObject() {
        assertTrue(evento.equals(evento));
    }

    @Test
    public void testEqualsWithIdenticalObjects() {
        Evento e2 = new Evento("nombre", 0, "categoria",
                new Organizador("nombre", "000000000", "email"),
                new Ubicacion("direccion", "tipo"),
                LocalDate.of(2023, 10, 1),
                LocalDateTime.of(2023, 10, 1, 10, 0), true);
        assertTrue(evento.equals(e2));
        assertEquals(evento.hashCode(), e2.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithDifferentObjects() {
        Evento eventoWithDifferentName = new Evento("otroNombre", 0, "categoria",
                new Organizador("nombre", "000000000", "email"),
                new Ubicacion("direccion", "tipo"),
                LocalDate.of(2023, 10, 1),
                LocalDateTime.of(2023, 10, 1, 10, 0), true);
        Evento eventoWithDifferentCategory = new Evento("nombre", 0, "otraCategoria",
                new Organizador("nombre", "000000000", "email"),
                new Ubicacion("direccion", "tipo"),
                LocalDate.of(2023, 10, 1),
                LocalDateTime.of(2023, 10, 1, 10, 0), true);
        Evento eventoWithDifferentOrganizador = new Evento("nombre", 0, "categoria",
                new Organizador("otroNombre", "000000000", "email"),
                new Ubicacion("direccion", "tipo"),
                LocalDate.of(2023, 10, 1),
                LocalDateTime.of(2023, 10, 1, 10, 0), true);
        Evento eventoWithDifferentUbicacion = new Evento("nombre", 0, "categoria",
                new Organizador("nombre", "000000000", "email"),
                new Ubicacion("otraDireccion", "tipo"),
                LocalDate.of(2023, 10, 1),
                LocalDateTime.of(2023, 10, 1, 10, 0), true);
        Evento eventoWithDifferentDate = new Evento("nombre", 0, "categoria",
                new Organizador("nombre", "000000000", "email"),
                new Ubicacion("direccion", "tipo"),
                LocalDate.of(2022, 10, 1),
                LocalDateTime.of(2023, 10, 1, 10, 0), true);
        Evento eventoWithDifferentTime = new Evento("nombre", 0, "categoria",
                new Organizador("nombre", "000000000", "email"),
                new Ubicacion("direccion", "tipo"),
                LocalDate.of(2023, 10, 1),
                LocalDateTime.of(2023, 10, 1, 15, 0), true);
        Evento eventoInactive = new Evento("nombre", 0, "categoria",
                new Organizador("nombre", "000000000", "email"),
                new Ubicacion("direccion", "tipo"),
                LocalDate.of(2023, 10, 1),
                LocalDateTime.of(2023, 10, 1, 10, 0), false);

        assertFalse(evento.equals(eventoWithDifferentName));
        assertFalse(evento.equals(eventoWithDifferentCategory));
        assertFalse(evento.equals(eventoWithDifferentOrganizador));
        assertFalse(evento.equals(eventoWithDifferentUbicacion));
        assertFalse(evento.equals(eventoWithDifferentDate));
        assertFalse(evento.equals(eventoWithDifferentTime));
        assertFalse(evento.equals(eventoInactive));

        assertNotEquals(evento.hashCode(), eventoWithDifferentName.hashCode());
        assertNotEquals(evento.hashCode(), eventoWithDifferentCategory.hashCode());
        assertNotEquals(evento.hashCode(), eventoWithDifferentOrganizador.hashCode());
        assertNotEquals(evento.hashCode(), eventoWithDifferentUbicacion.hashCode());
        assertNotEquals(evento.hashCode(), eventoWithDifferentDate.hashCode());
        assertNotEquals(evento.hashCode(), eventoWithDifferentTime.hashCode());
        assertNotEquals(evento.hashCode(), eventoInactive.hashCode());
    }

    @Test
    public void testEqualsWithNullFields() {
        Evento eventoWithNullName = new Evento(null, 0, "categoria",
                new Organizador("nombre", "000000000", "email"),
                new Ubicacion("direccion", "tipo"),
                LocalDate.of(2023, 10, 1),
                LocalDateTime.of(2023, 10, 1, 10, 0), true);
        Evento eventoWithNullCategory = new Evento("nombre", 0, null,
                new Organizador("nombre", "000000000", "email"),
                new Ubicacion("direccion", "tipo"),
                LocalDate.of(2023, 10, 1),
                LocalDateTime.of(2023, 10, 1, 10, 0), true);
        Evento eventoWithNullOrganizador = new Evento("nombre", 0, "categoria",
                null,
                new Ubicacion("direccion", "tipo"),
                LocalDate.of(2023, 10, 1),
                LocalDateTime.of(2023, 10, 1, 10, 0), true);
        Evento eventoWithNullUbicacion = new Evento("nombre", 0, "categoria",
                new Organizador("nombre", "000000000", "email"),
                null,
                LocalDate.of(2023, 10, 1),
                LocalDateTime.of(2023, 10, 1, 10, 0), true);
        Evento eventoWithNullDate = new Evento("nombre", 0, "categoria",
                new Organizador("nombre", "000000000", "email"),
                new Ubicacion("direccion", "tipo"),
                null,
                LocalDateTime.of(2023, 10, 1, 10, 0), true);
        Evento eventoWithNullTime = new Evento("nombre", 0, "categoria",
                new Organizador("nombre", "000000000", "email"),
                new Ubicacion("direccion", "tipo"),
                LocalDate.of(2023, 10, 1),
                null,
                true);

        assertFalse(evento.equals(eventoWithNullName));
        assertFalse(evento.equals(eventoWithNullCategory));
        assertFalse(evento.equals(eventoWithNullOrganizador));
        assertFalse(evento.equals(eventoWithNullUbicacion));
        assertFalse(evento.equals(eventoWithNullDate));
        assertFalse(evento.equals(eventoWithNullTime));

        assertFalse(eventoWithNullName.equals(eventoWithNullCategory));
        assertFalse(eventoWithNullName.equals(eventoWithNullOrganizador));
        assertFalse(eventoWithNullName.equals(eventoWithNullUbicacion));
        assertFalse(eventoWithNullName.equals(eventoWithNullDate));
        assertFalse(eventoWithNullName.equals(eventoWithNullTime));

        assertFalse(eventoWithNullCategory.equals(eventoWithNullOrganizador));
        assertFalse(eventoWithNullCategory.equals(eventoWithNullUbicacion));
        assertFalse(eventoWithNullCategory.equals(eventoWithNullDate));
        assertFalse(eventoWithNullCategory.equals(eventoWithNullTime));

        assertFalse(eventoWithNullOrganizador.equals(eventoWithNullUbicacion));
        assertFalse(eventoWithNullOrganizador.equals(eventoWithNullDate));
        assertFalse(eventoWithNullOrganizador.equals(eventoWithNullTime));

        assertFalse(eventoWithNullUbicacion.equals(eventoWithNullDate));
        assertFalse(eventoWithNullUbicacion.equals(eventoWithNullTime));

        assertFalse(eventoWithNullDate.equals(eventoWithNullTime));

        assertNotEquals(evento.hashCode(), eventoWithNullName.hashCode());
        assertNotEquals(evento.hashCode(), eventoWithNullCategory.hashCode());
        assertNotEquals(evento.hashCode(), eventoWithNullOrganizador.hashCode());
        assertNotEquals(evento.hashCode(), eventoWithNullUbicacion.hashCode());
        assertNotEquals(evento.hashCode(), eventoWithNullDate.hashCode());
        assertNotEquals(evento.hashCode(), eventoWithNullTime.hashCode());

        assertNotEquals(eventoWithNullName.hashCode(), eventoWithNullCategory.hashCode());
        assertNotEquals(eventoWithNullName.hashCode(), eventoWithNullOrganizador.hashCode());
        assertNotEquals(eventoWithNullName.hashCode(), eventoWithNullUbicacion.hashCode());
        assertNotEquals(eventoWithNullName.hashCode(), eventoWithNullDate.hashCode());
        assertNotEquals(eventoWithNullName.hashCode(), eventoWithNullTime.hashCode());

        assertNotEquals(eventoWithNullCategory.hashCode(), eventoWithNullOrganizador.hashCode());
        assertNotEquals(eventoWithNullCategory.hashCode(), eventoWithNullUbicacion.hashCode());
        assertNotEquals(eventoWithNullCategory.hashCode(), eventoWithNullDate.hashCode());
        assertNotEquals(eventoWithNullCategory.hashCode(), eventoWithNullTime.hashCode());

        assertNotEquals(eventoWithNullOrganizador.hashCode(), eventoWithNullUbicacion.hashCode());
        assertNotEquals(eventoWithNullOrganizador.hashCode(), eventoWithNullDate.hashCode());
        assertNotEquals(eventoWithNullOrganizador.hashCode(), eventoWithNullTime.hashCode());

        assertNotEquals(eventoWithNullUbicacion.hashCode(), eventoWithNullDate.hashCode());
        assertNotEquals(eventoWithNullUbicacion.hashCode(), eventoWithNullTime.hashCode());

        assertNotEquals(eventoWithNullDate.hashCode(), eventoWithNullTime.hashCode());

    }
}
