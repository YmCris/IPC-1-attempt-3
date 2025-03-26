package ymcris.ipc1.proyecto1.treasurehunter;

import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.Mapas;
import ymcris.ipc1.proyecto1.treasurehunter.ayuda.ComoJugar;
import ymcris.ipc1.proyecto1.treasurehunter.partida.Partida;
import ymcris.ipc1.proyecto1.treasurehunter.reportes.Reportes;
import ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.DiseñarMapas;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.EditorDeMapas;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.RecreadorDeMapas;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.ROJO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.crearArchivo;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.crearCarpetas;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.rutaCarpetaMapas;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.mostrarBienvenida;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.rutaCarpetaPartidas;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.rutaCarpetaJugadores;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.elegirArchivoDeTexto;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.añadirTextoEnArchivo;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.mostrarMenuPrincipal;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.mostrarArchivosEnCarpeta;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.existeElArchivoEnCarpeta;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.mostrarOpcionesIniciarPartida;
import static ymcris.ipc1.proyecto1.treasurehunter.exception.EntradaNoValidaException.errorEncontrado;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.obtenerCuantosElementosTieneUnaCarpeta;
import ymcris.ipc1.proyecto1.treasurehunter.partida.RecreadorDePartida;

/**
 * Clase Treasure Hunter es la clase Main, encargada de dar inicio al programa y
 * proporcionar las opciones del programa.
 *
 * @author YmCris
 * @version 21.0.5
 * @since 03/09/2025
 */
public class TreasureHunter {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    public static Aventurero aventurero;//¿Por qué es estático, no sé, pero así funciona?

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int opcionMapas = 0;
    private int opcionMenuPrincipal = 0;

    // INSTANCIAS --------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);

    // MÉTODO MAIN -------------------------------------------------------------
    /**
     * Método main encargado de iniciar el programa.
     *
     * @param args - paramétros para iniciar directamente en el jar
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        crearCarpetas();
        mostrarBienvenida();
        scanner.nextLine();
        while (true) {
            new TreasureHunter().verMenuPrincipal();
        }
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de mostrar el menú principal y evitar los errores que
     * esté pueda cometer
     */
    public void verMenuPrincipal() {
        do {//Por si introduce un número que no es
            mostrarMenuPrincipal();
            try {//por si introduce un string
                opcionMenuPrincipal = scanner.nextInt();
            } catch (InputMismatchException exception) {
                opcionMenuPrincipal = 8;
            }
            switch (opcionMenuPrincipal) {//Opciones dentro del juego
                case 1 -> //Como jugar el Treasure Hunter
                    new ComoJugar().enseñarAJugar();
                case 2 -> //Jugar una nueva partida
                    iniciarNuevaPartida();
                case 3 -> //Jugar una partida existente
                    elegirPartidaExistente();
                case 4 -> //Modifica un mapa ya existente
                    editarMapa();
                case 5 -> //Ver reportes del juego
                    new Reportes().solicitarOpcionReportes();
                case 6 -> //Sale del programa
                    System.exit(0);
                default -> {
                    errorEncontrado();
                    scanner.nextLine();
                }
            }
            //Opciones dentro del juego
        } while (opcionMenuPrincipal < 1 || opcionMenuPrincipal > 6);
    }

    /**
     * Método encargado de iniciar una nueva partida preguntando si juega con un
     * mapa ya existente o desea crear uno.
     */
    private void iniciarNuevaPartida() {
        do {//por si pone un número que no es
            mostrarOpcionesIniciarPartida();
            try {//En dado caso ponga un string
                opcionMapas = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcionMapas = 9;
            }
            switch (opcionMapas) {//Opciones al iniciar una nueva partida.
                case 1 -> //Juega con un mapa ya existente.
                    crearPartidaConUnMapaExistente();
                case 2 -> //Juega con un nuevo mapa.
                    crearPartidaConUnNuevoMapa();
                case 3 -> //vuelve al menu
                    verMenuPrincipal();
                case 4 -> //sale del programa
                    System.exit(0);
                default -> {
                    errorEncontrado();
                    scanner.nextLine();
                }
            }
            //Opciones al iniciar una nueva partida.
        } while (opcionMapas < 0 || opcionMapas >= 5);
    }

