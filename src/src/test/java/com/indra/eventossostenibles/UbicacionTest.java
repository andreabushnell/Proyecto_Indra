package com.indra.eventossostenibles;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class UbicacionTest {
    @Test
    public void testCreacionUbicacion() {
        Ubicacion ubicacion = new Ubicacion("direccion", "tipo");
        assertNotNull(ubicacion);
        assertNotNull(ubicacion.getDireccion());
        assertNotNull(ubicacion.getTipo());
    }
}
