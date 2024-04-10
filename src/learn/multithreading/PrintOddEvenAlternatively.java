package learn.multithreading;

/**
 * Alternatively Execute threads.
 * Asked in: TIBCO
 */
public class PrintOddEvenAlternatively {

    public static final Object lock = new Object();

    public static void main(String[] args) {
        alternateThreadExecutionUsingSynchronizedBlock();
    }

    public static void alternateThreadExecutionUsingSynchronizedBlock() {
        Thread evenThread = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    if (i % 2 == 0) {
                        System.out.println("even: " + i);
                        try {
                            lock.wait(); // Wait the thread so other thread can start
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        lock.notify(); // Notify the waiting thread to start
                    }
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    if (i % 2 != 0) {
                        System.out.println("odd: " + i);
                        try {
                            lock.wait(); // Wait the thread so other thread can start
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        lock.notify(); // Notify the waiting thread to start
                    }
                }
            }
        });

        evenThread.start();
        oddThread.start();
    }
}
