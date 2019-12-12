package psp_20191010_hilos;

/**
 *
 * @author Gonzalo
 */
public class MainHiloFlechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        HiloFlechas hiloRuneable = new HiloFlechas("Mi hilo uno");
        Thread hilo1 = new Thread(hiloRuneable);

        HiloFlechas hiloRuneable2 = new HiloFlechas("Mi hilo 1");
        Thread hilo2 = new Thread(hiloRuneable2);

        hilo1.start();
        hilo1.join();
        hilo2.start();
        hilo2.join();
        System.out.println("Finaliza proceso principal");
    }

}
