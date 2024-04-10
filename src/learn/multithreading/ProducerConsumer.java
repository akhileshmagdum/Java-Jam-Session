package learn.multithreading;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {

    public static class SharedBuffer {
        private List<Integer> buffer = new LinkedList<>();
        private int capacity;

        public SharedBuffer(int capacity) {
            this.capacity = capacity;
        }

        public synchronized void produce() throws InterruptedException {
            if (capacity == buffer.size()) {
                System.out.println("Buffer is full");
                wait();
            }
            int num = (int) Math.random();
            buffer.add(num);
            System.out.println("Added to the buffer");
            notify();
        }

        public synchronized void consume() throws InterruptedException {
            while (buffer.isEmpty()) {
                System.out.println("Buffer is empty");
                wait();
            }
            buffer.remove(0);
            System.out.println("Last element removed");
            notify();
        }
    }

    public static class ConsumerThread extends Thread {
        private SharedBuffer buffer;

        public ConsumerThread(String name, SharedBuffer buffer) {
            super(name);
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                buffer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ProducerThread extends Thread {
        private SharedBuffer buffer;

        public ProducerThread(String name, SharedBuffer buffer) {
            super(name);
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                buffer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(10);

        for (int i = 0; i < 10; i++) {
            ProducerThread producerThread = new ProducerThread("P" + i, buffer);
            ConsumerThread consumerThread = new ConsumerThread("C" + i, buffer);
            if (buffer.buffer.size() > buffer.capacity) {
                System.out.println("Threshold broken");
            }
            producerThread.start();
            consumerThread.start();
        }
    }
}
