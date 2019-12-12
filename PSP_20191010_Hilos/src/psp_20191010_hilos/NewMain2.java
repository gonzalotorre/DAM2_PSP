/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_20191010_hilos;

/**
 *
 * @author Gonzalo
 */
public class NewMain2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hilo hilo = new Hilo();
        hilo.start();
        for (int i = 1; i < 10000; i++) {
            System.out.print("NO ");
            if (i % 200 == 0) {
                System.out.println();
            }
        }

    }

}
