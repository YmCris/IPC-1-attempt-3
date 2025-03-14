package ymcris.ipc1.proyecto1.treasurehunter.personaje;

/**
 * Clase encargada de crear piratas para batallar por el tesoro.
 *
 * @author YmCris
 * @since Mar 14, 2025
 */
public class Pirata extends Personaje {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int dificultad;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Pirata(int dificultad, int vida, int mana, int ataque, int defensa, String nombre) {
        super(vida, mana, ataque, defensa, nombre);
        this.dificultad = dificultad;
    }

    // MÉTODOS -----------------------------------------------------------------
    public void atacar(Aventurero aventurero) {
        
    }

}
