package ymcris.ipc1.practica2.codengames.hunting.backend.jugador;

/**
 * Clase Jugador es la clase de referenciar al jugador dentro del juego de
 * Hunter.
 *
 * @author YmCris
 * @see Predatorable
 * @since Apr 8, 2025
 */
public class Jugador implements Predatorable {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nombre;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int puntaje;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public void disparar() {
        System.out.println("Piu piu");
    }

    // GETTERS -----------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    // SETTERS -----------------------------------------------------------------
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

}
