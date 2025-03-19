package ymcris.ipc1.proyecto1.treasurehunter.mapas;

import java.util.InputMismatchException;
import java.util.Scanner;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPersonaje;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTesoro;
import static ymcris.ipc1.proyecto1.treasurehunter.exception.EntradaNoValidaException.errorEncontrado;

/**
 *
 *
 * @author YmCris
 * @since Mar 18, 2025
 */
public class DiseñarMapas {

    // --------------------- VARIABLES DE REFERENCIA ---------------------------
    // ----------------------- VARIABLES PRIMITIVAS ----------------------------
    // ----------------------------- INSTANCIAS --------------------------------
    Scanner scanner = new Scanner(System.in);

    // ------------------------ MÉTODO CONSTRUCTOR -----------------------------
    // ----------------------------- MÉTODOS -----------------------------------
    /**
     * Método encargado de crear un nuevo mapa
     *
     * @return retorna el mapa modificado
     */
    public Mapas diseñarMapas() {
        String nombreMapa = "";
        Mapas mapaCreado;
        int numeroDeFilas = 0;
        int numeroDeColumnas = 0;
        int filaTesoro = 0;
        int columnaTesoro = 0;
        int filaJugador = 0;
        int columnaJugador = 0;
        CasillaTesoro tesoro;
        CasillaPersonaje personaje;
        //0. Preguntar las características (Parámetros del mapa)
        try {
            System.out.println("INGRESE EL NOMBRE DEL MAPA:");//Preguntar el nombre del mapa
            nombreMapa = scanner.nextLine();
            System.out.println("INGRESE EL NÚMERO DE FILAS DEL MAPA:");//Preguntar el número de filas
            numeroDeFilas = scanner.nextInt();
            System.out.println("INGRESE EL NÚMERO DE COLUMNAS DEL MAPA:");//Preguntar el número de columnas
            numeroDeColumnas = scanner.nextInt();
            if (numeroDeFilas <= 5 || numeroDeColumnas <= 5) {
                System.out.println("No puedes crear un mapa con estas dimensiones");
                errorEncontrado();
                scanner.nextLine();
                diseñarMapas();
            }
            //1. Preguntar detalles del tesoro
            System.out.println("INGRESE LA FILA EN LA QUE SE ENCONTRARÁ EL TESORO:");//Preguntar la posición del tesoro
            filaTesoro = scanner.nextInt();
            System.out.println("INGRESE LA COLUMNA EN LA QUE SE ENCONTRARÁ EL TESORO:");
            columnaTesoro = scanner.nextInt();
            //Validación de la posición del tesoro.
            if (filaTesoro < 0 || filaTesoro > numeroDeFilas) {
                System.out.println("La posición del tesoro debe de estar en el rango de las filas del mapa");
                errorEncontrado();
                scanner.nextLine();
                diseñarMapas();
            } else if (columnaTesoro < 0 || columnaTesoro > numeroDeColumnas) {
                System.out.println("La posición del tesoro debe de estar en el rango de las columnas del mapa");
                errorEncontrado();
                scanner.nextLine();
                diseñarMapas();
            }
            //2. Preguntar detalles del jugador
            System.out.println("INGRESE LA FILA EN LA QUE SE ENCONTRARÁ EL JUGADOR:");//Preguntar la posición del tesoro
            filaJugador = scanner.nextInt();
            System.out.println("INGRESE LA COLUMNA EN LA QUE SE ENCONTRARÁ EL JUGADOR:");
            columnaJugador = scanner.nextInt();
            //Validación de la posición del jugador.
            if (filaJugador < 0 || filaJugador > numeroDeFilas) {
                System.out.println("La posición del jugador debe de estar en el rango de las filas del mapa");
                errorEncontrado();
                scanner.nextLine();
                diseñarMapas();
            } else if (columnaJugador < 0 || columnaJugador > numeroDeColumnas) {
                System.out.println("La posición del jugador debe de estar en el rango de las columnas del mapa");
                errorEncontrado();
                scanner.nextLine();
                diseñarMapas();
            }
        } catch (InputMismatchException e) {
            errorEncontrado();
            scanner.nextLine();
            diseñarMapas();
        }
        personaje = new CasillaPersonaje(filaJugador, columnaJugador, aventurero);
        tesoro = new CasillaTesoro(filaTesoro, columnaTesoro, 1);
        mapaCreado = new Mapas(nombreMapa, numeroDeFilas, numeroDeColumnas, tesoro, personaje);
        return mapaCreado;
        //1. Crear un mapa lleno de casillas normales        
        //preguntar el tipo de casillas, su cantidad y sus parámetros
        //2. 
    }

    // ------------------------- GETTERS & SETTERS -----------------------------
}
