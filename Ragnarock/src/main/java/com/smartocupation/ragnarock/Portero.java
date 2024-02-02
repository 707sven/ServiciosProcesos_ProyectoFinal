/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartocupation.ragnarock;

/**
 *
 * @author marta
 */
public class Portero extends Thread {

    private String nombre;
    private Ragnarock club;

    public Portero(String nombre, Ragnarock club) {
        this.nombre = nombre;
        this.club = club;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            realizarAccion();
            pausaAleatoria();
        }
    }

    private void realizarAccion() {
        int decision = (int) (Math.random() * 2); // 0 para ingresar, 1 para salir

        if (decision == 0) {
            club.ingresarCliente();
            System.out.println("Portero " + nombre + " permitió la entrada.");
        } else {
            club.salirCliente();
            System.out.println("Portero " + nombre + " permitió la salida.");
        }

        pausaAleatoria(); // Agregamos una pausa entre acciones
    }

    private void pausaAleatoria() {
        try {
            // Simula una pausa aleatoria entre 1 y 5 segundos
            sleep((int) (Math.random() * 4000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
