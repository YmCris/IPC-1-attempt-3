package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import java.util.Scanner;
import java.util.InputMismatchException;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.Mapas;
import ymcris.ipc1.proyecto1.treasurehunter.batalla.Batalla;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.exception.EntradaNoValidaException.errorEncontrado;

/**
 * ClaseEnemigos es una clase hija que es la Clase encargada de crear casillas
 * del tipo enemigos las cuales harán que se inicie una pele y se determinen las
 * consecuencias en el mapa.
 *
 * @author YmCris
 * @see Casillas
 * @since Mar 15, 2025
 */
public class CasillaEnemigos extends Casillas {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Mapas mapa;
    private CasillaPersonaje casillaAventurero;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int tipoDePuntos;
    private int filaARetornar;
    private int puntosAQuitar;
    private int columnaARetornar;
    private boolean seHaRendido;
    private boolean puedeEscapar;
    private boolean pierdePuntos;

    // INSTANCIAS --------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método encargado de inicializar las variables más importantes de la
     * casilla enemigos.
     *
     * @param cantidad - cantidad de casillas enemigos que habrá en el mapa.
     * @param puedeEscapar - Verifica si el jugador puede escapar de la batalla.
     * @param pierdePuntos - Define si pierde energía o retorna a un lugar.
     * @param filaARetornar - fila a donde retorna si pierde
     * @param columnaARetornar - columna a donde retorna si pierde
     * @param puntosAQuitar - Puntos a quitar si pierde una partida.
     * @param tipoDePuntos - Tipo de puntos ha quitar si pierde una partida.
     * @param casillaAventurero
     * @param mapa
     */
    public CasillaEnemigos(int cantidad, boolean puedeEscapar, boolean pierdePuntos, int filaARetornar, int columnaARetornar, int puntosAQuitar, int tipoDePuntos, CasillaPersonaje casillaAventurero, Mapas mapa) {
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.tipoDePuntos = tipoDePuntos;//1. Vida 2. Mana 3. Ataque 4. Defensa //default 1
        this.puedeEscapar = puedeEscapar;
        this.filaARetornar = filaARetornar;
        this.puntosAQuitar = puntosAQuitar;
        this.pierdePuntos = pierdePuntos;
        this.simbolo = CYAN + "██" + RESETEAR;
        this.columnaARetornar = columnaARetornar;
        this.mapa = mapa;
        this.casillaAventurero = casillaAventurero;
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        if (seHaRendido == false) {
            System.out.println("\n".repeat(100));
            Batalla batalla = new Batalla(aventurero, pierdePuntos, puedeEscapar, tipoDePuntos, puntosAQuitar);
            batalla.pelear();
            if (aventurero.getVida() <= 0) {
                if (pierdePuntos == false) {// Es decir, es reubicado.
                    casillaAventurero.modificarCasillas(filaARetornar, columnaARetornar);
                    mapa.modificarMapas(filaARetornar, columnaARetornar, casillaAventurero);
                    System.out.println("Oh no aventurero " + aventurero.getNombre() + " Al perder la batalla has caido a la posición " + filaARetornar + "," + columnaARetornar + " del mapa");
                }
            }
        }
    }

    @Override
    public void mostrarMensaje() {
        int opcionBatalla = 0;
        do {
            try {
                System.out.println("\n".repeat(100));
                System.out.println(CYAN + "                    ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " haz pisado una casilla de enemigos" + CYAN + " ------------------------- " + RESETEAR);
                System.out.println(CYAN + "                     ------------------------- " + RESETEAR + "¿Deseas escapar o pelear? [1] Escapar  [2] Pelear" + CYAN + " ------------------------- " + RESETEAR);
                opcionBatalla = scanner.nextInt();
                if (opcionBatalla == 1 && puedeEscapar == true) {
                    seHaRendido = true;
                    System.out.println("\n".repeat(9));
                    System.out.println("Aventurero " + aventurero.getNombre() + " has escapado de la batalla");
                    break;
                } else if (opcionBatalla == 1 && puedeEscapar == false) {
                    System.out.println("No puede huir de la batalla, debes pelear");
                    scanner.nextLine();
                    aplicarEfecto(aventurero);
                    break;
                } else if (opcionBatalla == 2) {
                    aplicarEfecto(aventurero);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un número");
                scanner.nextLine();
                errorEncontrado();
            }
        } while (opcionBatalla <= 0 || opcionBatalla >= 3);
    }

}
