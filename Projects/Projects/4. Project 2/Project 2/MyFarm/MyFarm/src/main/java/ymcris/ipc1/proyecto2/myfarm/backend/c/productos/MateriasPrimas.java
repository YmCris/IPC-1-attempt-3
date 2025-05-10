package ymcris.ipc1.proyecto2.myfarm.backend.c.productos;

/**
 * Clase MateriasPrimas
 *
 * @author YmCris
 * @since May 4, 2025
 */
public class MateriasPrimas extends Productos {

    // CONSTANTES --------------------------------------------------------------
    private static final long serialVersionUID = 2513213;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public MateriasPrimas(String nombre, int precioDeVenta, int precioDeCompra) {
        super(nombre, precioDeVenta, precioDeCompra);
        this.esMateriaPrima = true;
        this.seObtieneAlDestazar = true;
    }

}
