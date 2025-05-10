package ymcris.ipc1.proyecto2.myfarm.backend;

import java.io.File;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Omnivoros;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Herbivoros;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Productos;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Archivos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ArchivoException;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios.ArchivosBinarios;

/**
 * Clase Creador es la clase encargada de crear los items predeterminados por el
 * enunciado así como capturar los posibles fallos que pueda tener
 *
 * @author YmCris
 * @see Archivos
 * @see ArchivosBinarios
 * @since May 7, 2025
 */
public class Creador {

    // INSTANCIAS --------------------------------------------------------------
    Archivos archivo = new Archivos();
    ArchivosBinarios binario = new ArchivosBinarios();

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de crear los fertilizantes predeterminados y guardarlos
     * en los archivos de texto.
     */
    public void crearFertilizantesPredeterminados() {
        Fertilizantes fertilizante1 = new Fertilizantes("cal", 15, 50);
        Fertilizantes fertilizante2 = new Fertilizantes("viruta", 35, 90);
        Fertilizantes fertilizante3 = new Fertilizantes("abono", 70, 150);
        try {
            File cal = archivo.crearArchivoDeTexto(archivo.getRutaCarpetaFertilizantes(), fertilizante1.getNombre());
            archivo.escribirEnArchivoDeTexto(cal, fertilizante1.getNombre());
            archivo.escribirEnArchivoDeTexto(cal, String.valueOf(fertilizante1.getFertilidad()));
            archivo.escribirEnArchivoDeTexto(cal, String.valueOf(fertilizante1.getPrecio()));
            File viruta = archivo.crearArchivoDeTexto(archivo.getRutaCarpetaFertilizantes(), fertilizante2.getNombre());
            archivo.escribirEnArchivoDeTexto(viruta, fertilizante2.getNombre());
            archivo.escribirEnArchivoDeTexto(viruta, String.valueOf(fertilizante2.getFertilidad()));
            archivo.escribirEnArchivoDeTexto(viruta, String.valueOf(fertilizante2.getPrecio()));
            File abono = archivo.crearArchivoDeTexto(archivo.getRutaCarpetaFertilizantes(), fertilizante3.getNombre());
            archivo.escribirEnArchivoDeTexto(abono, fertilizante3.getNombre());
            archivo.escribirEnArchivoDeTexto(abono, String.valueOf(fertilizante3.getFertilidad()));
            archivo.escribirEnArchivoDeTexto(abono, String.valueOf(fertilizante3.getPrecio()));
        } catch (ArchivoException e) {
            System.out.println("No se pudo crear los fertilizantes porque " + e.getMessage());
        }
    }

    /**
     * Método encargado de crear los únicos alimentos para los animales
     * predeterminados por el enunciado.
     */
    public void crearAlimentosParaAnimalesPredeterminados() {
        Alimentos alimentoH1 = new Alimentos("pasto", 55, 60, true);
        Alimentos alimentoH2 = new Alimentos("zanahoria", 15, 20, true);
        Alimentos alimentoH3 = new Alimentos("nuez", 10, 15, true);
        Alimentos alimentoO1 = new Alimentos("insectos", 50, 80, false);
        Alimentos alimentoO2 = new Alimentos("roedor", 25, 60, false);
        Alimentos alimentoO3 = new Alimentos("pollo", 80, 120, false);
        try {
            File pasto = archivo.crearArchivoDeTexto(archivo.getRutaCarpetaAlimentosAnimales(), alimentoH1.getNombre());
            archivo.escribirEnArchivoDeTexto(pasto, alimentoH1.getNombre());
            archivo.escribirEnArchivoDeTexto(pasto, String.valueOf(alimentoH1.getPrecioDeVenta()));
            archivo.escribirEnArchivoDeTexto(pasto, String.valueOf(alimentoH1.getPrecioDeCompra()));
            archivo.escribirEnArchivoDeTexto(pasto, String.valueOf(alimentoH1.esParaHerbivoros()));
            File zanahoria = archivo.crearArchivoDeTexto(archivo.getRutaCarpetaAlimentosAnimales(), alimentoH2.getNombre());
            archivo.escribirEnArchivoDeTexto(zanahoria, alimentoH2.getNombre());
            archivo.escribirEnArchivoDeTexto(zanahoria, String.valueOf(alimentoH2.getPrecioDeVenta()));
            archivo.escribirEnArchivoDeTexto(zanahoria, String.valueOf(alimentoH2.getPrecioDeCompra()));
            archivo.escribirEnArchivoDeTexto(zanahoria, String.valueOf(alimentoH2.esParaHerbivoros()));
            File nueces = archivo.crearArchivoDeTexto(archivo.getRutaCarpetaAlimentosAnimales(), alimentoH3.getNombre());
            archivo.escribirEnArchivoDeTexto(nueces, alimentoH3.getNombre());
            archivo.escribirEnArchivoDeTexto(nueces, String.valueOf(alimentoH3.getPrecioDeVenta()));
            archivo.escribirEnArchivoDeTexto(nueces, String.valueOf(alimentoH3.getPrecioDeCompra()));
            archivo.escribirEnArchivoDeTexto(nueces, String.valueOf(alimentoH3.esParaHerbivoros()));
            File granos = archivo.crearArchivoDeTexto(archivo.getRutaCarpetaAlimentosAnimales(), alimentoO1.getNombre());
            archivo.escribirEnArchivoDeTexto(granos, alimentoO1.getNombre());
            archivo.escribirEnArchivoDeTexto(granos, String.valueOf(alimentoO1.getPrecioDeVenta()));
            archivo.escribirEnArchivoDeTexto(granos, String.valueOf(alimentoO1.getPrecioDeCompra()));
            archivo.escribirEnArchivoDeTexto(granos, String.valueOf(alimentoO1.esParaHerbivoros()));
            File granos1 = archivo.crearArchivoDeTexto(archivo.getRutaCarpetaAlimentosAnimales(), alimentoO1.getNombre());
            archivo.escribirEnArchivoDeTexto(granos1, alimentoO1.getNombre());
            archivo.escribirEnArchivoDeTexto(granos1, String.valueOf(alimentoO1.getPrecioDeVenta()));
            archivo.escribirEnArchivoDeTexto(granos1, String.valueOf(alimentoO1.getPrecioDeCompra()));
            archivo.escribirEnArchivoDeTexto(granos1, String.valueOf(alimentoO1.esParaHerbivoros()));
            File huevos = archivo.crearArchivoDeTexto(archivo.getRutaCarpetaAlimentosAnimales(), alimentoO2.getNombre());
            archivo.escribirEnArchivoDeTexto(huevos, alimentoO2.getNombre());
            archivo.escribirEnArchivoDeTexto(huevos, String.valueOf(alimentoO2.getPrecioDeVenta()));
            archivo.escribirEnArchivoDeTexto(huevos, String.valueOf(alimentoO2.getPrecioDeCompra()));
            archivo.escribirEnArchivoDeTexto(huevos, String.valueOf(alimentoO2.esParaHerbivoros()));
            File pollo = archivo.crearArchivoDeTexto(archivo.getRutaCarpetaAlimentosAnimales(), alimentoO3.getNombre());
            archivo.escribirEnArchivoDeTexto(pollo, alimentoO3.getNombre());
            archivo.escribirEnArchivoDeTexto(pollo, String.valueOf(alimentoO3.getPrecioDeVenta()));
            archivo.escribirEnArchivoDeTexto(pollo, String.valueOf(alimentoO3.getPrecioDeCompra()));
            archivo.escribirEnArchivoDeTexto(pollo, String.valueOf(alimentoO3.esParaHerbivoros()));
        } catch (ArchivoException e) {
            System.out.println("Hubo un error al guardar los alimentos predeterminados porque " + e.getMessage());
        }

    }

