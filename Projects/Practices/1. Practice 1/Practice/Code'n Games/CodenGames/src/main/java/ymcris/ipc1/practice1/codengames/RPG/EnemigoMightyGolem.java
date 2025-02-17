package ymcris.ipc1.practice1.codengames.RPG;

import java.util.Random;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.jugador;

/**
 * Clase encargada de crear un Enemigo del tipo Mighty Golem
 *
 * @Date Feb 15, 2025
 * @author YmCris
 * @see Enemigo
 */
public class EnemigoMightyGolem extends Enemigo {

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();

    // MÉTODO CONSTRUCTO -------------------------------------------------------
    public EnemigoMightyGolem() {
        this.hp = 350;
        this.nombre = "golem";
        this.dificultad = "alta";
        this.FACTOR_DE_ATAQUE = 25;
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
        System.out.println(MAGENTA + "                     --------------- " + RESETEAR + this.nombre + " ha lastimado al aventurero " + jugador.getNombre() + " y le ha hecho " + daño + " de daño." + MAGENTA + " --------------- " + RESETEAR);
        if (personaje.getHp() <= 0) {
            System.out.println(MAGENTA + "                                               --------------- " + RESETEAR + "El jugador " + jugador.getNombre() + " ha sido derrotado por " + this.getNombre() + MAGENTA + " --------------- " + RESETEAR);
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
