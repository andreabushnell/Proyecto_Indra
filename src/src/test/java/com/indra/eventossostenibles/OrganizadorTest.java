package com.indra.eventossostenibles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrganizadorTest {

    @Test
    public void testGettersAndSetters() {
        Organizador organizador = new Organizador("nombre", "000000000", "correo");
        organizador.setNombre("nuevoNombre");
        organizador.setTelefono("123456789");
        organizador.setCorreo("nuevoCorreo");
        assertEquals("nuevoNombre", organizador.getNombre());
        assertEquals("123456789", organizador.getTelefono());
        assertEquals("nuevoCorreo", organizador.getCorreo());
    }

    @Test
    public void testToString() {
        Organizador organizador = new Organizador("nombre", "000000000", "correo");
        String expected = "Organizador [nombre=nombre, telefono=000000000, correo=correo]";
        assertEquals(expected, organizador.toString());
    }

    @Test
    public void testEqualsWithSameObject() {
        Organizador organizador = new Organizador("nombre", "000000000", "correo");
        assertTrue(organizador.equals(organizador));
    }

    @Test
    public void testEqualsWithIdenticalObjects() {
        Organizador o1 = new Organizador("nombre", "000000000", "correo");
        Organizador o2 = new Organizador("nombre", "000000000", "correo");
        assertTrue(o1.equals(o2));
        assertEquals(o1.hashCode(), o2.hashCode());
    }

    @Test
    public void testEqualsWithDifferentObjects() {
        Organizador o1 = new Organizador("nombre", "000000000", "correo");
        Organizador o2 = new Organizador("otroNombre", "111111111", "otroCorreo");
        Organizador o3 = new Organizador("nombre", "222222222", "correo");
        Organizador o4 = new Organizador("otroNombre", "000000000", "correo");

        assertFalse(o1.equals(o2));
        assertFalse(o1.equals(o3));
        assertFalse(o1.equals(o4));

        assertFalse(o2.equals(o3));
        assertFalse(o2.equals(o4));

        assertFalse(o3.equals(o4));

        assertNotEquals(o1.hashCode(), o2.hashCode());
        assertNotEquals(o1.hashCode(), o3.hashCode());
        assertNotEquals(o1.hashCode(), o4.hashCode());

        assertNotEquals(o2.hashCode(), o3.hashCode());
        assertNotEquals(o2.hashCode(), o4.hashCode());

        assertNotEquals(o3.hashCode(), o4.hashCode());

    }

    @Test
    public void testEqualsWithNullFields() {
        Organizador o1 = new Organizador("nombre", "000000000", "correo");
        Organizador o2 = new Organizador(null, "000000000", "correo");
        Organizador o3 = new Organizador("nombre", null, "correo");
        Organizador o4 = new Organizador("nombre", "000000000", null);
        Organizador o5 = new Organizador(null, null, "correo");
        Organizador o6 = new Organizador("nombre", null, null);
        Organizador o7 = new Organizador(null, "000000000", null);
        Organizador o8 = new Organizador(null, null, null);

        assertFalse(o1.equals(o2));
        assertFalse(o1.equals(o3));
        assertFalse(o1.equals(o4));
        assertFalse(o1.equals(o5));
        assertFalse(o1.equals(o6));
        assertFalse(o1.equals(o7));
        assertFalse(o1.equals(o8));

        assertFalse(o2.equals(o3));
        assertFalse(o2.equals(o4));
        assertFalse(o2.equals(o5));
        assertFalse(o2.equals(o6));
        assertFalse(o2.equals(o7));
        assertFalse(o2.equals(o8));

        assertFalse(o3.equals(o4));
        assertFalse(o3.equals(o5));
        assertFalse(o3.equals(o6));
        assertFalse(o3.equals(o7));
        assertFalse(o3.equals(o8));

        assertFalse(o4.equals(o5));
        assertFalse(o4.equals(o6));
        assertFalse(o4.equals(o7));
        assertFalse(o4.equals(o8));

        assertFalse(o5.equals(o6));
        assertFalse(o5.equals(o7));
        assertFalse(o5.equals(o8));

        assertFalse(o6.equals(o7));
        assertFalse(o6.equals(o8));

        assertFalse(o7.equals(o8));

        assertNotEquals(o1.hashCode(), o2.hashCode());
        assertNotEquals(o1.hashCode(), o3.hashCode());
        assertNotEquals(o1.hashCode(), o4.hashCode());
        assertNotEquals(o1.hashCode(), o5.hashCode());
        assertNotEquals(o1.hashCode(), o6.hashCode());
        assertNotEquals(o1.hashCode(), o7.hashCode());
        assertNotEquals(o1.hashCode(), o8.hashCode());

        assertNotEquals(o2.hashCode(), o3.hashCode());
        assertNotEquals(o2.hashCode(), o4.hashCode());
        assertNotEquals(o2.hashCode(), o5.hashCode());
        assertNotEquals(o2.hashCode(), o6.hashCode());
        assertNotEquals(o2.hashCode(), o7.hashCode());
        assertNotEquals(o2.hashCode(), o8.hashCode());

        assertNotEquals(o3.hashCode(), o4.hashCode());
        assertNotEquals(o3.hashCode(), o5.hashCode());
        assertNotEquals(o3.hashCode(), o6.hashCode());
        assertNotEquals(o3.hashCode(), o7.hashCode());
        assertNotEquals(o3.hashCode(), o8.hashCode());

        assertNotEquals(o4.hashCode(), o5.hashCode());
        assertNotEquals(o4.hashCode(), o6.hashCode());
        assertNotEquals(o4.hashCode(), o7.hashCode());
        assertNotEquals(o4.hashCode(), o8.hashCode());

        assertNotEquals(o5.hashCode(), o6.hashCode());
        assertNotEquals(o5.hashCode(), o7.hashCode());
        assertNotEquals(o5.hashCode(), o8.hashCode());

        assertNotEquals(o6.hashCode(), o7.hashCode());
        assertNotEquals(o6.hashCode(), o8.hashCode());

        assertNotEquals(o7.hashCode(), o8.hashCode());

        assertEquals(o8.hashCode(), new Organizador(null, null, null).hashCode());
    }

    @Test
    public void testEqualsWithDifferentClass() {
        Organizador o1 = new Organizador("nombre", "000000000", "correo");
        assertFalse(o1.equals(new Object()));
    }
}
