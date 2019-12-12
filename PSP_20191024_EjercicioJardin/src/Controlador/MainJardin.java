package Controlador;

import Modelo.HiloEntrar;
import Modelo.HiloSalir;
import Modelo.Jardin;

/**
 *
 * @author Gonzalo
 */
public class MainJardin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Jardin jardin = new Jardin(100);

        for (int i = 0; i < 40; i++) {
            new HiloEntrar("Entra Persona " + i, jardin).start();
        }

        for (int i = 0; i < 40; i++) {
            new HiloSalir("Sale Persona " + i, jardin).start();
        }

    }

}
