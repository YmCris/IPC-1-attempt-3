package ymcris.ipc1.proyecto1.treasurehunter.reportes;

import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;
import ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.ROJO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.rutaCarpetaJugadores;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.mostrarOpcionesReportes;
import static ymcris.ipc1.proyecto1.treasurehunter.exception.EntradaNoValidaException.errorEncontrado;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.obtenerArregloDeArchivosDeUnaCarpeta;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.obtenerUnaLineaDeUnArchivoDeTextoConUnIndice;

/**
 * Clase Reportes es la clase encargada de mostrar al jugador distintos datos
 * guardados de interes
 *
 * @author YmCris
 * @since Mar 25, 2025
 */
public class Reportes {

    // --------------------- VARIABLES DE REFERENCIA ---------------------------
    private File[] todosLosJugadores;

    // ---------------------------- INSTANCIAS ---------------------------------
    Scanner scanner = new Scanner(System.in);

    // ------------------------ MÉTODO CONSTRUCTOR -----------------------------
    public Reportes() {
        this.todosLosJugadores = obtenerArregloDeArchivosDeUnaCarpeta(rutaCarpetaJugadores);
    }

    // ----------------------------- MÉTODOS -----------------------------------
    /**
     * Método encargado de solicitar las opciones de los reportes
     */
    public void solicitarOpcionReportes() {
        int opcionReportes = 0;
        do {
            try {
                mostrarOpcionesReportes();
                opcionReportes = scanner.nextInt();
                scanner.nextLine();
                switch (opcionReportes) {
                    case 1 ->
                        verJugadoresGanadoresDeFormaDescendente();
                    case 2 ->
                        verJugadoresGanadoresDeFormaAscendente();
                    case 3 ->
                        verJugadoresPerdedores();
                    case 4 ->
                        new TreasureHunter().verMenuPrincipal();
                    case 5 ->
                        System.exit(0);
                    default -> {
                        System.out.println("Elige una opción entre [1-5]");
                        System.out.println("Presiona enter para continuar");
                        scanner.nextLine();
                    }
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Debes colocar un número");
                errorEncontrado();
            }
        } while (opcionReportes <= 0 || opcionReportes > 5);
        System.out.println("Presiona:");
        System.out.println("[1] Para seguir visualizando reportes");
        System.out.println("[2] Para regresar al menú principal");
        boolean opcion = scanner.nextLine().equals("1");
        if (opcion) {
            solicitarOpcionReportes();
        } else {
            new TreasureHunter().verMenuPrincipal();
        }
    }

    /**
     * Método encargado de mostrar todos los jugadores que han ganado una
     * partida ordenados de forma ascendente según el número de movimientos
     */
    private void verJugadoresGanadoresDeFormaAscendente() {//0 Nombre //1 si ha ganado (Encontro el tesoro) //2. numero de movimientos //3. Cantidad de combates //4. combates ganados //5. combates perdidos //6. combates huidos
        System.out.println("\n".repeat(100));
        if (obtenerArregloDeArchivosDeUnaCarpeta(rutaCarpetaJugadores).length == 0) {
            System.out.println("No has jugado ninguna partida, juega una partida y luego regresa");
        } else {
            //1. saber todo el tamaño del arreglo
            int tamañoArreglo = 0;
            for (File todosLosJugadore : todosLosJugadores) {//Recorre todos los archivos en la carpeta
                if (obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(todosLosJugadore, 1).equals("true")) {//Verifica si han ganado
                    tamañoArreglo++;
                }
            }
            File[] jugadoresGanadores = new File[tamañoArreglo];//Crea el arreglo de juadores
            //2. Leer los archivos de texto y verificar si han ganado y los guarda en el arreglo
            int indice = 0;
            for (File todosLosJugadore : todosLosJugadores) {//Recorre todos los archivos en la carpeta
                if (obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(todosLosJugadore, 1).equals("true")) {//Verifica si han ganado
                    //3. Almacenar todos los archivos de los jugadores ganadores de texto en un arreglo de jugadores ganadores
                    jugadoresGanadores[indice] = todosLosJugadore;
                    indice++;
                }
            }
            //4. Ordenar el arreglo de jugadores ganadores en base a sus movimientos (De Manera ascendente)
            File[] arregloOrdenado = ordenarAscendentementePorBurbuja(jugadoresGanadores);
            //5. Leer el arreglo posición en posición impriFmiendo las primeras 6 líneas (ahí se colocarán todo lo requerido)
            System.out.println(ROJO + "                       Estos son los jugadores ganadores ordenados según su cantidad de movimientos de manera ascendente:" + RESETEAR + "");
            System.out.println("");
            for (int i = 0; i < arregloOrdenado.length; i++) {
                System.out.println("┌----------------------------------------------------------------------------------------------------------------------------------------------------" + "");
                System.out.print("|" + (i + 1) + "| " + "Jugador: ");
                System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(arregloOrdenado[i], 0));
                System.out.print("| Número de movimientos: " + "");
                System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(arregloOrdenado[i], 2));
                System.out.print("| Cantidad de combates: " + "");
                System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(arregloOrdenado[i], 3));
                System.out.print("| Combates ganados: " + "");
                System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(arregloOrdenado[i], 4));
                System.out.print("| Combates perdidos: " + "");
                System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(arregloOrdenado[i], 5));
                System.out.print("| Combates huidos: " + "");
                System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(arregloOrdenado[i], 6));
                System.out.println("");
            }
            System.out.println("└----------------------------------------------------------------------------------------------------------------------------------------------------" + "");
        }
    }

    /**
     * Método encargado de mostrar todos los jugadores que han ganado una
     * partida ordenados de forma descendente según el número de movimientos
     */
    private void verJugadoresGanadoresDeFormaDescendente() {//Literalmente lo unico que cambia es el método de ordenamiento
        System.out.println("\n".repeat(100));
        if (obtenerArregloDeArchivosDeUnaCarpeta(rutaCarpetaJugadores).length == 0) {
            System.out.println("No has jugado ninguna partida, juega una partida y luego regresa");
        } else {
            //1. saber todo el tamaño del arreglo
            int tamañoArreglo = 0;
            for (File todosLosJugadore : todosLosJugadores) {//Recorre todos los archivos en la carpeta
                if (obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(todosLosJugadore, 1).equals("true")) {//Verifica si han ganado
                    tamañoArreglo++;
                }
            }
            File[] jugadoresGanadores = new File[tamañoArreglo];//Crea el arreglo con el tamaño correcto
            //2. Leer los archivos de texto y verificar si han ganado
            int indice = 0;
            for (File todosLosJugadore : todosLosJugadores) {//Recorre todos los archivos en la carpeta
                if (obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(todosLosJugadore, 1).equals("true")) {//Verifica si han ganado
                    //3. Almacenar todos los archivos de los jugadores ganadores de texto en un arreglo de jugadores ganadores
                    jugadoresGanadores[indice] = todosLosJugadore;
                    indice++;
                }
            }
            //4. Ordenar el arreglo de jugadores ganadores en base a sus movimientos (De Manera descendiente)
            File[] arregloOrdenado = ordenarDescendentementePorBurbuja(jugadoresGanadores);
            //5. Leer el arreglo posición en posición imprimiendo las primeras 6 líneas (ahí se colocarán todo lo requerido)
            System.out.println(ROJO + "                       Estos son los jugadores ganadores ordenados según su cantidad de movimientos de manera descendente:" + RESETEAR + "");
            System.out.println("");
            for (int i = 0; i < arregloOrdenado.length; i++) {
                System.out.println("┌----------------------------------------------------------------------------------------------------------------------------------------------------" + "");
                System.out.print("|" + (i + 1) + "| " + "Jugador: ");
                System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(arregloOrdenado[i], 0));
                System.out.print("| Número de movimientos: " + "");
                System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(arregloOrdenado[i], 2));
                System.out.print("| Cantidad de combates: " + "");
                System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(arregloOrdenado[i], 3));
                System.out.print("| Combates ganados: " + "");
                System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(arregloOrdenado[i], 4));
                System.out.print("| Combates perdidos: " + "");
                System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(arregloOrdenado[i], 5));
                System.out.print("| Combates huidos: " + "");
                System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(arregloOrdenado[i], 6));
                System.out.println("");
            }
            System.out.println("└----------------------------------------------------------------------------------------------------------------------------------------------------" + "");
        }
    }

    /**
     * Método encargado mostrar toda la información requerida de los jugadores
     * que perdieron una partida
     */
    private void verJugadoresPerdedores() {//0 Nombre //1 si ha ganado //2. numero de movimientos //3. Cantidad de combates //4. combates ganados //5. combates perdidos //6. combates huidos//7. Ha perdido(Se ha quedado sin vida por trampas o penalizaciones)
        System.out.println("\n".repeat(100));
        //1. Saber el tamaño del arreglo de juadores perdedores
        int tamañoArreglo = 0;
        for (File todosLosJugadore : todosLosJugadores) {
            if (obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(todosLosJugadore, 7).equals("true")) {
                tamañoArreglo++;
            }
        }
        //2. crear el arreglo de jugadores perdedores
        File[] jugadoresPerdedores = new File[tamañoArreglo];
        //3 Leer cada archivo y ver si en la línea 7 es true (Ha perdido)
        int contadorDeJugadoresPerdedores = 0;
        for (File todosLosJugadore : todosLosJugadores) {
            if (obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(todosLosJugadore, 7).equals("true")) {//Han perdido
                //4 Guardarlo en un arreglo de tipo file jugadoresPerdedores
                jugadoresPerdedores[contadorDeJugadoresPerdedores] = todosLosJugadore;
                contadorDeJugadoresPerdedores++;
            }
        }
        //5. Mostrar los jugadores con su información
        System.out.println(ROJO + "                                            Estos son los jugadores que han perdido una partida:" + RESETEAR + "");
        System.out.println("");
        for (int i = 0; i < jugadoresPerdedores.length; i++) {
            System.out.println("┌----------------------------------------------------------------------------------------------------------------------------------------------------" + "");
            System.out.print("|" + (i + 1) + "| " + "Jugador: ");
            System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(jugadoresPerdedores[i], 0));
            System.out.print("| Número de movimientos: " + "");
            System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(jugadoresPerdedores[i], 2));
            System.out.print("| Cantidad de combates: " + "");
            System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(jugadoresPerdedores[i], 3));
            System.out.print("| Combates ganados: " + "");
            System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(jugadoresPerdedores[i], 4));
            System.out.print("| Combates perdidos: " + "");
            System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(jugadoresPerdedores[i], 5));
            System.out.print("| Combates huidos: " + "");
            System.out.print(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(jugadoresPerdedores[i], 6));
            System.out.println("");
        }
        System.out.println("└----------------------------------------------------------------------------------------------------------------------------------------------------" + "");
    }

    /**
     * Método de ordenamiento burbuja encargado de editar un arreglo y
     * devolverlo ordenado ascendentemente
     *
     * @param arregloAOrdenar - Arreglo de archivos a ordenar
     * @return arreglo ordenado en base a la cantidad de movimientos
     */
    private File[] ordenarAscendentementePorBurbuja(File[] arregloAOrdenar) {
        if (arregloAOrdenar.length == 1) {
            return arregloAOrdenar;
        } else {
            int inicio = 0;
            int fin = arregloAOrdenar.length - 1;
            boolean hayCambio;
            do {
                hayCambio = false;
                for (int i = inicio; i < fin; i++) {
                    File elemento1 = arregloAOrdenar[i];
                    File elemento2 = arregloAOrdenar[i + 1];
                    if (Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(elemento1, 2)) > Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(elemento2, 2))) {
                        arregloAOrdenar[i] = elemento2;
                        arregloAOrdenar[i + 1] = elemento1;
                        hayCambio = true;
                    }
                }
            } while (hayCambio);
        }
        return arregloAOrdenar;
    }

    /**
     * Método de ordenamiento burbuja encargado de editar un arreglo y
     * devolverlo ordenado dsecendente
     *
     * @param arregloAOrdenar - Arreglo de archivos a ordenar
     * @return arreglo ordenado en base a la cantidad de movimientos
     */
    private File[] ordenarDescendentementePorBurbuja(File[] arregloAOrdenar) {
        if (arregloAOrdenar.length == 1) {
            return arregloAOrdenar;
        } else {
            int inicio = 0;
            int fin = arregloAOrdenar.length - 1;
            boolean hayCambio;
            do {
                hayCambio = false;
                for (int i = inicio; i < fin; i++) {
                    File elemento1 = arregloAOrdenar[i];
                    File elemento2 = arregloAOrdenar[i + 1];
                    if (Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(elemento1, 2)) < Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(elemento2, 2))) {
                        arregloAOrdenar[i] = elemento2;
                        arregloAOrdenar[i + 1] = elemento1;
                        hayCambio = true;
                    }
                }
            } while (hayCambio);
        }
        return arregloAOrdenar;
    }

}
