package ymcris.ipc1.proyecto2.myfarm.backend;

import java.io.File;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.ArchivosDeTexto;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ArchivoException;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Frutas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Grano;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;

/**
 * Clase CreadorDeItemsPredeterminados
 *
 * @author YmCris
 * @since May 7, 2025
 */
public class CreadorDeItemsPredeterminados {

    // INSTANCIAS --------------------------------------------------------------
    private ArchivosDeTexto archivo = new ArchivosDeTexto();

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void crearFertilizantesPredeterminados() {
        Fertilizantes fertilizante1 = new Fertilizantes("cal", 15, 50);
        Fertilizantes fertilizante2 = new Fertilizantes("viruta", 35, 90);
        Fertilizantes fertilizante3 = new Fertilizantes("abono", 70, 150);
        try {
            File cal = archivo.crearArchivo(archivo.getRutaCarpetaFertilizantes(), fertilizante1.getNombre());
            archivo.escribirEnArchivo(cal, fertilizante1.getNombre());
            archivo.escribirEnArchivo(cal, String.valueOf(fertilizante1.getFertilidad()));
            archivo.escribirEnArchivo(cal, String.valueOf(fertilizante1.getPrecio()));
            File viruta = archivo.crearArchivo(archivo.getRutaCarpetaFertilizantes(), fertilizante2.getNombre());
            archivo.escribirEnArchivo(viruta, fertilizante2.getNombre());
            archivo.escribirEnArchivo(viruta, String.valueOf(fertilizante2.getFertilidad()));
            archivo.escribirEnArchivo(viruta, String.valueOf(fertilizante2.getPrecio()));
            File abono = archivo.crearArchivo(archivo.getRutaCarpetaFertilizantes(), fertilizante3.getNombre());
            archivo.escribirEnArchivo(abono, fertilizante3.getNombre());
            archivo.escribirEnArchivo(abono, String.valueOf(fertilizante3.getFertilidad()));
            archivo.escribirEnArchivo(abono, String.valueOf(fertilizante3.getPrecio()));
        } catch (ArchivoException e) {
            System.out.println("No se pudo crear los fertilizantes porque " + e.getMessage());
        }
    }

    public void creadorDeAlimentosPredeterminados() {
        Alimentos alimentoH1 = new Alimentos("manzana", 20, 20, true);
        Alimentos alimentoH2 = new Alimentos("zanahoria", 10, 35, true);
        Alimentos alimentoH3 = new Alimentos("nuez", 25, 15, true);
        Alimentos alimentoO1 = new Alimentos("grano", 25, 40, false);
        Alimentos alimentoO2 = new Alimentos("huevo", 25, 60, false);
        Alimentos alimentoO3 = new Alimentos("pollo", 25, 100, false);
        try {
            File pasto = archivo.crearArchivo(archivo.getRutaCarpetaAlimentos(), alimentoH1.getNombre());
            archivo.escribirEnArchivo(pasto, alimentoH1.getNombre());
            archivo.escribirEnArchivo(pasto, String.valueOf(alimentoH1.getPrecioDeVenta()));
            archivo.escribirEnArchivo(pasto, String.valueOf(alimentoH1.getPrecioDeCompra()));
            archivo.escribirEnArchivo(pasto, String.valueOf(alimentoH1.esParaHerbivoros()));
            File zanahoria = archivo.crearArchivo(archivo.getRutaCarpetaAlimentos(), alimentoH2.getNombre());
            archivo.escribirEnArchivo(zanahoria, alimentoH2.getNombre());
            archivo.escribirEnArchivo(zanahoria, String.valueOf(alimentoH2.getPrecioDeVenta()));
            archivo.escribirEnArchivo(zanahoria, String.valueOf(alimentoH2.getPrecioDeCompra()));
            archivo.escribirEnArchivo(zanahoria, String.valueOf(alimentoH2.esParaHerbivoros()));
            File nueces = archivo.crearArchivo(archivo.getRutaCarpetaAlimentos(), alimentoH3.getNombre());
            archivo.escribirEnArchivo(nueces, alimentoH3.getNombre());
            archivo.escribirEnArchivo(nueces, String.valueOf(alimentoH3.getPrecioDeVenta()));
            archivo.escribirEnArchivo(nueces, String.valueOf(alimentoH3.getPrecioDeCompra()));
            archivo.escribirEnArchivo(nueces, String.valueOf(alimentoH3.esParaHerbivoros()));
            File granos = archivo.crearArchivo(archivo.getRutaCarpetaAlimentos(), alimentoO1.getNombre());
            archivo.escribirEnArchivo(granos, alimentoO1.getNombre());
            archivo.escribirEnArchivo(granos, String.valueOf(alimentoO1.getPrecioDeVenta()));
            archivo.escribirEnArchivo(granos, String.valueOf(alimentoO1.getPrecioDeCompra()));
            archivo.escribirEnArchivo(granos, String.valueOf(alimentoO1.esParaHerbivoros()));
            File huevos = archivo.crearArchivo(archivo.getRutaCarpetaAlimentos(), alimentoO2.getNombre());
            archivo.escribirEnArchivo(huevos, alimentoO2.getNombre());
            archivo.escribirEnArchivo(huevos, String.valueOf(alimentoO2.getPrecioDeVenta()));
            archivo.escribirEnArchivo(huevos, String.valueOf(alimentoO2.getPrecioDeCompra()));
            archivo.escribirEnArchivo(huevos, String.valueOf(alimentoO2.esParaHerbivoros()));
            File pollo = archivo.crearArchivo(archivo.getRutaCarpetaAlimentos(), alimentoO3.getNombre());
            archivo.escribirEnArchivo(pollo, alimentoO3.getNombre());
            archivo.escribirEnArchivo(pollo, String.valueOf(alimentoO3.getPrecioDeVenta()));
            archivo.escribirEnArchivo(pollo, String.valueOf(alimentoO3.getPrecioDeCompra()));
            archivo.escribirEnArchivo(pollo, String.valueOf(alimentoO3.esParaHerbivoros()));
        } catch (ArchivoException e) {
            System.out.println("Hubo un error al guardar los alimentos predeterminados porque " + e.getMessage());
        }

    }

