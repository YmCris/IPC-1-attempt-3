package ymcris.ipc1.proyecto2.myfarm.backend.a.interfaces;

/**
 * Interface Siembrable es la interfaz que otorga a un suelo la capacidad de
 * sembrar sobre él.
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public interface Siembrable {

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    public void sembrar(int fila, int columna, String semilla);
}
