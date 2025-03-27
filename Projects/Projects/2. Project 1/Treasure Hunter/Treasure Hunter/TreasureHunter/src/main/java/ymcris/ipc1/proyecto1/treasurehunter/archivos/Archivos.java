/**
 * Paquete donde se implementan todos los métodos necesarios para trabajar con archivos de texto
 */
package ymcris.ipc1.proyecto1.treasurehunter.archivos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * Clase Archivos es la clase encargada de crear, leer y escribir en archivos de
 * texto los valores necesarios para la persistencia del programa
 *
 * @author YmCris
 * @since Mar 23, 2025
 */
public class Archivos {

    // ----------------------- VARIABLES DE REFERENCIA -------------------------
    public static File carpetaMapas;
    public static File carpetaPartidas;
    public static File carpetaJugadores;
    public static String rutaCarpetaMapas;
    public static String rutaCarpetaPartidas;
    public static String rutaCarpetaJugadores;
    public static String rutaProyecto = System.getProperty("user.dir");

    // ----------------------------- MÉTODOS -----------------------------------
    // --------------------- MÉTODOS SOBRE CARPETAS-----------------------------
    /**
     * Método encargado de crear las carpetas en donde se van a guardar los
     * mapas, jugadores y partidas.
     */
    public static void crearCarpetas() {
        //1. Crea la carpeta para los Mapas
        rutaCarpetaMapas = rutaProyecto + File.separator + "Mapas";
        carpetaMapas = new File(rutaCarpetaMapas);
        carpetaMapas.mkdirs();
        //1. Crea la carpeta para las Partidas
        rutaCarpetaPartidas = rutaProyecto + File.separator + "Partidas";
        carpetaPartidas = new File(rutaCarpetaPartidas);
        carpetaPartidas.mkdirs();
        //1. Crea la carpeta para los Jugadores
        rutaCarpetaJugadores = rutaProyecto + File.separator + "Jugadores";
        carpetaJugadores = new File(rutaCarpetaJugadores);
        carpetaJugadores.mkdirs();
    }

    /**
     * Método encargado de mostrar cuántos elementos se encuentran en una
     * carpeta
     *
     * @param rutaCarpeta - ruta de la carpeta de donde se límitarán los
     * archivos
     * @return cantidad de elementos en la carpeta
     */
    public static int obtenerCuantosElementosTieneUnaCarpeta(String rutaCarpeta) {
        File carpetaArchivos = new File(rutaCarpeta);
        String[] nombreDeArchivosEnCarpeta = carpetaArchivos.list();
        return nombreDeArchivosEnCarpeta.length;
    }

    /**
     * Método encargado de mostrar los archivos que existen en una carpeta (Como
     * para mostrar las partidas existentes o mapas existentes)
     *
     * @param ruta - ruta donde se extraerán todos los archivos
     */
    public static void mostrarArchivosEnCarpeta(String ruta) {
        File carpetaArchivos = new File(ruta);
        String[] nombreDeArchivosEnCarpeta = carpetaArchivos.list();
        System.out.println("");
        for (int i = 0; i < nombreDeArchivosEnCarpeta.length; i++) {
            System.out.print("[" + i + "]" + " ");
            if (nombreDeArchivosEnCarpeta[i].toLowerCase().endsWith(".txt")) {
                System.out.print(nombreDeArchivosEnCarpeta[i].substring(0, nombreDeArchivosEnCarpeta[i].length() - 4));
            }
            System.out.println("");
        }
    }

    //-------------------------- MÉTODOS SOBRE ARCHIVOS ------------------------
    /**
     * Método encargado de crear archivos de texto. Es decir va a crear los
     * archivos para: 1. Nuevo mapa 2. Nuevo jugador 3. Nueva partida
     *
     * @param nombreArchivo Nombre que tendrá el archivo
     * @param rutaCarpeta - ruta del lugar donde se va a guardar el archivo
     * @return archivo creado
     */
    public static File crearArchivo(String nombreArchivo, String rutaCarpeta) {
        try {
            File file = new File(rutaCarpeta + File.separator + nombreArchivo + ".txt");
            file.createNewFile();
            return file;
        } catch (IOException e) {
            System.out.println("No se pudo crear el archivo ");
        }
        return null;
    }

