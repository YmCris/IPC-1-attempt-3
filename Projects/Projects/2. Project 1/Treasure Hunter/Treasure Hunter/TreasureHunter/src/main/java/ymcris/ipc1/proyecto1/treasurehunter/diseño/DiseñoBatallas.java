package ymcris.ipc1.proyecto1.treasurehunter.diseño;

import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.ROJO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.MAGENTA;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

/**
 * Clase DiseñoBatallas es la clase encargada de dar una vista más agradable al
 * Programa.
 *
 * @author YmCris
 * @see DiseñoMenus
 * @since Mar 12, 2025
 */
public class DiseñoBatallas {

    /**
     * Método encargado de mostrar las opciones que tiene el aventurero al
     * desarrollarse una batalla.
     *
     * @param aventurero - Aventurero que va a batallar.
     */
    public void verOpcionesBatalla(Aventurero aventurero) {
        System.out.println("............................................................................................................................................");
        System.out.println(". TURNO DE: " + MAGENTA + aventurero.getNombre() + RESETEAR + " '" + ROJO + aventurero.getSimbolo() + RESETEAR + "'" + "     .                                                                                                             .");
        System.out.println(". VIDA: " + aventurero.getVida() + "/" + aventurero.getVidaMaxima() + "              .    ┌---------------------┐   ┌---------------------┐   ┌---------------------┐   ┌---------------------┐    .");
        System.out.println(". MANA: " + aventurero.getMana() + "/" + aventurero.getManaMaximo() + "                .    ¦        ATACAR       ¦   ¦        CURAR        ¦   ¦       DEFENDER      ¦   ¦      ABANDONAR      ¦    .");
        System.out.println(". ATAQUE: " + aventurero.getAtaque() + "                .    ¦         [1]         ¦   ¦         [2]         ¦   ¦          [3]        ¦   ¦         [4]         ¦    .");
        System.out.println(". DEFENSA: " + aventurero.getDefensa() + "                .    ¦                     ¦   ¦                     ¦   ¦                     ¦   ¦                     ¦    .");
        System.out.println(". BATALLAS: " + aventurero.getBatallas() + "                .    └---------------------┘   └---------------------┘   └---------------------┘   └---------------------┘    .");
        System.out.println(".............................                                                                                                              .");
        System.out.println(".   Seleccione una opción   .                                                                                                              .");
        System.out.println("............................................................................................................................................");
    }

    /**
     * Método encargado de mostrar el escenario en el que va a batallar el
     * jugador.
     */
    public void mostrarEscenarioBatalla() {
        System.out.println("");
        System.out.println("");
        System.out.println("""
                                                    :-=--==-:                                                                      =*@@@@%+:          -%#
                                                    +%%%%%###%#:                    *-                                          *%@@@@%*@@@@%  %+ =%@@@#-       =+
                                                      -*%%%%*-:                    *%-                                         *@@@@@@*%=*@@%+=*@%@@@@##: :#@@@@@@%####-
                                                     -#%%%%#%#++==--:             *%+                                            :-@@@@%@@%#%@@@@@*-##*#%@@@@@#+--
                                                     =#%%%%%%%#*==+-             *%+                                             %%@+@+=+@@@@@@@##@@@@@@@@@@@-
                                                 -**######%*=--=-: -:           *%=                                                @@@@@%%@@#%@@@@@@@@@@#+:
                                                 +%%%%%##*++**=               :*#-                                               *@@@@@@*=@@%%@@@#@@@#-
                                                =#%%%%%###==###=             -#+:                                                %@@@=@@*#.*@@@@+ +-%-
                                              :#%%*:*%%%#**#*#%#=           *#:                                                  %@@@@%@@#@@@@@@#
                                              +%#-  :*%%##**%%%%%#*+-:    =#=                                                   *@@@@@@@@%@@@@@@%
                                            :+**-   -%%####***=:+#%%%*+*%%#-                                                   :@@@@=*@@@@@@@@@@@@-::
                                          :##%%%+  :#%%*+%####*=:-*%%##%%+*-                                                  :@@@@=  *@@@@@@@@@@@@@@
                                          *#*#%#   =%%#+*%#*+###*- :-::=--:                                                   %@@@#    @@@@@@@@@@@@@@-
                                          :*%%#=  +%%%%##%%%%%%#++*+=-:                                                      @@@@+    *@@@@@@@@@@@@@@@@:
                                           =#*= -#%%%%*+#%%%%%%##*--=*#%%*-                                              -##%@##     :##%%#%#%@@%*%%@@%%@-
                                             :=#*-*%%%*+%%%%%%%%#%%#+-:--:                                               %%@%#-     -#%@@%@@%%%@@%@@@@@@+@@=
                                           :*#= :*##%%#+%%%%%%%%##%%%%%%*-                                             =%@**        @@@@@@@@@@@@@@@@@@@@@+%#
                                         :##-  :#*%%%+--%%%%%%%%%##%%%%%%%%%=                                  :-+*#%@@@=          @@@@@@@@@@+@@@@@@@@@@@*
                                              :#=#%%%%#+%%%%%%%%%%##%%%%*: :+%=                       -%@@@@@@@@@@@@%+:           #@@@@@@@@@@+:#%@@@@@@@
                                              *%%%%%%%*+%%%%%%%%%%%##%*-     :*:                          :==++=-:                %@@@@@*      :@@@@@@@@#
                                             +%%%%%%%%%##%%%%%##%%%%+:                                                            @@@@@+         * #@@@@@+
                                            +%%%%%%*=*%#*%%%%%##%%%%%+:                                                           :@@@@%            #@@@@*
                                             *%%%%#-   :+++=-+++#%%%#-                                                              @@@@@            :@%%@=
                                             #%%+                -#%#-                                                              *@@@@+            -%@@+
                                            :%%*                  -#%*:                                                              -@@@#              :@%
                                           :%%#:                   *%%#-                                                              #@@%               =@+
                                          :%%%#                   :*%%%%#*:                                                           *@@@@               =@-
                                          +*++-                    =+====-                                                          +@@@@@@                *%
                              """);
    }

}
