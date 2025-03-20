package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.AMARILLO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;

/**
 * Clase encargada de crear casillas del tipo pista la cual da información
 * acerca del paradero del tesoro.
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaPista extends Casillas {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String pista;
    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int cantidadPistasPartida;
    private boolean pistaEsDireccional;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public CasillaPista( int cantidad, boolean pistaEsDireccional) {
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.simbolo = AMARILLO + "▒▒" + RESETEAR;
        this.pistaEsDireccional = pistaEsDireccional;
    }

    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        //Agrega la pista al archivo
        if (pistaEsDireccional) {//pista es direccional, norte, sur, etc
            //1. obtener la posición del jugador
            //2. obtener la posición del tesoro
            //3. restar las posiciones de fila y columna
            //4. Indicar la dirección del tesoro según el resultado.
            //5. agrega pista al archivo
        } else if (!pistaEsDireccional) {// pista es de cerca, lejos, etc
            //1. obtener la posición del jugador
            //2. obtener la posición del tesoro
            //3. restar las posiciones de fila y columna
            //4. Indicar la dirección del tesoro según el resultado y las dimensiones del mapa.
            //5. agrega pista al archivo
        }
        cantidadPistasPartida++;
    }

    @Override
    public void mostrarMensaje() {
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " +aventurero.getNombre() + " te haz topado con una casilla pista" + CYAN + " ------------------------- " + RESETEAR);
        aplicarEfecto(aventurero);
    }

    protected Casillas modificarCasillas(int filaNueva, int columnaNueva, boolean pistaEsDireccional) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        this.pistaEsDireccional = pistaEsDireccional;
        return this;
    }

}
