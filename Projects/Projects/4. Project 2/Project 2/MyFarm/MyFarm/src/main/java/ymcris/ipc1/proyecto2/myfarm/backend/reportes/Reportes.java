package ymcris.ipc1.proyecto2.myfarm.backend.reportes;

import java.io.File;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios.ArchivosBinarios;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Archivos;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ArchivoException;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granja.Granja;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;

/**
 * Clase Reportes es la clase encargada de brindar los reportes solicitados al
 * usuario.
 *
 * @author YmCris
 * @since May 12, 2025
 */
public final class Reportes {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private File reportesPartidas;
    private File reportesAnimales;
    private File reportesPlantas;
    private Granja[] granja;
    private Animales[] animales;
    private Semillas[] semillas;

    // INSTANCIAS --------------------------------------------------------------
    Archivos archivos = new Archivos();
    ArchivosBinarios binarios = new ArchivosBinarios();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Reportes() {
        crearReportePartidas();
        this.animales = binarios.obtenerAnimales();
        this.granja = binarios.obtenerPartidas();
        this.semillas = binarios.obtenerSemillas();
        //crearReportes();
        modificarTodosLosReportesPartidas();
        //modificarTodosLosReportesAnimales();
        //modificarTodosLosReportesSemillas();
    }

    private void crearReportes() {
        for (Animales animal : animales) {
            archivos.escribirEnArchivoDeTexto(reportesAnimales, animal.getNombre());
            archivos.escribirEnArchivoDeTexto(reportesAnimales, String.valueOf(animal.getCriasCompradas()));
            archivos.escribirEnArchivoDeTexto(reportesAnimales, String.valueOf(animal.getVecesDestazado()));
        }
        for (Semillas semilla : semillas) {
            archivos.escribirEnArchivoDeTexto(reportesPlantas, semilla.getNombre());
            archivos.escribirEnArchivoDeTexto(reportesPlantas, String.valueOf(semilla.getSemillasAdquiridas()));
            archivos.escribirEnArchivoDeTexto(reportesPlantas, String.valueOf(semilla.getCeldasDeTerrenoSembradas()));
        }
    }

    private void crearReportePartidas() {
        try {
            reportesPartidas = archivos.crearArchivoDeTexto(archivos.getRutaCarpetaReportes(), "Reportes Partidas");
            reportesAnimales = archivos.crearArchivoDeTexto(archivos.getRutaCarpetaReportes(), "Reportes Animales");
            reportesPlantas = archivos.crearArchivoDeTexto(archivos.getRutaCarpetaReportes(), "Reportes Plantas");
        } catch (ArchivoException ex) {
            System.out.println("No se ha podido crear los archivos porque " + ex.getMessage());
        }
    }

    private void modificarTodosLosReportesPartidas() {
        for (Granja g : granja) {
            String nombre = g.getNombre();
            int duracion = g.getTiempoJugado();
            int oro = g.getOroGenerado();
            int alimentoGenerado = g.getAlimentoGenerado();
            int alimentoConsumido = g.getAlimentoConsumido();
            agregarContenidoAlReportePartidas(nombre, duracion, oro, alimentoGenerado, alimentoConsumido);
        }
    }

    private void modificarTodosLosReportesAnimales() {
        try {
            for (Animales animal : animales) {
                int criasCompradas = animal.getCriasCompradas();
                int vecesDestazado = animal.getVecesDestazado();
                agregarContenidoAlReporteAnimales(criasCompradas, vecesDestazado);
            }
        } catch (ArchivoException ex) {
            System.out.println("Ha ocurrido un error al modificar los reporetes de los animales porque " + ex.getMessage());
        }
    }

