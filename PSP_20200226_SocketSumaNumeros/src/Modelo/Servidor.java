/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class Servidor {

    private final int puerto = 2000;
    private int suma = 0;

    public Servidor() {
        try {
            ServerSocket server = new ServerSocket(puerto);
            for (int numCliente = 0; numCliente < 3; numCliente++) {
                Socket cliente = server.accept();
                InputStream is = cliente.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                int numero = dis.readInt();
                suma = suma + numero;
                if (numCliente < 3) {
                    System.out.print(numero + " + ");
                } else {
                    System.out.print(numero + " = ");
                }
            }
            System.out.println("La suma de los números introsucidos ha sido " + suma);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
