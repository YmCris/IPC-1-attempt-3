package ymcris.ipc1.practice1.codengames.RPG;

import static ymcris.ipc1.practice1.codengames.RPG.RPG.jugador;

/**
 * Clase encargada de ser la clase abstracta "padre" de los enemigos. Crear
 * enemigos, Define su daño y atacar a un personaje
 *
 * @Date Feb 15, 2025
 * @author YmCris
 */
public abstract class Enemigo {

    // VARIABLES ---------------------------------------------------------------
    protected int hp;
    protected String nombre;
    protected int dañoARealizar;
    protected String dificultad;
    protected int FACTOR_DE_ATAQUE;
    protected final String RESETEAR = "\033[0m";
    protected final String MAGENTA = "\033[95m";

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    /**
     * Método encargado de calcular el daño que le van a realizar al PERSONAJE.
     *
     * @param personaje - PERSONAJE al cual se le calculará el daño.
     * @return - daño (daño que le hará al PERSONAJE)
     */
    protected abstract int calcularDaño(Personaje personaje);

    /**
     * Método encargado de realizar el daño a un PERSONAJE.
     *
     * @param personaje - Personaje al cual le aplicará el daño.
     */
    protected abstract void atacar(Personaje personaje);

    /**
     * Método encargado de aumentar la dificultad de un enemigo.
     *
     * @param dificultad - Nueva dificultad que tendrá el enemigo.
     * @param hp - Nuevo hp que tendrá el enemigo.
     * @param factorDeAtaque - Nuevo factor de ataque ("Daño") que tendrá el
     * enemigo.
     */
    protected abstract void modificarDificultad(String dificultad, int hp, int factorDeAtaque);

    /**
     * Método encargado de que el enemigo reciba el daño y verifica si el
     * enemigo ha muerto.
     *
     * @param daño - Daño que recibirá el enemigo.
     * @return true si el enemigo ha muerto.
     */
    public boolean recibirDaño(int daño) {
        this.hp -= daño;
        if (this.hp < 0) {
            this.hp = 0;
            System.out.println(MAGENTA + "                                           El enemigo " + this.nombre + " ha sido vencido por " + jugador.getNombre() + RESETEAR);
            jugador.setMonstruosVencidos(+1);
            return true;
        }
        return false;
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
