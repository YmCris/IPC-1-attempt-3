package ymcris.ipc1.practice1.codengames.carreras;

import java.util.Scanner;
import static ymcris.ipc1.practice1.codengames.carreras.Carreras.jugadorDos;
import static ymcris.ipc1.practice1.codengames.carreras.Carreras.jugadorUno;
import static ymcris.ipc1.practice1.codengames.carreras.Carreras.opcionMenu;

/**
 * Clase encargada de hacer que el juego funciones, con métodos que mueven a los
 * vehículos, definen ganador, etc.
 *
 * @since Feb 12, 2025
 * @author YmCris
 */
public class MotorDelJuego {

    // VARIABLES ---------------------------------------------------------------
    public static int numeroDeDados;
    private String jugadorActual;
    private boolean juegoTerminado;
    protected static int cantidadDeRivales;

    // INSTANCIAS --------------------------------------------------------------
    Dados dados = new Dados();
    Scanner scanner = new Scanner(System.in);

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método encargado de inicializar las variables necesarias.
     */
    public MotorDelJuego() {
        this.juegoTerminado = false;
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encarado de ser el motor del juego cuando se juegue con una
     * computadora.
     *
     * @param numeroDeJugadores - Numero de vehículos que se van a enfrentar
     * contra el jugador.
     */
    protected void echarPuntaComputadora(int numeroDeJugadores) {
        System.out.println("¿Con cuántos dados desea Jugar?");
        numeroDeDados = scanner.nextInt();
        scanner.nextLine();
        Pista pistaActual = new Pista(numeroDeJugadores);
        pistaActual.elegirPista();
        do {
            informarJuego();
            elegirDesicion();
            pistaActual.elegirPista();
        } while (pistaActual.verificarJuegoTerminado() || juegoTerminado == true);
    }

    /**
     * Motor del juego cuando se jueguen 2 jugadores.
     */
    protected void echarPuntaRival() {
        do {

        } while (juegoTerminado == false);

    }

    /**
     * Método encargado de pedir los datos necesarios para jugar contra una
     * computadora.
     */
    protected void jugarContraComputadora() {
        scanner.nextLine();
        System.out.println("Ingrese su nombre: ");
        Carreras.jugadorUno = scanner.nextLine();
        System.out.println("¿Contra cuántos vehículos desea competir?");
        cantidadDeRivales = scanner.nextInt();
        echarPuntaComputadora(cantidadDeRivales);
    }

    /**
     * Método encargado de pedir el nombre 
     */
    protected void jugarContraRival() {
        Carreras carrera = new Carreras();
        cantidadDeRivales = 1;
        carrera.pedirNombres();
        echarPuntaRival();
    }

    private void elegirDesicion() {
        System.out.println("Selecciona tu opción:");
        System.out.println("1. Tirar los dados");
        System.out.println("2. Regresar al menú de carreras");
        int desicion = scanner.nextInt();
        switch (desicion) {
            case 1 -> {
                Pista pista = new Pista();
                pista.moverVehiculoJugador(dados.lanzarDados(numeroDeDados));
                pista.moverVehiculosAleatorios(dados.lanzarDados(numeroDeDados));
            }
            case 2 -> {
                Carreras carrera = new Carreras();
                carrera.irAlMenuPrincipal();
            }
            default ->
                elegirDesicion();
        }
    }

    private void informarJuego() {
        Pista pista = new Pista();
        if (opcionMenu == 1) {//computadora
            System.out.println("El vehículo de: " + jugadorUno + " " + jugadorUno.charAt(0) + " Ha recorrido " + pista.getPosicionVehiculo(0));
        } else if (opcionMenu == 2) {//rival
            System.out.println("El vehículo de: " + jugadorUno + " " + jugadorUno.charAt(0) + " Ha recorrido " + pista.getPosicionVehiculo(0));
            System.out.println("El vehículo de: " + jugadorDos + " " + jugadorDos.charAt(0) + " Ha recorrido " + pista.getPosicionVehiculo(1));
        }

    }

    // GETTERS -----------------------------------------------------------------
    public int getNumeroDeDados() {
        return numeroDeDados;
    }

    public String getJugadorActual() {
        return jugadorActual;
    }

    public static int getCantidadDeRivales() {
        return cantidadDeRivales;
    }

}
