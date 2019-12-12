package Modelo;

/**
 *
 * @author Gonzalo
 */
public class Jardin {
    
    private int numPersonas;

    public Jardin(int numPersonas) {
        this.numPersonas = numPersonas;
    }
    
    public void incrementarPersonas(){
        System.out.println("Hilo " + Thread.currentThread().getName() + " ---- Entra en el jardín.");
        numPersonas++;
        System.out.println("Total personas en el jardín: " + numPersonas);
    }
    
    public void decrementarPersonas(){
        System.out.println("Hilo " + Thread.currentThread().getName() + " ---- Sale del jardín.");
        numPersonas--;
        System.out.println("Total personas en el jardín: " + numPersonas);
    }
    
}
