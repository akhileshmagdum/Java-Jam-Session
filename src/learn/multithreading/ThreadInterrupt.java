package learn.multithreading;

public class ThreadInterrupt {

    public static void main(String[] args) {

        Thread throwsInterruptExpThread = new Thread(() -> {
            System.out.println("Running thread ");
            try {
                Thread.sleep(1000);
                System.out.println("Thread executed");
            } catch (InterruptedException e) {
                System.out.println("Interrupt signal works!");
            }
        });

        throwsInterruptExpThread.start();
        throwsInterruptExpThread.interrupt();

        Thread checkInterruptionThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(i);
            }
        });

        checkInterruptionThread.setDaemon(true);
        checkInterruptionThread.start();
    }
}
