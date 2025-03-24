package ymcris.ipc1.proyecto1.treasurehunter.batalla;

import java.util.Scanner;
import java.util.InputMismatchException;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Pirata;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoBatallas;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.MAGENTA;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.exception.EntradaNoValidaException.errorEncontrado;

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

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int opcion;
    private int tipoDePuntos;
    private int opcionBatalla;
    private int puntosAQuitar;
    private boolean rendirse;
    private boolean pierdePuntos;
    private boolean defensaActiva;
    private boolean puedeAbandonar;

    // INSTANCIAS --------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método encargado de inicializar las variables necesarias para la pelea.
     *
     * @param aventurero - aventurero que peleará.
     * @param pierdePuntos - Define si pierde puntos o es reubicado.
     * @param puedeAbandonar - verifica si el jugador se puede rendir.
     * @param tipoDePuntos - verifica el tipo de puntos a quitar si pierde.
     * @param puntosAQuitar - cantidad de puntos a quitar.
     */
    public Batalla(Aventurero aventurero, boolean pierdePuntos, boolean puedeAbandonar, int tipoDePuntos, int puntosAQuitar) {
        this.opcion = 0;
        this.rendirse = false;
        this.opcionBatalla = 0;
        this.defensaActiva = false;
        this.aventurero = aventurero;
        this.pierdePuntos = pierdePuntos;// true = pierde puntos ; false = es reubicado
        this.tipoDePuntos = tipoDePuntos;
        this.puntosAQuitar = puntosAQuitar;
        this.puedeAbandonar = puedeAbandonar;
        this.pirata = new Pirata(aventurero);//Crea el pirata
    }

    /**
     * Método encargado de verificar si la partida se ha terminado
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
        return false;//si no ha terminado la partida
    }

    /**
     * Método encargado de aplicar los efectos una vez la partida ha sido
     * terminada.
     */
    private void aplicarEfectosPartidaTerminada() {
        if (this.pirata.getVida() <= 0) {// Aventurero ganador
            aplicarEfectosAventureroGanador();
        } else if (this.aventurero.getVida() <= 0) {// Aventurero perdedor
            aplicarEfectosAventureroPerdedor();
        }//No hay else, porque no puede haber empate.
    }

    /**
     * Método encargado de aplicar los efectos de la batalla al jugador.
     */
    private void aplicarEfectosAventureroGanador() {
        //Aplica los efectos de la batalla
        this.aventurero.setBatallas(this.aventurero.getBatallas() + 1);
        this.aventurero.setBatallasGanadas(this.aventurero.getBatallasGanadas() + 1);
        this.aventurero.setVida(aventurero.getVidaTotal());
        this.aventurero.setMana(aventurero.getManaMaximo());
        do {
            System.out.println("   Oh gran aventurero " + aventurero.getNombre() + " como agradecimiento por derrotar al temible pirata " + pirata.getNombre() + " los aldeanos se ofrecen a ayudarte en tu travesia");
            System.out.println("   Seleacciona tu recompensa: [1] Aumentar el ataque en 1   [2] Aumentar tu defensa en 1   [3] Aumentar tu vida en 1   [4] Aumentar tu mana en 1");
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcion = 5;
            }
            switch (opcion) {//Aumenta 1 punto en la estadística que el jugador haya deseado
                case 1 -> {
                    aventurero.setAtaque(aventurero.getAtaque() + 1);
                    System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " tu ataque ha aumentado 1, tienes " + aventurero.getAtaque() + " puntos de ataque" + CYAN + " ------------------------- " + RESETEAR);
                }
                case 2 -> {
                    aventurero.setDefensa(aventurero.getDefensa() + 1);
                    System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " tu defensa ha aumentado 1, tienes " + aventurero.getDefensa() + " puntos de defensa" + CYAN + " ------------------------- " + RESETEAR);
                }
                case 3 -> {
                    aventurero.setVidaTotal(aventurero.getVida() + 1);
                    aventurero.setVida(aventurero.getVida() + 1);
                    System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " tu vida ha aumentado 1, tienes " + aventurero.getVida() + " puntos de vida" + CYAN + " ------------------------- " + RESETEAR);
                }
                case 4 -> {
                    aventurero.setManaMaximo(aventurero.getMana() + 1);
                    aventurero.setMana(aventurero.getMana() + 1);
                    System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " tu mana ha aumentado 1, tienes " + aventurero.getMana() + " puntos de mana" + CYAN + " ------------------------- " + RESETEAR);
                }
                default -> {
                    errorEncontrado();
                }
            }
        } while (opcion < 0 || opcion >= 5);
    }

    /**
     * Método encargado de aplicar los efectos del aventurero perdedor tanto de
     * la batalla como los de la casilla SI Y SÓLO SI, ESTOS EFECTOS SON DE
     * QUTIAR PUNTOS, LOS DE REHUBICACIÓN SE ENCARGA LA CASILLA, NO ESTE MÉTODO
     */
    private void aplicarEfectosAventureroPerdedor() {
        //Aplica efectos Batalla
        System.out.println(CYAN + "                                   " + RESETEAR + "Aventurero " + aventurero.getNombre() + " tras tu ardua batalla contra el pirata " + pirata.getNombre() + " saliste herido,\n                                      tu vida y mana se han restablecido a lo que tenías antes de iniciar la batalla");
        this.aventurero.setBatallasPerdidas(this.aventurero.getBatallasPerdidas() + 1);
        aventurero.setVida(aventurero.getVidaPrevioAUnaBatalla());
        aventurero.setMana(aventurero.getManaPrevioAUnaBatalla());
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + " Tienes " + aventurero.getVidaPrevioAUnaBatalla() + " puntos de vida y " + " Tienes " + aventurero.getManaPrevioAUnaBatalla() + " puntos de mana" + CYAN + " ------------------------- " + RESETEAR);
        //Aplica efectos Casilla
        if (pierdePuntos = true) {
            switch (tipoDePuntos) {
                case 1 -> {//quita vida
                    aventurero.setVida(aventurero.getVida() - puntosAQuitar);
                    System.out.println("Por el efecto de las casillas, has perdido " + puntosAQuitar + " de vida, tienes " + aventurero.getVida());
                }
                case 2 -> {//quita mana
                    aventurero.setMana(aventurero.getMana() - puntosAQuitar);
                    System.out.println("Por el efecto de las casillas, has perdido " + puntosAQuitar + " de mana, tienes " + aventurero.getMana());
                }
                case 3 -> {//quita ataque
                    aventurero.setAtaque(aventurero.getAtaque() - puntosAQuitar);
                    System.out.println("Por el efecto de las casillas, has perdido " + puntosAQuitar + " de ataque, tienes " + aventurero.getAtaque());
                }
                case 4 -> {//quita defensa
                    aventurero.setDefensa(aventurero.getDefensa() - puntosAQuitar);
                    System.out.println("Por el efecto de las casillas, has perdido " + puntosAQuitar + " de defensa, tienes " + aventurero.getDefensa());
                }
                default -> {
                    aventurero.setVida(aventurero.getVida() - puntosAQuitar);
                    System.out.println("Por el efecto de las casillas, has perdido " + puntosAQuitar + " de vida, tienes " + aventurero.getVida());
                }
            }
        }
    }

    /**
     * Método encargado de hacer que el pirata y el jugador se menten la madre.
     */
    public void pelear() {
        System.out.println("                                              Aventurero " + aventurero.getNombre() + ", tu rival es el temible pirata " + pirata.getNombre() + " ten cuidado");
        System.out.println(MAGENTA + "                                                                      ¡ES MUY PELIGROSO!" + RESETEAR);
        int contador = 3;
        do {
            if (contador <= 0) {
                defensaActiva = false;
                aventurero.setDefensa(aventurero.getDefensaPrevioAUnaBatalla());
                contador = 3;
            }
            pirata.mostrarInformacion();//1. Mostrar información del pirata
            do {//Se evita que el usuario introduzca un número fuera de lo esperado
                new DiseñoBatallas().mostrarEscenarioBatalla();//2. Mostrar escenario batalla
                new DiseñoBatallas().verOpcionesBatalla(aventurero);//3. Mostrar opciones de batalla
                try {//se evita que introduzca un string
                    opcionBatalla = scanner.nextInt();
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    opcionBatalla = 5;
                }
                switch (opcionBatalla) {//4. Seleccionar opción
                    case 1 -> //atacar
                        aventurero.atacar(pirata);//5. Mostrar efectos realizados al pirata
                    case 2 -> //curar
                        aventurero.curar();
                    case 3 -> {//defender
                        if (defensaActiva == true) {
                            System.out.println("Ya tienes activa la defensa, pierdes tu turno");
                        } else {
                            aventurero.defender();
                            defensaActiva = true;
                            contador = 3;
                        }
                    }
                    case 4 -> {//rendirse
                        if (puedeAbandonar == true) {
                            rendirse = true;
                            break;
                        } else {
                            System.out.println("No te puedes rendir, dirigete en el menú y cambia las configuraciones");
                        }
                    }
                    default ->
                        errorEncontrado();
                }
            } while (opcionBatalla < 0 || opcionBatalla >= 5);
            if (pirata.getVida() > 0 && rendirse == false) {//5. Verificar si el pirata sigue vivo y que el jugador no se haya rendido.
                pirata.atacar(aventurero);//6. Pirata ataca y muestra información del daño que ha realizado el pirata al jugador
            }
            contador--;
        } while (!batallaTerminada());//7. Verificar si la partida no se ha terminado
        aplicarEfectosPartidaTerminada();//8. Al terminar la paritda se aplican los efectos
    }
}
