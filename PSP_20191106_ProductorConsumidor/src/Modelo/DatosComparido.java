package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class DatosComparido {

    private String dato;

    public synchronized void almacenarDato(String datoDado) {
        if(dato != null){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(DatosComparido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.dato = datoDado;
        notify();
        System.out.println("Dato alacenado");
    }

    public synchronized String getDato() {
        if (dato == null) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(DatosComparido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String valor = dato;
        dato = null;
        notify();
        System.out.println("Dato sacado");
        return valor;
    }

}
