package ymcris.ipc1.practica2.codengames.buscaminas.controllers;

import ymcris.ipc1.practica2.codengames.Controllers;
import ymcris.ipc1.practica2.codengames.buscaminas.backend.Buscaminas;
import ymcris.ipc1.practica2.codengames.buscaminas.frontend.JFBuscaminas;
import ymcris.ipc1.practica2.codengames.buscaminas.backend.casillas.CasillasNormales;
import static ymcris.ipc1.practica2.codengames.buscaminas.backend.Buscaminas.partidaTerminadaBuscaminas;

/**
 * Clase BuscaminasController Es la clase Controller que se encarga de
 *
 * @author YmCris
 * @see Buscaminas
 * @see Controllers
 * @see JFBuscaminas
 * @since Apr 3, 2025
 */
public class BuscaminasController extends Controllers {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String avatar;
    private Buscaminas buscaminas;
    private JFBuscaminas buscaminasFrame;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int opcionJuego;
    private int filasTablero;
    private int columnasTablero;
    private int cantidadDeMinas;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public BuscaminasController() {
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public boolean todoEnOrden(String avatar, int filas, int columnas, int minas) throws NumberFormatException {
        if (avatar.isBlank() || filas < 5 || columnas < 5 || minas < 1 || minas > filas * columnas) {
            return false;
        } else {
            this.avatar = avatar;
            this.filasTablero = filas;
            this.columnasTablero = columnas;
            this.cantidadDeMinas = minas;
            iniciarJuego();
            return true;
        }
    }

    @Override
    public void iniciarJuego() {
        this.buscaminas = new Buscaminas(avatar, filasTablero, columnasTablero, cantidadDeMinas);
        this.buscaminasFrame = new JFBuscaminas();
        this.buscaminasFrame.setVisible(true);
    }

    @Override
    public void jugar() {
        if (partidaTerminadaBuscaminas == false && opcionJuego == 2) {
            buscaminas.descubrirCasillas();
        } else {
            buscaminas.marcarCasillas();
        }
    }

    @Override
    public String encontrarErrores(String avatar, int filas, int columnas, int minas) {
        if (avatar.isBlank()) {
            return "No puedes tener un nombre en blanco";
        } else if (filas < 5) {
            return "Las filas tienen que ser mayor a 5";
        } else if (columnas < 5) {
            return "Las columnas tienen que ser mayor a 5";
        } else if (minas < 1) {
            return "Tienes que tener almenos una mina";
        } else if (minas > filas * columnas) {
            return "Las minas no caben en el tablero";
        } else {
            return "";
        }
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de recibir datos del JFBuscaminas para posteriormente
     * enviarselos al backend y generar la acción.
     *
     * @param filaCasilla - fila de la casilla presionada
     * @param columnaCasilla - columna de la casilla presionada
     */
    public void recibirDatosCasillas(int filaCasilla, int columnaCasilla) {
        buscaminas.recibirInformacionCasilla(filaCasilla, columnaCasilla);
    }

    /**
     * Método encargado de obtener la cantidad de minas adyacentes del bakcend
     * para mandarselo al frontend.
     *
     * @return Cantidad de minas adyacentes
     */
    public String cantidadDeMinasAdyacentes() {
        try {
            CasillasNormales casilla = (CasillasNormales) buscaminas.getTablero().getTablero()[buscaminas.getFilaCasilla()][buscaminas.getColumnaCasilla()];
            return buscaminas.getTablero().descubrirCasillasAdyacentes(casilla);
        } catch (ClassCastException e) {
        }
        return "";
    }

    // GETTERS -----------------------------------------------------------------
    public String getAvatar() {
        return avatar;
    }

    public Buscaminas getBuscaminas() {
        return buscaminas;
    }

    public int getFilasTablero() {
        return filasTablero;
    }

    public int getColumnasTablero() {
        return columnasTablero;
    }

    public int getCantidadDeMinas() {
        return cantidadDeMinas;
    }

    public int getOpcionJuego() {
        return opcionJuego;
    }

    // SETTERS -----------------------------------------------------------------
    public void setOpcionJuego(int opcionJuego) {
        this.opcionJuego = opcionJuego;
    }

}
