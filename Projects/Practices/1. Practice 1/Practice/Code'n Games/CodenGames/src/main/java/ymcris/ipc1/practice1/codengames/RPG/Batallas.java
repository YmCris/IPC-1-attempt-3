package ymcris.ipc1.practice1.codengames.RPG;

import java.util.Random;
import java.util.Scanner;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.aventureroDragon;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.aventureroGolem;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.aventureroLobo;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.verOpcionesBatalla;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.verOpcionesItems;
import static ymcris.ipc1.practice1.codengames.reportes.Reportes.setContadorJugadorEnBatallaRPG;
import static ymcris.ipc1.practice1.codengames.reportes.Reportes.setContadorJugadorPerdedorRPG;

/**
 * Clase encargada de simular la batalla entre los personajes y los enemigos.
 * Las opciones que se tienen durante la batalla (atacar, curar, item, tengo
 * miedo) y verificar si la partida ha acabo y aplicar sus consecuencias.
 *
 * @Date Feb 16, 2025
 * @author YmCris
 * @see Enemigo
 * @see Personaje
 */
public class Batallas {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Enemigo enemigo;
    private Enemigo[] enemigos;
    private Personaje personaje;
    private final String AZUL;
    private final String RESETEAR;
    private final String MAGENTA;
    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private boolean batallaTerminada;

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();
    Enemigo wolf = new EnemigoDarkWolf();
    Enemigo dragon = new EnemigoDragon();
    Enemigo golem = new EnemigoMightyGolem();
    Inventario inventario = new Inventario();
    Scanner scanner = new Scanner(System.in);

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método constructor encargado de crear una batalla.
     *
     * @param personaje - Personaje el cual va a pelear.
     */
    public Batallas(Personaje personaje) {
        this.MAGENTA = "\033[95m";
        this.RESETEAR = "\033[0m";
        this.AZUL = "\033[34m";
        this.personaje = personaje;
        this.batallaTerminada = false;
        this.enemigos = new Enemigo[]{wolf, dragon, golem};
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de seleccionar un enemigo aleatorio.
     *
     * @return Enemigo que será el oponente en la batalla
     */
    private Enemigo elegirEnemigoAleatorio() {
        int numero = random.nextInt(enemigos.length);
        enemigo = enemigos[numero];//Selecciona un enemigo x definido en el constructor
        return enemigo;
    }

    /**
     * Método encargado de "Tengo miedo", el cual verifica si el jugador tiene
     * el oro suficiente para salir y se lo resta.
     *
     * @return true si el aventurero tiene el oro y escapa.
     */
    private boolean escaparDeLaBatalla() {
        int oroParaEscapar = (personaje.getNivel() * 2) + random.nextInt(5, 11);//[5,10] FORMULA DADA
        if (personaje.getOro() >= oroParaEscapar) {
            System.out.println(AZUL + "                                ---------- " + RESETEAR + "Aventurero " + personaje.getNombre() + " has logrado escapar del temible " + enemigo.getNombre() + " pero él se ha quedado con tu oro" + AZUL + " ---------- " + RESETEAR);
            personaje.setOro(-oroParaEscapar);
            System.out.println(AZUL + "                                                     ---------- " + RESETEAR + "Has perdido " + oroParaEscapar + " de oro, tu oro actual es de " + personaje.getOro() + AZUL + " ---------- " + RESETEAR);
            return batallaTerminada = true;
        } else {
            System.out.println(AZUL + "                                          ---------- " + RESETEAR + personaje.getNombre() + " no tienes el oro suficiente, debes seguir peleando" + AZUL + " ---------- " + RESETEAR);
            return batallaTerminada = false;
        }
    }

    /**
     * Método encargado de aplicar las consecuencias en dado caso el jugador
     * haya ganado o perdido
     */
    private void aplicarConsecuenciasBatalla() {
        if (personaje.getHp() > 0) {//Jugador ganador (Aumenta oro y experiencia)
            int experienciaGanada = random.nextInt(20, 31);//[20,30]
            int oroGanado = random.nextInt(15, 46);//[15,46]
            personaje.setExperiencia(+experienciaGanada);
            personaje.setOro(+oroGanado);
            System.out.println(MAGENTA + "                                ---------- " + RESETEAR + "Felicidades valiente Aventurero, por derrotar al " + enemigo.getNombre() + " has recibido " + experienciaGanada + " de experiencia y " + oroGanado + " de oro" + MAGENTA + " ---------- " + RESETEAR);
        } else if (personaje.getHp() <= 0) {//Enemigo ganador, resetea los atributos del personaje derrotado
            System.out.println(MAGENTA + "                                          ---------- " + RESETEAR + "Tras la ardua batalla contra " + enemigo.getNombre() + " perdiste muchos artículos valiosos" + MAGENTA + " ---------- " + RESETEAR);
            System.out.println(MAGENTA + "                                             ---------- " + RESETEAR + "Todos tus logros se han esfumado, puedes verificar tu status en el menú" + MAGENTA + " ---------- " + RESETEAR);
            personaje.resetearEstadisticas();
        }
    }

    /**
     * Método encargado de verificar si la partida ha terminado.
     *
     * @return true si la partida ha terminado.
     */
    private boolean verificarPartidaTerminada() {
        if (personaje.getHp() <= 0) {//Verifica si el personaje no ha muerto
            aplicarConsecuenciasBatalla();
            setContadorJugadorPerdedorRPG(1);
            enemigo.resetearVida();//Resetea la vida del enemigo para que no empiece con la vida que tenia cuando mato al personaje
            return batallaTerminada = true;
        } else if (enemigo.getHp() <= 0) {//Verifica si el enemigo ha muerto
            System.out.println(AZUL + "                                          ---------- " + RESETEAR + "Bien hecho aventurero " + personaje.getNombre() + " has logrado derrotar al temible " + enemigo.getNombre() + AZUL + " ---------- " + RESETEAR);
            aplicarConsecuenciasBatalla();
            personaje.setMonstruosVencidos(+1);
            enemigo.resetearVida();//Resetea la vida del enemigo para que no empiece vida 0
            return batallaTerminada = true;
        } else {
            return batallaTerminada = false;
        }
    }

    /**
     * Método encargado de atacar a un enemigo basado el ataque del personaje.
     */
    private void atacarEnemigo() {
        int ataquePersonaje = ((personaje.getNivel() + 1) * 10) + random.nextInt(10, 21);//FORMULA DADA
        if (enemigo.getHp() > 0) {//VERIFICA si el enemigo aun no ha muerto
            enemigo.recibirDaño(ataquePersonaje);//Daña al enemigo con el ataque aleatorio.
            System.out.println(AZUL + "                                                        ---------- " + RESETEAR + personaje.getNombre() + " le has hecho " + ataquePersonaje + " de daño a " + enemigo.getNombre() + AZUL + " ---------- " + RESETEAR);
            System.out.println(AZUL + "                                                                  ---------- " + RESETEAR + enemigo.getNombre() + " tiene " + enemigo.hp + " de vida" + AZUL + " ---------- " + RESETEAR);
        }
    }

    /**
     * Método encargado de curar al personaje dependiendo si tiene el mana
     * suficiente o su vida no es máxima.
     */
    private void curarPersonaje() {
        int curacionPersonaje = ((personaje.getNivel() + 1) * 5) + random.nextInt(15, 26);//FORMULA DADA
        if (personaje.getHp() < personaje.getHpMaximo()) {//verifica si el perosnaje no tiene la vida full (no se curaría)
            if (personaje.getMp() > 0) {//verifica si tiene mana
                personaje.setHp(curacionPersonaje);
                personaje.setMp(-1);
                System.out.println(AZUL + "                                               ---------- " + RESETEAR + personaje.getNombre() + " te has curado " + curacionPersonaje + ", tienes " + personaje.getHp() + " de vida y " + personaje.getMp() + " de mana" + AZUL + " ---------- " + RESETEAR);
            } else if (personaje.getMp() <= 0) {
                System.out.println(AZUL + "                                                      ---------- " + RESETEAR + personaje.getNombre() + " no tienes mana para curarte" + AZUL + " ---------- " + RESETEAR);
            }
        } else {
            System.out.println(AZUL + "                                          ---------- " + RESETEAR + "No puedes curarte, tu hp esta en su capacidad máxima :)" + AZUL + " ---------- " + RESETEAR);
        }
    }

    /**
     * Método encargado de seleccionar una potion.
     */
    private void seleccionarItem() {
        int indice;
        String[] items = {"potion", "mpotion", "hipotion"};//nombres de los items
        do {//Repite las opciones para que no se crashee el programa
            inventario.mostrarItems();
            mostrarEscenarioBatalla();
            verOpcionesItems();
            indice = scanner.nextInt();
        } while (indice < 1 || indice > items.length);
        inventario.usarItem(items[indice - 1], personaje);
    }

    /**
     * Método encargado de ejecutar la pelea entre un personaje y un enemigo.
     */
    public void pelear() {
        setContadorJugadorEnBatallaRPG(+1);
        System.out.println("\n".repeat(100));
        elegirEnemigoAleatorio();
        System.out.println(AZUL + "                                      Tu enemigo es " + enemigo.getNombre() + " con una dificultad " + enemigo.getDificultad() + " con " + enemigo.getHp() + " de vida" + RESETEAR);
        System.out.println("                                        Aventurero " + personaje.getNombre() + " ten cuidado " + enemigo.getNombre() + ", ES MUY PELIGROSO");
        batallaTerminada = false;
        int opcionJugador;
        do {
            System.out.println("");
            mostrarEscenarioBatalla();
            verOpcionesBatalla(personaje);
            opcionJugador = scanner.nextInt();
            switch (opcionJugador) {//TURNO DEL JUGADOR
                case 1 -> //atacar
                    atacarEnemigo();
                case 2 -> //curar
                    curarPersonaje();
                case 3 -> //usarItem
                    seleccionarItem();
                case 4 -> {//tengomiedo (lit)
                    batallaTerminada = true;
                    escaparDeLaBatalla();
                    batallaTerminada = true;
                }
                default ->
                    System.out.println("Elige una opción válida.");
            }
            if (verificarPartidaTerminada() == false) {//VERIFICA QUE EL JUGADOR NO HAYA MATADO AL ENEMIGO
                enemigo.atacar(personaje);//TURNO DEL ENEMIGO
                if (personaje.getHp() <= 0) {//VERIFICA QUE EL ENEMIGO NO HAYA MATADO AL PERSONAJE
                    verificarPartidaTerminada();
                }
            }
        } while (batallaTerminada == false);
    }

    /**
     * Método encargado de elegir el escenario de la batalla dependiendo del
     * enemigo que haya sido elegido.
     */
    private void mostrarEscenarioBatalla() {
        String nombreEnemigo = enemigo.getNombre();
        switch (nombreEnemigo) {
            case "darkwolf" ->
                aventureroLobo();
            case "dragon" ->
                aventureroDragon();
            case "golem" ->
                aventureroGolem();
            default -> {
                System.out.println("No existe el enemigo, crealo en la sección crear enemigos (aun no disponible xd)");
            }
        }
    }

}
