package ymcris.ipc1.practice1.codengames.RPG;

/**
 * Clase encargada de crear un Enemigo del tipo Mighty Golem
 *
 * @since Feb 15, 2025
 * @author YmCris
 * @see Enemigo
 */
public class EnemigoMightyGolem extends Enemigo {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public EnemigoMightyGolem() {
        this.hp = 350;
        this.vidaMaxima = 350;
        this.nombre = "golem";
        this.dificultad = "alta";
        this.FACTOR_DE_ATAQUE = 25;
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    protected void modificarDificultad(String dificultad, int hp, int factorDeAtaque) {
        this.dificultad = dificultad;
        this.hp = hp;
        this.FACTOR_DE_ATAQUE = factorDeAtaque;
    }

}
