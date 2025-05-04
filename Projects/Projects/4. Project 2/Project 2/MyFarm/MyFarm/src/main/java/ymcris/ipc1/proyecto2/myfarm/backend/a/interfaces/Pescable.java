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
    public abstract void colocarBarco(int oroGranjero);

    public abstract void quitarBarco(int oroGranjero);

    public abstract void pescar();
}