    /**
     * Método encargado de crear el jugador que estará activo durante la
     * partida, ya sea con un mapa previamente cargado o con uno nuevo.
     *
     * @return Aventurero - Aventurero del jugador.
     */
    private Aventurero crearJugador() {
        do {
            boolean todoEnOrden = true;
            System.out.println("\n".repeat(100));
            System.out.println(ROJO + "AVENTURERO" + RESETEAR);
            System.out.println("· INGRESE EL NOMBRE DEL NUEVO AVENTURERO:");
            String nombreAventurero = scanner.nextLine().toLowerCase();
            if (nombreAventurero.isBlank()) {
                todoEnOrden = false;
                System.out.println("No puedes tener un nombre vacío");
                errorEncontrado();
            }
            if (existeElArchivoEnCarpeta(rutaCarpetaJugadores, nombreAventurero) == true) {
                todoEnOrden = false;
                errorEncontrado();
            }
            if (todoEnOrden == true) {
                if (!nombreAventurero.isBlank() && existeElArchivoEnCarpeta(rutaCarpetaMapas, nombreAventurero) == false) {
                    File archivoJugador = crearArchivo(nombreAventurero, rutaCarpetaJugadores);
                    Aventurero nuevoAventurero = new Aventurero(nombreAventurero, false, 0, 0, 0, 0, 0, false, 250, 250, 250, 20, 20, 20, 100, 20, 20, 0, 0, archivoJugador);
                    nuevoAventurero.guardarAvanceEnArchivo();
                    return nuevoAventurero;
                }
            }
        } while (true);
    }

    private String pedirNombrePartida() {
        do {
            System.out.println("\n".repeat(100));
            System.out.println(ROJO + "PARTIDA" + RESETEAR);
            System.out.println("· INGRESE EL NOMBRE DE LA PARTIDA:");
            String nombrePartida = scanner.nextLine().toLowerCase();
            if (nombrePartida.isBlank()) {
                System.out.println("El nombre de la partida no puede estar en blanco");
                errorEncontrado();
            } else {
                if (existeElArchivoEnCarpeta(rutaCarpetaPartidas, nombrePartida) == true) {
                    errorEncontrado();
                } else {
                    return nombrePartida;
                }
            }
        } while (true);
    }

    private void crearPartidaConUnNuevoMapa() {
        scanner.nextLine();
        aventurero = crearJugador();//Crea el aventurero
        DiseñarMapas nuevoMapa = new DiseñarMapas();//Diseña el mapa a jugar
        Mapas mapa = nuevoMapa.preguntarCaracteristicasMapa();
        String nombrePartida = pedirNombrePartida();//Obtiene el nombre de la partida
        File archivoPartida = crearArchivo(nombrePartida, rutaCarpetaPartidas);//Crea ka partida en archivo
        añadirTextoEnArchivo(nombrePartida, archivoPartida);
        añadirTextoEnArchivo(mapa.getNombre(), archivoPartida);
        añadirTextoEnArchivo(aventurero.getNombre(), archivoPartida);
        Partida partida = new Partida(aventurero, mapa, nombrePartida);//Crea una nueva partida
        partida.iniciarNuevaPartida();//Inicia una nueva partida
    }

