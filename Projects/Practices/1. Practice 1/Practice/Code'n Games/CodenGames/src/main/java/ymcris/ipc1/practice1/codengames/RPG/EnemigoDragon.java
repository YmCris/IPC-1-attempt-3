package ymcris.ipc1.practice1.codengames.RPG;

import java.util.Random;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.jugador;

/**
 * Clase encargada de crear un Enemigo del tipo Dragon
 *
 * @Date Feb 15, 2025
 * @author YmCris
 * @see Enemigo
 */
public class EnemigoDragon extends Enemigo {

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();

    // MÉTODO CONSTRUCTO -------------------------------------------------------
    public EnemigoDragon() {
        this.hp = 200;
        this.nombre = "dragon";
        this.dificultad = "media";
        this.FACTOR_DE_ATAQUE = 15;
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    protected void atacar(Personaje personaje) {
        if (personaje.getHp() <= 0) {
            System.out.println("El jugador " + jugador.getNombre() + " ya ha sido derrotado.");
            return;
        }
        int daño = calcularDaño(personaje);
        personaje.setHp(-daño);
        if (personaje.getHp() <= 0) {
            System.out.println("El jugador " + jugador.getNombre() + " ha sido derrotado por " + this.getNombre());
        }
    }

    @Override
    protected int calcularDaño(Personaje personaje) {
        dañoARealizar = random.nextInt((FACTOR_DE_ATAQUE + personaje.getNivel()), (FACTOR_DE_ATAQUE + personaje.getNivel() + 10) + 1);// +1 porque el bound excluye el ultimo valor "[)"
        return dañoARealizar;
    }

    @Override
    protected void modificarDificultad(String dificultad, int hp, int factorDeAtaque) {
        this.dificultad = dificultad;
        this.hp = hp;
        this.FACTOR_DE_ATAQUE = factorDeAtaque;
    }

}
