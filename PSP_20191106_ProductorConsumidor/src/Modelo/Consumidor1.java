package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class Consumidor1 extends Thread {

    private DatosComparido datos;
    private String nombre;
    private int numero;

    public Consumidor1(DatosComparido datos, String nombre, int numero) {
        this.datos = datos;
        this.nombre = nombre;
        this.numero = numero;
    }

    @Override
    public void run() {
        String dato;
        for (int i = 0; i < numero; i++) {
            dato = datos.getDato();
            System.out.println(nombre + " " + dato);
        }
        System.out.println("Se acaba el hilo de " + nombre);
    }

}
