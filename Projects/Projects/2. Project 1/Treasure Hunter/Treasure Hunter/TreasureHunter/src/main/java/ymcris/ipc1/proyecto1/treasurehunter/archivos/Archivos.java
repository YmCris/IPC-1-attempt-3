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
    /**
     * Método encargado de crear las carpetas en donde se van a guardar los
     * mapas, jugadores y partidas.
     */
    public static void crearCarpetas() {
        //Mapas
        rutaCarpetaMapas = rutaProyecto + File.separator + "Mapas";
        carpetaMapas = new File(rutaCarpetaMapas);
        carpetaMapas.mkdirs();
        //Partidas
        rutaCarpetaPartidas = rutaProyecto + File.separator + "Partidas";
        carpetaPartidas = new File(rutaCarpetaPartidas);
        carpetaPartidas.mkdirs();
        //Jugadores
        rutaCarpetaJugadores = rutaProyecto + File.separator + "Jugadores";
        carpetaJugadores = new File(rutaCarpetaJugadores);
        carpetaJugadores.mkdirs();
    }

    //-------------------------- MÉTODOS SOBRE ARCHIVOS ------------------------
    /**
     * Método encargado de crear archivos de texto. Es decir va a crear los
     * archivos para: 1. Nuevo mapa 2. Nuevo jugador 3. Nueva partida
     *
     * @param nombreArchivo Nombre que tendrá el archivo
     * @param rutaCarpeta - ruta del lugar donde se va a guardar el archivo
     */
    public static void crearArchivo(String nombreArchivo, String rutaCarpeta) {
        try {
            File file = new File(rutaCarpeta + File.separator + nombreArchivo + ".txt");
            if (file.exists()) {
                System.out.println("El archivo ya existe");
                System.out.println("Su nombre es: " + file.getName());
            } else {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Ha habido un error al crear el archivo " + nombreArchivo + e.getMessage());
        }
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
        for (int i = 0; i < nombreDeArchivosEnCarpeta.length; i++) {
            System.out.print(i + " ");
            if (nombreDeArchivosEnCarpeta[i].toLowerCase().endsWith(".txt")) {
                System.out.print(nombreDeArchivosEnCarpeta[i].substring(0, nombreDeArchivosEnCarpeta[i].length() - 4));
            }
            System.out.println("");
        }
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
     * Método encargado de leer todo el contenido de un archivo de texto
     *
     * @param file - archivo del cual se va a leer.
     */
    public static void leerTodoElTextoDeUnArchivo(File file) {
        try (FileReader reader = new FileReader(file); BufferedReader read = new BufferedReader(reader);) {//Instancia un nuevo reader
            String valor;
            while ((valor = read.readLine()) != null) {
                System.out.println(valor);
            }
        } catch (IOException e) {
            System.out.println("Ha habido un error en la lectura del archivo");
        }
    }

    /**
     * Método encargado de leer todo el contenido de un archivo de texto con un
     * índice (algo así como para mostrarle al usuario qué va a editar)
     *
     * @param file
     */
    public static void mostrarTodoElTextoDeUnArchivoConIndice(File file) {
        try (FileReader reader = new FileReader(file); BufferedReader read = new BufferedReader(reader);) {//Instancia un nuevo reader
            String valor;
            int contador = 0;
            while ((valor = read.readLine()) != null) {
                System.out.print(contador + " ");
                System.out.print(valor);
                System.out.println("");
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Ha habido un error en la lectura del archivo");
        }
    }

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
