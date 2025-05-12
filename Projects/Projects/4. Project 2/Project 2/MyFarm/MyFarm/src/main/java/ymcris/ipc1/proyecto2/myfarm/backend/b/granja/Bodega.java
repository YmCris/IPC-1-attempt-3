package ymcris.ipc1.proyecto2.myfarm.backend.b.granja;

import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.ListaDoble;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;

/**
 * Clase Bodega es la clase encargada de almacenar los elementos dentro de la
 * bodega.
 *
 * @author YmCris
 * @see ListaDoble
 * @since May 3, 2025
 */
public final class Bodega {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Granjero granjero;
    private Alimentos[] alimentos;
    private MateriasPrimas[] materias;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Bodega(Granjero granjero) {
        this.granjero = granjero;
        this.alimentos = granjero.getAlimentosParaAnimales();
        this.materias = granjero.obtenerMateriaDelGranjero();
    }
    
    // GETTERS -----------------------------------------------------------------
    public Alimentos[] getAlimentos() {
        return alimentos;
    }

    public MateriasPrimas[] getMaterias() {
        return materias;
    }

    public Granjero getGranjero() {
        return granjero;
    }
    
    // SETTERS -----------------------------------------------------------------
    public void setAlimentos(Alimentos[] alimentos) {
        this.alimentos = alimentos;
    }

    public void setMaterias(MateriasPrimas[] materias) {
        this.materias = materias;
    }

}
