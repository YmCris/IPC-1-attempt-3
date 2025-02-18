package ymcris.ipc1.practice1.codengames.RPG;

/**
 * Clase encargada de crear un Enemigo del tipo Dragon
 *
 * @since Feb 15, 2025
 * @author YmCris
 * @see Enemigo
 */
public class EnemigoDragon extends Enemigo {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public EnemigoDragon() {
        this.hp = 200;
        this.vidaMaxima = 200;
        this.nombre = "dragon";
        this.dificultad = "media";
        this.FACTOR_DE_ATAQUE = 15;
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    protected void modificarDificultad(String dificultad, int hp, int factorDeAtaque) {
        this.dificultad = dificultad;
        this.hp = hp;
        this.FACTOR_DE_ATAQUE = factorDeAtaque;
    }

}
