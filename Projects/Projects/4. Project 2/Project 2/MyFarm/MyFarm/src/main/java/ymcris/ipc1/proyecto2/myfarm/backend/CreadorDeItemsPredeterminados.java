package ymcris.ipc1.proyecto2.myfarm.backend;

import java.io.File;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios.ArchivosBinarios;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Archivos;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ArchivoException;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Herbivoros;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Omnivoros;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;

/**
 * Clase CreadorDeItemsPredeterminados
 *
 * @author YmCris
 * @since May 7, 2025
 */
public class CreadorDeItemsPredeterminados {

    // INSTANCIAS --------------------------------------------------------------
    private Archivos archivo = new Archivos();
    ArchivosBinarios binario = new ArchivosBinarios();

    // MÉTODOS CONCRETOS -------------------------------------------------------
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

    public void creadorDeAlimentosPredeterminados() {
        Alimentos alimentoH1 = new Alimentos("pasto", 20, 20, true);
        Alimentos alimentoH2 = new Alimentos("zanahoria", 10, 35, true);
        Alimentos alimentoH3 = new Alimentos("nuez", 25, 15, true);
        Alimentos alimentoO1 = new Alimentos("frijol", 25, 40, false);
        Alimentos alimentoO2 = new Alimentos("huevo", 25, 60, false);
        Alimentos alimentoO3 = new Alimentos("pollo", 25, 100, false);
        try {
            File pasto = archivo.crearArchivoDeTexto(archivo.getRutaCarpetaAlimentosAnimales(), alimentoH1.getNombre());
            archivo.escribirEnArchivoDeTexto(pasto, alimentoH1.getNombre());
            archivo.escribirEnArchivoDeTexto(pasto, String.valueOf(alimentoH1.getPrecioDeVenta()));
            archivo.escribirEnArchivoDeTexto(pasto, String.valueOf(alimentoH1.getPrecioDeCompra()));
            archivo.escribirEnArchivoDeTexto(pasto, String.valueOf(alimentoH1.esParaHerbivoros()));
            File manzana = archivo.crearArchivoDeTexto(archivo.getRutaCarpetaAlimentosAnimales(), alimentoH1.getNombre());
            archivo.escribirEnArchivoDeTexto(manzana, alimentoH1.getNombre());
            archivo.escribirEnArchivoDeTexto(manzana, String.valueOf(alimentoH1.getPrecioDeVenta()));
            archivo.escribirEnArchivoDeTexto(manzana, String.valueOf(alimentoH1.getPrecioDeCompra()));
            archivo.escribirEnArchivoDeTexto(manzana, String.valueOf(alimentoH1.esParaHerbivoros()));
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
        Herbivoros vaca = new Herbivoros("vaca", 500, 2, 600, true, true, true);
        Omnivoros gallina = new Omnivoros("gallina", 50, 0.5, 180, false, true, true);
        binario.guardarAnimales(vaca);
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
        Alimentos grano = new Alimentos("grano", 10, 20, true);
        Alimentos manzana = new Alimentos("manzana", 15, 25, true);
        Alimentos carne = new Alimentos("carne", 60, 80, false);
        Alimentos leche = new Alimentos("leche", 15, 12, false);
        Alimentos huevo = new Alimentos("huevo", 5, 10, false);
        binario.guardarMaterias(cuero);
        binario.guardarAlimento(grano);
        binario.guardarAlimento(manzana);
        binario.guardarAlimento(carne);
        binario.guardarAlimento(leche);
        binario.guardarAlimento(huevo);
    }

}
