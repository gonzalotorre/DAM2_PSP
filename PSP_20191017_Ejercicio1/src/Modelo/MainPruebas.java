/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gonzalo
 */
public class MainPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int numeroHilos = (int) (Math.random() * 10);
        List<MyThread> listaHilos = new ArrayList();
        for (int i = 0; i < numeroHilos; i++) {
            listaHilos.add(new MyThread("Hilo " + i));
        }
        for (MyThread hilo : listaHilos) {
            hilo.start();
        }

        Scanner teclado = new Scanner(System.in);
        System.out.print("Numero de hilos: ");
        int numeroHilosTeclado = teclado.nextInt();
        List<MyThread> listaHilos2 = new ArrayList();
        for (int i = 0; i < numeroHilosTeclado; i++) {
            listaHilos2.add(new MyThread("Hilo " + i));
        }

        for (MyThread hilo : listaHilos2) {
            hilo.start();
        }

    }

}
