package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import static modelo.Cliente.HOST;

/**
 *
 * @author Gonzalo
 */
public class Servidor {

    static final int puerto = 2000;

    public Servidor() {
        try {
            //Creamos el socket para el servidor con el puerto a través del cual va a escuchar a los clientes.
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Escuchando del puerto: " + puerto);
            //Lanzamos los dos dados
            int dado1 = (int) (Math.random() * 5 + 1);
            int dado2 = (int) (Math.random() * 5 + 1);
            int resultadoServidor = dado1 + dado2;

            System.out.println("En el servidor ha salido un " + dado1 + ", " + dado2 + "\n");
            System.out.println("Esperando la jugada del cliente");
            System.out.println("-------------------------------");
            //ejecutamos el método accept, lo que hace es esperar hasta que el cliente se conecte al servidor.
            Socket cliente = servidor.accept();
            InputStream is = cliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            //Creamos el OutputStream para enviar los datos al cliente
            OutputStream os = cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            //Mandamos el resultado al cliente
            dos.writeInt(dado1);
            dos.writeInt(dado2);
            //Recibimos los datos del cliente:
            int cliDado1 = dis.readInt();
            int cliDado2 = dis.readInt();
            int resultadoCliente = cliDado1 + cliDado2;
            if (resultadoServidor > resultadoCliente) {
                System.out.println("Servidor gana con " + dado1 + " + " + dado2);
                System.out.println("El cliente saca " + cliDado1 + " + " + cliDado2);
            } else if (resultadoServidor < resultadoCliente) {
                System.out.println("Cliente gana con " + cliDado1 + " + " + cliDado2);
                System.out.println("El servidor saca " + dado1 + " + " + dado2);
            } else {
                System.out.println("TABLAS");
            }
            System.out.println("Cerrando cliente");
            cliente.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
