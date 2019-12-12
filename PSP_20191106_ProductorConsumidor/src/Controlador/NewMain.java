package Controlador;

import Modelo.Consumidor1;
import Modelo.DatosComparido;
import Modelo.Productor;

/**
 *
 * @author Gonzalo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DatosComparido dc = new DatosComparido();
        Productor p1 = new Productor(dc, "Prod1", 10);
        Consumidor1 c1 = new Consumidor1(dc, "Consumidor1", 10);
        
        p1.start();
        c1.start();
        
    }
    
}
