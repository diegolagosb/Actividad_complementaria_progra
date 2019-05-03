package com.mycompany.actividad_complementaria_progra;

import java.util.Scanner;

/**
 *
 * @author Diego Lagos
 */
public class JuegoDeDados {

    public JuegoDeDados() {
    }

    public void Menu() {
        boolean salir = false;
        while (!salir) {
            try {
                mostrarOpcionesMenu();
                int opcion = leerEntero();
                if (opcion > 2 || opcion < 1) {
                    System.out.println("La opcion ingresada no es valida, intentelo nuevamente.");
                } else {
                    switch (opcion) {
                        case 1: {
                            comprobarGanador(sumarDados(lanzarDado1(crearDado()), lanzarDado2(crearDado())));
                            break;
                        }
                        case 2: {
                            salir = validarSalidaDelJuego();
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("Valor no esperado, intentelo nuevamente.");
            }
        }
    }

    private void mostrarOpcionesMenu() {
        System.out.println("Ingrese una opción: ");
        System.out.println("<1> Jugar");
        System.out.println("<2> Salir del juego");
    }

    private boolean validarSalidaDelJuego() {                //valida la segunda opcion de salir, si el usuario quiere detener el programa, o seguir usandolo (jugando).
        System.out.println("¿Desea salir del juego?");
        System.out.println("<1> Seguir jugando");
        System.out.println("<2> Salir");
        int opcion = leerEntero();
        return opcion == 2;
    }

    private int leerEntero() {                              //valida la opcion ingresada para el menu.
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private Dado crearDado() {                               //crea el objeto dado
        return new Dado();
    }

    private Dado lanzarDado1(Dado dado1) {
        int resultado = (int) (Math.random() * 6) + 1;      //crea al azar el valor que resultó al lanzar el primer dado (cara superior a la vista).
        dado1.setCara(resultado);
        System.out.println("El resultado del primer dado es: " + resultado);
        return dado1;
    }

    private Dado lanzarDado2(Dado dado2) {                   //crea al azar el valor que resultó al lanzar el segundo dado (cara superior a la vista).
        int resultado = (int) (Math.random() * 6) + 1;
        dado2.setCara(resultado);
        System.out.println("El resultado del segundo dado es: " + resultado);
        return dado2;
    }

    private int sumarDados(Dado dado1, Dado dado2) {         //calcula la suma de los resultados de los 2 lanzamientos.
        return dado1.getCara() + dado2.getCara();
    }

    private void comprobarGanador(int resultado) {           //comprueba si la suma de los resultados al lanzar los dados es el esperado para ser ganador del juego.
        if (resultado == 7) {
            System.out.println("Ganaste! La suma de los dados ha sido 7.");
        } else {
            System.out.println("Buen intento... sigue participando.");
        }

    }
}
