package learn.multithreading;

import java.util.ArrayList;

public class VirtualThreadDemo {

    public static void main(String[] args) {
        ArrayList<Thread> virtualThreads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread virtualThread = Thread.ofVirtual().unstarted(() -> {
                System.out.println("This is: " + Thread.currentThread());
            });
            virtualThreads.add(virtualThread);
        }

        for (Thread t : virtualThreads) {
            t.start();
        }

        // This thread is need to demonstrate virtual threads since virtual threads are daemon threads
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
