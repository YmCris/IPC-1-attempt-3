package ymcris.ipc1.practica2.codengames.buscaminas.controllers;

import javax.swing.JFrame;
import ymcris.ipc1.practica2.codengames.Controllers;
import ymcris.ipc1.practica2.codengames.buscaminas.backend.Buscaminas;
import ymcris.ipc1.practica2.codengames.buscaminas.frontend.JFBuscaminas;

/**
 * Clase BuscaminasController Es la clase Controller que se encarga de
 *
 * @author YmCris
 * @see Controllers
 * @since Apr 3, 2025
 */
public class BuscaminasController extends Controllers {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String avatar;
    private Buscaminas buscaminas;
    private JFrame buscaminasFrame;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int opcionJuego;
    private int filasTablero;
    private int columnasTablero;
    private int cantidadDeMinas;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------ñ
    public BuscaminasController() {
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public boolean todoEnOrden(String avatar, int filas, int columnas, int minas) throws NumberFormatException {
        if (avatar.isBlank() || filas < 10 || columnas < 10 || minas < 1 || minas > filas * columnas) {
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

    public String encontrarErrores(String avatar, int filas, int columnas, int minas) {
        if (avatar.isBlank()) {
            return "No puedes tener un nombre en blanco";
        } else if (filas < 10) {
            return "Las filas tienen que ser mayor a 10";
        } else if (columnas < 10) {
            return "Las columnas tienen que ser mayor a 10";
        } else if (minas < 1) {
            return "Tienes que tener almenos una mina";
        } else if (minas > filas * columnas) {
            return "Las minas no caben en el tablero";
        } else {
            return "";
        }
    }

    @Override
    public void iniciarJuego() {
        this.buscaminas = new Buscaminas(avatar, filasTablero, columnasTablero, cantidadDeMinas);
        this.buscaminasFrame = new JFBuscaminas();
        this.buscaminasFrame.setVisible(true);
        buscaminas.iniciarPartida();
    }

    public void recibirDatosCasillas(int filaCasilla, int columnaCasilla) {
        buscaminas.recibirInformacionCasilla(filaCasilla, columnaCasilla);
    }

    public String getAvatar() {
        return avatar;
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

    public void setOpcionJuego(int opcionJuego) {
        this.opcionJuego = opcionJuego;
    }

}
