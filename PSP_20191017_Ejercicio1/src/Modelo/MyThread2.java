package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class MyThread2 implements Runnable {

    String nombre;

    @Override
    public void run() {
        int tiempo = (int) (Math.random() * 5 + 1);
        try {
            System.out.println("Se duerme " + nombre);
            Thread.sleep(tiempo);
            System.out.println("Se despierta " + nombre);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Termina hilo " + nombre);
    }

}
