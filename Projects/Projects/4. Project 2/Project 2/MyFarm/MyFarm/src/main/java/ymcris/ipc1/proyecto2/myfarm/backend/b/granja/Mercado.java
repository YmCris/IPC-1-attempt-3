package ymcris.ipc1.proyecto2.myfarm.backend.b.granja;

import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Recreador;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios.ArchivosBinarios;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;

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
    private Granjero granjero;
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
    public Mercado(Granjero granjero) {
        this.granjero = granjero;
        this.alimentosGranjero = granjero.obtenerAlimentosDelGranjero();
        this.materiasGranjero = granjero.obtenerMateriaDelGranjero();
        this.fertilizantes = recreador.obtenerFertilizantesExistentes();
        this.alimentosParaAnimales = recreador.obtenerAlimentosParaAnimalesExistentes();
        this.semillas = recreador.obtenerSemillasExistentes();
        this.animales = binario.obtenerAnimales();
    }

    public boolean jugadorTieneDineroSufiente(int precio) {
        return granjero.getOro() >= precio;
    }
    
    public void agregarAlimentoParaAnimalAlJugador(String nombreAlimento) {
        granjero.agregarAlimentoParaAnimales(nombreAlimento);
    }

    public void agregarFertilizanteAlJugador(String nombreFertilizante) {
        granjero.agregarFertilizante(nombreFertilizante);
    }

    public void agregarAnimalAlJugador(String nombreAnimal) {
        Animales nuevoAnimal = (Animales) binario.obtenerObjeto(binario.getRutaCarpetaAnimales(), nombreAnimal);
        granjero.getAnimales().agregar(nuevoAnimal, nuevoAnimal.getNombre());
    }

    public void agregarSemillaAlJugador(String nombreSemilla) {
        Semillas nuevaSemilla = (Semillas) binario.obtenerObjeto(binario.getRutaCarpetaSemillas(), nombreSemilla);
        granjero.getSemillas().agregar(nuevaSemilla, nuevaSemilla.getNombre());
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

    public Granjero getGranjero() {
        return granjero;
    }

}
