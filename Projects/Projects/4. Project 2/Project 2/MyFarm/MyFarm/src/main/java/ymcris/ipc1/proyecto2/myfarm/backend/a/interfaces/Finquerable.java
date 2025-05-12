package ymcris.ipc1.proyecto2.myfarm.backend.a.interfaces;

import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;

/**
 * Interface Finquerable es la interfaz que le brinda al tipo de suelo la
 * posibilidad de que sea parte de una finca
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public interface Finquerable {

    // MÉTODOS ABSTRACTOS ------------------------------------------------------ç
    /**
     * Método encargado de agregar un animal al tablero.
     *
     * @param animal animal que será criado
     */
    public abstract void criarAnimales(Animales animal);
}
