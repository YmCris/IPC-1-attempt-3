package ymcris.ipc1.proyecto1.treasurehunter.diseño;

import java.io.File;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.obtenerUnaLineaDeUnArchivoDeTextoConUnIndice;

/**
 * Clase DiseñoMenus es la clase encargada de hacer más agradable todo el juego
 * de TreasureHunter.
 *
 * @author YmCris
 * @since Mar 12, 2025
 */
public class DiseñoMenus {

    // VARIABLES DE REFENCIA ---------------------------------------------------
    public static final String AZUL = "\u001B[94m";//casilas energía
    public static final String CYAN = "\u001B[96m";//casillas enemigos
    public static final String ROJO = "\u001B[91m";//CASILLA PERSONAJE
    public static final String NEGRO = "\u001B[90m";//casillas tesoro, trampa y tesoro
    public static final String BLANCO = "\u001B[97m";//casillas personaje
    public static final String AMARILLO = "\u001B[93m";//casillas pista
    public static final String RESETEAR = "\u001B[0m";//resetea
    public static final String VERDE = "\u001B[92m";//casillas muro
    public static final String MAGENTA = "\u001B[95m";//casilla teletransporte

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de darle la bienvenida al usuario al iniciar el
     * programa.
     */
    public static void mostrarBienvenida() {
        System.out.println("\n".repeat(100));
        System.out.println(CYAN
                + "                                     Aventurero, un mundo lleno de tesoros, peligros e innumerables desafíos y aventuras te espera\n"
                + "                   Preparáte para navegar en un mapa lleno de trampas, pistas y enemigos, para encontrar el tesoro más grande de todos los tiempo\n"
                + "                                                                        Bienvenido a" + RESETEAR);
        System.out.println("\n".repeat(2));
        System.out.println(NEGRO + ""
                + "                 ████████░█████▄░▄█████░▄████▄░▄██████░██░░░██░█████▄░▄█████     ██░░░██░██░░░██░██████▄░████████░▄█████░█████▄\n"
                + "                    ██░░░░██░░██░██░░░░░██░░██░██░░░░░░██░░░██░██░░██░██░░░░     ██░░░██░██░░░██░██░░░██░░░░██░░░░██░░░░░██░░██\n"
                + "                    ██░░░░█████▀░█████░░██░░██░▀█████▄░██░░░██░█████▀░█████░     ███████░██░░░██░██░░░██░░░░██░░░░█████░░█████▀\n"
                + "                    ██░░░░██░░██░██░░░░░██████░░░░░░██░██░░░██░██░░██░██░░░░     ██░░░██░██░░░██░██░░░██░░░░██░░░░██░░░░░██░░██\n"
                + "                    ██░░░░██░░██░▀█████░██░░██░██████▀░▀█████▀░██░░██░▀█████     ██░░░██░▀█████▀░██░░░██░░░░██░░░░▀█████░██░░██\n"
                + "                                                                                                                                                                                " + RESETEAR);
        System.out.println("\n".repeat(1));
        mostrarBrujula();
        System.out.println("\n".repeat(3));
        System.out.println(ROJO + "                                                                       By Code'n Bugs" + RESETEAR);
        System.out.println(AZUL + "                                                                       --------------" + RESETEAR);
        System.out.println("");
        System.out.println("");
        System.out.println(AMARILLO + "Presione enter para continuar." + RESETEAR);
    }

    /**
     * Método encargado de mostrar las opciones que se tienen al ingresar al
     * juego.
     */
    public static void mostrarMenuPrincipal() {
        System.out.println("\n".repeat(100));
        System.out.println("                                            ┌------------------------------------------------┐");
        System.out.println("                                            |                 MENÚ PRINCIPAL                 |");
        System.out.println("                                            ├------------------------------------------------┤");
        System.out.println("                                            ¦ [1] ¿Cómo Jugar Treasure Hunter?               ¦");
        System.out.println("                                            ¦ [2] Iniciar Nueva Partida                      ¦");
        System.out.println("                                            ¦ [3] Cargar Partida Existente                   ¦");
        System.out.println("                                            ¦ [4] Editar Mapas                               ¦");
        System.out.println("                                            ¦ [5] Ver reportes                               ¦");
        System.out.println("                                            ¦ [6] Salir del programa                         ¦");
        System.out.println("                                            ├------------------------------------------------┤");
        System.out.println("                                            ¦            -Seleccione una opción-             ¦");
        System.out.println("                                            └------------------------------------------------┘");
        System.out.println("");
    }