    public void creadorDeAnimalesPredeterminados() {
        Productos cuero = (Productos) binario.obtenerObjeto(binario.getRutaCarpetaMateriaPrima(), "cuero");
        Productos carne = (Productos) binario.obtenerObjeto(binario.getRutaCarpetaMateriaPrima(), "carne");
        Productos leche = (Productos) binario.obtenerObjeto(binario.getRutaCarpetaAlimentos(), "leche");
        Productos huevos = (Productos) binario.obtenerObjeto(binario.getRutaCarpetaAlimentos(), "huevo");
        Herbivoros vaca = new Herbivoros("vaca", 500, 2, 600, true, true, true);
        cuero.setProduccion(25);
        vaca.getProductosDestazables().agregar(cuero);
        vaca.setPorcentajeDeProduccionConDestaze(vaca.getPorcentajeDeProduccionConDestaze() + 25);
        carne.setProduccion(75);
        vaca.getProductosDestazables().agregar(carne);
        vaca.setPorcentajeDeProduccionConDestaze(vaca.getPorcentajeDeProduccionConDestaze() + 75);
        leche.setProduccion(100);
        vaca.getProductosNoDestazables().agregar(leche);
        vaca.setPorcentajeDeProduccionSinDestaze(vaca.getPorcentajeDeProduccionSinDestaze() + 100);
        binario.guardarAnimales(vaca);
        Omnivoros gallina = new Omnivoros("gallina", 50, 0.5, 180, false, true, true);
        carne.setProduccion(100);
        gallina.getProductosDestazables().agregar(carne);
        gallina.setPorcentajeDeProduccionConDestaze(gallina.getPorcentajeDeProduccionConDestaze() + carne.getProduccion());
        huevos.setProduccion(100);
        gallina.getProductosNoDestazables().agregar(huevos);
        gallina.setPorcentajeDeProduccionSinDestaze(gallina.getPorcentajeDeProduccionSinDestaze() + huevos.getProduccion());
        binario.guardarAnimales(gallina);
    }

    public void creadorDeSemillasPredeterminadas() {
        Alimentos grano = (Alimentos) binario.obtenerObjeto(binario.getRutaCarpetaAlimentos(), "grano");
        Alimentos manzana = (Alimentos) binario.obtenerObjeto(binario.getRutaCarpetaAlimentos(), "manzana");
        Semillas semillaMaiz = new Semillas("maiz", 50, false, 15, grano);
        Semillas semillaFruta = new Semillas("manzano", 100, true, 25, manzana);
        binario.guardarSemillas(semillaMaiz);
        binario.guardarSemillas(semillaFruta);
    }

    public void creadorDeProductosPredeterminados() {
        MateriasPrimas cuero = new MateriasPrimas("cuero", 50, 50);
        MateriasPrimas carne = new MateriasPrimas("carne", 50, 50);
        Alimentos grano = new Alimentos("grano", 10, 20, true);
        Alimentos manzana = new Alimentos("manzana", 15, 25, true);
        Alimentos leche = new Alimentos("leche", 15, 12, false);
        Alimentos huevo = new Alimentos("huevo", 5, 10, false);
        binario.guardarMaterias(cuero);
        binario.guardarMaterias(carne);
        binario.guardarAlimento(grano);
        binario.guardarAlimento(manzana);
        binario.guardarAlimento(leche);
        binario.guardarAlimento(huevo);
    }

}
