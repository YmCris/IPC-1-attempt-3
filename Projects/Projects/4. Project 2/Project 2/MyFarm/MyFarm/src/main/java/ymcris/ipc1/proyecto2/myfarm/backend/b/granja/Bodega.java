package ymcris.ipc1.proyecto2.myfarm.backend.b.granja;

import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.ListaDoble;

/**
 * Clase Bodega es la clase encargada de almacenar los elementos dentro de la
 * bodega.
 *
 * @author YmCris
 * @since May 3, 2025
 */
public final class Bodega {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Alimentos[] alimentos;
    private MateriasPrimas[] materias;
    private ListaDoble<Alimentos> listaDeAlimentos;
    private ListaDoble<MateriasPrimas> listaDeMateriaPrima;

    public Bodega(ListaDoble<Alimentos> listaDeAlimentos, ListaDoble<MateriasPrimas> listaDeMateriaPrima) {
        this.listaDeAlimentos = listaDeAlimentos;
        this.listaDeMateriaPrima = listaDeMateriaPrima;
        this.alimentos = obtenerAlimentos();
        this.materias = obtenerMateria();
    }

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    // INSTANCIAS --------------------------------------------------------------
    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    // MÉTODOS CONCRETOS -------------------------------------------------------
    public Alimentos[] obtenerAlimentos() {
        Object[] objetos = listaDeAlimentos.obtenerArregloDeObjetos();
        Alimentos[] arreglo = new Alimentos[objetos.length];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (Alimentos) objetos[i];
        }
        return arreglo;
    }

    public MateriasPrimas[] obtenerMateria() {
        Object[] objetos = listaDeMateriaPrima.obtenerArregloDeObjetos();
        MateriasPrimas[] arreglo = new MateriasPrimas[objetos.length];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (MateriasPrimas) objetos[i];
        }
        return arreglo;
    }

    // GETTERS -----------------------------------------------------------------
    public ListaDoble<Alimentos> getListaDeAlimentos() {
        return listaDeAlimentos;
    }

    public ListaDoble<MateriasPrimas> getListaDeMateriaPrima() {
        return listaDeMateriaPrima;
    }

    public Alimentos[] getAlimentos() {
        return alimentos;
    }

    public MateriasPrimas[] getMaterias() {
        return materias;
    }

}
