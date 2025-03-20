package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import java.util.InputMismatchException;
import java.util.Scanner;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import ymcris.ipc1.proyecto1.treasurehunter.batalla.Batalla;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;

/**
 * Clase encargada de crear casillas del tipo enemigos las cuales harán que se
 * inicie una pele y se determinen las consecuencias en el mapa.
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaEnemigos extends Casillas {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int opcion;
    private int tipoDePuntos;
    private int filaARetornar;
    private int puntosAQuitar;
    private int columnaARetornar;
    private boolean puedeEscapar;
    private boolean pierdeEnergia;

    // INSTANCIAS --------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);

    public CasillaEnemigos(int cantidad, boolean puedeEscapar, boolean pierdeEnergia, int filaARetornar, int columnaARetornar, int puntosAQuitar, int tipoDePuntos) {
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.puedeEscapar = puedeEscapar;
        this.puntosAQuitar = puntosAQuitar;
        this.simbolo = CYAN + "██" + RESETEAR;
        this.filaARetornar = filaARetornar;
        this.tipoDePuntos = tipoDePuntos;//1. Vida 2. Mana 3. Ataque 4. Defensa
        this.columnaARetornar = columnaARetornar;
    }

    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        Batalla batalla = new Batalla(aventurero, pierdeEnergia, puedeEscapar, tipoDePuntos, puntosAQuitar);
        batalla.pelear();
        if (aventurero.getVida() < 0) {
            if (pierdeEnergia == false) {
                aventurero.setPosicionInicial(1, 1);
                aventurero.setPosicionInicial(1, 1);
                System.out.println("Oh no aventurero " + aventurero.getNombre() + " Al perder la batalla has caido a la posición " + filaARetornar + "," + columnaARetornar + " del mapa");
            }
        }
    }

    @Override
    public void mostrarMensaje() {
        System.out.println("\n".repeat(100));
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero" + aventurero.getNombre() + " haz pisado una casilla de enemigos" + CYAN + " ------------------------- " + RESETEAR);
        System.out.println(CYAN + "                      ------------------------- " + RESETEAR + "¿Deseas escapar o pelear? [1] escapar, [2] pelear" + CYAN + " ------------------------- " + RESETEAR);
        try {
            opcion = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Debes ingresar un número");
            mostrarMensaje();
        }
        if (opcion == 1 && puedeEscapar) {
            System.out.println("Aventurero " + aventurero.getNombre() + " has escapado de la batalla");
        } else if (opcion == 2) {
            aplicarEfecto(aventurero);
        } else {
            mostrarMensaje();
        }
    }

    protected Casillas modificarCasillas(int filaNueva, int columnaNueva, int tipoDePuntos, int filaARetornar, int puntosAQuitar, int columnaARetornar) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        this.tipoDePuntos = tipoDePuntos;
        this.filaARetornar = filaARetornar;
        this.puntosAQuitar = puntosAQuitar;
        this.columnaARetornar = columnaARetornar;
        return this;
    }

}
