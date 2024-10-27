/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productor_consumidor;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Usuario
 */
class Consumidor implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumidor(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int number = queue.take(); // Tomar el número de la cola
                int result = number * 2; // Multiplicar por 2
                System.out.println("Consumidor ha consumido: " + number + ", Resultado: " + result);
                Thread.sleep(1000); // Esperar un tiempo antes de consumir el siguiente número
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
