package ymcris.ipc1.practice1.codengames.carreras;

import java.util.Random;
import static ymcris.ipc1.practice1.codengames.CodenGames.AZUL;
import static ymcris.ipc1.practice1.codengames.CodenGames.RESETEAR_COLOR;
import static ymcris.ipc1.practice1.codengames.CodenGames.scanner;

/**
 * Clase encargada de Generar la pista, mostrarla y modificarla
 *
 * @Date Feb 9, 2025
 * @author YmCris
 */
public class Pista {

    //VARIABLES-----------------------------------------------------------------
    private char jugador1;
    private char jugador2;
    private int numeroDeVehiculos;
    private int posicionJugador1;
    private int posicionJugador2;
    private int[] posicionesVehiculos;
    private static char[] vehiculos;
    private static char[][] pista;//static porque pertenece a la clase, no a una posible instancia.
    private final char trap;
    private final char booster;
    private final int longitudPistaCorta;
    private final int longitudPistaMedia;
    private final int longitudPistaLarga;
    private final int[] longitudesPistas;

    //OBJETOS-------------------------------------------------------------------
    Random random = new Random();
    MotorDelJuego motor = new MotorDelJuego();

    //MÉTODOS CONSTRUCTORES ----------------------------------------------------
    public Pista(int numeroDeJugadores) {
        this.trap = 'T';
        this.booster = 'B';
        this.posicionJugador1 = 0;
        this.posicionJugador2 = 0;
        this.longitudPistaCorta = 75;
        this.longitudPistaMedia = 100;
        this.longitudPistaLarga = 150;
        this.numeroDeVehiculos = numeroDeJugadores;
        Pista.vehiculos = new char[numeroDeJugadores];
        this.posicionesVehiculos = new int[numeroDeJugadores + 1];
        this.longitudesPistas = new int[]{longitudPistaCorta, longitudPistaMedia, longitudPistaLarga};
    }

    public Pista() {
        this.trap = 'T';
        this.booster = 'B';
        this.posicionJugador1 = 0;
        this.posicionJugador2 = 0;
        this.longitudPistaCorta = 75;
        this.longitudPistaMedia = 100;
        this.longitudPistaLarga = 150;
        this.longitudesPistas = new int[]{longitudPistaCorta, longitudPistaMedia, longitudPistaLarga};
    }

    //MÉTODOS-------------------------------------------------------------------
    private void crearPista(int filas, int columnas) {//longitud = columnas
        pista = new char[filas + 1][columnas];
        for (char[] pista1 : pista) {//RELLENA LA PISTA CON '_'
            for (int j = 0; j < pista1.length; j++) {
                pista1[j] = '_';
            }
        }
        agregarVehiculos();
    }

    private void mostrarPista() {
        añadirBoostersOTraps();
        System.out.println(AZUL + "PISTA:" + RESETEAR_COLOR);
        for (char[] pista1 : pista) {//i = filas
            for (int j = 0; j < pista1.length; j++) {//j = columnas
                System.out.print(pista1[j]);
            }
            System.out.println("|");
        }
    }

    protected void modificarPista(char modificacion, int fila, int columna) {
        for (char[] pista1 : pista) {
            for (int j = 0; j < pista1.length; j++) {
                if (fila < pista.length && columna < pista[0].length) {// Verifica que el tamaño de la fila y la columna sean los adecuados
                    if (pista[fila][columna] == '_') {//verifica que no hayan vehiculos, traps o boosters
                        pista[fila][columna] = modificacion;//implementa la modificación
                    }
                }
            }
        }
    }

    private void añadirBoostersOTraps() {
        boolean modificacionesActivadas;
        int limiteDeFilas = MotorDelJuego.cantidadDeRivales + 1;
        int limiteDeColumnas = pista[0].length;
        do {
            int numeroDeBoosters = random.nextInt(1, 7);//[1,6)
            int numeroDeTraps = random.nextInt(1, 7);//[1,6)
            for (char[] pista1 : pista) {
                for (int i = 0; i < numeroDeBoosters; i++) {//Implementa los boosters en la pista
                    modificarPista(booster, random.nextInt(0, limiteDeFilas), random.nextInt(0, limiteDeColumnas));//Fila [0,3] Columnas [0,150) con tres rivales
                }
                for (int i = 0; i < numeroDeTraps; i++) {//Implementa los traps
                    modificarPista(trap, random.nextInt(0, limiteDeFilas), random.nextInt(0, limiteDeColumnas));//Fila [0,2] Columnas [0,150)
                }
            }
            modificacionesActivadas = true;
        } while (modificacionesActivadas == false);
    }

    protected void elegirPista() {
        System.out.println("                                        ┌------------------------------------------------┐");
        System.out.println("                                        |             ¿QUÉ PISTA DESEA USAR?             |");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ¦ [1]        Pista corta ( 75 metros)            ¦");
        System.out.println("                                        ¦ [2]        Pista Media (100 metros)            ¦");
        System.out.println("                                        ¦ [3]        Pista Larga (150 metros)            ¦");
        System.out.println("                                        ¦ [4]              Crear Pista                   ¦");
        System.out.println("                                        ¦ [5]                Regresar                    ¦");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦            -Seleccione una opción-             ¦");
        System.out.println("                                        └------------------------------------------------┘");
        int opcionPista = scanner.nextInt();
        scanner.nextLine();
        switch (opcionPista) {
            case 1 -> {
                crearPista(MotorDelJuego.cantidadDeRivales, longitudesPistas[0]);
                mostrarPista();
            }
            case 2 -> {
                crearPista(MotorDelJuego.cantidadDeRivales, longitudesPistas[1]);
                mostrarPista();
            }
            case 3 -> {
                crearPista(MotorDelJuego.cantidadDeRivales, longitudesPistas[2]);
                mostrarPista();
            }
            case 4 -> {
                System.out.println("Ingrese los metros de la pista:");
                int longitudPista = Integer.parseInt(scanner.nextLine());
                if (longitudPista < 0 || longitudPista > 500) {
                    System.out.println("Debes crear una pista mayor a 50 metros y menor a 500");
                    elegirPista();
                } else {
                    crearPista(MotorDelJuego.cantidadDeRivales, longitudPista);
                }
            }
            case 5 -> {
                Carreras carrera = new Carreras();
                carrera.irAlMenuPrincipal();
            }
            default -> {
                System.out.println("Elige una pista adecuada.");
                elegirPista();
            }
        }
    }

