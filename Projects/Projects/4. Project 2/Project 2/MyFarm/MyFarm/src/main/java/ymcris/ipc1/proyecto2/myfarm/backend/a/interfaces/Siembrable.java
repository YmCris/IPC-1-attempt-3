package ymcris.ipc1.proyecto2.myfarm.backend.a.interfaces;

import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;

/**
 * Interface Siembrable es la interfaz que otorga a un suelo la capacidad de
 * sembrar sobre él.
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public interface Siembrable {

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    /**
     * Método encargado de sembrar en la celda (instancia de grama)
     *
     * @param semilla semilla a sembrar.
     */
    public void sembrar(Semillas semilla);
}
