package ymcris.ipc1.proyecto2.myfarm.backend.c.plantas;

import ymcris.ipc1.proyecto2.myfarm.backend.a.cola.Cola;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Grama;

/**
 * Clase Frutas es la subclase encargada de referenciar los objetos del tipo
 * fruta
 *
 * @author YmCris
 * @since May 7, 2025
 */
public class Frutas extends Planta {

    // CONSTANTES --------------------------------------------------------------
    private static final int TIEMPO_PARA_DESAPARECER = 2;//20

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Frutas(String nombre, Semillas semilla, int fertilidadSuelo, Cola<Alimentos> ordenDeProduccionAlimentos, Grama grama) {
        super(nombre, semilla, fertilidadSuelo, ordenDeProduccionAlimentos, grama);
        this.tiempoParaCosechar = tiempoCosecha();
        this.tiempoParaPodrirse = tiempoPodrirse();
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    @Override
    public Alimentos darCosecha() {
        int cantidadDeAlimentos = random.nextInt(semilla.getAlimento().getProduccion() + fertilidadSuelo, semilla.getAlimento().getProduccion() + fertilidadSuelo + semilla.getCantidadDeSemillasRequerida());
        Alimentos alimento = semilla.getAlimento();
        //La cantidad de alimentos que darán depende de la fertilidad del suelo
        alimento.setProduccion(cantidadDeAlimentos);
        //Solo se podrá cosechar el alimento en la forma en la que se fue dando, es decir FIFO
        ordenDeProduccionAlimentos.agregarElemento(alimento, alimento.getNombre());
        return alimento;
    }

    @Override
    public void run() {
        //No mueren al recoger la cosecha, pero mueren eventualmente.
        while (!estaPodrida) {
            if (TIEMPO_PARA_DESAPARECER + tiempoParaCosechar + tiempoParaPodrirse == tiempoVivido) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Ha ocurrido un error en el hilo de la fruta " + this.getNombre());
                }
            }
        }
        System.out.println("El hilo de la planta " + getNombre());
    }

}
