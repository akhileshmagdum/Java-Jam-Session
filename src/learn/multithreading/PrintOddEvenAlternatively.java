package learn.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Alternatively Execute threads.
 * Asked in: TIBCO
 */
public class PrintOddEvenAlternatively {

    public static final Object lock = new Object();

    public static void main(String[] args) {
        alternateThreadExecutionUsingSynchronizedBlock();
        alternateThreadExecutionUsingReentrantLock();
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

    public static void alternateThreadExecutionUsingReentrantLock() {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        Thread evenThread = new Thread(() -> {
            reentrantLock.lock(); // Acquire lock
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    System.out.println("even: " + i);
                    try {
                        condition.await(); // Wait the thread so other thread can start
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    condition.signal(); // Signal the waiting thread to start
                }
            }
            reentrantLock.unlock(); // Release lock
        });

        Thread oddThread = new Thread(() -> {
            reentrantLock.lock(); // Acquire lock
            for (int i = 0; i < 10; i++) {
                if (i % 2 != 0) {
                    System.out.println("odd: " + i);
                    try {
                        condition.await(); // Wait the thread so other thread can start
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    condition.signal(); // Signal the waiting thread to start
                }
            }
            reentrantLock.unlock(); // Release lock
        });

        evenThread.start();
        oddThread.start();
    }
}
