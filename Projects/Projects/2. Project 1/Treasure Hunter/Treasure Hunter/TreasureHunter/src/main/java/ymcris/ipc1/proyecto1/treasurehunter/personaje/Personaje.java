package ymcris.ipc1.proyecto1.treasurehunter.personaje;

import java.util.Random;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

/**
 * SuperClase encargada de crear objetos del tipo Personaje, de los cuales
 * heredarán los objetos aventurero y pirata
 *
 * @author YmCris
 * @since Mar 13, 2025
 */
public abstract class Personaje {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    protected int vida;
    protected int mana;
    protected int ataque;
    protected int defensa;
    protected char simbolo;

    // VARIABLES DE REFERENCIA -------------------------------------------------
    protected String nombre;

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();

    // MÉTODOS CONSTRUCTORES ---------------------------------------------------
    /**
     * Método creador de Personajes.
     *
     * @param vida - Vida inicial del personaje
     * @param mana - Mana inicial del personaje
     * @param ataque - Ataque inicial del personaje
     * @param defensa - Defensa inicial del personaje
     * @param nombre - Nombre del personaje
     */
    public Personaje(int vida, int mana, int ataque, int defensa, String nombre) {
        this.vida = vida;
        this.mana = mana;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nombre = nombre;
        this.simbolo = nombre.charAt(0);
    }

    /**
     * Constructor vacio para el pirata ya que el se instancia con un aventurero
     * y de ahí se sacan sus atributos
     */
    public Personaje() {
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de que el personaje reciba daño durante la batalla,
     * final porque no esta pensasod para que una clase hija lo sobreescriba
     *
     * @param daño - Daño que recibirá
     */
    public final void recibirDaño(int daño) {
        this.setVida(this.getVida() - daño);
        if (this.getVida() <= 0) {
            this.setVida(0);
        }
    }

    /**
     * Método encargado de atacar a un personaje, final porque no esta pensasod
     * para que una clase hija lo sobreescriba
     *
     * @param personaje - Personaje al cual se atacará
     */
    public final void atacar(Personaje personaje) {
        int dañoARealizar = random.nextInt(0, (this.getAtaque() - personaje.getDefensa()) + 1);//Forma random de hacer que la defensa sirva para recibir daño
        personaje.recibirDaño(dañoARealizar);
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + this.getNombre() + " le ha realizado " + dañoARealizar + " de daño a " + personaje.getNombre() + ", le quedan " + personaje.getVida() + " puntos de vida" + CYAN + " ------------------------- " + RESETEAR);
    }

    //GETTERS & SETTERS --------------------------------------------------------
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
        if (this.mana < 0) {
            this.mana = 0;
        }
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
