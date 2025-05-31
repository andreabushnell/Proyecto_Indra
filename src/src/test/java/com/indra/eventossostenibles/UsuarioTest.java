package com.indra.eventossostenibles;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UsuarioTest {
    @Test
    public void testCreacionUsuario() {
        Usuario usuario = new Usuario("nombre", "email", "000000000");
        assertNotNull(usuario);
        assertNotNull(usuario.getNombre());
        assertNotNull(usuario.getCorreo());
        assertNotNull(usuario.getTelefono());
    }
}
