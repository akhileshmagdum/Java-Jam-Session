package learn.multithreading;

public class ThreadsDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside the custom thread");
            }
        });
        thread.setName("customThread");

        Thread threadLambda = new Thread(() -> System.out.println("Inside the lambda thread"));
        threadLambda.setName("threadLambda");
        //10 is the highest whereas 1 is the lowest
        threadLambda.setPriority(Thread.MAX_PRIORITY);

        System.out.println(Thread.currentThread().getName() + " Current thread before execution");
        thread.start();
        System.out.println(Thread.currentThread().getName() + " Current thread after execution");
        threadLambda.start();
    }
}
