package ymcris.ipc1.practica2.codengames.hunting.controllers;

import java.util.InputMismatchException;
import ymcris.ipc1.practica2.codengames.Controllers;
import ymcris.ipc1.practica2.codengames.hunting.backend.Hunter;
import ymcris.ipc1.practica2.codengames.hunting.frontend.JFHunter;

/**
 * Clase HunterController es el controller encargado de comunicar el frontend
 * con el backend y viseversa frontend con backend.
 *
 * @author YmCris
 * @since Apr 8, 2025
 */
public class HunterController extends Controllers {

    // CONSTANTES --------------------------------------------------------------
    private static final int VELOCIDAD_MINIMA_PATOS = 1500;
    private static final int CANTIDAD_MINIMA_DE_ACIERTOS = 3;
    private static final int CANTIDAD_MINIMA_DE_REDUCCION = 1000;

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Hunter hunter;
    private JFHunter JFHunter;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public HunterController() {
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public boolean todoEnOrden(String nombre, int velocidadInicialPatos, int cantidadDeAciertos, int reduccionDeTiempo) throws NumberFormatException, InputMismatchException {
        if (nombre.isBlank() || velocidadInicialPatos <= VELOCIDAD_MINIMA_PATOS || cantidadDeAciertos <= CANTIDAD_MINIMA_DE_ACIERTOS || reduccionDeTiempo >= velocidadInicialPatos || reduccionDeTiempo <= CANTIDAD_MINIMA_DE_REDUCCION) {
            return false;
        } else {
            iniciarlizarAtributos(nombre, velocidadInicialPatos, cantidadDeAciertos, reduccionDeTiempo);
            return true;
        }
    }

    @Override
    public String encontrarErrores(String nombre, int velocidadInicialPatos, int cantidadDeAciertos, int reduccionDeTiempo) throws NumberFormatException, InputMismatchException {
        if (nombre.isBlank()) {
            return "No puedes tener un nombre vacio";
        } else if (velocidadInicialPatos <= VELOCIDAD_MINIMA_PATOS) {
            return "No puedes tener una velocidad inicial menor a " + VELOCIDAD_MINIMA_PATOS;
        } else if (cantidadDeAciertos <= CANTIDAD_MINIMA_DE_ACIERTOS) {
            return "Debes acertar más de " + CANTIDAD_MINIMA_DE_ACIERTOS + " veces para poder aumentar la velocidad ";
        } else if (reduccionDeTiempo >= velocidadInicialPatos) {
            return "No puedes reducir más tiempo del cual inicias";
        } else if (reduccionDeTiempo <= CANTIDAD_MINIMA_DE_REDUCCION) {
            return "No puedes reducir el tiempo menos de " + CANTIDAD_MINIMA_DE_REDUCCION;
        } else {
            return "";
        }
    }

    @Override
    public void iniciarJuego() {
        //Crea el juego (Básicamente aquí no se necesita ya que se creo en el constructor ya que no era mucho)
    }

    @Override
    public void jugar() {
        hunter.jugar();
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void iniciarlizarAtributos(String avatar, int velocidadInicialPatos, int cantidadDeAciertosParaAumentarVelocidad, int reduccionDeTiempoPatos) {
        this.hunter = new Hunter(avatar, velocidadInicialPatos, cantidadDeAciertosParaAumentarVelocidad, reduccionDeTiempoPatos);
        this.JFHunter = new JFHunter();
        this.JFHunter.setVisible(true);
    }

    // GETTERS -----------------------------------------------------------------
    public Hunter getHunter() {
        return hunter;
    }

}
