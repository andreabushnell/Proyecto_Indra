package com.indra.eventossostenibles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UbicacionTest {
    @Test
    public void testCreacionUbicacion() {
        Ubicacion ubicacion = new Ubicacion("direccion", "tipo");
        assertNotNull(ubicacion);
        assertNotNull(ubicacion.getDireccion());
        assertNotNull(ubicacion.getTipo());
    }

    @Test
    public void testGettersAndSetters() {
        Ubicacion ubicacion = new Ubicacion("direccionInicial", "tipoInicial");
        ubicacion.setDireccion("nuevaDireccion");
        ubicacion.setTipo("nuevoTipo");
        assertEquals("nuevaDireccion", ubicacion.getDireccion());
        assertEquals("nuevoTipo", ubicacion.getTipo());
    }

    @Test
    public void testToString() {
        Ubicacion ubicacion = new Ubicacion("Calle 123", "Oficina");
        String expected = "Ubicacion [direccion=Calle 123, tipo=Oficina]";
        assertEquals(expected, ubicacion.toString());
    }

    @Test
    public void testEqualsWithSameObject() {
        Ubicacion u1 = new Ubicacion("Dir", "Tipo");
        assertTrue(u1.equals(u1));
    }

    @Test
    public void testEqualsWithIdenticalObjects() {
        Ubicacion u1 = new Ubicacion("Dir", "Tipo");
        Ubicacion u2 = new Ubicacion("Dir", "Tipo");
        assertTrue(u1.equals(u2));
        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    public void testEqualsWithDifferentObjects() {
        Ubicacion u1 = new Ubicacion("Dir", "Tipo");
        Ubicacion u2 = new Ubicacion("OtraDir", "Tipo");
        Ubicacion u3 = new Ubicacion("Dir", "OtroTipo");

        assertFalse(u1.equals(u2));
        assertFalse(u1.equals(u3));

        assertNotEquals(u1.hashCode(), u2.hashCode());
        assertNotEquals(u1.hashCode(), u3.hashCode());
    }

    @Test
    public void testEqualsWithNullFields() {
        Ubicacion u1 = new Ubicacion("Dir", "Tipo");
        Ubicacion u2 = new Ubicacion("Dir", null);
        Ubicacion u3 = new Ubicacion(null, "Tipo");
        Ubicacion u4 = new Ubicacion(null, null);

        assertFalse(u1.equals(u2));
        assertFalse(u1.equals(u3));
        assertFalse(u1.equals(u4));

        assertFalse(u2.equals(u3));

        assertFalse(u4.equals(u2));
        assertFalse(u4.equals(u3));

        assertNotEquals(u1.hashCode(), u2.hashCode());
        assertNotEquals(u1.hashCode(), u3.hashCode());
        assertNotEquals(u1.hashCode(), u4.hashCode());

        assertNotEquals(u2.hashCode(), u3.hashCode());

        assertNotEquals(u4.hashCode(), u1.hashCode());
        assertNotEquals(u4.hashCode(), u2.hashCode());
        assertNotEquals(u4.hashCode(), u3.hashCode());

        assertEquals(u4.hashCode(), new Ubicacion(null, null).hashCode());

    }

    @Test
    public void testEqualsWithDifferentClass() {
        Ubicacion u1 = new Ubicacion("Dir", "Tipo");
        assertNotNull(u1);
        assertFalse(u1.equals(null));
        assertFalse(u1.equals(new Object()));
    }
}
