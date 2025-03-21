package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.mapas.Mapas.tablero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.mapas.Mapas.casillaTesoro;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.AMARILLO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.mapas.Mapas.casillaAventurero;

/**
 * Clase encargada de crear casillas del tipo pista la cual da información
 * acerca del paradero del tesoro.
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaPista extends Casillas {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int cantidadPistasPartida;
    private boolean pistaEsDireccional;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public CasillaPista(int cantidad, boolean pistaEsDireccional) {
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.simbolo = AMARILLO + "▒▒" + RESETEAR;
        this.pistaEsDireccional = pistaEsDireccional;
    }

    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        //1. Determinamos nuestro marco de referencia en base a la posición del jugador.
        int filaTesoro = casillaTesoro.getFila();
        int columnaTesoro = casillaTesoro.getColumna();
        int filaAventurero = casillaAventurero.getFila();
        int columnaAventurero = casillaAventurero.getColumna();
        if (pistaEsDireccional) {//pista es direccional, norte, sur, etc
            //2. Verificamos si la pista no está en una dirección directa (norte, sur, este, oeste)
            if (columnaTesoro == columnaAventurero && filaTesoro < filaAventurero) {//Esta en el norte//Norte: Son las filas menores a la de la posición del jugador en la columna del jugador)
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el norte" + CYAN + " ------------------------- " + RESETEAR);
            } else if (columnaTesoro == columnaAventurero && filaTesoro > filaAventurero) {//Esta en el sur//Sur: Son las filas mayores a la posición del jugador en la columna del jugador
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el sur" + CYAN + " ------------------------- " + RESETEAR);
            } else if (filaTesoro == filaAventurero && columnaTesoro < columnaAventurero) {//Está en el oeste //Oeste: Son las columnas menores a la de la posición del jugador en la fila del jugador
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el oeste" + CYAN + " ------------------------- " + RESETEAR);
            } else if (filaTesoro == filaAventurero && columnaTesoro > columnaAventurero) {//Está en el este //Este: Son las columnas mayores a la de la posición del jugador en fila del jugador.
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el este" + CYAN + " ------------------------- " + RESETEAR);
            }
            //3. Verificamos si la pista esta entre dos direcciones directas
            if (columnaTesoro < columnaAventurero && filaTesoro < filaAventurero) {//Está en el noroeste //Noroeste: se encuentra entre el norte y el oeste
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el noroeste" + CYAN + " ------------------------- " + RESETEAR);
            } else if (columnaTesoro > columnaAventurero && filaTesoro < filaAventurero) {//Está en el noreste //Noreste: se encuentra entre el norte y el este
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el noreste" + CYAN + " ------------------------- " + RESETEAR);
            } else if (columnaTesoro < columnaAventurero && filaTesoro > filaAventurero) {//Está en el suroesete////Suroeste: se encuentra entre el sur y el oeste
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el suroeste" + CYAN + " ------------------------- " + RESETEAR);
            } else if (columnaAventurero < columnaTesoro && filaAventurero < filaTesoro) {//Está en el sureste//Sureste: se encuentra entre el sur y el este
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el sureste" + CYAN + " ------------------------- " + RESETEAR);
            }
        } else if (!pistaEsDireccional) {// pista es de cerca, lejos, etc
            int tamañoMapa = tablero.length;
            int tamañoMuyLejano = (int) tamañoMapa / 4;
            int tamañoLejano = (int) tamañoMapa / 8;
            int tamañoMediano = (int) tamañoMapa / 16;
            int tamañoCercano = (int) tamañoMapa / 32;
            int tamañoMuyCercano = (int) tamañoMapa / 64;
            if (filaTesoro * columnaTesoro <= tamañoMuyCercano) {//Muy cerca
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace muy cerca" + CYAN + " ------------------------- " + RESETEAR);
            } else if (filaTesoro * columnaTesoro <= tamañoCercano) {//cerca
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace cerca" + CYAN + " ------------------------- " + RESETEAR);
            } else if (filaTesoro * columnaTesoro <= tamañoMediano) {//Meidano
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace a una media distancia" + CYAN + " ------------------------- " + RESETEAR);
            } else if (filaTesoro * columnaTesoro <= tamañoLejano) {// Lejos
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace lejos" + CYAN + " ------------------------- " + RESETEAR);
            } else if (filaTesoro * columnaTesoro <= tamañoMuyLejano) {//MUY LEJOS
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace muy lejos" + CYAN + " ------------------------- " + RESETEAR);
            } else if (filaTesoro * columnaTesoro > tamañoMuyLejano) {//SUPEEER LEJOS
                System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace Supeeeer lejos" + CYAN + " ------------------------- " + RESETEAR);
            }
        }
        cantidadPistasPartida++;
    }

    @Override
    public void mostrarMensaje() {
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " te haz topado con una casilla pista" + CYAN + " ------------------------- " + RESETEAR);
        aplicarEfecto(aventurero);
    }

    protected Casillas modificarCasillas(int filaNueva, int columnaNueva, boolean pistaEsDireccional) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        this.pistaEsDireccional = pistaEsDireccional;
        return this;
    }

}
