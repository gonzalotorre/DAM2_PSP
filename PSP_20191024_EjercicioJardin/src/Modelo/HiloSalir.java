/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Gonzalo
 */
public class HiloSalir extends Thread {

    Jardin j;

    public HiloSalir(String nombre, Jardin j) {
        this.j = j;
        this.setName(nombre);
    }

    @Override
    public void run() {
        j.decrementarPersonas();
    }

}