    protected void agregarVehiculos() {
        if (Carreras.opcionMenu == 1) {//jugar contra computadora.
            jugador1 = Carreras.jugadorUno.charAt(0);//convierte la primera letra del nombre del jugador 1 en un char
            posicionJugador1 = 0;
            modificarPista(jugador1, 0, 0);//Coloca al jugador 1 en la pista
            for (int i = 1; i < numeroDeVehiculos + 1; i++) {
                char elementoAAgregar = Carreras.computadora[random.nextInt(0, 10)];
                pista[i][0] = elementoAAgregar;
                posicionesVehiculos[i] = 0;
                vehiculos[i - 1] = elementoAAgregar;
            }
        } else if (Carreras.opcionMenu == 2) {//jugar contra rival
            jugador1 = Carreras.jugadorUno.charAt(0);//convierte la primera letra del nombre del jugador 1 en un char
            jugador2 = Carreras.jugadorDos.charAt(0);//convierte la primera letra del nombre del jugador 2 en un char
            modificarPista(jugador1, 0, 0);//Coloca al jugador 1 en la pista
            modificarPista(jugador2, 1, 0);//Coloca al jugador 2 en la pista
            posicionJugador1 = 0;
            posicionJugador2 = 0;
        }
    }

    protected void moverVehiculoJugador(int resultadoDado) {
        if (Carreras.opcionMenu == 1) {//opcion 1 = jugar contra computadora
            pista[0][posicionJugador1] = 0;
            posicionJugador1 += resultadoDado;
            if (posicionJugador1 >= pista[0].length) {
                posicionJugador1 = pista[0].length - 1;
                System.out.println("El jugador 1 ha ganado");
            }
            pista[0][posicionJugador1] = jugador1;
        } else if (Carreras.opcionMenu == 2) {//opcion 2 jugar contra rival
            pista[0][posicionJugador1] = 0;
            posicionJugador1 += resultadoDado;
            if (posicionJugador1 >= pista[0].length) {
                posicionJugador1 = pista[0].length - 1;
                System.out.println("El jugador 1 ha ganado");
            }
            pista[0][posicionJugador1] = jugador1;
            pista[1][posicionJugador2] = 0;
            posicionJugador2 += resultadoDado;
            if (posicionJugador2 >= pista[0].length) {
                posicionJugador2 = pista[0].length - 1;
                System.out.println("El jugador 2 ha ganado");
            }
            pista[1][posicionJugador2] = jugador2;
        }
    }

    private void definirPosicionesInicialesVehiculos() {
        for (int i = 0; i < numeroDeVehiculos; i++) {
            this.posicionesVehiculos[i] = 0;
        }
    }

    protected void moverVehiculosAleatorios(int resultadoDados) {
        definirPosicionesInicialesVehiculos();
        for (int i = 1; i <= numeroDeVehiculos; i++) {
            pista[i][posicionesVehiculos[i]] = 0;
            int movimientoAleatorio = random.nextInt(resultadoDados) * 2;
            posicionesVehiculos[i] += movimientoAleatorio;
            if (posicionesVehiculos[i] >= pista[0].length) {
                posicionesVehiculos[i] = pista[0].length - 1;
                System.out.println("El vehículo " + (i + 1) + " llegó a la meta " + Carreras.jugadorUno + " perdió");
            }
            pista[i][posicionesVehiculos[i]] = vehiculos[i];
        }
    }

    protected boolean verificarJuegoTerminado() {
        for (int i = 0; i < pista.length; i++) {
            for (int j = 0; j < pista[i].length; j++) {
                if (posicionJugador1 == pista[0].length) { // POR SI GANA EL JUGADOR 1
                    System.out.println("El jugador " + Carreras.jugadorUno + " es el ganador.");
                    motor.setHumanoGanador(+1);
                    return true;
                }
                if (posicionJugador2 == pista[0].length) { //POR SI GANA EL JUGADOR 2
                    System.out.println("El jugador " + Carreras.jugadorDos + " es el ganador.");
                    motor.setHumanoGanador(+1);
                    return true;
                }
                if (getPosicionVehiculo(i) == pista[0].length) { // POR SI GANA UN VEHÍCULO
                    System.out.println("El vehículo " + i + " " + Carreras.computadora[i] + " es el ganador.");
                    motor.setComputadoraGanadora(+1);
                    return true;
                }
                if ((posicionJugador1 == pista[0].length && posicionJugador2 == pista[0].length)
                        || (posicionJugador1 == pista[0].length && getPosicionVehiculo(i) == pista[0].length)
                        || (posicionJugador2 == pista[0].length && getPosicionVehiculo(i) == pista[0].length)) { // POR SI HAY EMPATE
                    System.out.println("¡Es un empate!");
                    return true;
                }
            }
        }
        return false;
    }

    protected int getPosicionVehiculo(int indiceVehiculo) {
        if (indiceVehiculo == 0) {
            return posicionJugador1;
        } else {
            return posicionesVehiculos[indiceVehiculo];
        }
    }

}
