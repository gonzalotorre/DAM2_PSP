package Modelo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class BancoParque {

    private int numeroPlazas;
    private boolean plazaDisponible;
    private int totalPersonasSentadas;

    public BancoParque(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
        this.plazaDisponible = true;
        this.totalPersonasSentadas = 0;
    }

    public synchronized void levantarseSentarsePersona(PersonaEnElParque p){
        
        if(p.isSentarse()){
            while(!plazaDisponible){
                System.out.println("La persona " + p.getNombre() + " no tiene sitio para sentarse.");
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(BancoParque.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("<***> la persona " + p.getNombre() + " se ha sentado.");
            totalPersonasSentadas++;
            if(totalPersonasSentadas == numeroPlazas){
                plazaDisponible = false;
                System.out.println("BANCO LLENO.");
            }
        } else {
            System.out.println("---> La persona " + p.getNombre() + " se ha levantado.");
            totalPersonasSentadas--;
            plazaDisponible = true;
            System.out.println("Hay " + (numeroPlazas - totalPersonasSentadas) + " plazas libres.");
            notifyAll();
        }
        
        
    }
    
    
}
