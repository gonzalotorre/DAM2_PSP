package Modelo;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Gonzalo
 */
public class Cliente {
    
    static final String HOST = "localhost";
    static final int puerto = 2000;

    public Cliente() {
        try {
            //Creamos el socket para los clientes con el puerto en el que el servidor está escuchando y el host.
            Socket cliente = new Socket(HOST, puerto);
            OutputStream os = cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            //Calculamos el número para enviarlo junto con el mensaje al servidor y que este lo muestre.
            int numero = (int) (Math.random() * 9) + 1;
            System.out.println("Mensaje a enviar al servidor. NÚMERO: " + numero);
            //Escribimos el mensaje con el número generado que después será mostrado en la consola.
            dos.writeUTF("Mesaje de salida que el cliente envia al servidor. NÚMERO: " + numero);
            cliente.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
