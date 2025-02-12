package ymcris.ipc1.practice1.codengames.carreras;

import java.util.Random;
import static ymcris.ipc1.practice1.codengames.CodenGames.scanner;

/**
 * Clase encargada de Generar la pista, mostrarla y modificarla
 *
 * @Date Feb 9, 2025
 * @author YmCris
 */
public class Pista {

    //VARIABLES-----------------------------------------------------------------
    private int numeroDeJugadores;
    private static char[][] pista;//static porque pertenece a la clase, no a una posible instancia.
    private final char trap;
    private final char booster;
    private final int longitudPistaCorta;
    private final int longitudPistaMedia;
    private final int longitudPistaLarga;
    private final int[] longitudesPistas;

    //OBJETOS-------------------------------------------------------------------
    private Random random = new Random();

    //MÉTODO CONSTRUCTO---------------------------------------------------------
    /**
     * Método constructor encargado de inicializar los atributos necesraios.
     *
     * @param numeroDeJugadores - Representa las filas que va a tener la "pista"
     */
    public Pista(int numeroDeJugadores) {
        this.trap = 'T';
        this.booster = 'B';
        this.longitudPistaCorta = 75;
        this.longitudPistaMedia = 100;
        this.longitudPistaLarga = 150;
        this.numeroDeJugadores = numeroDeJugadores;
        this.longitudesPistas = new int[]{longitudPistaCorta, longitudPistaMedia, longitudPistaLarga};
    }

    //MÉTODOS-------------------------------------------------------------------
    /**
     * Método encargado de crear la pista.
     *
     * @param longitud - Tamaño/ longitud que va a tener la pista.
     */
    private void crearPista(int longitud) {
        pista = new char[numeroDeJugadores][longitud];
        for (char[] pista1 : pista) {//i = filas
            for (int j = 0; j < pista1.length; j++) {//j = columnas
                pista1[j] = '_';
            }
        }
    }

    /**
     * Método encargado de mostrar la pista.
     */
    private void mostrarPista() {
        añadirElementos();
        for (char[] pista1 : pista) {//i = filas
            for (int j = 0; j < pista1.length; j++) {//j = columnas
                System.out.print(pista1[j]);
            }
            System.out.println("|");
        }
    }

    /**
     * Método encargado de poder agregar elementos (boosters o traps) en la
     * pista.
     *
     * @param modificacion - simbolo del elemento.
     * @param fila - Posición en la fila de la pista.
     * @param columna - Posición en la columna de la pista
     */
    private void modificarPista(char modificacion, int fila, int columna) {
        for (char[] pista1 : pista) {
            for (int j = 0; j < pista1.length; j++) {
                if (fila < numeroDeJugadores && columna < pista[0].length) {// Verifica que el tamaño de la fila y la columna sean los adecuados
                    if (pista[fila][columna] == '_') {
                        pista[fila][columna] = modificacion;
                    }
                }
            }
        }
    }

    /**
     * Método encargado de determinar el número de boosters o traps que habrán
     * en la pista y su posición.
     */
    private void añadirElementos() {
        boolean modificacionesActivadas;
        do {
            int numeroDeBoosters = random.nextInt(1, 7);//[1,6)
            int numeroDeTraps = random.nextInt(1, 7);
            for (char[] pista1 : pista) {
                for (int i = 0; i < numeroDeBoosters; i++) {//Implementa los boosters en la pista
                    modificarPista(booster, random.nextInt(0, numeroDeJugadores), random.nextInt(0, pista[0].length));//ej Fila [0,2) Columnas [0,150)
                }
                for (int i = 0; i < numeroDeTraps; i++) {//Implementa los traps
                    modificarPista(trap, random.nextInt(0, numeroDeJugadores), random.nextInt(0, pista[0].length));//ej Fila [0,2) Columnas [0,150)
                }
            }
            modificacionesActivadas = true;
        } while (modificacionesActivadas == false);
    }

    /**
     * Método encargado de mostrar el menú de elegir pista
     */
    protected void elegirPista() {
        System.out.println("                                        ┌------------------------------------------------┐");
        System.out.println("                                        |             ¿QUÉ PISTA DESEA USAR?             |");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ¦ [1]        Pista corta ( 75 metros)            ¦");
        System.out.println("                                        ¦ [2]        Pista Media (100 metros)            ¦");
        System.out.println("                                        ¦ [3]        Pista Larga (150 metros)            ¦");
        System.out.println("                                        ¦ [4]              Crear Pista                   ¦");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦            -Seleccione una opción-             ¦");
        System.out.println("                                        └------------------------------------------------┘");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1 -> {
                crearPista(longitudesPistas[0]);
                mostrarPista();
            }
            case 2 -> {
                crearPista(longitudesPistas[1]);
                mostrarPista();
            }
            case 3 -> {
                crearPista(longitudesPistas[2]);
                mostrarPista();
            }
            case 4 -> {
                System.out.println("Ingrese los metros de la pista:");
                int longitudPista = Integer.parseInt(scanner.nextLine());
                if (longitudPista < 0 || longitudPista > 500) {
                    System.out.println("Debes crear una pista mayor a 50 metros y menor a 500");
                    elegirPista();
                } else {
                    crearPista(longitudPista);
                }
            }
            default -> {
                System.out.println("Elige una pista adecuada.");
                elegirPista();
            }
        }
    }

    //GETTERS & SETTERS---------------------------------------------------------
    public int getNumeroDeJugadores() {
        return numeroDeJugadores;
    }

    public void setNumeroDeJugadores(int numeroDeJugadores) {
        this.numeroDeJugadores = numeroDeJugadores;
    }

}
