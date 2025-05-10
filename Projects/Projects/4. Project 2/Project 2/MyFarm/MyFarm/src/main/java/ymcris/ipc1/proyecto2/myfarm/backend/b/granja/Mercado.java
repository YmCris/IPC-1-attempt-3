package ymcris.ipc1.proyecto2.myfarm.backend.b.granja;

import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Recreador;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios.ArchivosBinarios;

/**
 * Clase Mercado es la clase del backend encargada de proporcionar la lógica
 * detrás del mercado.
 *
 * @author YmCris
 * @see Recreador
 * @see ArchivosBinarios
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
    private Alimentos[] alimentosGranjero;
    private MateriasPrimas[] materiasGranjero;

    // INSTANCIAS --------------------------------------------------------------
    Recreador recreador = new Recreador();
    ArchivosBinarios binario = new ArchivosBinarios();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Mercado(Alimentos[] alimentosGranjero, MateriasPrimas[] materiasGranjero) {
        this.alimentosGranjero = alimentosGranjero;
        this.materiasGranjero = materiasGranjero;
        this.fertilizantes = recreador.obtenerFertilizantesExistentes();
        this.alimentosParaAnimales = recreador.obtenerAlimentosParaAnimalesExistentes();
        this.semillas = recreador.obtenerSemillasExistentes();
        this.animales = binario.obtenerAnimales();
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

    public Alimentos[] getAlimentosGranjero() {
        return alimentosGranjero;
    }

    public MateriasPrimas[] getMateriasGranjero() {
        return materiasGranjero;
    }

}
