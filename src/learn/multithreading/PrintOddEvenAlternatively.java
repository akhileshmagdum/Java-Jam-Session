package learn.multithreading;

/**
 * Alternatively Execute threads.
 * Asked in: TIBCO
 */
public class PrintOddEvenAlternatively {

    public static final Object lock = new Object();
    public static final Integer MAX_NUMBER = 10;
    public static Integer currentNumber = 1;

    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            while (currentNumber <= MAX_NUMBER) {
                synchronized (lock) {
                    if (currentNumber % 2 == 0) {
                        System.out.println(currentNumber);
                        currentNumber++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            while (currentNumber <= MAX_NUMBER) {
                synchronized (lock) {
                    if (currentNumber % 2 != 0) {
                        System.out.println(currentNumber);
                        currentNumber++;
                        lock.notify(); //Notify thread to stop waiting
                    } else {
                        try {
                            lock.wait(); //Wait for notification
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        evenThread.start();
        oddThread.start();
    }
}
