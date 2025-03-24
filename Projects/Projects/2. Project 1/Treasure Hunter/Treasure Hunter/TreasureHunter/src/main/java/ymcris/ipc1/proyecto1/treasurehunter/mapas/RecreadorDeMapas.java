package ymcris.ipc1.proyecto1.treasurehunter.mapas;

import java.io.File;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.obtenerUnaLineaDeUnArchivoDeTextoConUnIndice;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPersonaje;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTesoro;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;

/**
 *
 *
 * @author YmCris
 * @since Mar 24, 2025
 */
public class RecreadorDeMapas {

    private File mapaEnArchivo;
    private Aventurero aventurero;

    public RecreadorDeMapas(File mapaEnArchivo, Aventurero aventurero) {
        this.mapaEnArchivo = mapaEnArchivo;
        this.aventurero = aventurero;
    }

    public Mapas recrearMapas() {
        //1. Reimplementa todo el diseño DiseñarMapas().preguntarCaracterísticasMapa();
        String nombreMapa = obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 0);//nombreMapa
        int filasMapa = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 1));//filasMapas
        int columnasMapa = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 2)); //columnasMapas
        int filaTesoro = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 3));//filaTesoro
        int columnaTesoro = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 4));//columnaTesoro
        //crearCasillaTesoro
        CasillaTesoro tesoro = new CasillaTesoro(filaTesoro, columnaTesoro);
        int filaJugador = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 5));
        int columnaJugador = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 6));
        //crearCasillaPersonaje
        CasillaPersonaje casillaAventurero = new CasillaPersonaje(filaJugador, columnaJugador, aventurero);
        Mapas mapa = new Mapas(nombreMapa, filasMapa, columnasMapa, tesoro, casillaAventurero);
        mapa.crearTablero();
        mapa.mostrarMapaCompleto();
        mapa.modificarMapas(filaTesoro, columnaTesoro, tesoro);
        mapa.modificarMapas(filaJugador, columnaJugador, casillaAventurero);
        //2. Reimplementar todo lo de DiseñarMapas().diseñarMapas();
        //crearMapa
        //RellenarNuevoMapa con casillas normales
        //seguir la creación de las casillas
        //crear casillas muro
        //crear casillas trampa
        //crear casillas pista
        //crear casillas teletransporte
        //crear casillas energía
        //crear casillas enemigos
        //Mapas mapa = new Mapas();
        return mapa;
    }

    // --------------------- VARIABLES DE REFERENCIA ---------------------------
    // ----------------------- VARIABLES PRIMITIVAS ----------------------------
    // ---------------------------- INSTANCIAS ---------------------------------
    // ------------------------ MÉTODO CONSTRUCTOR -----------------------------
    // ----------------------------- MÉTODOS -----------------------------------
    // ------------------------- GETTERS & SETTERS -----------------------------
}
