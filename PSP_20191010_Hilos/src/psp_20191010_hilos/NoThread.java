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
public class NoThread extends Thread implements Runnable{

    public void run() {
        int i;
        for (i = 1; i <= 20; i++) {
            System.out.println("NO");
        }
    }
}
