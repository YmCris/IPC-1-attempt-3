package ymcris.ipc1.proyecto1.treasurehunter;

import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;
import ymcris.ipc1.proyecto1.treasurehunter.ayuda.ComoJugar;
import ymcris.ipc1.proyecto1.treasurehunter.partida.Partida;
import ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.DiseñarMapas;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.RecreadorDeMapas;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.ROJO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.crearCarpetas;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.mostrarBienvenida;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.mostrarMenuPrincipal;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.mostrarArchivosEnCarpeta;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.mostrarOpcionesIniciarPartida;
import static ymcris.ipc1.proyecto1.treasurehunter.exception.EntradaNoValidaException.errorEncontrado;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.obtenerCuantosElementosTieneUnaCarpeta;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.Mapas;

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
    public static Aventurero aventurero;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int opcionMenuPrincipal = 0;
    private int opcionMapas = 0;

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
        new TreasureHunter().verMenuPrincipal();
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
                case 1://Muestra como jugar el juego
                    new ComoJugar().enseñarAJugar();
                    break;
                case 2://Inicia una nueva partida
                    iniciarNuevaPartida();
                    break;
                case 3://Carga una partida ya existente
                    new ComoJugar().enseñarAJugar();//new Archivo().cargarPartida();
                    break;
                case 4:
//Modifica un mapa ya existente
                    //new DiseñarMapas().diseñarMapas();
                    break;
                case 5://Muestra los reportes del juego
                    new ComoJugar().enseñarAJugar();//new Reportes().mostrarReportes();
                    break;
                case 6://Sale del programa
                    System.exit(0);
                    break;
                default:
                    errorEncontrado();
                    scanner.nextLine();
                    break;
            }
        } while (opcionMenuPrincipal < 1 || opcionMenuPrincipal > 6);
    }

    /**
     * Método encargado de crear el jugador que estará activo durante la
     * partida, ya sea con un mapa previamente cargado o con uno nuevo.
     *
     * @return Aventurero - Personaje del jugador.
     */
    private Aventurero crearJugador() {
        System.out.println("\n".repeat(100));
        System.out.println(ROJO + "AVENTURERO" + RESETEAR);
        System.out.println("· INGRESE EL NOMBRE DEL NUEVO AVENTURERO:");
        String nombreAventurero = scanner.nextLine();
        if (nombreAventurero.isBlank()) {
            System.out.println("No puedes tener un nombre vacío");
            errorEncontrado();
            crearJugador();
        } else {
            aventurero = new Aventurero(250, 15, 100, 20, nombreAventurero);//Se crea el aventurero del jugador.
            return aventurero;
        }
        return null;
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
                case 1: //Juega con un mapa ya existente.
                    jugarConUnMapaExistente();
                    break;
                case 2://Juega con un nuevo mapa.
                    jugarConUnNuevoMapa();
                    break;
                case 3://vuelve al menu
                    verMenuPrincipal();
                    break;
                case 4://sale del programa
                    System.exit(0);
                    break;
                default:
                    errorEncontrado();
                    scanner.nextLine();
                    break;
            }
        } while (opcionMapas < 0 || opcionMapas >= 5);
    }

    private void jugarConUnNuevoMapa() {
        scanner.nextLine();
        System.out.println("\n".repeat(100));
        System.out.println(ROJO + "PARTIDA" + RESETEAR);
        System.out.println("· INGRESE EL NOMBRE DE LA PARTIDA:");
        String nombrePartida = scanner.nextLine();
        if (nombrePartida.isBlank()) {
            System.out.println("El nombre de la partida no puede estar en blanco");
            errorEncontrado();
            iniciarNuevaPartida();
        } else {
            Aventurero aventurero = crearJugador();
            DiseñarMapas nuevoMapa = new DiseñarMapas();
            Partida partida = new Partida(aventurero, nuevoMapa.preguntarCaracteristicasMapa(), nombrePartida);
            partida.iniciarNuevaPartida();//Inicia una nueva partida
        }

    }

    private void jugarConUnMapaExistente() {
        scanner.nextLine();
        System.out.println("\n".repeat(100));
        System.out.println(ROJO + "PARTIDA" + RESETEAR);
        System.out.println("· INGRESE EL NOMBRE DE LA PARTIDA:");
        String nombrePartidaNueva = scanner.nextLine();
        if (nombrePartidaNueva.isBlank()) {
            System.out.println("El nombre de la partida no puede estar en blanco");
            errorEncontrado();
            iniciarNuevaPartida();
        } else {
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
                jugarConUnMapaExistente();
            }
            if (opcionArchivo < 0 || opcionArchivo > obtenerCuantosElementosTieneUnaCarpeta(Archivos.rutaCarpetaMapas) - 1) {
                System.out.println("No existe ese archivo");
                errorEncontrado();
                jugarConUnMapaExistente();
            } else {
                scanner.nextLine();
                Aventurero aventureroNuevo = crearJugador();
                File mapaElegido = Archivos.elegirArchivoDeTexto(Archivos.rutaCarpetaMapas, opcionArchivo);
                RecreadorDeMapas recreador = new RecreadorDeMapas(mapaElegido, aventureroNuevo);
                Mapas mapaYaExistente = recreador.recrearMapas();
                Partida partida = new Partida(aventureroNuevo, mapaYaExistente, nombrePartidaNueva);
                partida.iniciarNuevaPartida();//Inicia una nueva partida
            }
        }
    }

}
