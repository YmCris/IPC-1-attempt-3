package ymcris.ipc1.proyecto1.treasurehunter.partida;

import java.io.File;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.Mapas;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.RecreadorDeMapas;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.rutaCarpetaMapas;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.rutaCarpetaJugadores;
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

    // ----------------------- VARIABLES PRIMITIVAS ----------------------------
    // ---------------------------- INSTANCIAS ---------------------------------
    // ------------------------ MÉTODO CONSTRUCTOR -----------------------------
    public RecreadorDePartida(File archivoPartida) {
        this.archivoPartida = archivoPartida;
    }

    // ----------------------------- MÉTODOS -----------------------------------
    public void iniciarPartida() {
        String nombrePartida = obtenerNombrePartida();
        obtenerArchivoJugador();
        obtenerArchivoMapa();
        recrearJugador();
        Mapas mapaRecreado = recrearMapa();
        Partida partida = new Partida(aventurero, mapaRecreado, nombrePartida);
        partida.iniciarNuevaPartida();
    }

    private String obtenerNombrePartida() {
        String nombrePartida = obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoPartida, 0);
        return nombrePartida;
    }

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

    private Mapas recrearMapa() {
        RecreadorDeMapas mapaRecreador = new RecreadorDeMapas(archivoMapa, aventurero);
        Mapas mapaRecreado = mapaRecreador.recrearMapas();
        return mapaRecreado;

    }

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
        int filaJugador = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 17));//14. fila jugador
        int columnaJugador = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(archivoJugador, 18));//15. columna jugador
        aventurero = new Aventurero(nombreJugador, haEncontradoTesoro, numeroMovimientos, batallas, batallasGanadas, batallasPerdidas, batallasHuidas, haPerdido, vida, vidaPrevioAUnaBatalla, vidaTotal, mana, manaPrevioAUnaBatalla, manaTotal, ataque, defensa, defensaPrevioAUnaBatalla, filaJugador, columnaJugador, archivoJugador);
    }

}
