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
public class Hilo extends NoThread {

    public void run() {
        for (int i = 1; i < 10000; i++) {
            System.out.print("SI ");
            if (i % 200 == 0) {
                System.out.println();
            }
        }
    }

}
