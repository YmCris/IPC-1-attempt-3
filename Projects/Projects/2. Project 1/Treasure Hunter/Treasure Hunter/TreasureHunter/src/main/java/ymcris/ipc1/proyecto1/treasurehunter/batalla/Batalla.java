package ymcris.ipc1.proyecto1.treasurehunter.batalla;

import java.util.Scanner;
import ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoBatallas;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Pirata;

/**
 * Clase encargada de hacer que el aventurero y el pirata se madreen hasta que
 * uno gane.
 *
 * @author YmCris
 * @see Pirata
 * @see Aventurero
 * @since Mar 14, 2025
 */
public class Batalla {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Pirata pirata;
    private Aventurero aventurero;
    private final String CYAN;
    private final String MAGENTA;
    private final String RESETEAR;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private boolean rendirse;
    private boolean puedeAbandonar;
    private boolean batallaTerminada;

    // INSTANCIAS --------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Batalla(Aventurero aventurero) {
        this.RESETEAR = "\u001B[0m";
        this.MAGENTA = "\u001B[95m";
        this.CYAN = "\u001B[96m";
        this.rendirse = false;
        this.puedeAbandonar = true;
        this.batallaTerminada = false;
        this.aventurero = aventurero;
        this.pirata = new Pirata(aventurero);
    }

    /**
     * Método encargado de verificar si el aventurero ha ganado o perdido la
     * batalla.
     *
     * @return true si el aventurero ha ganado la batalla
     */
    private boolean aventureroGanador() {
        if (pirata.getVida() <= 0) {//Pirata se ha quedado sin vida
            System.out.println(MAGENTA + " ------------------------- " + RESETEAR + "Felicidades aventurero " + aventurero.getNombre() + " haz logrado vencer al temible pirata " + pirata.getNombre() + MAGENTA + " ------------------------- " + RESETEAR);
            batallaTerminada = true;
            aplicarEfectosPartidaTerminada();
            return true;
        } else if (aventurero.getVida() <= 0) {//Aventurero se ha quedado sin vida
            System.out.println(MAGENTA + " ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " haz sido derrotado por el temible pirata " + pirata.getNombre() + MAGENTA + " ------------------------- " + RESETEAR);
            batallaTerminada = true;
            aplicarEfectosPartidaTerminada();
            return false;
        } else if (puedeAbandonar == true && rendirse == true) {//Aventurero se ha rendido
            System.out.println(MAGENTA + " ------------------------- " + RESETEAR + "'He de perder la batalla, más no la guerra' " + aventurero.getNombre() + " haz escapado del temible pirata " + pirata.getNombre() + MAGENTA + " ------------------------- " + RESETEAR);
            batallaTerminada = true;
            aplicarEfectosPartidaTerminada();
            return false;
        }
        batallaTerminada = false;
        return false;
    }

    /**
     * Método encargado de aplicar los efectos una vez la partida ha sido
     * terminada.
     */
    private void aplicarEfectosPartidaTerminada() {
        if (aventureroGanador() && batallaTerminada == true) {// Aventurero ganador

        } else if (!aventureroGanador() && batallaTerminada == true) {// Aventurero perdedor

        }
    }

    public void pelear() {
        int opcion = 0;
        System.out.println("                                              Aventurero " + aventurero.getNombre() + ", tu rival es el temible pirata " + pirata.getNombre() + " ten cuidado");
        System.out.println(MAGENTA + "                                                                      ¡ES MUY PELIGROSO!" + RESETEAR);
        do {
            pirata.mostrarInformacion();//1. Mostrar información del pirata
            do {
                new DiseñoBatallas().mostrarEscenarioBatalla();//2. Mostrar escenario batalla
                new DiseñoBatallas().verOpcionesBatalla(aventurero);//3. Mostrar opciones de batalla
                opcion = scanner.nextInt();
                switch (opcion) {//4. Seleccionar opción
                    case 1:
                        aventurero.atacar(pirata);//5. Mostrar efectos realizados al pirata
                        break;
                    case 2:
                        aventurero.curar();
                        break;
                    case 3:
                        aventurero.defender(2, true);
                    case 4:
                        if (puedeAbandonar == true) {
                            rendirse = true;
                        } else {
                            System.out.println("No te puedes rendir, dirigete en el menú y cambia las configuraciones");
                        }
                        break;
                    default:
                        System.out.println("Ingresa una opción válida [1-4]");
                        break;
                }
            } while (opcion < 0 || opcion > 5);
            aplicarEfectosPartidaTerminada();//6. Verificar si el pirata sigue vivo// batalla terminada
            pirata.atacar(aventurero);//7. Pirata ataca //8. Mostrar información del daño que ha realizado el pirata al jugador
            aplicarEfectosPartidaTerminada();//9. Verificar si el jugador sigue vivo// batalla terminada
        } while (rendirse == false && puedeAbandonar == true || batallaTerminada == false);
    }

}
