package ymcris.ipc1.practice1.codengames.RPG;

import java.util.Random;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.jugador;

/**
 * Clase encargada de ser la clase abstracta "padre" de los enemigos. Crear
 * enemigos, Definir su daño y atacar a un personaje y recibir daño.
 *
 * @Date Feb 15, 2025
 * @author YmCris
 */
public abstract class Enemigo {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    protected String nombre;
    protected String dificultad;
    protected final String RESETEAR = "\033[0m";
    protected final String MAGENTA = "\033[95m";
    // VARIABLE PRIMITIVAS -----------------------------------------------------
    protected int hp;
    protected int vidaMaxima;
    protected int dañoARealizar;
    protected int FACTOR_DE_ATAQUE;

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    /**
     * Método encargado de aumentar la dificultad de un enemigo.
     *
     * @param dificultad - Nueva dificultad que tendrá el enemigo.
     * @param hp - Nuevo hp que tendrá el enemigo.
     * @param factorDeAtaque - Nuevo factor de ataque ("Daño") que tendrá el
     * enemigo.
     */
    protected abstract void modificarDificultad(String dificultad, int hp, int factorDeAtaque);//Abstracto porque puede depender de cada enemigo la forma en la que aumentarian

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de calcular el daño que le van a realizar al PERSONAJE.
     *
     * @param personaje - PERSONAJE al cual se le calculará el daño.
     * @return - daño (daño que le hará al PERSONAJE)
     */
    protected int calcularDaño(Personaje personaje) {
        dañoARealizar = random.nextInt((FACTOR_DE_ATAQUE + personaje.getNivel()), (FACTOR_DE_ATAQUE + personaje.getNivel() + 10) + 1);// +1 porque el bound excluye el ultimo valor "[)"
        return dañoARealizar;
    }

    /**
     * Método encargado de realizar el daño a un PERSONAJE.
     *
     * @param personaje - Personaje al cual le aplicará el daño.
     */
    protected void atacar(Personaje personaje) {
        if (personaje.getHp() <= 0) {//Verifica que el personaje no haya muerto.
            System.out.println("El jugador " + jugador.getNombre() + " ya ha sido derrotado.");
            return;
        }
        int daño = calcularDaño(personaje);
        personaje.setHp(-daño);//Daña al personaje
        System.out.println(MAGENTA + "                                     --------------- " + RESETEAR + this.nombre + " ha lastimado al aventurero " + jugador.getNombre() + " y le ha hecho " + daño + " de daño" + MAGENTA + " --------------- " + RESETEAR);
        if (personaje.getHp() <= 0) {//Verifica si el ataque mató al personaje.
            System.out.println(MAGENTA + "                                               --------------- " + "El jugador " + jugador.getNombre() + " ha sido derrotado por " + this.getNombre() + MAGENTA + " --------------- " + RESETEAR);
        }
    }

    /**
     * Método encargado de que el enemigo reciba el daño y verifica si el
     * enemigo ha muerto.
     *
     * @param daño - Daño que recibirá el enemigo.
     * @return true si el enemigo ha muerto.
     */
    public boolean recibirDaño(int daño) {
        this.hp -= daño;
        if (this.hp < 0) {//para que no tenga una vida negativa
            this.hp = 0;
            System.out.println(MAGENTA + "                                                               El enemigo " + this.nombre + " ha sido vencido por " + jugador.getNombre() + RESETEAR);
            return true;
        }
        return false;
    }

    /**
     * Método encargado de recuperar la vida del enemigo después de una batalla.
     */
    protected void resetearVida() {
        this.hp = this.vidaMaxima;
    }

    // GETTERS & SETTERS -------------------------------------------------------
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getFACTOR_DE_ATAQUE() {
        return FACTOR_DE_ATAQUE;
    }

    public void setFACTOR_DE_ATAQUE(int FACTOR_DE_ATAQUE) {
        this.FACTOR_DE_ATAQUE = FACTOR_DE_ATAQUE;
    }

}
