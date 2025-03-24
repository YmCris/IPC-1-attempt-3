package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.AMARILLO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

/**
 * Clase encargada de crear casillas del tipo pista la cual da información
 * acerca del paradero del tesoro.
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaPista extends Casillas {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    public static String pista;
    public static String[] pistas;
    private CasillaTesoro casillaTesoro;
    private CasillaPersonaje casillaAventurero;
    private Casillas[][] tablero;
    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private static int contador;
    private int cantidadPistasPartida;
    private boolean pistaEsDireccional;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método encargado de crear casillas pista
     *
     * @param cantidad - cantidad de casillas pista durante una partida
     * @param pistaEsDireccional - true si lo es y false si es aproximada
     * @param casillaTesoro
     * @param casillaAventurero
     * @param tablero
     */
    public CasillaPista(int cantidad, boolean pistaEsDireccional, CasillaTesoro casillaTesoro, CasillaPersonaje casillaAventurero, Casillas[][] tablero) {
        CasillaPista.contador = 0;
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.simbolo = AMARILLO + "▒▒" + RESETEAR;
        this.pistaEsDireccional = pistaEsDireccional;
        this.casillaTesoro = casillaTesoro;
        this.casillaAventurero = casillaAventurero;
        CasillaPista.pistas = new String[90];
        this.tablero = tablero;
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        if (pistaEsDireccional) {//pista es direccional, norte, sur, etc
            calcularPistaDireccional();
        } else if (!pistaEsDireccional) {// pista es de aproximación cerca, lejos, etc
            calcularPistaAproximada();
        }
        cantidadPistasPartida++;
    }

    @Override
    public void mostrarMensaje() {
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " te haz topado con una casilla pista" + CYAN + " ------------------------- " + RESETEAR);
        aplicarEfecto(aventurero);
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    protected Casillas modificarCasillas(int filaNueva, int columnaNueva, boolean pistaEsDireccional) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        this.pistaEsDireccional = pistaEsDireccional;
        return this;
    }

    /**
     * Método encargado de calcular si la pista es direccional
     */
    private void calcularPistaDireccional() {
        //1. Determinamos nuestro marco de referencia en base a la posición del jugador.
        int filaTesoro = casillaTesoro.getFila();
        int columnaTesoro = casillaTesoro.getColumna();
        int filaAventurero = casillaAventurero.getFila();
        int columnaAventurero = casillaAventurero.getColumna();
        //2. Verificamos si la pista no está en una dirección directa (norte, sur, este, oeste)
        if (columnaTesoro == columnaAventurero && filaTesoro < filaAventurero) {//Esta en el norte//Norte: Son las filas menores a la de la posición del jugador en la columna del jugador)
            pista = CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el norte" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        } else if (columnaTesoro == columnaAventurero && filaTesoro > filaAventurero) {//Esta en el sur//Sur: Son las filas mayores a la posición del jugador en la columna del jugador
            pista = CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el sur" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        } else if (filaTesoro == filaAventurero && columnaTesoro < columnaAventurero) {//Está en el oeste //Oeste: Son las columnas menores a la de la posición del jugador en la fila del jugador
            pista = CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el oeste" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        } else if (filaTesoro == filaAventurero && columnaTesoro > columnaAventurero) {//Está en el este //Este: Son las columnas mayores a la de la posición del jugador en fila del jugador.
            pista = CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el este" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        }
        //3. Verificamos si la pista esta entre dos direcciones directas
        if (columnaTesoro < columnaAventurero && filaTesoro < filaAventurero) {//Está en el noroeste //Noroeste: se encuentra entre el norte y el oeste
            pista = CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el noroeste" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        } else if (columnaTesoro > columnaAventurero && filaTesoro < filaAventurero) {//Está en el noreste //Noreste: se encuentra entre el norte y el este
            pista = CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el noreste" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        } else if (columnaTesoro < columnaAventurero && filaTesoro > filaAventurero) {//Está en el suroesete////Suroeste: se encuentra entre el sur y el oeste
            pista = CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el suroeste" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        } else if (columnaAventurero < columnaTesoro && filaAventurero < filaTesoro) {//Está en el sureste//Sureste: se encuentra entre el sur y el este
            pista = CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace en el sureste" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        }

    }

    /**
     * Método encaragdo de calcular la pista si esta es aproximada
     */
    private void calcularPistaAproximada() {
        int filaTesoro = casillaTesoro.getFila();
        int columnaTesoro = casillaTesoro.getColumna();
        int filaAventurero = casillaAventurero.getFila();
        int columnaAventurero = casillaAventurero.getColumna();
        int tamañoMapa = tablero.length;
        int tamañoMuyLejano = tamañoMapa;
        int tamañoLejano = tamañoMapa / 2;
        int tamañoMediano = tamañoMapa / 3;
        int tamañoCercano = tamañoMapa / 5;
        int tamañoMuyCercano = tamañoMapa / 8;
        int distancia = Math.abs(filaTesoro - filaAventurero) + Math.abs(columnaTesoro - columnaAventurero);
        if (distancia <= tamañoMuyCercano) {//Muy cerca
            pista = CYAN + "                  ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace muy cerca" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        } else if (distancia <= tamañoCercano) {//Cerca
            pista = CYAN + "                   ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace cerca" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        } else if (distancia <= tamañoMediano) {//Media
            pista = CYAN + "           ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace a una media distancia" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        } else if (distancia <= tamañoLejano) {//Lejos
            pista = CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace lejos" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        } else if (distancia <= tamañoMuyLejano) {//Muy lejos
            pista = CYAN + "                 ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace muy lejos" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        } else {//Hasta la chingada
            pista = CYAN + "               ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " lo que buscas yace supeeeer lejos" + CYAN + " ------------------------- " + RESETEAR;
            pistas[contador] = pista;
            contador++;
            System.out.println(pista);
        }
    }

    // GETTERS -----------------------------------------------------------------
    public String getPista() {
        return pista;
    }

    public String[] getPistas() {
        return pistas;
    }

}
