/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productor_consumidor;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Usuario
 */
class Productor implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final Random random = new Random();

    public Productor(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int number = random.nextInt(100) + 1; // Generar número aleatorio entre 1 y 100
                queue.put(number); // Agregar el número a la cola
                System.out.println("Productor ha producido: " + number);
                Thread.sleep(500); // Esperar un tiempo antes de producir el siguiente número
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
