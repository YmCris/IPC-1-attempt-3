package ymcris.ipc1.proyecto2.myfarm.backend.c.plantas;

import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;

/**
 * Clase Grano es la sub clase de planta encargada de referenciar las plantas
 * que producen granos al morir.
 *
 * @author YmCris
 * @since May 7, 2025
 */
public class Grano extends Planta {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Grano(String nombre, Semillas semilla, int semillasRequeridas) {
        super(nombre, semilla, semillasRequeridas);
        this.desapareceAlMorir = true;
        this.produceFruta = false;
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public Alimentos darCosecha() {
        return null;
    }

    @Override
    public void run() {

    }
}
