package opcion1_dosHilos.modelo;


import opcion1_dosHilos.modelo.Jardin;

public class HiloPersonaEntra extends Thread {
    private Jardin j;
    
    public HiloPersonaEntra(String nombreHilo, Jardin j){
        //asigamos la puerta de entrada al jardin 
        //y un nombre a dicha puerta
        this.j=j;
        this.setName(nombreHilo);
    }
    
    public void run(){
        //para ese jardin invocamos al método para que incremente
        j.entraPersonaAlJardin();
    }
}
