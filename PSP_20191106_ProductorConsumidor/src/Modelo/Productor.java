package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class Productor extends Thread {

    private DatosComparido dato;
    private String nombre;
    private int numeroValores;

    public Productor(DatosComparido dato, String nombre, int numeroValores) {
        this.dato = dato;
        this.nombre = nombre;
        this.numeroValores = numeroValores;
    }

    @Override
    public void run() {
        for (int i = 0; i < numeroValores; i++) {
            dato.almacenarDato("" + i);
            System.out.println("Alacenado el valor " + nombre + " " + i);
        }
        System.out.println("Se ha terminado el hilo del productor");
    }

}
