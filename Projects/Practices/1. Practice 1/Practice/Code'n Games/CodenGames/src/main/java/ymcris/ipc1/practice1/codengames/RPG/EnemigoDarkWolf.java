package ymcris.ipc1.practice1.codengames.RPG;

/**
 * Clase encargada de crear un Enemigo del tipo DarkWolf
 *
 * @Date Feb 15, 2025
 * @author YmCris
 * @see Enemigo
 */
public class EnemigoDarkWolf extends Enemigo {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public EnemigoDarkWolf() {
        this.hp = 100;
        this.vidaMaxima = 100;
        this.nombre = "darkwolf";
        this.dificultad = "facil";
        this.FACTOR_DE_ATAQUE = 10;
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    protected void modificarDificultad(String dificultad, int hp, int factorDeAtaque) {
        this.dificultad = dificultad;
        this.hp = hp;
        this.FACTOR_DE_ATAQUE = factorDeAtaque;
    }

}
