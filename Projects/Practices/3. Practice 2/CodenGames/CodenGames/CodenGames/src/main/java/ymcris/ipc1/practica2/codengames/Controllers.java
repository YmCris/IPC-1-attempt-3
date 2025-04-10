/**
 * Paquete encargado de crear la clase padre controlers
 */
package ymcris.ipc1.practica2.codengames;

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
     * Método encargado de iniciar el juego (Es decir la creación de los
     * elementos en el backend y mostrado en el frontend) en base a si se han
     * pasado las pruebas.
     */
    public abstract void iniciarJuego();

    /**
     * Método abstracto encargado de jugar el videojuego en el backen
     * (Importante porque de lo contrarío no habría un orden entre el backend y
     * frontend)
     */
    public abstract void jugar();

    // FUNCIONES ABSTRACTAS ----------------------------------------------------
    /**
     * Método encargado de verificar si las entradas proporcionadas por el
     * usuario son válidas, más no dar un mensaje concreto.
     *
     * @param avatar - avatar a verificar si esta en blanco
     * @param numero1 - numero a verificar
     * @param numero2 - numero a verificar
     * @param numero3 - numero a verificar
     * @return - true si son válidas, false si no lo son.
     */
    public abstract boolean todoEnOrden(String avatar, int numero1, int numero2, int numero3);

    /**
     * Método encargado de encontrar los errores y proporcionar un mensaje que
     * posteriormente será mostrado por el frame (Vista).
     *
     * @param avatar - avatar a verificar si esta en blanco
     * @param numero1 - numero a verificar
     * @param numero2 - numero a verificar
     * @param numero3 - numero a verificar
     * @return un mensaje de error en dado caso lo haya.
     */
    public abstract String encontrarErrores(String avatar, int numero1, int numero2, int numero3);

}
