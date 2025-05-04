package ymcris.ipc1.proyecto2.myfarm.backend.a.interfaces;

/**
 * Interface Finquerable es la interfaz que le brinda al tipo de suelo la
 * posibilidad de que sea parte de una finca
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public interface Finquerable {

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    public abstract void crearParcela();

    public abstract void criarAnimales();
}
