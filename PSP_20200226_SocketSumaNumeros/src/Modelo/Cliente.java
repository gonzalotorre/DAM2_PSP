package Modelo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */
public class Cliente {

    private final String HOST = "localhost";
    private final int puerto = 2000;

    public Cliente() {
        try {
            Socket cliente = new Socket(HOST, puerto);
            OutputStream os = cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            int num = (int)(Math.random() * 99 + 1);
            dos.writeInt(num);
            System.out.println("El primer usuario ha generado el número " + num + " para la suma");
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
