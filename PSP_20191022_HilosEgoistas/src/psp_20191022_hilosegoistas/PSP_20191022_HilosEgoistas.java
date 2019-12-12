package psp_20191022_hilosegoistas;

import Modelo.HiloColores;

/**
 *
 * @author Gonzalo
 */
public class PSP_20191022_HilosEgoistas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HiloColores rojo = new HiloColores("Rojo");
        HiloColores verde = new HiloColores("Verde");
        HiloColores amarillo = new HiloColores("Amarillo");
        Thread hilo1 = new Thread(rojo);
        Thread hilo2 = new Thread(verde);
        Thread hilo3 = new Thread(amarillo);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
    }
    
}
