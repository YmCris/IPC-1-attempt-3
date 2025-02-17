package ymcris.ipc1.practice1.codengames.RPG;

import java.util.Random;
import java.util.Scanner;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.aventureroDragon;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.aventureroGolem;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.aventureroLobo;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.verOpcionesBatalla;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.verOpcionesItems;

/**
 * Clase encargada de simular la batalla entre los personajes y los enemigos.
 * Las opciones que se tienen durante la batalla (atacar, curar, item, tengo
 * miedo) y verificar si la partida ha acabo y aplicar sus consecuencias.
 *
 * @Date Feb 16, 2025
 * @author YmCris
 */
public class Batallas {

    // VARIABLES ---------------------------------------------------------------
    private Enemigo enemigo;
    private Enemigo[] enemigos;
    private Personaje personaje;
    private boolean batallaTerminada;
    private final String AZUL;
    private final String RESETEAR;
    protected final String MAGENTA;

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();
    Enemigo wolf = new EnemigoDarkWolf();
    Enemigo dragon = new EnemigoDragon();
    Enemigo golem = new EnemigoMightyGolem();
    Inventario inventario = new Inventario();
    Scanner scanner = new Scanner(System.in);

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Batallas(Personaje personaje) {
        this.MAGENTA = "\033[95m";
        this.RESETEAR = "\033[0m";
        this.AZUL = "\033[34m";
        this.personaje = personaje;
        this.batallaTerminada = false;
        this.enemigos = new Enemigo[]{wolf, dragon, golem};
    }

    // MÉTODOS -----------------------------------------------------------------
    private Enemigo elegirEnemigoAleatorio() {
        int numero = random.nextInt(enemigos.length);
        enemigo = enemigos[numero];
        return enemigo;
    }

    private boolean escaparDeLaBatalla() {
        int oroParaEscapar = (personaje.getNivel() * 2) + random.nextInt(5, 11);//[5,10]
        if (personaje.getOro() >= oroParaEscapar) {
            System.out.println(AZUL + "                                          ---------- " + RESETEAR + "Aventurero " + personaje.getNombre() + " has logrado escapar del temible " + enemigo.getNombre() + " pero él se ha quedado con tu oro" + AZUL + " ---------- " + RESETEAR);
            personaje.setOro(-oroParaEscapar);
            System.out.println(AZUL + "                                          ---------- " + RESETEAR + "Has perdido " + oroParaEscapar + " de oro, tu oro actual es de " + personaje.getOro() + AZUL + " ---------- " + RESETEAR);
            return batallaTerminada = true;
        } else {
            System.out.println(AZUL + "                                          ---------- " + RESETEAR + personaje.getNombre() + " no tienes el oro suficiente, debes seguir peleando" + AZUL + " ---------- " + RESETEAR);
            return batallaTerminada = false;
        }
    }

    private void aplicarConsecuenciasBatalla() {
        if (personaje.getHp() > 0) {
            int experienciaGanada = random.nextInt(20, 31);//[20,30]
            int oroGanado = random.nextInt(15, 46);//[15,46]
            personaje.setExperiencia(+experienciaGanada);
            personaje.setOro(+oroGanado);
            System.out.println(MAGENTA + "                                          ---------- " + RESETEAR + "Felicidades valiente Aventurero, por derrotar al " + enemigo.getNombre() + " has recibido " + experienciaGanada + " de experiencia y " + oroGanado + " de oro" + MAGENTA + " ---------- " + RESETEAR);
        } else if (personaje.getHp() <= 0) {
            System.out.println(MAGENTA + "                                          ---------- " + RESETEAR + "Tras la ardua batalla contra " + enemigo.getNombre() + " perdiste muchos artículos valiosos" + MAGENTA + " ---------- " + RESETEAR);
            System.out.println(MAGENTA + "                                             ---------- " + RESETEAR + "Todos tus logros se han esfumado, puedes verificar tu status en el menú" + MAGENTA + " ---------- " + RESETEAR);
            personaje.resetearEstadisticas();
        }
    }

