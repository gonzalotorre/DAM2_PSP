package Modelo;

/**
 *
 * @author Gonzalo
 */
public class HiloColores implements Runnable {

    private String color;

    public HiloColores(String color) {
        this.color = color;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(color + i);
            Thread.yield();
        }
    }

}
