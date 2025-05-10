package ymcris.ipc1.proyecto2.myfarm.backend.a.interfaces;

/**
 * Interface Pescable es la interfaz encargada de brindar al suelo la capacidad
 * de agregar barcos a la celda / suelo
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public interface Pescable {

    // CONSTANTES --------------------------------------------------------------
    public static final int PRECIO_BARCOS = 100;
    public static final int PRECIO_QUITAR_BARCOS = 50;

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    /**
     * Método encargado de colocar un barco pesquero en la celda (instancia) de
     * agua.
     */
    public abstract void colocarBarco();

    /**
     * Método encargado de quitar el barco de la celda.
     */
    public abstract void quitarBarco();

    /**
     * Método encargado de pescar y obtener peces.
     */
    public abstract void pescar();
}
