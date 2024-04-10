package learn.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static final Semaphore semaphore = new Semaphore(3);

    public static class CustomThread extends Thread {

        public CustomThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println("Running thread: " + this.getName());
            try {
                semaphore.acquire(); // Acquired lock
                System.out.println("Acquired permit on thread" +
                        this.getName() + ", remaining permits: " + semaphore.availablePermits());
                Thread.sleep(10000);
                semaphore.release(); // Permit released
                System.out.println("Permit released on thread: " + this.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            CustomThread thread = new CustomThread("T" + i);
            thread.start();
        }
    }
}
