package ymcris.ipc1.proyecto1.treasurehunter.personaje;

/**
 * Clase encargada de crear piratas, aumentar su dificultad y atacar al
 * aventurero durante una batalla por el tesoro.
 *
 * @author YmCris
 * @since Mar 14, 2025
 */
public final class Pirata extends Personaje {

    private final String NEGRO = "\u001B[90m";
    private final String RESETEAR = "\u001B[0m";

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Pirata(Aventurero aventurero) {
        this.nombre = "Barba Negra";
        this.vida = random.nextInt(aventurero.getVida() - (aventurero.getVida()) / 2, aventurero.getVida() + (aventurero.getVida()) / 2);
        this.mana = random.nextInt(aventurero.getMana() - (aventurero.getMana()) / 2, aventurero.getMana() + (aventurero.getMana()) / 2);
        this.ataque = random.nextInt(aventurero.getAtaque() - (aventurero.getAtaque()) / 2, aventurero.getAtaque() + (aventurero.getAtaque()) / 2);
        this.defensa = random.nextInt(aventurero.getDefensa() - (aventurero.getDefensa()) / 2, aventurero.getDefensa() + (aventurero.getDefensa()) / 2);
    }

    /**
     * Método encargado de mostrar la información del pirata.
     */
    public void mostrarInformacion() {
        System.out.println(NEGRO + "                        ------------------------- " + RESETEAR + this.getNombre() + ": " + "Vida: " + this.getVida() + " Mana: " + this.getMana() + " Ataque: " + this.getAtaque() + " Defensa: " + this.getDefensa() + NEGRO + " ------------------------- " + RESETEAR);
    }

}
