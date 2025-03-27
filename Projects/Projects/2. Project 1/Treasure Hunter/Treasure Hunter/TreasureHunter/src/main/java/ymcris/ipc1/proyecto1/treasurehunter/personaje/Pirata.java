package ymcris.ipc1.proyecto1.treasurehunter.personaje;

import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.NEGRO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

/**
 * Clase encargada de crear piratas, aumentar su dificultad y atacar al
 * aventurero durante una batalla por el tesoro.
 *
 * @author YmCris
 * @see Personaje
 * @since Mar 14, 2025
 */
public final class Pirata extends Personaje {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método constructor encargado de construir un pirata iniciando sus
     * atributos en base a un aventurero
     *
     * @param aventurero Aventurero con el que peleará
     */
    public Pirata(Aventurero aventurero) {
        //En base a las fórmulas dadas se inicializan los atributos del pirata.
        this.nombre = "Barba Negra";
        this.vida = random.nextInt(aventurero.getVida() - (aventurero.getVida()) / 2, aventurero.getVida() + (aventurero.getVida()) / 2);
        this.mana = random.nextInt(aventurero.getMana() - (aventurero.getMana()) / 2, aventurero.getMana() + (aventurero.getMana()) / 2);
        this.ataque = random.nextInt(aventurero.getAtaque() - (aventurero.getAtaque()) / 2, aventurero.getAtaque() + (aventurero.getAtaque()) / 2);
        this.defensa = random.nextInt(aventurero.getDefensa() - (aventurero.getDefensa()) / 2, aventurero.getDefensa() + (aventurero.getDefensa()) / 2);
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de mostrar la información del pirata durante la batalla.
     */
    public void mostrarInformacion() {
        System.out.println(NEGRO + "                        ------------------------- " + RESETEAR + this.getNombre() + ": " + "Vida: " + this.getVida() + " Mana: " + this.getMana() + " Ataque: " + this.getAtaque() + " Defensa: " + this.getDefensa() + NEGRO + " ------------------------- " + RESETEAR);
    }

}
