package ymcris.ipc1.proyecto2.myfarm.backend.c.plantas;

import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;

/**
 * Clase Frutas es la subclase encargada de referenciar los objetos del tipo
 * fruta
 *
 * @author YmCris
 * @since May 7, 2025
 */
public class Frutas extends Planta {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Frutas(String nombre, Semillas semilla, int semillasRequeridas) {
        super(nombre, semilla, semillasRequeridas);
        this.desapareceAlMorir = false;
        this.produceFruta = true;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    @Override
    public Alimentos darCosecha() {
        return null;
    }

    @Override
    public void run() {

    }

}
