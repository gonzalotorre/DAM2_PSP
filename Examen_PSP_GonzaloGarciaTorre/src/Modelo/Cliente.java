package Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class Cliente extends Thread {

    private String nombre;
    private String sexo;
    private boolean entrar;
    private Probador probador;

    public Cliente(String nombre, String sexo, Probador probador, boolean entrar) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.probador = probador;
        this.entrar = entrar;
        System.out.println("***" + nombre + " QUIERE PROBAR ROPA***");
    }

    public boolean isEntrar() {
        return entrar;
    }

    public void setEntrar(boolean entrar) {
        this.entrar = entrar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void run() {
        //El cliente entra al probador
        probador.entrarSalirProbador(this);
        int tiempo = (int) (Math.random() * (600 + 900));
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        entrar = false;
        //Después de probar la prenda (tiempo) el cliente sale del probador
        probador.entrarSalirProbador(this);
    }

}
