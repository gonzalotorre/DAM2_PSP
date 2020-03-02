package Modelo;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

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
            System.out.print("Introduce el número a adivinar: ");
            Scanner teclado = new Scanner(System.in);
            int numero = teclado.nextInt();
            System.out.println("Número a enviar al servidor: " + numero);
            //Escribimos el mensaje con el número generado que después será mostrado en la consola.
            dos.writeInt(numero);
            cliente.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
