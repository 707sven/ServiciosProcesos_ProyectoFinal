/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.smartocupation.ragnarock;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marta
 */
public class Ragnarock {

    // Inicialización de variables
    int aforoMaximo = 10; // Límite de personas permitidas en el club
    int aforoActual = 0; // Inicialmente no hay personas en el club

    // Registro de actividades
    private List<String> registroActividades = new ArrayList<>();

    // Método para imprimir el registro de actividades
    public void imprimirRegistroActividades() {
        System.out.println("Registro de Actividades:");
        for (String actividad : registroActividades) {
            System.out.println(actividad);
        }
    }

    public static void main(String[] args) {
        // Creación de instancias de Portero y arranque de hilos
        Ragnarock club = new Ragnarock();  // Instancia del club

        Portero portero1 = new Portero("Portero1", club);
        Portero portero2 = new Portero("Portero2", club);

        portero1.start();
        portero2.start();

        // Simulación de acciones de entrada y salida desde el main
        club.ingresarCliente();
        club.salirCliente();

        // Esperar a que los porteros finalicen antes de continuar
        try {
            portero1.join();
            portero2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimir el registro de actividades
        club.imprimirRegistroActividades();
    }

    // Método para la entrada de un cliente
    public synchronized void ingresarCliente() {
        if (aforoActual < aforoMaximo) {
            aforoActual++;
            String actividad = "Cliente ingresó. Aforo actual: " + aforoActual;
            registroActividades.add(actividad);
            System.out.println(actividad);
        } else {
            System.out.println("Aforo completo. No se permite la entrada.");
        }
    }

    // Método para la salida de un cliente
    public synchronized void salirCliente() {
        if (aforoActual > 0) {
            aforoActual--;
            String actividad = "Cliente salió. Aforo actual: " + aforoActual;
            registroActividades.add(actividad);
            System.out.println(actividad);
        } else {
            System.out.println("No hay clientes dentro del club.");
        }
    }
}
