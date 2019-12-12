package psp_20191010_hilos;

/**
 *
 * @author Gonzalo
 */
public class HiloFlechas implements Runnable {

    public String nombre;

    public HiloFlechas(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (nombre.equalsIgnoreCase("Mi hilo uno")) {
                System.out.println(i + " " + nombre + " -->");
            } else {
                System.out.println(i + " " + nombre + " <--");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Finaliza el hilo : " + nombre);
    }

}
