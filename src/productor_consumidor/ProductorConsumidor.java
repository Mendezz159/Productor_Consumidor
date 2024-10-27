/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productor_consumidor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Usuario
 */
public class ProductorConsumidor {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10); // Cola con capacidad de 10 elementos

        Thread productorThread = new Thread(new Productor(queue));
        Thread consumidorThread = new Thread(new Consumidor(queue));

        productorThread.start(); // Iniciar hilo productor
        consumidorThread.start(); // Iniciar hilo consumidor

        try {
            productorThread.join(); // Esperar a que el hilo productor termine
            consumidorThread.join(); // Esperar a que el hilo consumidor termine
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
