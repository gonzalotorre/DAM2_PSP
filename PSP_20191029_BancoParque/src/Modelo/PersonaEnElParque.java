package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class PersonaEnElParque extends Thread {

    private String nombre;
    private BancoParque banco;
    private boolean sentarse;

    public PersonaEnElParque(String nombre, BancoParque banco, boolean sentarse) {
        this.nombre = nombre;
        System.out.println("La persona " + nombre + " está en el parque.");
        this.banco = banco;
        this.sentarse = sentarse;
    }

    public void run(){
        banco.levantarseSentarsePersona(this);
        int tiempoSentado = (int) (Math.random() * 500);
        try {
            Thread.sleep(tiempoSentado);
        } catch (InterruptedException ex) {
            Logger.getLogger(PersonaEnElParque.class.getName()).log(Level.SEVERE, null, ex);
        }
        sentarse = false;
        banco.levantarseSentarsePersona(this);
    }
    
    public boolean isSentarse() {
        return sentarse;
    }

    public String getNombre() {
        return nombre;
    }

    
    
    

}
