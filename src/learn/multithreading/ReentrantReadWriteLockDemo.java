package learn.multithreading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private int value = 0;

    public int getValue() {
        lock.readLock().lock();
        try {
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void increment() {
        lock.writeLock().lock();
        try {
            value++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo example = new ReentrantReadWriteLockDemo();

        // Multiple threads reading the value
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("Value: " + example.getValue());
            }).start();
        }

        // Single thread incrementing the value
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                example.increment();
            }
        }).start();
    }
}

