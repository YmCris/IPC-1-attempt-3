package ymcris.ipc1.proyecto1.treasurehunter.diseño;

import java.util.Scanner;

/**
 * Clase DiseñoMenus es la clase encargada de hacer más agradable todo el juego
 * de TreasureHunter.
 *
 * @author YmCris
 * @since Mar 12, 2025
 */
public class DiseñoMenus {

    // VARIABLES DE REFENCIA ---------------------------------------------------
    private final String AZUL = "\u001B[94m";// todos los colores son brillantes
    private final String CYAN = "\u001B[96m";
    private final String ROJO = "\u001B[91m";
    private final String NEGRO = "\u001B[90m";
    private final String BLANCO = "\u001B[97m";
    private final String AMARILLO = "\u001B[93m";
    private final String RESETEAR = "\u001B[0m";
    //private final String VERDE = "\u001B[92m";
    //private final String MAGENTA = "\u001B[95m";
    // INSTANCAS ---------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de darle la bienvenida al usuario al iniciar el
     * programa.
     */
    public void mostrarBienvenida() {
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
        scanner.nextLine();
        mostrarMenuPrincipal();
    }

    /**
     * Método encargado de mostrar las opciones que se tienen al ingresar al
     * juego.
     */
    public void mostrarMenuPrincipal() {
        System.out.println("\n".repeat(100));
        System.out.println("                                            ┌------------------------------------------------┐");
        System.out.println("                                            |                 MENÚ PRINCIPAL                 |");
        System.out.println("                                            ├------------------------------------------------┤");
        System.out.println("                                            ¦ [1] ¿Cómo Jugar Treasure Hunter?               ¦");
        System.out.println("                                            ¦ [2] Iniciar Nueva Partida                      ¦");
        System.out.println("                                            ¦ [3] Cargar Partida                             ¦");
        System.out.println("                                            ¦ [3] Diseñar Mapas                              ¦");
        System.out.println("                                            ¦ [4] Ver reportes                               ¦");
        System.out.println("                                            ¦ [5] Salir del programa                         ¦");
        System.out.println("                                            ├------------------------------------------------┤");
        System.out.println("                                            ¦            -Seleccione una opción-             ¦");
        System.out.println("                                            └------------------------------------------------┘");
        System.out.println("");
    }

    /**
     * Método encargado de mostrar una imagen llamativa para el videojuego.
     */
    private void mostrarBrujula() {
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
