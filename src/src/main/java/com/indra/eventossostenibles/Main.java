package com.indra.eventossostenibles;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Organizador organizador = new Organizador("Xunta de Galicia", "900900900", "@xunta.gal");
        Ubicacion ubicacion = new Ubicacion("Bastiagueiro","Presencial");
        Usuario usuario = new Usuario("Juan Casals","juan.casals@gmail.com","625124010");
        Evento evento = new Evento("Limpieza de la playa de Bastiagueiro", 8, "Medio Ambiente",
        organizador, ubicacion, LocalDate.of(2025,12,05), LocalDateTime.of(2025,12,05,9,0));

        evento.inscribirParticipante(usuario);
        
        System.out.println("\n"+evento+"\n");
        System.out.println(usuario+"\n");

    }
}