package ymcris.ipc1.proyecto1.treasurehunter.mapas;

import java.util.Scanner;
import java.util.InputMismatchException;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTesoro;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPersonaje;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.exception.EntradaNoValidaException.errorEncontrado;

/**
 * Clase encargada de crear mapas.
 *
 * @author YmCris
 * @since Mar 18, 2025
 */
public class DiseñarMapas {

    // --------------------- VARIABLES DE REFERENCIA ---------------------------
    private Mapas mapaCreado;
    private String nombreMapa;
    private CasillaTesoro tesoro;
    private CasillaPersonaje personaje;
    // ----------------------- VARIABLES PRIMITIVAS ----------------------------
    private int filaTesoro;
    private int filaJugador;
    private int columnaTesoro;
    private int numeroDeFilas;
    private int columnaJugador;
    private int numeroDeColumnas;
    // ----------------------------- INSTANCIAS --------------------------------
    Scanner scanner = new Scanner(System.in);

    // ------------------------ MÉTODO CONSTRUCTOR -----------------------------
    // ----------------------------- MÉTODOS -----------------------------------
    /**
     * Método encargado de crear un nuevo mapa
     *
     * @return retorna el mapa modificado
     */
    public Mapas crearMapa() {
        //0. Preguntar las características (Parámetros del mapa)
        try {
            System.out.println("\n".repeat(100));
            //0. Preguntar detalles del mapa
            System.out.println("· INGRESE EL NOMBRE DEL MAPA:");//Preguntar el nombre del mapa
            this.nombreMapa = scanner.nextLine();
            System.out.println("· INGRESE EL NÚMERO DE FILAS DEL MAPA:");//Preguntar el número de filas
            this.numeroDeFilas = scanner.nextInt();
            System.out.println("· INGRESE EL NÚMERO DE COLUMNAS DEL MAPA:");//Preguntar el número de columnas
            this.numeroDeColumnas = scanner.nextInt();
            System.out.println("\n".repeat(100));
            //1. Preguntar detalles del tesoro
            System.out.println("· INGRESE LA FILA EN LA QUE SE ENCONTRARÁ EL TESORO:");//Preguntar la fila del tesoro
            this.filaTesoro = scanner.nextInt();
            System.out.println("· INGRESE LA COLUMNA EN LA QUE SE ENCONTRARÁ EL TESORO:");//Preguntar la columnas del tesoro
            this.columnaTesoro = scanner.nextInt();
            System.out.println("\n".repeat(100));
            //2. Preguntar detalles del jugador
            System.out.println("· INGRESE LA FILA EN LA QUE SE ENCONTRARÁ EL JUGADOR:");//Preguntar la fila del jugador
            this.filaJugador = scanner.nextInt();
            System.out.println("· INGRESE LA COLUMNA EN LA QUE SE ENCONTRARÁ EL JUGADOR:");//Preguntar la columna del jugador
            this.columnaJugador = scanner.nextInt();
            //3. Validaciones
            realizarValidaciones();
        } catch (InputMismatchException e) {
            errorEncontrado();
            scanner.nextLine();
            crearMapa();
        }
        this.personaje = new CasillaPersonaje(filaJugador, columnaJugador, aventurero);
        this.tesoro = new CasillaTesoro(filaTesoro, columnaTesoro, 1);
        this.mapaCreado = new Mapas(nombreMapa, numeroDeFilas, numeroDeColumnas, tesoro, personaje);
        return this.mapaCreado;
    }

    /**
     * Método encargado de verificar que todos los atributos esten tengan las
     * dimensiones correctas.
     */
    private void realizarValidaciones() {
        if (numeroDeFilas > 10 && numeroDeColumnas > 10) {//Validación para el tamaño del mapa
            //todo en orden
        } else if (filaTesoro >= 0 && filaTesoro < numeroDeFilas) {//Validación para el tesoro
            //todo en orden
        } else if (columnaTesoro >= 0 && columnaTesoro < numeroDeColumnas) {
            //todo en orden
        } else if (filaJugador >= 0 && filaJugador < numeroDeFilas) {//Validación para el jugador
            //todo en orden
        } else if (columnaJugador >= 0 && columnaJugador < numeroDeColumnas) {
            //todo en orden
        } else {
            System.out.println("No has introducido correctamente alguno de los siguientes datos:");
            System.out.println("1) Mapa con dimensiones menores de 10*10");
            System.out.println("2) La posición del tesoro no se encontraba dentro del rango del mapa");
            System.out.println("3) La posición del jugador no se encontraba dentro del rango del mapa");
            System.out.println("Vuelve a intentarlo evitando los errores mensionados");
            scanner.nextLine();
            scanner.nextLine();
            crearMapa();

        }
    }
}
