package com.indra.eventossostenibles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testGettersAndSetters() {
        Usuario usuario = new Usuario("Juan", "juan@email.com", "123456789");
        usuario.setNombre("Pedro");
        usuario.setCorreo("pedro@email.com");
        usuario.setTelefono("987654321");

        assertNotNull(usuario.getNombre());
        assertNotNull(usuario.getCorreo());
        assertNotNull(usuario.getTelefono());
    }

    @Test
    public void testToString() {
        Usuario usuario = new Usuario("Ana", "ana@email.com", "111222333");
        String expected = "Usuario [nombre=Ana, correo=ana@email.com, telefono=111222333]";
        assertEquals(expected, usuario.toString());
    }

    @Test
    public void testEqualsWithSameObject() {
        Usuario u1 = new Usuario("Ana", "ana@email.com", "123456789");
        assertTrue(u1.equals(u1));
    }

    @Test
    public void testEqualsWithIdenticalObjects() {
        Usuario u1 = new Usuario("Ana", "ana@email.com", "123456789");
        Usuario u2 = new Usuario("Ana", "ana@email.com", "123456789");
        assertTrue(u1.equals(u2));
        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    public void testEqualsWithDifferentObjects() {
        Usuario u1 = new Usuario("Ana", "ana@email.com", "123456789");
        Usuario u2 = new Usuario("OtraAna", "ana@email.com", "123456789");
        Usuario u3 = new Usuario("Ana", "otra@email.com", "123456789");
        Usuario u4 = new Usuario("Ana", "ana@email.com", "987654321");

        assertFalse(u1.equals(u2));
        assertFalse(u1.equals(u3));
        assertFalse(u1.equals(u4));

        assertNotEquals(u1.hashCode(), u2.hashCode());
        assertNotEquals(u1.hashCode(), u3.hashCode());
        assertNotEquals(u1.hashCode(), u4.hashCode());
    }

    @Test
    public void testEqualsWithNullFields() {
        Usuario u1 = new Usuario("Ana", "ana@email.com", "123456789");
        Usuario u2 = new Usuario("Ana", null, "123456789");
        Usuario u3 = new Usuario(null, "ana@email.com", "123456789");
        Usuario u4 = new Usuario("Ana", "ana@email.com", null);
        Usuario u5 = new Usuario(null, null, "123456789");
        Usuario u6 = new Usuario(null, "ana@email.com", null);
        Usuario u7 = new Usuario("Ana", null, null);
        Usuario u8 = new Usuario(null, null, null);

        assertFalse(u1.equals(u2));
        assertFalse(u1.equals(u3));
        assertFalse(u1.equals(u4));
        assertFalse(u1.equals(u5));
        assertFalse(u1.equals(u6));
        assertFalse(u1.equals(u7));
        assertFalse(u1.equals(u8));

        assertFalse(u2.equals(u3));
        assertFalse(u2.equals(u4));
        assertFalse(u2.equals(u5));
        assertFalse(u2.equals(u6));
        assertFalse(u2.equals(u7));
        assertFalse(u2.equals(u8));

        assertFalse(u3.equals(u4));
        assertFalse(u3.equals(u5));
        assertFalse(u3.equals(u6));
        assertFalse(u3.equals(u7));
        assertFalse(u3.equals(u8));

        assertFalse(u4.equals(u5));
        assertFalse(u4.equals(u6));
        assertFalse(u4.equals(u7));
        assertFalse(u4.equals(u8));

        assertFalse(u5.equals(u6));
        assertFalse(u5.equals(u7));
        assertFalse(u5.equals(u8));

        assertFalse(u6.equals(u7));
        assertFalse(u6.equals(u8));

        assertFalse(u7.equals(u8));

        assertNotEquals(u1.hashCode(), u2.hashCode());
        assertNotEquals(u1.hashCode(), u3.hashCode());
        assertNotEquals(u1.hashCode(), u4.hashCode());
        assertNotEquals(u1.hashCode(), u5.hashCode());
        assertNotEquals(u1.hashCode(), u6.hashCode());
        assertNotEquals(u1.hashCode(), u7.hashCode());
        assertNotEquals(u1.hashCode(), u8.hashCode());

        assertNotEquals(u2.hashCode(), u3.hashCode());
        assertNotEquals(u2.hashCode(), u4.hashCode());
        assertNotEquals(u2.hashCode(), u5.hashCode());
        assertNotEquals(u2.hashCode(), u6.hashCode());
        assertNotEquals(u2.hashCode(), u7.hashCode());
        assertNotEquals(u2.hashCode(), u8.hashCode());

        assertNotEquals(u3.hashCode(), u4.hashCode());
        assertNotEquals(u3.hashCode(), u5.hashCode());
        assertNotEquals(u3.hashCode(), u6.hashCode());
        assertNotEquals(u3.hashCode(), u7.hashCode());
        assertNotEquals(u3.hashCode(), u8.hashCode());

        assertNotEquals(u4.hashCode(), u5.hashCode());
        assertNotEquals(u4.hashCode(), u6.hashCode());
        assertNotEquals(u4.hashCode(), u7.hashCode());
        assertNotEquals(u4.hashCode(), u8.hashCode());

        assertNotEquals(u5.hashCode(), u6.hashCode());
        assertNotEquals(u5.hashCode(), u7.hashCode());
        assertNotEquals(u5.hashCode(), u8.hashCode());

        assertNotEquals(u6.hashCode(), u7.hashCode());
        assertNotEquals(u6.hashCode(), u8.hashCode());

        assertNotEquals(u7.hashCode(), u8.hashCode());

        assertEquals(u8.hashCode(), new Usuario(null, null, null).hashCode());

    }

    @Test
    public void testEqualsWithDifferentClass() {
        Usuario u1 = new Usuario("Ana", "ana@email.com", "123456789");
        assertFalse(u1.equals(new Object()));
    }
}
