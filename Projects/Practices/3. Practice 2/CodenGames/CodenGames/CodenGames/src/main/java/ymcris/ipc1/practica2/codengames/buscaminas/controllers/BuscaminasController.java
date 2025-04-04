package ymcris.ipc1.practica2.codengames.buscaminas.controllers;

import javax.swing.JFrame;
import ymcris.ipc1.practica2.codengames.Controllers;
import ymcris.ipc1.practica2.codengames.buscaminas.backend.Buscaminas;

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
    private JFrame jMenuPrincipal;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int filasTablero;
    private int columnasTablero;
    private int cantidadDeMinas;
    private boolean pasoPruebas;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------ñ
    public BuscaminasController(JFrame frame) {
        super(frame);
        this.jMenuPrincipal = frame;
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public boolean todoEnOrden(String avatar, int filas, int columnas, int minas) throws NumberFormatException {
        if (avatar.isBlank() || filas < 10 || columnas < 10 || minas < 1 || minas > filas * columnas) {
            return false;
        } else {
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

    }
}
