package com.indra.eventossostenibles;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class OrganizadorTest {
    @Test
    public void testCreacionOrganizador() {
        Organizador organizador = new Organizador("nombre", "000000000", "correo");
        assertNotNull(organizador);
        assertNotNull(organizador.getNombre());
        assertNotNull(organizador.getTelefono());
        assertNotNull(organizador.getCorreo());
    }
}
