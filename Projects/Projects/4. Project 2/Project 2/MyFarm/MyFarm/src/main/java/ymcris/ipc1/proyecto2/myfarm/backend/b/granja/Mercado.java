package ymcris.ipc1.proyecto2.myfarm.backend.b.granja;

import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios.ArchivosBinarios;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.ListaDoble;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Recreador;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Archivos;

/**
 * Clase Mercado es la clase del backend encargada de proporcionar la lógica
 * detrás del mercado.
 *
 * @author YmCris
 * @since May 3, 2025
 */
public class Mercado {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    // COMPRAR:
    private Semillas[] semillas;
    private Animales[] animales;
    private Fertilizantes[] fertilizantes;
    private Alimentos[] alimentosParaAnimales;

    // VENDER: 
    private ListaDoble<Alimentos> alimentos;
    private ListaDoble<MateriasPrimas> materias;

    // INSTANCIAS --------------------------------------------------------------
    private Recreador recreador = new Recreador();
    ArchivosBinarios binario = new ArchivosBinarios();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Mercado(ListaDoble<Alimentos> alimentos, ListaDoble<MateriasPrimas> materias) {
        this.alimentos = alimentos;
        this.materias = materias;
        this.fertilizantes = recreador.recrearFertilizantes();
        this.alimentosParaAnimales = recreador.recrearAlimentos();
        this.semillas = recreador.recreadorSemillas();
        this.animales = binario.obtenerAnimales();
    }

    private void modificarAnimales() {

    }

    // GETTERS -----------------------------------------------------------------
    public Fertilizantes[] getFertilizantes() {
        return fertilizantes;
    }

    public Alimentos[] getAlimentosParaAnimales() {
        return alimentosParaAnimales;
    }

    public Semillas[] getSemillas() {
        return semillas;
    }

    public Animales[] getAnimales() {
        return animales;
    }

}
