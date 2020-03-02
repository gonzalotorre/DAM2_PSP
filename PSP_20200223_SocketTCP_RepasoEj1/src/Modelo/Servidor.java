package Modelo;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
                System.out.println("Esperando por el número procedente del cliente que se conecta.");
                //ejecutamos el método accept, lo que hace es esperar hasta que el cliente se cpnecte al servidor.
                Socket cliente = servidor.accept();
                //Una vez conectado el cliente se gestiona la petición del cliente.
                System.out.println("Sirviendo al cliente: " + nCliente);
                InputStream is = cliente.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                //Generamos el número a adivinar
                if(nCliente >= 1){
                    System.out.println("Generando un nuevo número que debe acertar el cliente");
                } else {
                    System.out.println("Generando el número que debe acertar el cliente");
                }
                //Generamos el número que debe adivinar el cliente que se conecta.
                int numAdivinar = (int) (Math.random() * 9 + 1);
                //Obtenemos el número que introdujo el cliente para comprobar si acertó o no.
                int numCliente = dis.readInt();
                //Comprobamos si el número introducido por el cliente es correcto o no.
                if (numCliente == numAdivinar) {
                    System.out.println("HAS ACERTADO!!! El número que había que adivinar era "
                            + numAdivinar + " y tú has dicho " + numCliente);
                } else {
                    System.out.println("HAS FALLADO!!! El número que había que adivinar era "
                            + numAdivinar + " y tú has dicho " + numCliente);
                }
                //Cerramos la conexión con el cliente.
                cliente.close();
            }
            System.out.println("TODOS LOS CLIENTES ATENDIDOS");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
