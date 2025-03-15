package ymcris.ipc1.proyecto1.treasurehunter.batalla;

import java.util.InputMismatchException;
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
    private int opcionBatalla;
    private int opcion;
    private boolean rendirse;
    private boolean puedeAbandonar;

    // INSTANCIAS --------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Batalla(Aventurero aventurero, boolean puedeAbandonar) {
        this.opcion = 0;
        this.opcionBatalla = 0;
        this.RESETEAR = "\u001B[0m";
        this.MAGENTA = "\u001B[95m";
        this.CYAN = "\u001B[96m";
        this.rendirse = false;
        this.puedeAbandonar = puedeAbandonar;
        this.aventurero = aventurero;
        this.pirata = new Pirata(aventurero);
    }

    /**
     * Método encargado de verificar si el aventurero ha ganado o perdido la
     * batalla.
     *
     * @return true si la batalla esta terminada
     */
    private boolean batallaTerminada() {
        if (this.pirata.getVida() <= 0) {//Pirata se ha quedado sin vida
            System.out.println(MAGENTA + "              ------------------------- " + RESETEAR + "Felicidades aventurero " + aventurero.getNombre() + " haz logrado vencer al temible pirata " + pirata.getNombre() + MAGENTA + " ------------------------- " + RESETEAR);
            return true;
        } else if (this.aventurero.getVida() <= 0) {//Aventurero se ha quedado sin vida
            System.out.println(MAGENTA + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " haz sido derrotado por el temible pirata " + pirata.getNombre() + MAGENTA + " ------------------------- " + RESETEAR);
            return true;
        } else if (this.puedeAbandonar == true && this.rendirse == true) {//Aventurero se ha rendido
            this.aventurero.setBatallasHuidas(this.aventurero.getBatallasHuidas() + 1);
            System.out.println(MAGENTA + "              ------------------------- " + RESETEAR + "'He de perder la batalla, más no la guerra' " + aventurero.getNombre() + " haz escapado del temible pirata " + pirata.getNombre() + MAGENTA + " ------------------------- " + RESETEAR);
            return true;
        }
        return false;
    }

    /**
     * Método encargado de aplicar los efectos una vez la partida ha sido
     * terminada.
     */
    private void aplicarEfectosPartidaTerminada() {
        if (this.pirata.getVida() <= 0) {// Aventurero ganador
            this.aventurero.setBatallas(this.aventurero.getBatallas() + 1);
            this.aventurero.setBatallasGanadas(this.aventurero.getBatallasGanadas() + 1);
            this.aventurero.setVida(aventurero.getVidaMaxima());
            this.aventurero.setMana(aventurero.getManaMaximo());
            do {
                System.out.println("   Oh gran aventurero " + aventurero.getNombre() + " como agradecimiento por derrotar al temible pirata " + pirata.getNombre() + " los aldeanos se ofrecen a ayudarte en tu travesia");
                System.out.println("   Seleacciona tu recompensa: [1] Aumentar el ataque en 1   [2] Aumentar tu defensa en 1   [3] Aumentar tu vida en 1   [4] Aumentar tu mana en 1");
                try {
                    opcion = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Opción no válida, introduce una opción del [1-4]");
                    scanner.nextLine();
                    opcion = 5;
                }
                switch (opcion) {
                    case 1 -> {
                        aventurero.setAtaque(aventurero.getAtaque() + 1);
                        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " tu ataque ha aumentado 1, tienes " + aventurero.getAtaque() + " puntos de ataque" + CYAN + " ------------------------- " + RESETEAR);
                    }
                    case 2 -> {
                        aventurero.setDefensa(aventurero.getDefensa() + 1);
                        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " tu defensa ha aumentado 1, tienes " + aventurero.getDefensa() + " puntos de defensa" + CYAN + " ------------------------- " + RESETEAR);
                    }
                    case 3 -> {
                        aventurero.setVida(aventurero.getVida() + 1);
                        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " tu vida ha aumentado 1, tienes " + aventurero.getVida() + " puntos de vida" + CYAN + " ------------------------- " + RESETEAR);
                    }
                    case 4 -> {
                        aventurero.setMana(aventurero.getMana() + 1);
                        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " tu mana ha aumentado 1, tienes " + aventurero.getMana() + " puntos de mana" + CYAN + " ------------------------- " + RESETEAR);
                    }
                    default ->
                        System.out.println("Opción no válida, introduce una opción del [1-4]");
                }
            } while (opcion < 0 || opcion >= 5);
        } else if (this.aventurero.getVida() <= 0) {// Aventurero perdedor
            System.out.println(CYAN + "                                   " + RESETEAR + "Aventurero " + aventurero.getNombre() + " tras tu ardua batalla contra el pirata " + pirata.getNombre() + " saliste herido,\n                                      tu vida y mana se han restablecido a lo que tenías antes de iniciar la batalla");
            this.aventurero.setBatallasPerdidas(this.aventurero.getBatallasPerdidas() + 1);
            aventurero.setVida(aventurero.getVidaPrevioAUnaBatalla());
            aventurero.setMana(aventurero.getManaPrevioAUnaBatalla());
            System.out.println(CYAN + "              ------------------------- " + RESETEAR + " Tienes " + aventurero.getVidaPrevioAUnaBatalla() + " puntos de vida y " + " Tienes " + aventurero.getManaPrevioAUnaBatalla() + " puntos de mana" + CYAN + " ------------------------- " + RESETEAR);
        }
    }

    /**
     * Método encargado de hacer que el pirata y el jugador se menten la madre.
     */
    public void pelear() {
        System.out.println("                                              Aventurero " + aventurero.getNombre() + ", tu rival es el temible pirata " + pirata.getNombre() + " ten cuidado");
        System.out.println(MAGENTA + "                                                                      ¡ES MUY PELIGROSO!" + RESETEAR);
        do {
            pirata.mostrarInformacion();//1. Mostrar información del pirata
            do {//Se evita que el usuario introduzca un número fuera de lo esperado
                new DiseñoBatallas().mostrarEscenarioBatalla();//2. Mostrar escenario batalla
                new DiseñoBatallas().verOpcionesBatalla(aventurero);//3. Mostrar opciones de batalla
                try {
                    opcionBatalla = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Opción no válida, introduce una opción del [1-4]");
                    scanner.nextLine();
                    opcionBatalla = 5;
                }
                switch (opcionBatalla) {//4. Seleccionar opción
                    case 1 -> //atacar
                        aventurero.atacar(pirata);//5. Mostrar efectos realizados al pirata
                    case 2 -> //curar
                        aventurero.curar();
                    case 3 -> //defender
                        aventurero.defender();
                    case 4 -> {//rendirse
                        if (puedeAbandonar == true) {
                            puedeAbandonar = true;
                            rendirse = true;
                            break;
                        } else {
                            System.out.println("No te puedes rendir, dirigete en el menú y cambia las configuraciones");
                        }
                    }
                    default ->
                        System.out.println("Ingresa una opción válida [1-4]");
                }
                //4. Seleccionar opción
            } while (opcionBatalla < 0 || opcionBatalla >= 5);
            if (pirata.getVida() > 0 && rendirse == false) {//6. Verificar si el pirata sigue vivo
                pirata.atacar(aventurero);//7. Pirata ataca y muestra información del daño que ha realizado el pirata al jugador
            }
        } while (!batallaTerminada());//8. Verificar si el jugador sigue vivo
        aplicarEfectosPartidaTerminada();
    }

}
