package learn.multithreading;

public class ThreadsObj {

    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
    }

    public static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("This is the thread " + this.getName());
        }
    }
}
