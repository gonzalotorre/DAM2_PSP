package Modelo;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;

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
            //Bucle que se ejecuta hasta que se haya escuchado a los 3 clientes.
            for (int nCliente = 0; nCliente < 3; nCliente++) {
                System.out.println("Esperando para mostrar mensaje procedente del cliente que se conecta.");
                //ejecutamos el método accept, lo que hace es esperar hasta que el cliente se cpnecte al servidor.
                Socket cliente = servidor.accept();
                //Una vez conectado el cliente se gestiona la petición del cliente.
                System.out.println("Sirviendo al cliente: " + nCliente);
                InputStream is = cliente.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                //Mostramos el mensaje enviado por el cliente.
                System.out.println(dis.readUTF());
                cliente.close();
            }
            System.out.println("TODOS LOS CLIENTES ATENDIDOS");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