    private void modificarTodosLosReportesSemillas() {
        try {
            for (Semillas semilla : semillas) {
                int semillasAdquiridas = semilla.getSemillasAdquiridas();
                int celdasDeTerrenoSembradas = semilla.getCeldasDeTerrenoSembradas();
                agregarContenidoAlReporteSemillas(semillasAdquiridas, celdasDeTerrenoSembradas);
            }
        } catch (ArchivoException e) {
            System.out.println("Ha ocurrido un error al modificar los reporetes de las semillas porque " + e.getMessage());
        }
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    private void agregarContenidoAlReportePartidas(String nombreGranjero, int duracionPartida, int oroGenerado, int alimentoGenerado, int alimentoConsumido) {
        archivos.escribirEnArchivoDeTexto(reportesPartidas, "--------------------------------- PARTIDA DE " + nombreGranjero + " ---------------------------------");
        archivos.escribirEnArchivoDeTexto(reportesPartidas, "Nombre del Granjero: " + nombreGranjero);
        archivos.escribirEnArchivoDeTexto(reportesPartidas, String.valueOf("Duración de la partida: " + duracionPartida));
        archivos.escribirEnArchivoDeTexto(reportesPartidas, String.valueOf("Oro Generado: " + oroGenerado));
        archivos.escribirEnArchivoDeTexto(reportesPartidas, String.valueOf("Alimento Generado: " + alimentoGenerado));
        archivos.escribirEnArchivoDeTexto(reportesPartidas, String.valueOf("Alimento Consumido: " + alimentoConsumido));
    }

    private void agregarContenidoAlReporteAnimales(int criasCompradas, int vecesDestazado) throws ArchivoException {
        int[] numeros = new int[(animales.length * 2) + 1];
        int indice = 1;
        int condicion = 3;
        int elementosAgregados = 0;
        while (elementosAgregados < numeros.length - 1) {
            for (int j = indice; j < condicion; j++) {
                System.out.println("numeros: " + (j - 1) + " linea: " + j);
                numeros[j - 1] = Integer.parseInt(archivos.leerArchivoDeTexto(reportesAnimales, j));
                elementosAgregados++;
            }
            indice = indice + 3;
            condicion = condicion + 3;
        }
        System.out.println("holas");
        binarios.eliminarArchivo(archivos.getRutaCarpetaReportes(), "Reportes Animales");
        archivos.crearArchivoDeTexto(archivos.getRutaCarpetaReportes(), "Reportes Animales");
        int indice2 = 1;
        int condicion2 = 3;
        int elementosAgregados2 = 0;
        while (elementosAgregados2 < numeros.length - 1) {
            for (int i = indice2; i < condicion2; i++) {
                System.out.println("nombre: " + (i - 1) + " valor 1: " + i + " valor 2 " + (i + 1));
                elementosAgregados2++;
                archivos.escribirEnArchivoDeTexto(reportesAnimales, String.valueOf(animales[i - 1].getNombre()));
                archivos.escribirEnArchivoDeTexto(reportesAnimales, String.valueOf(numeros[i] + criasCompradas));
                archivos.escribirEnArchivoDeTexto(reportesAnimales, String.valueOf(numeros[i + 1] + vecesDestazado));
            }
            indice2 = indice2 + 3;
            condicion2 = condicion2 + 3;
        }
        System.out.println("todo termina como debería terminar");
    }

    private void agregarContenidoAlReporteSemillas(int semillasAdquiridas, int celdasDeTerrenoSembradas) throws ArchivoException {
        int[] numeros = new int[(semillas.length * 2) + 1];
        int indice = 1;
        int condicion = 3;
        int elementosAgregados = 0;
        while (elementosAgregados < numeros.length) {
            for (int j = indice; j < condicion; j++) {
                System.out.println("numeros: " + (j - 1) + " linea: " + j);
                numeros[j - 1] = Integer.parseInt(archivos.leerArchivoDeTexto(reportesPlantas, j));
                elementosAgregados++;
            }
            indice = indice + 3;
            condicion = condicion + 3;
        }
        binarios.eliminarArchivo(archivos.getRutaCarpetaReportes(), "Reportes Plantas");
        archivos.crearArchivoDeTexto(archivos.getRutaCarpetaReportes(), "Reportes Plantas");
        int elementosAgregados2 = 0;
        int indice2 = 1;
        int condicion2 = 3;
        while (elementosAgregados2 < numeros.length) {
            for (int i = indice2; i < condicion2; i++) {
                elementosAgregados2++;
                archivos.escribirEnArchivoDeTexto(reportesPlantas, String.valueOf(semillas[i - 1].getNombre()));
                archivos.escribirEnArchivoDeTexto(reportesPlantas, String.valueOf(numeros[i] + semillasAdquiridas));
                archivos.escribirEnArchivoDeTexto(reportesPlantas, String.valueOf(numeros[i + 1] + celdasDeTerrenoSembradas));
            }
            indice2 = indice2 + 1;
            condicion2 = condicion2 + 3;
        }
        System.out.println("todo termina como debería terminar");
    }

    public File getReportesPartidas() {
        return reportesPartidas;
    }

    public File getReportesAnimales() {
        return reportesAnimales;
    }

    public File getReportesPlantas() {
        return reportesPlantas;
    }

}
