package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class MainBancoParque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BancoParque banco = new BancoParque(2);
        String nombre;
        boolean sentarse = true;
        for (int i = 0; i < 10; i++) {
            nombre = "Persona" + i;
            (new PersonaEnElParque(nombre, banco, sentarse)).start();
            int tiempo = (int) (Math.random()*500);
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainBancoParque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
