package ymcris.ipc1.proyecto1.treasurehunter.mapas;

import java.util.Scanner;
import java.util.InputMismatchException;
import ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter;
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
    private CasillaTesoro casillaTesoro;
    private CasillaPersonaje casillaAventurero;
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
            TreasureHunter inicio = new TreasureHunter();
            inicio.verMenuPrincipal();
        }
        this.casillaAventurero = new CasillaPersonaje(filaJugador, columnaJugador, aventurero);
        this.casillaTesoro = new CasillaTesoro(filaTesoro, columnaTesoro, 1);
        this.mapaCreado = new Mapas(nombreMapa, numeroDeFilas, numeroDeColumnas, casillaTesoro, casillaAventurero);
        this.mapaCreado.crearMapa();
        this.mapaCreado.modificarMapas(filaTesoro, columnaTesoro, casillaTesoro);
        this.mapaCreado.modificarMapas(filaJugador, columnaJugador, casillaAventurero);
        return this.mapaCreado;
    }

    /**
     * Método encargado de verificar que todos los atributos esten tengan las
     * dimensiones correctas.
     */
    private void realizarValidaciones() {
        boolean nombreMapaVacio = nombreMapa.isBlank();
        boolean dimensionesInvalidas = numeroDeFilas < 10 || numeroDeColumnas < 10;
        boolean tesoroFueraDeRango = filaTesoro < 0 || filaTesoro >= numeroDeFilas || columnaTesoro < 0 || columnaTesoro >= numeroDeColumnas;
        boolean jugadorFueraDeRango = filaJugador < 0 || filaJugador >= numeroDeFilas || columnaJugador < 0 || columnaJugador >= numeroDeColumnas;
        if (nombreMapaVacio || dimensionesInvalidas || tesoroFueraDeRango || jugadorFueraDeRango) {
            System.out.println("No has introducido correctamente alguno de los siguientes datos:");
            if (nombreMapaVacio) {
                System.out.println("0) El mapa no puede tener un nombre vacio");
            }
            if (dimensionesInvalidas) {
                System.out.println("1) El mapa debe ser de al menos 10x10.");
            }
            if (tesoroFueraDeRango) {
                System.out.println("2) La posición del tesoro debe estar dentro del rango del mapa.");
            }
            if (jugadorFueraDeRango) {
                System.out.println("3) La posición del jugador debe estar dentro del rango del mapa.");
            }
            System.out.println("");
            System.out.println("Vuelve a intentarlo evitando estos errores.");
            errorEncontrado();
            scanner.nextLine();
            crearMapa();
        }
    }

    /**
     * Método encargado de modificar mapa
     *
     * @param mapa
     * @return
     */
    public Mapas diseñarMapas(Mapas mapa) {
        System.out.println("Las características del mapa son:");
        System.out.println("FILAS: " + numeroDeFilas);
        System.out.println("COlUMNAS: " + numeroDeColumnas);
        System.out.println("POSICIÓN DEL TESORO: " + filaTesoro + "," + columnaTesoro);
        System.out.println("POSICIÓN DEL JUGADOR: " + filaJugador + "," + columnaJugador);
        //casillas normnales
        //casillas trampa
        //casillas pista
        //casilla teletransporte
        //casillas muro
        //casillas energía
        //casillas enemigo
        return this.mapaCreado;
    }

}