    public void creadorDeAnimalesPredeterminados() {

    }

    public void creadorDeSemillasPredeterminadas() {
        Semillas semillaMaiz = new Semillas("maiz", 50, false, "grano");
        Semillas semillaFruta = new Semillas("manzano", 100, true, "manzana");
        try {
            File maiz = archivo.crearArchivo(archivo.getRutaCarpetaSemillas(), semillaMaiz.getNombre());
            archivo.escribirEnArchivo(maiz, semillaMaiz.getNombre());
            archivo.escribirEnArchivo(maiz, String.valueOf(semillaMaiz.getPrecio()));
            archivo.escribirEnArchivo(maiz, String.valueOf(semillaMaiz.isProduceFruta()));
            archivo.escribirEnArchivo(maiz, String.valueOf(semillaMaiz.getAlimento().getNombre()));
            File manzano = archivo.crearArchivo(archivo.getRutaCarpetaSemillas(), semillaFruta.getNombre());
            archivo.escribirEnArchivo(manzano, semillaFruta.getNombre());
            archivo.escribirEnArchivo(manzano, String.valueOf(semillaFruta.getPrecio()));
            archivo.escribirEnArchivo(manzano, String.valueOf(semillaFruta.isProduceFruta()));
            archivo.escribirEnArchivo(manzano, String.valueOf(semillaFruta.getAlimento().getNombre()));
        } catch (ArchivoException e) {
            System.out.println("Hubo un error al crear las semillas predeterminadas porque " + e.getMessage());
        }
    }

    public void creadorDePlantasPredeterminadas() {
        try {
            File maiz = archivo.crearArchivo(archivo.getRutaCarpetaPlantas(), "maiz");
            archivo.escribirEnArchivo(maiz, "maiz");
            archivo.escribirEnArchivo(maiz, "grano");
            archivo.escribirEnArchivo(maiz, "15");
            File manzano = archivo.crearArchivo(archivo.getRutaCarpetaPlantas(), "manzano");
            archivo.escribirEnArchivo(manzano, "manzano");
            archivo.escribirEnArchivo(manzano, "manzana");
            archivo.escribirEnArchivo(manzano, "30");
        } catch (ArchivoException e) {
            System.out.println("Hubo un error al crear las plantas predeterminadas porque " + e.getMessage());
        }
    }

}
