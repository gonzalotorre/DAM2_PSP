package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static modelo.Servidor.puerto;

/**
 *
 * @author Gonzalo
 */
public class Cliente {

    static final String HOST = "localhost";
    static final int puerto = 2000;

    public Cliente() {
        try {
            System.out.println("CLIENTE \n"
                    + "*******");
            //Creamos el socket para los clientes con el puerto en el que el servidor está escuchando y el host.
            Socket cliente = new Socket(HOST, puerto);
            OutputStream os = cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            //Creamos el InputStream para recibir los datos del servidor
            InputStream is = cliente.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            //El cliente tira los dados
            int dado1 = (int) (Math.random() * 5 + 1);
            //Mandamos el resultado al server
            dos.writeInt(dado1);
            int dado2 = (int) (Math.random() * 5 + 1);
            //Mandamos el resultado al server
            dos.writeInt(dado2);
            int resultadoCliente = dado1 + dado2;
            System.out.println("En el cliente ha salido un " + dado1 + ", " + dado2);
            System.out.println("-------------------------------");
            int serverDado1 = dis.readInt();
            int serverDado2 = dis.readInt();
            int resultadoServer = serverDado1 + serverDado2;
            if(resultadoCliente > resultadoServer){
                System.out.println("Cliente gana con " + dado1 + " + " + dado2);
                System.out.println("El servidor saca " + serverDado1 + " + " + serverDado2);
            } else if(resultadoCliente < resultadoServer) {
                System.out.println("Servidor gana con " + serverDado1 + " + " + serverDado2);
                System.out.println("El cliente saca " + dado1 + " + " + dado2);
            } else {
                System.out.println("TABLAS");
            }
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
