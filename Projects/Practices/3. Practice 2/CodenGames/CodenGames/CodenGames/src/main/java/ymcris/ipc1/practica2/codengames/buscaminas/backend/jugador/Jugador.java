/**
 * Paquete encargado de Crear un jugador y las posibles clases que se puedan relacionar a este.
 */
package ymcris.ipc1.practica2.codengames.buscaminas.backend.jugador;

import java.io.Serializable;

/**
 * Clase Jugador es la clase encargada de crear un objeto Jugador que será el
 * que jugará los juegos y servirá como base para la persistencia de los
 * reportes.
 *
 * @author YmCris
 * @since Apr 3, 2025
 */
public class Jugador implements Serializable {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nombre;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int record;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método constructor encargado de crear un jugador.
     *
     * @param nombre - Nombre del jugador.
     * @param record - Record que tendrá el jugador en los reportes.
     */
    public Jugador(String nombre, int record) {
        this.nombre = nombre;
        this.record = record;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de mostrar la información del jugador.
     */
    public void mostrarInformación() {
        System.out.println("Jugador: " + this.nombre + " tu record es: " + this.record);
    }

    // GETTERS -----------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public int getRecord() {
        return record;
    }

    // SETTERS -----------------------------------------------------------------
    public void setRecord(int record) {
        this.record = record;
    }

}
