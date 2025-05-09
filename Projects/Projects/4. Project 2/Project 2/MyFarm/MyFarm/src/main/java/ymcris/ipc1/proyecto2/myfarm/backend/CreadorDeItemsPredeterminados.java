package ymcris.ipc1.proyecto2.myfarm.backend;

import java.io.File;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.ArchivosDeTexto;
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
            File pasto = archivo.crearArchivo(archivo.getRutaCarpetaAlimentosParaAnimales(), alimentoH1.getNombre());
            archivo.escribirEnArchivo(pasto, alimentoH1.getNombre());
            archivo.escribirEnArchivo(pasto, String.valueOf(alimentoH1.getPrecioDeVenta()));
            archivo.escribirEnArchivo(pasto, String.valueOf(alimentoH1.getPrecioDeCompra()));
            archivo.escribirEnArchivo(pasto, String.valueOf(alimentoH1.esParaHerbivoros()));
            File manzana = archivo.crearArchivo(archivo.getRutaCarpetaAlimentos(), alimentoH1.getNombre());
            archivo.escribirEnArchivo(manzana, alimentoH1.getNombre());
            archivo.escribirEnArchivo(manzana, String.valueOf(alimentoH1.getPrecioDeVenta()));
            archivo.escribirEnArchivo(manzana, String.valueOf(alimentoH1.getPrecioDeCompra()));
            archivo.escribirEnArchivo(manzana, String.valueOf(alimentoH1.esParaHerbivoros()));
            File zanahoria = archivo.crearArchivo(archivo.getRutaCarpetaAlimentosParaAnimales(), alimentoH2.getNombre());
            archivo.escribirEnArchivo(zanahoria, alimentoH2.getNombre());
            archivo.escribirEnArchivo(zanahoria, String.valueOf(alimentoH2.getPrecioDeVenta()));
            archivo.escribirEnArchivo(zanahoria, String.valueOf(alimentoH2.getPrecioDeCompra()));
            archivo.escribirEnArchivo(zanahoria, String.valueOf(alimentoH2.esParaHerbivoros()));
            File nueces = archivo.crearArchivo(archivo.getRutaCarpetaAlimentosParaAnimales(), alimentoH3.getNombre());
            archivo.escribirEnArchivo(nueces, alimentoH3.getNombre());
            archivo.escribirEnArchivo(nueces, String.valueOf(alimentoH3.getPrecioDeVenta()));
            archivo.escribirEnArchivo(nueces, String.valueOf(alimentoH3.getPrecioDeCompra()));
            archivo.escribirEnArchivo(nueces, String.valueOf(alimentoH3.esParaHerbivoros()));
            File granos = archivo.crearArchivo(archivo.getRutaCarpetaAlimentosParaAnimales(), alimentoO1.getNombre());
            archivo.escribirEnArchivo(granos, alimentoO1.getNombre());
            archivo.escribirEnArchivo(granos, String.valueOf(alimentoO1.getPrecioDeVenta()));
            archivo.escribirEnArchivo(granos, String.valueOf(alimentoO1.getPrecioDeCompra()));
            archivo.escribirEnArchivo(granos, String.valueOf(alimentoO1.esParaHerbivoros()));
            File granos1 = archivo.crearArchivo(archivo.getRutaCarpetaAlimentos(), alimentoO1.getNombre());
            archivo.escribirEnArchivo(granos1, alimentoO1.getNombre());
            archivo.escribirEnArchivo(granos1, String.valueOf(alimentoO1.getPrecioDeVenta()));
            archivo.escribirEnArchivo(granos1, String.valueOf(alimentoO1.getPrecioDeCompra()));
            archivo.escribirEnArchivo(granos1, String.valueOf(alimentoO1.esParaHerbivoros()));
            File huevos = archivo.crearArchivo(archivo.getRutaCarpetaAlimentosParaAnimales(), alimentoO2.getNombre());
            archivo.escribirEnArchivo(huevos, alimentoO2.getNombre());
            archivo.escribirEnArchivo(huevos, String.valueOf(alimentoO2.getPrecioDeVenta()));
            archivo.escribirEnArchivo(huevos, String.valueOf(alimentoO2.getPrecioDeCompra()));
            archivo.escribirEnArchivo(huevos, String.valueOf(alimentoO2.esParaHerbivoros()));
            File pollo = archivo.crearArchivo(archivo.getRutaCarpetaAlimentosParaAnimales(), alimentoO3.getNombre());
            archivo.escribirEnArchivo(pollo, alimentoO3.getNombre());
            archivo.escribirEnArchivo(pollo, String.valueOf(alimentoO3.getPrecioDeVenta()));
            archivo.escribirEnArchivo(pollo, String.valueOf(alimentoO3.getPrecioDeCompra()));
            archivo.escribirEnArchivo(pollo, String.valueOf(alimentoO3.esParaHerbivoros()));
        } catch (ArchivoException e) {
            System.out.println("Hubo un error al guardar los alimentos predeterminados porque " + e.getMessage());
        }

    }

    public void creadorDeAnimalesPredeterminados() {
        Herbivoros vaca = new Herbivoros("vaca", 500, 2, 600, true, true, true);
        Omnivoros gallina = new Omnivoros("gallina", 50, 0.5, 180, false, true, true);
        try {
            File archivoVaca = archivo.crearArchivo(archivo.getRutaCarpetaAnimales(), vaca.getNombre());
            archivo.escribirEnArchivo(archivoVaca, vaca.getNombre());
            archivo.escribirEnArchivo(archivoVaca, String.valueOf(vaca.getPrecio()));
            archivo.escribirEnArchivo(archivoVaca, String.valueOf(vaca.getEspacio()));
            archivo.escribirEnArchivo(archivoVaca, String.valueOf(vaca.getEdadMaxima()));
            archivo.escribirEnArchivo(archivoVaca, String.valueOf(vaca.isEsHerbivoro()));
            archivo.escribirEnArchivo(archivoVaca, String.valueOf(vaca.isEsDestazable()));
            archivo.escribirEnArchivo(archivoVaca, String.valueOf(vaca.isProduciraProductosConDestace()));
            File archivoGalllina = archivo.crearArchivo(archivo.getRutaCarpetaAnimales(), gallina.getNombre());
            archivo.escribirEnArchivo(archivoGalllina, gallina.getNombre());
            archivo.escribirEnArchivo(archivoGalllina, String.valueOf(gallina.getPrecio()));
            archivo.escribirEnArchivo(archivoGalllina, String.valueOf(gallina.getEspacio()));
            archivo.escribirEnArchivo(archivoGalllina, String.valueOf(gallina.getEdadMaxima()));
            archivo.escribirEnArchivo(archivoGalllina, String.valueOf(gallina.isEsHerbivoro()));
            archivo.escribirEnArchivo(archivoGalllina, String.valueOf(gallina.isEsDestazable()));
            archivo.escribirEnArchivo(archivoGalllina, String.valueOf(gallina.isProduciraProductosConDestace()));
        } catch (ArchivoException e) {
            System.out.println("No se pudieron guardar los animales predeterminados porque " + e.getMessage());
        }
    }

    public void creadorDeSemillasPredeterminadas() {
        Semillas semillaMaiz = new Semillas("maiz", 50, false, 15, "grano");
        Semillas semillaFruta = new Semillas("manzano", 100, true, 25, "manzana");
        try {
            File maiz = archivo.crearArchivo(archivo.getRutaCarpetaSemillas(), semillaMaiz.getNombre());
            archivo.escribirEnArchivo(maiz, semillaMaiz.getNombre());
            archivo.escribirEnArchivo(maiz, String.valueOf(semillaMaiz.getPrecio()));
            archivo.escribirEnArchivo(maiz, String.valueOf(semillaMaiz.isProduceFruta()));
            archivo.escribirEnArchivo(maiz, String.valueOf(semillaMaiz.getCantidadDeSemillasRequerida()));
            archivo.escribirEnArchivo(maiz, String.valueOf(semillaMaiz.getAlimento().getNombre()));
            File manzano = archivo.crearArchivo(archivo.getRutaCarpetaSemillas(), semillaFruta.getNombre());
            archivo.escribirEnArchivo(manzano, semillaFruta.getNombre());
            archivo.escribirEnArchivo(manzano, String.valueOf(semillaFruta.getPrecio()));
            archivo.escribirEnArchivo(manzano, String.valueOf(semillaFruta.isProduceFruta()));
            archivo.escribirEnArchivo(manzano, String.valueOf(semillaFruta.getCantidadDeSemillasRequerida()));
            archivo.escribirEnArchivo(manzano, String.valueOf(semillaFruta.getAlimento().getNombre()));
        } catch (ArchivoException e) {
            System.out.println("Hubo un error al crear las semillas predeterminadas porque " + e.getMessage());
        }
    }

    public void creadorDeProductosPredeterminados() {
        MateriasPrimas cuero = new MateriasPrimas("cuero", 50, 50);
        Alimentos carne = new Alimentos("carne", 60, 80, false);
        Alimentos leche = new Alimentos("leche", 15, 12, false);
        Alimentos huevo = new Alimentos("huevo", 5, 10, false);
        try {
            File archivo1 = archivo.crearArchivo(archivo.getRutaCarpetaMateriaPrima(), cuero.getNombre());
            archivo.escribirEnArchivo(archivo1, String.valueOf(cuero.getNombre()));
            archivo.escribirEnArchivo(archivo1, String.valueOf(cuero.getPrecioDeVenta()));
            archivo.escribirEnArchivo(archivo1, String.valueOf(cuero.getPrecioDeCompra()));
            File archivo2 = archivo.crearArchivo(archivo.getRutaCarpetaAlimentos(), carne.getNombre());
            archivo.escribirEnArchivo(archivo2, String.valueOf(carne.getNombre()));
            archivo.escribirEnArchivo(archivo2, String.valueOf(carne.getPrecioDeVenta()));
            archivo.escribirEnArchivo(archivo2, String.valueOf(carne.getPrecioDeCompra()));
            archivo.escribirEnArchivo(archivo2, String.valueOf(carne.esParaHerbivoros()));
            File archivo3 = archivo.crearArchivo(archivo.getRutaCarpetaAlimentos(), leche.getNombre());
            archivo.escribirEnArchivo(archivo3, String.valueOf(leche.getNombre()));
            archivo.escribirEnArchivo(archivo3, String.valueOf(leche.getPrecioDeVenta()));
            archivo.escribirEnArchivo(archivo3, String.valueOf(leche.getPrecioDeCompra()));
            archivo.escribirEnArchivo(archivo3, String.valueOf(leche.esParaHerbivoros()));
            File archivo4 = archivo.crearArchivo(archivo.getRutaCarpetaAlimentos(), huevo.getNombre());
            archivo.escribirEnArchivo(archivo4, String.valueOf(huevo.getNombre()));
            archivo.escribirEnArchivo(archivo4, String.valueOf(huevo.getPrecioDeVenta()));
            archivo.escribirEnArchivo(archivo4, String.valueOf(huevo.getPrecioDeCompra()));
            archivo.escribirEnArchivo(archivo4, String.valueOf(huevo.esParaHerbivoros()));
        } catch (ArchivoException e) {
            System.out.println("Hubo un error al crear los productos predeterminados porque " + e.getMessage());
        }
    }

}
