package ymcris.ipc1.proyecto1.treasurehunter.partida;

import java.io.File;
import java.util.Scanner;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.Mapas;
import ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.RecreadorDeMapas;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.rutaCarpetaMapas;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.rutaCarpetaJugadores;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.sobreEscribirUnaLineaDeArchivo;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.obtenerArregloDeArchivosDeUnaCarpeta;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.obtenerUnaLineaDeUnArchivoDeTextoConUnIndice;

/**
 * RecreadorDePartida es la clase encargada de crecrear una partida obteniendo
 * un mapa ya creado y creando un jugador desde 0 a través de sus elementos
 * guardados en archivos
 *
 * @author YmCris
 * @since Mar 26, 2025
 */
public class RecreadorDePartida {

    // --------------------- VARIABLES DE REFERENCIA ---------------------------
    private File archivoMapa;
    private File archivoPartida;
    private File archivoJugador;

    // ---------------------------- INSTANCIAS ---------------------------------
    Scanner scanner = new Scanner(System.in);

    // ----------------------- VARIABLES PRIMITIVAS ----------------------------
    int filaJugador;
    int columnaJugador;

    // ------------------------ MÉTODO CONSTRUCTOR -----------------------------
    /**
     * Método encargado de recrear una partida en base a un archivo partida
     *
     * @param archivoPartida - archivo donde se encuentran el nombre del jugador
     * y del mapa
     */
    public RecreadorDePartida(File archivoPartida) {
        this.archivoPartida = archivoPartida;
    }

    // ----------------------------- MÉTODOS -----------------------------------
    /**
     * Método encargado de iniciar la partida con los paramétros inicializados
     * con los otros métodos
     */
    public void iniciarPartida() {
        String nombrePartida = obtenerNombrePartida();
        obtenerArchivoJugador();
        obtenerArchivoMapa();
        recrearJugador();
        if (obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 1).equals("true") || obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 7).equals("true")) {
            System.out.println("No puedes jugar esta partida porque ya terminó");
            System.out.println("Presiona enter para regresar al menú principal");
            scanner.nextLine();
            new TreasureHunter().verMenuPrincipal();
        } else {
            Mapas mapaRecreado = recrearMapa();
            Partida partida = new Partida(aventurero, mapaRecreado, nombrePartida);
            partida.iniciarNuevaPartida();
        }
    }

    /**
     * Método encargado de obtener el nombre de la partida a partid de su
     * archivo
     *
     * @return nombre de la partida
     */
    private String obtenerNombrePartida() {
        String nombrePartida = obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoPartida, 0);
        return nombrePartida;
    }

    /**
     * Método encargado de obtener el archivo del mapa a partir de su nombre
     *
     * @return archivo del mapa a recrear
     */
    private File obtenerArchivoMapa() {
        String nombreArchivoMapa = obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoPartida, 1) + ".txt";
        File[] todosLosMapas = obtenerArregloDeArchivosDeUnaCarpeta(rutaCarpetaMapas);
        for (File todosLosMapa : todosLosMapas) {
            if (todosLosMapa.getName().toLowerCase().equals(nombreArchivoMapa)) {
                archivoMapa = todosLosMapa;
                return archivoMapa = todosLosMapa;
            }
        }
        return null;
    }

    /**
     * Método encargado de obtener el archivo del jugador a partir de su nombre
     *
     * @return archivo del jugador que estaba jugando la partida
     */
    private File obtenerArchivoJugador() {
        String nombreArchivoJugador = obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoPartida, 2) + ".txt";
        File[] todosLosJugadores = obtenerArregloDeArchivosDeUnaCarpeta(rutaCarpetaJugadores);
        for (File jugadores : todosLosJugadores) {
            if (jugadores.getName().toLowerCase().equals(nombreArchivoJugador)) {
                archivoJugador = jugadores;
                return archivoJugador = jugadores;
            }
        }
        return null;
    }

    /**
     * Método encargado de recrear el mapa a través de su archivo obtenido de
     * otro método
     *
     * @return Mapa ya recreado
     */
    private Mapas recrearMapa() {
        //Modifica el archivo de texto para que cambie su posición
        sobreEscribirUnaLineaDeArchivo(String.valueOf(filaJugador), archivoMapa, 5);
        sobreEscribirUnaLineaDeArchivo(String.valueOf(columnaJugador), archivoMapa, 6);
        RecreadorDeMapas mapaRecreador = new RecreadorDeMapas(archivoMapa, aventurero);
        Mapas mapaRecreado = mapaRecreador.recrearMapas();
        return mapaRecreado;

    }

    /**
     * Método encargado de recrear al jugador creando uno nuevo a partir de
     * todos sus atributos colocados en su archivo
     */
    private void recrearJugador() {
        String nombreJugador = obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 0);//0 Nombre 
        boolean haEncontradoTesoro = Boolean.parseBoolean(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 1));//1 haEcontrado el tesoro si ha ganado (Encontro el tesoro) 
        int numeroMovimientos = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 2));//2. numero de movimientos 
        int batallas = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 3));//3. Cantidad de combates 
        int batallasGanadas = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 4));//4. combates ganados 
        int batallasPerdidas = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 5));//5. combates perdidos 
        int batallasHuidas = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 6));//6. combates huidos
        boolean haPerdido = Boolean.parseBoolean(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 7));//7. haPerdido(Se ha quedado sin vida por trampas o penalizaciones)
        int vida = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 8));//8. Vida
        int vidaPrevioAUnaBatalla = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 9));//9. Vida previo a un combate
        int vidaTotal = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 10));//10. vida total
        int mana = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 11));//11. mana
        int manaPrevioAUnaBatalla = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 12));//12. mana previo a un combate
        int manaTotal = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 13));//13. mana total
        int ataque = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 14));//14. ataque
        int defensa = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 15));//15. defensa
        int defensaPrevioAUnaBatalla = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 16));//16. defensa previo  a un combate
        filaJugador = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 17));//14. fila jugador
        columnaJugador = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 18));//15. columna jugador
        aventurero = new Aventurero(nombreJugador, haEncontradoTesoro, numeroMovimientos, batallas, batallasGanadas, batallasPerdidas, batallasHuidas, haPerdido, vida, vidaPrevioAUnaBatalla, vidaTotal, mana, manaPrevioAUnaBatalla, manaTotal, ataque, defensa, defensaPrevioAUnaBatalla, filaJugador, columnaJugador, archivoJugador);
    }

}