    /**
     * Método SUPER IMPORTANTE encargado de destruir archivos que no cuentan con
     * las líneas requeridas para el funcionamiento del programa, ya que un
     * archivo con menos líneas o más lineas de lo que se espera afecta todo el
     * programa haciendolo casi inservible
     *
     * @param rutaCarpetaArchivos - Ruta donde se evaluarán los archivos
     * @param numeroDeLineas - número de líneas que deben tener los archivos
     */
    public static void destructorDeArchivos(String rutaCarpetaArchivos, int numeroDeLineas) {
        File file = new File(rutaCarpetaArchivos);//0. crea la carpeta
        if (file.listFiles() != null) {
            File[] archivosExistentes = file.listFiles();//1. Obtener un arreglo de todos los archivos
            for (File archivosExistente : archivosExistentes) {//2. Recorrer cada uno de ellos
                if (obtenerCuantasLineasTieneUnArchivo(archivosExistente) == numeroDeLineas) {//3. Verificar si el número de líneas de esos archivos son los que deberían tener
                    //Todo en orden;
                } else {
                    System.out.println("Se ha eliminado el archivo: " + archivosExistente.getName() + " porque ha sido modificado");
                    archivosExistente.delete();
                }
            }
        }
    }

    /**
     * Método encargado de verificar si no existe un archivo con un nombre en
     * especifico en una carpeta
     *
     * @param rutaCarpeta - Carpeta donde se va a verificar si existe el archivo
     * @param nombreArchivo - nombre del archivo a verificar
     * @return true si existe
     */
    public static boolean existeElArchivoEnCarpeta(String rutaCarpeta, String nombreArchivo) {
        File file = new File(rutaCarpeta);
        File[] archivosEnCarpeta = file.listFiles();
        String nombreBuscado = nombreArchivo + ".txt";
        for (File archivosEnCarpeta1 : archivosEnCarpeta) {
            if (archivosEnCarpeta1.getName().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("No puedes usar ese nombre, porque que ya existe");
                System.out.println("Los nombres que no puedes tener son:");
                for (File file1 : archivosEnCarpeta) {
                    System.out.println(file1.getName().substring(0, file1.getName().length() - 4));
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Método encargado de eliminar un archivo de texto (Por si algo cae en un
     * catch)
     *
     * @param archivo - archivo a eliminar
     */
    public static void eliminarArchivo(File archivo) {
        if (archivo.exists()) {
            archivo.delete();
        }
    }

    /**
     * Método encargado de obtener cuantas líneas hay en un archivo de texto
     *
     * @param archivo - archivo en el cual se vana leer las líneas.
     * @return numero de líneas que yace en él.
     */
    public static int obtenerCuantasLineasTieneUnArchivo(File archivo) {
        int contador = 0;
        try (FileReader reader = new FileReader(archivo); BufferedReader leer = new BufferedReader(reader)) {
            while (leer.readLine() != null) {
                contador++;
            }
        } catch (Exception e) {
        }
        return contador;
    }

    /**
     * Método encargado de elegir un archivo de texto en especifico (para
     * modificarlo luego, como los mapas)
     *
     * @param ruta - carpeta donde se va a encontrar el archivo
     * @param indice - posición donde se encuentra el archivo.
     * @return File - archivo a modificar o a utilizar.
     */
    public static File elegirArchivoDeTexto(String ruta, int indice) {
        try {
            File archivos = new File(ruta);
            File[] archivosDeTextoEnCarpeta = archivos.listFiles();
            return archivosDeTextoEnCarpeta[indice];
        } catch (Exception e) {
            System.out.println("No se ha podido devolber el archivo");
        }
        return null;
    }

    /**
     * Método encargado de obtener un arreglo de archivos de texto en base a la
     * ruta de una carpeta
     *
     * @param rutaCarpeta - ruta donde se encuentran los archivos
     * @return arreglo de todos los archivos en una carpeta
     */
    public static File[] obtenerArregloDeArchivosDeUnaCarpeta(String rutaCarpeta) {
        File[] arregloDeArchivos;
        try {
            File carpeta = new File(rutaCarpeta);
            arregloDeArchivos = carpeta.listFiles();
            return arregloDeArchivos;
        } catch (Exception e) {
            System.out.println("No se ha podido obtener el número de archivos en una carpeta");
        }
        return null;
    }

    //-------------------- MÉTODOS PARA ESCRIBIR EN ARCHIVOS -------------------
    /**
     * Método encargado de añadir texto en un archivo ya existente (Osea para
     * añadir los atributos del mapa, aventurero o partida al a su respectivo
     * archivo)
     *
     * @param textoAAñadir - Texto a agregar en el archivo de texto
     * @param file - Archivo de texto en el cual se escribirá
     */
    public static void añadirTextoEnArchivo(String textoAAñadir, File file) {
        try (FileWriter write = new FileWriter(file, true); BufferedWriter escribir = new BufferedWriter(write);) {
            escribir.write(textoAAñadir);
            escribir.newLine();
            escribir.flush();
        } catch (IOException ex) {
            System.out.println("Ha habido un problema al escribir en el archivo " + file.getName());
        }
    }

    /**
     * Método encargado de sobreescribir una línea de texto en el archivo basado
     * en su posición (parámetro indice) (Basicamente para modificar los mapas
     * (y casillas))
     *
     * @param textoASobreescribir - texto que remplazará la linea del índice
     * @param file - archivo sobre el cual se va a editar la línea
     * @param indice - posición de la línea a editar
     */
    public static void sobreEscribirUnaLineaDeArchivo(String textoASobreescribir, File file, int indice) {
        try {
            int numeroDeLineas = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {//1. Leer el archivo para saber cuantas lineas tiene
                while (reader.readLine() != null) {
                    numeroDeLineas++;
                }
            }
            String[] contenidoArchivo = new String[numeroDeLineas];
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {// 2. Guardar todas las líneas en un array de Strings
                for (int i = 0; i < numeroDeLineas; i++) {
                    contenidoArchivo[i] = reader.readLine();
                }
            }
            if (indice < 0 || indice >= numeroDeLineas) {// 3. Verificar si el índice es válido
                System.out.println("El índice especificado está fuera de rango.");
                return;
            }
            // 4. Modificar la línea en la posición indicada
            contenidoArchivo[indice] = textoASobreescribir;
            try (BufferedWriter escribir = new BufferedWriter(new FileWriter(file))) {// 5. Escribir nuevamente el archivo con las líneas actualizadas
                for (int i = 0; i < numeroDeLineas; i++) {
                    escribir.write(contenidoArchivo[i]);
                    escribir.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al modificar el archivo: " + e.getMessage());
        }
    }
    //---------------------- MÉTODOS PARA LEER EN ARCHIVOS ---------------------

    /**
     * Método encargado de retornar una línea específica de un archivo de texto
     * para usarla (Usar atributos guardados en los archivos, como para usar
     * mapas ya creados)
     *
     * @param file - archivo en el cual se va a obtener la línea.
     * @param linea - línea de donde se quiere obtener esa información
     * @return String de la línea
     */
    public static String obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(File file, int linea) {
        try (BufferedReader leer = new BufferedReader(new FileReader(file))) {
            String valor;
            int contador = 0;
            while ((valor = leer.readLine()) != null) {
                if (contador == linea) {
                    return valor;
                }
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;
    }
}