    private boolean verificarPartidaTerminada() {
        if (personaje.getHp() <= 0) {
            aplicarConsecuenciasBatalla();
            return batallaTerminada = true;
        } else if (enemigo.getHp() <= 0) {
            System.out.println(AZUL + "                                          ---------- " + RESETEAR + "Bien hecho aventurero " + personaje.getNombre() + " has logrado derrotar al temible " + enemigo.getNombre() + AZUL + " ---------- " + RESETEAR);
            aplicarConsecuenciasBatalla();
            return batallaTerminada = true;
        } else {
            return batallaTerminada = false;
        }
    }

    private void atacarEnemigo() {
        int ataquePersonaje = ((personaje.getNivel() + 1) * 10) + random.nextInt(10, 21);
        if (enemigo.getHp() > 0) {
            enemigo.recibirDaño(ataquePersonaje);
            System.out.println(AZUL + "                                         ---------- " + RESETEAR + personaje.getNombre() + " le has hecho " + ataquePersonaje + " de daño a " + enemigo.getNombre() + AZUL + " ---------- " + RESETEAR);
            System.out.println(AZUL + "                                                   ---------- " + RESETEAR + enemigo.getNombre() + " tiene " + enemigo.hp + " de vida" + AZUL + " ---------- " + RESETEAR);
        }
    }

    private void curarPersonaje() {
        int curacionPersonaje = ((personaje.getNivel() + 1) * 5) + random.nextInt(15, 26);
        if (personaje.getHp() < personaje.getHpMaximo()) {
            if (personaje.getMp() > 0) {
                personaje.setHp(curacionPersonaje);
                personaje.setMp(-1);
                System.out.println(AZUL + "                                          ---------- " + RESETEAR + personaje.getNombre() + " te has curado " + curacionPersonaje + ", tienes " + personaje.getHp() + " de vida y " + personaje.getMp() + " de mana" + AZUL + " ---------- " + RESETEAR);
            } else if (personaje.getMp() <= 0) {
                System.out.println(AZUL + "                                          ---------- " + RESETEAR + personaje.getNombre() + " no tienes mana para curarte" + AZUL + " ---------- " + RESETEAR);
            }
        } else {
            System.out.println(AZUL + "                                          ---------- " + RESETEAR + "No puedes curarte, tu hp esta en su capacidad máxima :)" + AZUL + " ---------- " + RESETEAR);
        }
    }

    private void seleccionarItem() {
        int indice;
        String[] items = {"potion", "mpotion", "hipotion"};
        do {
            inventario.mostrarItems();
            mostrarEscenarioBatalla();
            verOpcionesItems();
            indice = scanner.nextInt();
        } while (indice < 1 || indice > items.length);
        inventario.usarItem(items[indice - 1], personaje);
    }

    public void pelear() {
        System.out.println("\n".repeat(100));
        elegirEnemigoAleatorio();
        System.out.println(AZUL + "Tu enemigo es: " + enemigo.getNombre() + " con una dificultad " + enemigo.getDificultad() + RESETEAR);
        System.out.println("                              Aventurero " + personaje.getNombre() + " ten cuidado " + enemigo.getNombre() + ", ES MUY PELIGROSO");
        batallaTerminada = false;
        int opcionJugador;
        do {
            System.out.println("");
            mostrarEscenarioBatalla();
            verOpcionesBatalla(personaje);
            opcionJugador = scanner.nextInt();
            switch (opcionJugador) {
                case 1 -> //atacar
                    atacarEnemigo();
                case 2 -> //curar
                    curarPersonaje();
                case 3 -> //usarItem
                    seleccionarItem();
                case 4 -> //tengomiedo (lit)
                    escaparDeLaBatalla();
                default ->
                    System.out.println("Elige una opción válida.");
            }
            verificarPartidaTerminada();
            enemigo.atacar(personaje);
            verificarPartidaTerminada();
        } while (batallaTerminada == false);
    }

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
