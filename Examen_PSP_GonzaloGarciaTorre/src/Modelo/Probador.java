package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class Probador {

    private String estado;
    private boolean libre;
    int contadorH = 0;
    int contadorM = 0;
    String cadenaClientes = "";

    public Probador() {
        estado = "libre";
        libre = true;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public synchronized void entrarSalirProbador(Cliente c) {
        //Cuando se cree el cliente, va a querer entrar al probador, por lo que será true
        if (c.isEntrar()) {
            while (!estado.equals("libre")) {
                System.out.println("------------------------------------");
                System.out.println("PROBADOR OCUPADO. ESPERE, POR FAVOR.");
                System.out.println("------------------------------------");
                try {
                    //Espera hasta que el cliente que está usando el probador salga
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Probador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println(c.getNombre() + " ESTÁ PROBANDO.");
            estado = "ocupado";
            //Entró y lo notifica
            notifyAll();
        } else {
            System.out.println(c.getNombre() + " HA SALIDO DEL PROBADOR.");
            estado = "libre";
            if (c.getSexo().equals("H")) {
                contadorH++;
                cadenaClientes = cadenaClientes + "H ";
            } else {
                contadorM++;
                cadenaClientes = cadenaClientes + "M ";
            }
            System.out.println("**************************************************");
            System.out.println("HAN ENTRADO EN EL PROBADOR: " + contadorH + " hombres y " + contadorM + " mujeres.");
            System.out.println("La secuencia de uso ha sido " + cadenaClientes);
            System.out.println("**************************************************");
            notifyAll();
        }
    }

}
