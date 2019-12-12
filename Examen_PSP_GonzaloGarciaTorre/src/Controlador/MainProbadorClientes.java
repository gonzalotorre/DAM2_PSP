package Controlador;

import Modelo.Cliente;
import Modelo.Probador;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class MainProbadorClientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String sexo, nombre;
        boolean entrar = true;
        Probador p = new Probador();
        for (int i = 0; i < 8; i++) {
            nombre = "Cliente-" + i;
            //Generación del sexo del cliente
            int sexoInt = (int)(Math.random()*(1+1));
            if(sexoInt == 0){
                sexo = "M";
            } else {
                sexo = "H";
            }
            //Se inicia el hilo del cliente
            (new Cliente(nombre, sexo, p, entrar)).start();
            //Tiempo hasta que llegue otro cliente.
            int tiempo = (int) (Math.random() * (60 + 560));
            try {
                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainProbadorClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
