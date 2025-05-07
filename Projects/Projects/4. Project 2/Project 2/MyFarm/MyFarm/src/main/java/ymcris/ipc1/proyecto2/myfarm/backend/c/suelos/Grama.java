package ymcris.ipc1.proyecto2.myfarm.backend.c.suelos;

import ymcris.ipc1.proyecto2.myfarm.backend.a.interfaces.Siembrable;
import ymcris.ipc1.proyecto2.myfarm.backend.a.interfaces.Finquerable;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.ListaDoble;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;

/**
 * Clase Grama es la clase hija de Suelo encargada de representar la grama
 * dentro del terreno
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public class Grama extends Suelo implements Siembrable, Finquerable {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String animalesPermitidos;
    private ListaDoble<String> animales;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int fertilidad;
    private boolean esParcela;
    private boolean estaOpupado;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Grama(Granjero granjero, int precio, int distribucion, boolean estaSucio) {
        super(granjero, precio, distribucion, estaSucio);
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public void sembrar(int fila, int columna, String semilla) {

    }

    @Override
    public void crearParcela() {

    }

    @Override
    public void criarAnimales() {

    }

    public void añadirFertilidad(Fertilizantes fertilizante) {
        this.fertilidad = fertilidad + fertilizante.getFertilidad();
    }

    // GETTERS -----------------------------------------------------------------
    public ListaDoble<String> getAnimales() {
        return animales;
    }

    public String getAnimalesPermitidos() {
        return animalesPermitidos;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public boolean isEsParcela() {
        return esParcela;
    }

    public boolean estaOpupado() {
        return estaOpupado;
    }


    // SETTERS -----------------------------------------------------------------
    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    public void setEsParcela(boolean esParcela) {
        this.esParcela = esParcela;
    }

    public void setAnimalesPermitidos(String animalesPermitidos) {
        this.animalesPermitidos = animalesPermitidos;
    }

    public void setEstaOpupado(boolean estaOpupado) {
        this.estaOpupado = estaOpupado;
    }

}
