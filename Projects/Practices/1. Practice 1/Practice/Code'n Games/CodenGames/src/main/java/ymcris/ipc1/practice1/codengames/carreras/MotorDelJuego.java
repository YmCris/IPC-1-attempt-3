package ymcris.ipc1.practice1.codengames.carreras;

import java.util.Scanner;

/**
 * Clase encargada de hacer que el juego funciones, con métodos que mueven a los
 * vehículos, definen ganador, etc.
 *
 * @since Feb 12, 2025
 * @author YmCris
 */
public class MotorDelJuego {

    // VARIABLES ---------------------------------------------------------------
    public int numeroDeDados;
    protected static int cantidadDeRivales;

    // INSTANCIAS --------------------------------------------------------------
    Dados dados = new Dados();
    Scanner scanner = new Scanner(System.in);

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encarado de ser el motor del juego cuando se juegue con una
     * computadora.
     *
     * @param numeroDeJugadores - Numero de vehículos que se van a enfrentar
     * contra el jugador.
     */
    private void echarPuntaComputadora(int numeroDeJugadores) {
        do {
            System.out.println("¿Con cuántos dados desea Jugar?");
            System.out.println("El dado debe ser mayor a uno");
            numeroDeDados = scanner.nextInt();
        } while (numeroDeDados <= 1);
        Pista pistaActual = new Pista(numeroDeJugadores);
        pistaActual.elegirPista();
        do {
            int desicion;
            pistaActual.mostrarPista();
            System.out.println("Selecciona tu acción:");
            System.out.println("1. Tirar los dados");
            System.out.println("2. Terminar programa");
            System.out.println("3. Regresar al menú de carreras");
            desicion = scanner.nextInt();
            switch (desicion) {
                case 1 -> {
                    int resultadoDadosJugador = dados.lanzarDados(numeroDeDados);
                    pistaActual.moverVehiculoJugador(resultadoDadosJugador);
                    if (pistaActual.getTamañoPista() != pistaActual.getPosicionJugador1()) {
                        pistaActual.moverVehiculosAleatorios(dados.lanzarDadosVehículos(numeroDeDados));
                    }
                }
                case 2 ->
                    System.exit(0);
                case 3 ->
                    new Carreras().irAlMenuPrincipal();
                default -> {
                    System.out.println("Ingresa una opción válida");
                }
            }
        } while (pistaActual.verificarJuegoTerminado() == false);
        Carreras carreras = new Carreras();
        carreras.finalizarPartida();
    }

    /**
     * Método encargado de realizar el juego pero con un rival
     */
    private void echarPuntaRival() {
        System.out.println("¿Con cuántos dados desea Jugar?");
        numeroDeDados = scanner.nextInt();
        scanner.nextLine();
        if (numeroDeDados <= 0) {
            System.out.println("El dado debe ser mayor a uno, se jugará con 2 dados");
            numeroDeDados = 2;
        }
        Pista pistaActual = new Pista(2);
        pistaActual.elegirPista();
        do {
            int desicion;
            pistaActual.mostrarPista();
            System.out.println("Selecciona tu acción:");
            System.out.println("1. Tirar los dados");
            System.out.println("2. Terminar programa");
            System.out.println("3. Regresar al menú de carreras");
            desicion = scanner.nextInt();
            System.out.println("\n".repeat(100));
            switch (desicion) {
                case 1 -> {
                    int resultadoDadosJugador1 = dados.lanzarDados(numeroDeDados);
                    pistaActual.moverVehiculoJugador(resultadoDadosJugador1);
                }
                case 2 ->
                    System.exit(0);
                case 3 ->
                    new Carreras().irAlMenuPrincipal();
                default -> {
                    System.out.println("Ingresa una opción válida");
                }
            }
        } while (pistaActual.verificarJuegoTerminado() == false);
        new Carreras().finalizarPartida();
    }

    /**
     * Método encargado de pedir los datos necesarios para jugar contra una
     * computadora.
     */
    protected void jugarContraComputadora() {
        System.out.println("Ingrese su nombre: ");
        Carreras.jugadorUno = scanner.nextLine();
        System.out.println("¿Contra cuántos vehículos desea competir?");
        cantidadDeRivales = scanner.nextInt();
        echarPuntaComputadora(cantidadDeRivales);
    }

    /**
     * Método encargado de pedir el nombre de los jugadores
     */
    protected void jugarContraRival() {
        System.out.println("Ingrese el nombre del primer jugador: ");
        Carreras.jugadorUno = scanner.nextLine();
        System.out.println("Ingrese el nombre del segundo jugador: ");
        Carreras.jugadorDos = scanner.nextLine();
        cantidadDeRivales = 1;
        echarPuntaRival();
    }

}
