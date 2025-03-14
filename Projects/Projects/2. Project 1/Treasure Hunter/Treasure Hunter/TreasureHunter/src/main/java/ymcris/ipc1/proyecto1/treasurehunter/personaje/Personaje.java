package ymcris.ipc1.proyecto1.treasurehunter.personaje;

/**
 * Clase encargada de crear objetos del tipo Aventurer
 *
 * @author YmCris
 * @since Mar 13, 2025
 */
public class Personaje {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int vida;
    private int mana;
    private int ataque;
    private int defensa;
    private char simbolo;

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nombre;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
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

    //GETTERS & SETTERS --------------------------------------------------------
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
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
