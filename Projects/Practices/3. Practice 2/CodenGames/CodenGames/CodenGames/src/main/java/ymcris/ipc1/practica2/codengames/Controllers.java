/**
 * Paquete encargado de crear la clase padre controlers
 */
package ymcris.ipc1.practica2.codengames;

import javax.swing.JFrame;

/**
 * Clase Controllers Es la clase abstracta padre que servirá para poder crear
 * controlers para los juegos
 *
 * @author YmCris
 * @since Apr 3, 2025
 */
public abstract class Controllers {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    protected boolean pasoPruebas;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Controllers() {

    }

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    /**
     * Método encargado de verificar si las entradas proporcionadas por el
     * usuario son válidas.
     *
     * @param avatar
     * @param numero1
     * @param numero2
     * @param numero3
     * @return - true si son válidas, false si no lo son.
     */
    public abstract boolean todoEnOrden(String avatar, int numero1, int numero2, int numero3);

    /**
     * Método encargado de incializar el juego en base a si se han pasado las
     * pruebas.
     */
    public abstract void iniciarJuego();
}