    private void crearPartidaConUnMapaExistente() {
        if (obtenerCuantosElementosTieneUnaCarpeta(rutaCarpetaMapas) <= 0) {//Verifica si tiene mapas creados.
            System.out.println("No tienes mapas creados");
            System.out.println("Presiona enter para regresar al menú principal:");
            scanner.nextLine();
            verMenuPrincipal();
        } else {//Si tiene mapas creados:
            System.out.println("\n".repeat(100));
            System.out.println(ROJO + "ELIJA SU MAPA:" + RESETEAR);
            System.out.println("· INGRESE EL NÚMERO EN EL QUE SE ENCUENTRA EL MAPA CON EL QUE DESEA JUGAR:");
            mostrarArchivosEnCarpeta(Archivos.rutaCarpetaMapas);
            int opcionArchivo = 0;
            try {
                opcionArchivo = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Debes introducir un valor numérico");
                errorEncontrado();
                scanner.nextLine();
                crearPartidaConUnMapaExistente();
            }
            if (opcionArchivo < 0 || opcionArchivo > obtenerCuantosElementosTieneUnaCarpeta(Archivos.rutaCarpetaMapas) - 1) {
                System.out.println("No existe ese archivo");
                errorEncontrado();
                crearPartidaConUnMapaExistente();
            } else {//Pasa todas las validaciones
                scanner.nextLine();
                aventurero = crearJugador();//Crea un aventurero
                String nombrePartidaNueva = pedirNombrePartida();//Pide el nombre de la partida
                File mapaElegido = Archivos.elegirArchivoDeTexto(Archivos.rutaCarpetaMapas, opcionArchivo);//Obtiene el archivo de la carpeta
                RecreadorDeMapas recreador = new RecreadorDeMapas(mapaElegido, aventurero);//Crea un recreador de mapas
                Mapas mapaYaExistente = recreador.recrearMapas();//Crea un mapa recreandolo desde el archivo mapaElegido
                File archivoPartida = crearArchivo(nombrePartidaNueva, rutaCarpetaPartidas);//Crea el archivo de la partida
                añadirTextoEnArchivo(nombrePartidaNueva, archivoPartida);
                añadirTextoEnArchivo(mapaYaExistente.getNombre(), archivoPartida);
                añadirTextoEnArchivo(aventurero.getNombre(), archivoPartida);
                Partida partida = new Partida(aventurero, mapaYaExistente, nombrePartidaNueva);//Crea una nueva partida
                partida.iniciarNuevaPartida();//Inicia una nueva partida
            }
        }
    }

    /**
     * Método encargado de realizar las validaciones correspondientes para
     * editar un mapa ya existente
     */
    private void editarMapa() {
        if (obtenerCuantosElementosTieneUnaCarpeta(rutaCarpetaMapas) > 0) {//Verifica si tiene mapas ya creados
            try {
                //1. Mostrar todos los mapas
                mostrarArchivosEnCarpeta(rutaCarpetaMapas);
                //2. Pedir que mapa quiere modificar
                System.out.println("¿Qué mapa desea modificar?");
                int opcionMapaAEditar = scanner.nextInt();
                if (opcionMapaAEditar < 0 || opcionMapaAEditar >= obtenerCuantosElementosTieneUnaCarpeta(rutaCarpetaMapas)) {
                    System.out.println("No existe ese mapa");
                    errorEncontrado();
                    editarMapa();
                } else {//Modificar mapa
                    File mapaAModificar = elegirArchivoDeTexto(rutaCarpetaMapas, opcionMapaAEditar);//Obtiene el mapa a modificar
                    EditorDeMapas editor = new EditorDeMapas(mapaAModificar);//Le pasa el mapa a la clase
                    editor.editarMapa();//editos lo edita
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("La opción es un número");
                errorEncontrado();
                editarMapa();
            } catch (NullPointerException ex) {
                System.out.println("No tienes mapas todavía");
                errorEncontrado();
            }
        } else {//No tiene mapas creados
            scanner.nextLine();
            System.out.println("No tienes mapas aun, crealos en la sección de crear mapas");
            System.out.println("Presiona enter para continuar");
            scanner.nextLine();
            verMenuPrincipal();
        }
    }

    private void elegirPartidaExistente() {
        int indiceArchivo = 0;
        do {
            System.out.println(ROJO + "Estas son las partidas que existen:" + RESETEAR);
            mostrarArchivosEnCarpeta(rutaCarpetaPartidas);
            System.out.println("¿Qué partida deseas jugar?");
            indiceArchivo = 0;
            try {
                indiceArchivo = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Debes colocar un número");
                errorEncontrado();
            }
        } while (indiceArchivo < 0 || indiceArchivo > obtenerCuantosElementosTieneUnaCarpeta(rutaCarpetaPartidas));
        File archivoPartida = elegirArchivoDeTexto(rutaCarpetaPartidas, indiceArchivo);
        RecreadorDePartida recreador = new RecreadorDePartida(archivoPartida);
        recreador.iniciarPartida();
    }

}
