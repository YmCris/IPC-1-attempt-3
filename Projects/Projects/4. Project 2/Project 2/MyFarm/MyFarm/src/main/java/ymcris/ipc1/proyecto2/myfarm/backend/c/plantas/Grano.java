package ymcris.ipc1.proyecto2.myfarm.backend.c.plantas;

import java.util.Random;
import ymcris.ipc1.proyecto2.myfarm.backend.a.cola.Cola;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ColaException;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaDobleException;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Grama;

/**
 * Clase Grano es la sub clase de planta encargada de referenciar las plantas
 * que producen granos al morir.
 *
 * @author YmCris
 * @since May 7, 2025
 */
public class Grano extends Planta {

    // INSTANCIAS --------------------------------------------------------------
    private Granjero granjero;

    private boolean cosechaRecogida;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Grano(String nombre, Semillas semilla, int fertilidadSuelo, Cola<Alimentos> ordenDeProduccionAlimentos, Grama grama, Granjero granjero) {
        super(nombre, semilla, fertilidadSuelo, ordenDeProduccionAlimentos, grama);
        this.granjero = granjero;
        this.tiempoParaCosechar = tiempoCosecha();
        this.tiempoParaPodrirse = tiempoParaCosechar + tiempoPodrirse();
        this.cosechaRecogida = false;
        System.out.println("El tiempo para cosechar es: " + tiempoParaCosechar + " tiempo para podrirse " + tiempoParaPodrirse);
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public Alimentos darCosecha() {
        try {
            Alimentos alimento = granjero.obtenerAlimentos(semilla.getAlimento().getNombre());
            int cantidadDeAlimentos = random.nextInt(1, fertilidadSuelo + alimento.getPrecioDeCompra() / 2);
            //La cantidad de alimentos que darán depende de la fertilidad del suelo
            alimento.setCantidad(alimento.getCantidad() + cantidadDeAlimentos);
            //Solo se podrá cosechar el alimento en la forma en la que se fue dando, es decir FIFO
            ordenDeProduccionAlimentos.agregarElemento(alimento, alimento.getNombre());
            return alimento;
        } catch (ListaDobleException ex) {
            System.out.println("Ha ocurrido un error al darse la cosecha porque " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void run() {
        //Mueren y desaparecen al momento de la cosecha
        Alimentos alimentoARetornar = null;
        while (!estaPodrida) {
            if (cosechaRecogida == false) {
                try {
                    Thread.sleep(1000);
                    tiempoVivido++;//Las plantas crecen y están listas para cosechar su alimento
                    if (tiempoVivido == tiempoParaCosechar) {
                        cosechaLista = true;
                        alimentoARetornar = darCosecha();//Lo guardo en la cola y luego cada instanicia verificará si cosechaLista && entonces podrá obtenerlo (osea luego se suma o agrega al alimentos<> del granjero)
                        alimentoARetornar.setEstaPodrido(false);
                        this.getGrama().setText("Cosecha lista, orden " + getOrdenDeProduccionAlimentos().getIndice());
                        this.getGrama().agregarImagenSemillaFin();
                    }
                    if (cosechaRecogida == false) {
                        if (tiempoVivido == tiempoParaPodrirse) {
                            estaPodrida = true;//Si no se cosechan las siembras despues de un cierto tiempo aleatorio, estas se pudren y se pierde la cosecha.
                            tiempoVivido = 0;
                            try {
                                ordenDeProduccionAlimentos.sacarElemento();
                                this.getGrama().setText("Cosecha podrida");
                                this.getGrama().setEstaSucio(true);
                            } catch (ColaException | ListaDobleException | NullPointerException ex) {
                                System.out.println("Ha ocurrido un error al sacar el elemento que se pudrio porque " + ex.getMessage());
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("El hilo de la planta " + nombre + " ha sido interrumpido, porque " + e.getMessage());
                }
            }
        }
        System.out.println("Se ha terminado el hilo del grano");
    }

    public boolean isCosechaRecogida() {
        return cosechaRecogida;
    }

    public void setCosechaRecogida(boolean cosechaRecogida) {
        this.cosechaRecogida = cosechaRecogida;
    }

}
