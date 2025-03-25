package ymcris.ipc1.proyecto1.treasurehunter.mapas;

import java.io.File;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.Casillas;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaMuro;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPista;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTesoro;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTrampa;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaEnergia;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaEnemigos;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPersonaje;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTeletransporte;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.ROJO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.obtenerUnaLineaDeUnArchivoDeTextoConUnIndice;

/**
 * Clase encargadda de editar un mapa ya existente.
 *
 * @author YmCris
 * @see DiseñarMapas
 * @since Mar 24, 2025
 */
public class RecreadorDeMapas {

    // --------------------- VARIABLES DE REFERENCIA ---------------------------
    private File mapaEnArchivo;
    private Aventurero aventurero;
    private Casillas[][] tablero;

    // ------------------------ MÉTODO CONSTRUCTOR -----------------------------
    public RecreadorDeMapas(File mapaEnArchivo, Aventurero aventurero) {
        this.mapaEnArchivo = mapaEnArchivo;
        this.aventurero = aventurero;
    }

    // ----------------------------- MÉTODOS -----------------------------------
    public Mapas recrearMapas() {
        //1. Reimplementa todo el diseño DiseñarMapas().preguntarCaracterísticasMapa();
        String nombreMapa = obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 0);//nombreMapa
        System.out.println(ROJO + "MAPA: " + RESETEAR + nombreMapa);
        int filasMapa = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 1));//filasMapas
        int columnasMapa = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 2)); //columnasMapas
        int filaTesoro = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 3));//filaTesoro
        int columnaTesoro = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 4));//columnaTesoro
        //crearCasillaTesoro
        CasillaTesoro tesoro = new CasillaTesoro(filaTesoro, columnaTesoro);
        int filaJugador = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 5));//filajugador
        int columnaJugador = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 6));//columna jugador
        //crearCasillaPersonaje
        CasillaPersonaje casillaAventurero = new CasillaPersonaje(filaJugador, columnaJugador, aventurero);
        //2. Crear el tablero, implementar las casillas jugador y tesoro
        Mapas mapa = new Mapas(nombreMapa, filasMapa, columnasMapa, tesoro, casillaAventurero);
        tablero = mapa.crearTablero();
        mapa.modificarMapas(filaTesoro, columnaTesoro, tesoro);
        mapa.modificarMapas(filaJugador, columnaJugador, casillaAventurero);
        //3. Reimplementar todo lo de DiseñarMapas().diseñarMapas();
        //3.1 Casillas Trampa
        int cantidadCasillasTrampa = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 7));//cantidad casillas trampa
        int puntosAQuitar = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 8));//quita vida
        boolean quitaVida = Boolean.parseBoolean(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 9));//
        for (int i = 0; i < cantidadCasillasTrampa; i++) {
            CasillaTrampa trampas = new CasillaTrampa(cantidadCasillasTrampa, puntosAQuitar, quitaVida);
            mapa.modificarMapas(mapa.numeroRandomFilas(), mapa.numeroRandomColumnas(), trampas);
        }
        //3.2 Casillas Pista
        int cantidadCasillasPista = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 10));
        boolean esDireccional = Boolean.parseBoolean(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 11));
        for (int i = 0; i < cantidadCasillasPista; i++) {
            CasillaPista pistas = new CasillaPista(cantidadCasillasPista, esDireccional, tesoro, casillaAventurero, tablero);
            mapa.modificarMapas(mapa.numeroRandomFilas(), mapa.numeroRandomColumnas(), pistas);
        }
        //3.3 Casillas Teletransporte
        int cantidadCasillasTeletransporte = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 12));
        boolean ubicacionAleatoria = Boolean.parseBoolean(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 13));
        int filaTeletransporte = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 14));
        int columnaTeletransporte = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 15));
        int numeroDeFilas = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 16));
        int numeroDeColumnas = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 17));
        for (int i = 0; i < cantidadCasillasTeletransporte; i++) {
            CasillaTeletransporte teletransporte = new CasillaTeletransporte(cantidadCasillasTeletransporte, ubicacionAleatoria, filaTeletransporte, columnaTeletransporte, numeroDeFilas, numeroDeColumnas, casillaAventurero, tesoro, mapa, tablero);
            mapa.modificarMapas(mapa.numeroRandomFilas(), mapa.numeroRandomColumnas(), teletransporte);
        }
        //3.4 Casillas Energía
        int cantidadCasillasEnergia = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 18));
        int puntosARecuperar = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 19));
        boolean recuperaVida = Boolean.parseBoolean(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 20));
        for (int i = 0; i < cantidadCasillasEnergia; i++) {
            CasillaEnergia energia = new CasillaEnergia(cantidadCasillasEnergia, puntosARecuperar, recuperaVida);
            mapa.modificarMapas(mapa.numeroRandomFilas(), mapa.numeroRandomColumnas(), energia);
        }
        //3.5 Casillas Enemigos
        int cantidadCasillasEnemigos = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 21));
        boolean puedeEscapar = Boolean.parseBoolean(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 22));
        boolean pierdePuntos = Boolean.parseBoolean(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 23));
        int filaARetornar = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 24));
        int columnaARetornar = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 25));
        int puntosAQuitarBatalla = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 26));
        int tipoDePuntos = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 27));
        for (int i = 0; i < cantidadCasillasEnemigos; i++) {
            CasillaEnemigos enemigos = new CasillaEnemigos(cantidadCasillasEnemigos, puedeEscapar, pierdePuntos, filaARetornar, columnaARetornar, puntosAQuitarBatalla, tipoDePuntos, casillaAventurero, mapa);
            mapa.modificarMapas(mapa.numeroRandomFilas(), mapa.numeroRandomColumnas(), enemigos);
        }
        //3.6 Casillas Muro
        int cantidadCasillasMuro = Integer.parseInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 28));
        for (int i = 0; i < cantidadCasillasMuro; i++) {
            CasillaMuro muros = new CasillaMuro(cantidadCasillasMuro);
            mapa.modificarMapas(mapa.numeroRandomFilas(), mapa.numeroRandomColumnas(), muros);
        }
        return mapa;
    }

}
