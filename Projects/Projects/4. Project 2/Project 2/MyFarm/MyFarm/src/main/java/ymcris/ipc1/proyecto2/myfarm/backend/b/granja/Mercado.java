package ymcris.ipc1.proyecto2.myfarm.backend.b.granja;

import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Recreador;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaDobleException;
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
        this.alimentosGranjero = granjero.obtenerAlimentosDeAnimalesDelGranjero();
        this.materiasGranjero = granjero.obtenerMateriaDelGranjero();
        this.fertilizantes = recreador.obtenerFertilizantesExistentes();
        this.alimentosParaAnimales = recreador.obtenerAlimentosParaAnimalesExistentes();
        this.semillas = recreador.obtenerSemillasExistentes();
        this.animales = binario.obtenerAnimales();
    }

    public boolean existeAlimento(String nombreAlimento) {
        try {
            return granjero.getAlimentos().existeNodoConContenido(nombreAlimento);
        } catch (ListaDobleException ex) {
            System.out.println("Hubo un error al capturar si existe el alimento porque " + ex.getMessage());
            return false;
        }
    }

    public boolean existeMateria(String nombreMateria) {
        try {
            return granjero.getMaterias().existeNodoConContenido(nombreMateria);
        } catch (ListaDobleException e) {
            System.out.println("Hubo un error al capturar si existe la materia porque " + e.getMessage());
            return false;
        }
    }

    public void ganarOro(int cantidadGanada) {
        getGranjero().setOro(getGranjero().getOro() + cantidadGanada);
    }

    public void perderOro(int cantidadPerdida) {
        getGranjero().setOro(getGranjero().getOro() - cantidadPerdida);
    }

    public void venderAlimento(String nombreAlimento) {
        try {
            granjero.getAlimentos().usar(nombreAlimento);
        } catch (ListaDobleException ex) {
            System.out.println("Ocurrió un error al intentar vender el alimento porque " + ex.getMessage());
        }
    }

    public void venderMateria(String nombreMateria) {
        try {
            granjero.getMaterias().usar(nombreMateria);
        } catch (ListaDobleException e) {
            System.out.println("Ocurrió un error al intentar vender el alimento porque " + e.getMessage());
        }
    }

    public boolean jugadorTieneDineroSufiente(int precio) {
        return granjero.getOro() >= precio;
    }

    public void agregarAlimentoParaAnimalAlJugador(String nombreAlimento) {
        granjero.agregarCantidadAlimentoParaAnimales(nombreAlimento);
    }

    public void agregarFertilizanteAlJugador(String nombreFertilizante) {
        granjero.agregarCantidadFertilizante(nombreFertilizante);
    }

    public void agregarAnimalAlJugador(String nombreAnimal) {
        Animales nuevoAnimal = (Animales) binario.obtenerObjeto(binario.getRutaCarpetaAnimales(), nombreAnimal);
        granjero.getAnimales().agregar(nuevoAnimal, nuevoAnimal.getNombre());
    }

    public void agregarSemillaAlJugador(String nombreSemilla, int cantidadSemillas) {
        Semillas nuevaSemilla = (Semillas) binario.obtenerObjeto(binario.getRutaCarpetaSemillas(), nombreSemilla);
        try {
            if (!granjero.getSemillas().existeNodoConContenido(nuevaSemilla.getNombre())) {
                granjero.getSemillas().agregar(nuevaSemilla, nuevaSemilla.getNombre());
            } else {
                granjero.agregarCantidadASemilla(nombreSemilla, cantidadSemillas);
            }
        } catch (ListaDobleException | NullPointerException ex) {
            granjero.getSemillas().agregar(nuevaSemilla, nuevaSemilla.getNombre());
            granjero.agregarCantidadASemilla(nombreSemilla, cantidadSemillas);
        }
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

    // SETTERS -----------------------------------------------------------------
    public void setSemillas(Semillas[] semillas) {
        this.semillas = semillas;
    }

    public void setAnimales(Animales[] animales) {
        this.animales = animales;
    }

    public void setFertilizantes(Fertilizantes[] fertilizantes) {
        this.fertilizantes = fertilizantes;
    }

    public void setAlimentosParaAnimales(Alimentos[] alimentosParaAnimales) {
        this.alimentosParaAnimales = alimentosParaAnimales;
    }

    public void setAlimentosGranjero(Alimentos[] alimentosGranjero) {
        this.alimentosGranjero = alimentosGranjero;
    }

    public void setMateriasGranjero(MateriasPrimas[] materiasGranjero) {
        this.materiasGranjero = materiasGranjero;
    }

}
