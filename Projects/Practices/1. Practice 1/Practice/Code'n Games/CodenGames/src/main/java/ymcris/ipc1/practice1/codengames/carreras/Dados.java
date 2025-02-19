package ymcris.ipc1.practice1.codengames.carreras;

import java.util.Random;

/**
 * Clase encargada de simular los dados y dar el resultado de X dados.
 *
 * @since Feb 9, 2025
 * @author YmCris
 */
public class Dados {

    // VARIABLES ---------------------------------------------------------------
    private int resultadoJugador;
    private int resultadoComputadora;

    // INSTANCIAS --------------------------------------------------------------
    private Random random = new Random();

    //MÉTODOS-------------------------------------------------------------------
    /**
     * Método encargado de simular el lanzado de dados que representará el
     * avance de los jugadores (humanos).
     *
     * @param numeroDeDados - número de dados con los que se desearán jugar.
     * @return resultado de el lanzamiento de los dados
     */
    protected int lanzarDados(int numeroDeDados) {
        int resultadoDado;
        resultadoJugador = 0;
        for (int i = 0; i < numeroDeDados; i++) {
            resultadoDado = random.nextInt(1, 7);
            resultadoJugador += resultadoDado;
        }
        return resultadoJugador;
    }

    /**
     * Método encargado de simular el lanzado de dados que representará el
     * avance de los jugadores (Maquinas).
     *
     * @param numeroDeDados - número de dados con los que se desearán jugar.
     * @return resultado de el lanzamiento de los dados
     */
    protected int lanzarDadosVehículos(int numeroDeDados) {
        int resultadoDado;
        resultadoComputadora = 0;
        for (int i = 0; i < numeroDeDados; i++) {
            resultadoDado = random.nextInt(1, 7);
            resultadoComputadora += resultadoDado;
        }
        return resultadoComputadora;
    }

}
