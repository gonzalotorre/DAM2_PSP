/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseprocessmetodos;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Gonzalo
 */
public class ClaseProcessMetodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * 
         */
        Process porceso = new Process() {
            /**
             * Devuelve el flujo de salida conectado a la entrada normal del subproceso.
             * @return OutputStream, el flujo de salida.
             */
            @Override
            public OutputStream getOutputStream() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            /**
             * Devuelve el flujo de entrada conectado a la salida normal del subproceso.
             * @return InputStream, el flujo de entrada.
             */
            @Override
            public InputStream getInputStream() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            /**
             * Devuelve la secuencia de entrada conectada a la salida de error del subproceso.
             * @return InputStream 
             */
            @Override
            public InputStream getErrorStream() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            /**
             * Hace que el hilo actual espere, 
             * si es necesario, hasta que el proceso representado por este objeto Process haya finalizado.
             * @return abstract int
             * @throws InterruptedException 
             */
            @Override
            public int waitFor() throws InterruptedException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            /**
             * //devuelve el valor de salida del subproceso.
             * @return abstract int 
             */
            @Override
            public int exitValue() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            /**
             * Con este método se mata el subproceso.
             */
            @Override
            public void destroy() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        /**
         * un semáforo mantiene un conjunto de permisos. Cada acquire() bloquea si es necesario hasta que haya un permiso disponible,
         * y luego lo toma. Cada release() agrega un permiso, potencialmente liberando a un adquirente de bloqueo. 
         */
        Semaphore semaphore = new Semaphore(0);
        
        /**
         * Devuelve una estimación del número de subprocesos que esperan adquirir.
         */
        semaphore.getQueueLength();
        
        /**
         * Libera un permiso y lo devuelve al semáforo.
         */
        semaphore.release();
        /**
         * Libera el número dado de permisos y los devuelve al semáforo.
         */
        semaphore.release(0);
        
        /**
         * Adquiere un permiso de este semáforo, solo si hay uno disponible en el momento de la invocación.
         */
        semaphore.tryAcquire();
    }
    
}
