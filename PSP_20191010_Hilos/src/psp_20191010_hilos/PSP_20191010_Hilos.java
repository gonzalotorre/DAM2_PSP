package psp_20191010_hilos;

/**
 *
 * @author Gonzalo
 */
public class PSP_20191010_Hilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;
        NoThread hilo = new NoThread();
        hilo.start();
        for(i = 1; i<=20;i++){
            System.out.println("SI");
        }
        
        System.out.println("-------------------------------------------------");
        
        NoThread claseRuneable = new NoThread();
        Thread hilo1 = new Thread(claseRuneable);
        hilo1.start();;
        for(i = 1; i<=20;i++){
            System.out.println("SI");
        }
        
        
    }
    
}