    /**
     * Método encargado de mostrar que desea realizar el usuario.
     */
    public static void mostrarOpcionesIniciarPartida() {
        System.out.println("\n".repeat(100));
        System.out.println("                                            ┌------------------------------------------------┐");
        System.out.println("                                            |             ¿Cón qué deseas jugar?             |");
        System.out.println("                                            ├------------------------------------------------┤");
        System.out.println("                                            ¦ [1] Jugar con un mapa ya existente             ¦");
        System.out.println("                                            ¦ [2] Crear un nuevo mapa                        ¦");
        System.out.println("                                            ¦ [3] Regresar                                   ¦");
        System.out.println("                                            ¦ [4] Salir del programa                         ¦");
        System.out.println("                                            ├------------------------------------------------┤");
        System.out.println("                                            ¦            -Seleccione una opción-             ¦");
        System.out.println("                                            └------------------------------------------------┘");
        System.out.println("");
    }

    /**
     * Método encargado de mostrar las opciones del mapa
     *
     * @param mapaEnArchivo
     */
    public static void mostrarOpcionesEditarMapa(File mapaEnArchivo) {
        System.out.println("\n".repeat(100));
        System.out.println("                ----------------------------------------------------------------------------------------- ");
        System.out.println("                                      ¿Qué carácterística del mapa desea editar?                         ");
        System.out.println("                ----------------------------------------------------------------------------------------- ");
        System.out.println("                       [ 0] Nombre del mapa ........................................ " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 0));
        System.out.println("                       [ 1] Número de filas del mapa ............................... " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 1));
        System.out.println("                       [ 2] Número de columnas del mapa ............................ " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 2));
        System.out.println("                       [ 3] Fila en la que se encuentra el tesoro .................. " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 3));
        System.out.println("                       [ 4] Columna en la que se encuentra el tesoro ............... " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 4));
        System.out.println("                       [ 5] Fila en la que se encuentra el jugador ................. " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 5));
        System.out.println("                       [ 6] Columna en la que se encuentra el jugador .............. " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 6));
        System.out.println("                       [ 7] Cantidad de casillas trampa ............................ " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 7));
        System.out.println("                       [ 8] Puntos que quitan las trampas  ......................... " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 8));
        System.out.println("                       [ 9] Efecto de la trampa .................................... " + convertirBooleanoAInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 9)));
        System.out.println("                       [10] Cantidad de casillas Pista ............................. " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 10));
        System.out.println("                       [11] Tipo de pista .......................................... " + convertirBooleanoAInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 11)));
        System.out.println("                       [12] Cantidad de casillas Teletransporte .................... " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 12));
        System.out.println("                       [13] Tipo de teletransportación ............................. " + convertirBooleanoAInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 13)));
        System.out.println("                       [14] Fila a retornar en la casilla teletransporte ........... " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 14));
        System.out.println("                       [15] Columna a retornar en la casilla teletransporte ........ " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 15));
        System.out.println("                       [18] Cantidad de casillas de energía ........................ " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 18));
        System.out.println("                       [19] Puntos a restarurar .................................... " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 19));
        System.out.println("                       [20] Efecto de la casilla energía ........................... " + convertirBooleanoAInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 20)));
        System.out.println("                       [21] Cantidad de casillas enemigos .......................... " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 21));
        System.out.println("                       [22] Puede escapar de la batalla ............................ " + convertirBooleanoAInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 22)));
        System.out.println("                       [23] Si pierede puntos o es reubicado ....................... " + convertirBooleanoAInt(obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 23)));
        System.out.println("                       [24] Fila a retornar si pierde .............................. " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 24));
        System.out.println("                       [25] Columna a retornar si pierde ........................... " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 25));
        System.out.println("                       [26] Puntos a quitar ........................................ " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 26));
        System.out.println("                       [27] Tipo de puntos a quitar ................................ " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 27));
        System.out.println("                       [28] Numero de casillas muro ................................ " + obtenerUnaLineaDeUnArchivoDeTextoConUnIndice(mapaEnArchivo, 28));
        System.out.println("                ----------------------------------------------------------------------------------------- ");
    }

    /**
     * Método encargado de mostrar las opciones de los reportes
     */
    public static void mostrarOpcionesReportes() {
        System.out.println("\n".repeat(100));
        System.out.println("                                ┌--------------------------------------------------------------------------┐");
        System.out.println("                                |                           ¿Qué desea visualizar?                         |");
        System.out.println("                                ├--------------------------------------------------------------------------┤");
        System.out.println("                                ¦ [1] Jugadores que han encontrado el tesoro ordenados por movimientos     ¦");
        System.out.println("                                ¦ [2] Jugadores que han encontrado el tesoro ordenados por batalla ganadas ¦");
        System.out.println("                                ¦ [3] Jugadores que han perdido una partida                                ¦");
        System.out.println("                                ¦ [4] Regresar                                                             ¦");
        System.out.println("                                ¦ [5] Salir del programa                                                   ¦");
        System.out.println("                                ├--------------------------------------------------------------------------┤");
        System.out.println("                                ¦                           -Seleccione una opción-                        ¦");
        System.out.println("                                └--------------------------------------------------------------------------┘");
        System.out.println("");
    }

    /**
     * Método encargado de convertir un booleano a un string para luego pasarlo
     * a un entero
     *
     * @param booleano - booleano que se verificara si es true o false
     * @return 1 si es true, 2 si es cualquier otra coas
     */
    public static String convertirBooleanoAInt(String booleano) {
        if (booleano.equals("true")) {
            return "1";
        } else if (booleano.equals("false")) {
            return "2";
        }
        return null;
    }

    /**
     * Método encargado de mostrar una imagen llamativa para el videojuego.
     */
    private static void mostrarBrujula() {
        System.out.println(BLANCO + "                              .:::;&:                                                                                                               \n"
                + "                              .X&&X+$.                 :;                                                                                           \n"
                + "                               :X+X&$x                :+.                                                                                           \n"
                + "                                +X;.;:                :.                                                                                            \n"
                + "                                    .    ..:::..     .++.                                                                                           \n"
                + "                                    ;:+X;..    ..::x:+&x.                                                                                           \n"
                + "                                :x$+:$:          ;$$$ Xx:                                                                                           \n"
                + "                             .;X;   .+$;..::::::..;:    :X+.                                                                                        \n"
                + "                            +X:     .x&&x+;:.::;+xx+:     .x+.       .;++                                                                           \n"
                + "                          .+;    .+X;:x&$          .;Xx.    :X;    ;&&;                                                                             \n"
                + "                 :;X:    .++X. .+X:   ;x&$      .:    :++.   .x;   .x&&+:                                                                           \n"
                + "                    .;:X:&&&$..X+     .x+&X     X       :X:    ;.   .X&$.+x.                                                                        \n"
                + "                     +X$x.:. .$:       ;+X&X. :&;        .$:;x$X:    ;X:.                                                                           \n"
                + "                     .:::   .$:        .X.$&+;$&    .;;;X$&&X;  ;X                                                                                  \n"
                + "                       X;   +x    :+x+;.;x:&&&&$++++xX$&$x:;X   .&                                                                                  \n"
                + "                      .$.   $:      .;X&&&.+&x::+X$&&&+:   .$    X;                                                                                 \n"
                + "                      :$   .$.        :X&&&&&&&&&&$;.       $.   x;                                                                                 \n"
                + "                      .$.   $:     :X&&&X:.;$+.&&&X:       .$    $:                                                                                 \n"
                + "                       X;   ++ :;X&$X;;+X&&&&&:+$xX$$+:    :X   .$                                                                                  \n"
                + "                       :X  .;&$&$Xxx+:. .$$XX&$.X:    ..  .&.   :;:.                                                                                \n"
                + "                   ::.  :;XXx+$;.       ;&x..X&X;x       .$::+;:+&;                                                                                 \n"
                + "               :+$;;$:  .;;   :X;      .$;   .X&Xx:     :X: .:+X:$+:.        :x                                                                     \n"
                + "           .x&$;X$&$$;   .x;   .+X.    ;:     .$$x+   .+x.   ..     ;X;      &&X.                                                                   \n"
                + "            .X&&&&$&&;    .++.   .xX:.          $$x::xx:    ;X:        :;  .$&&&x.                                                                  \n"
                + "              :X&&.:;.      :X;.    :xX+;:::..::+&&x:     :X+          :;x$&&&&&&x. :.                                                              \n"
                + "                ..            :++:   .:;::;;;;;:.:Xx.  .;X+  .+x.    .X&&&&&&&&&&&XX&$;. .                                                          \n"
                + "                                :;:+$X&$:         :$::X+:.:X&&&&$.  ;$&&&&&&&&&&&&&&&&X:X&$;                                                        \n"
                + "                                +$$;:X+:+x+;;;;+X$;:+   .x&&&&&&&&$x;$&&&&&&&&&&&&&$&+;$&&&&X:                                                      \n"
                + "                                :xx:                .   +&&&&&$&&&&&++&&&&&&&&&&X$&&.+&&&&&&&&+                .                                    \n"
                + "                             :&&+   ;+                .;$&&&$&&&&&&&&+.X&&&&&&&&X:+;;&&&&&&&&&&&+XX:         .:$&:                                  \n"
                + "                           .+&&&&x;:$.             .;x&&&&$&&&&&&&$xX&&;:X&&;:$&X:.;$&&&&&&&&&&&&&&&$;     :$&$&&&;                                 \n"
                + "                        +$X$&&&&&&&&&+.    ;;   .;X&&&&&&&&&.x&&X&$:  :+&+:x. .:+&&&&&&&&&&&&&&&&&&&&&$;   X$:.:;$&x+;                              \n"
                + "                   ;$&x:&&&&&&&&&&&&&&$;  x&&$&&&&&&&X;;x&&&X.;: ;&&+.  :+;.  .+&&&&&&X;x&&&+:XX:;+$&&&&$X$X.    :&&&&$:                            \n"
                + "                 +&&&&&&;+&&&&&&&&&&&&$;$&&&&&&&&&&$:  .X&&&$:     .+$&.     :&&&&x.X.   :$&&x.      .+&&&$     ;+:..x&&X$;  :.                     \n"
                + "            .+++&&&&&&&&&X;+:&&&&&&&&X:X&&&&&&&&&&x... .x&&;          XX   :$&&&&;         .:X&&;.   +&&&&&&X:.        +&&&$&$&$:                   \n"
                + "         .:$&&&&&&&&&&&&&&X::X$;X&$X;X$X;$&&&$$&&$&&&&+:;;.               .;+;;.    .+$&&&&&&&&&$$$+&&x .;..;X$&+:.     .x&&:  :X&$;:               \n"
                + "        :X&&&&$X$$X&&&XX&$X&&+ ;X+X&+:.:X&;;X:;$&$X;;XX:                          ;X&$+:.     :. .X&&+          .:+:     .x&&x:..+$$&$x;.           \n"
                + "      :X$&$+;.   +&&$:  :;.+&&$;+$+..X$+:    :$&X;.    .                       :X&&+:      :+$&&&&&&;                      ;$&&&$$XXXX&&&&$X+.      \n"
                + "     :::..       ..         :X&&&x. :x.        :X+                           X$X;:       +X+;::::::.                         :x$;:::::::....:;X:    " + RESETEAR);
    }
}
