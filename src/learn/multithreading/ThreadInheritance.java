package learn.multithreading;

public class ThreadInheritance {
    public static final int MAX_LENGTH = 1000;

    public static void main(String[] args) {
        Vault vault = new Vault(8);
        AscendingHackerThread ascHacker = new AscendingHackerThread(vault);
        DescendingHackerThread descHacker = new DescendingHackerThread(vault);
        PoliceThread police = new PoliceThread();

        System.out.println("The game begins");
        ascHacker.start();
        descHacker.start();
        police.start();
    }

    public static class Vault {
        private final int password;

        public Vault(int password) {
            this.password = password;
        }

        public boolean guessPassword(int password) {
            return this.password == password;
        }
    }

    public abstract static class HackerThread extends Thread {
        protected Vault vault;
        public static final int MAX_LENGTH = 1000;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("The hacker thread");
            super.start();
        }
    }

    public static class AscendingHackerThread extends HackerThread {

        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_LENGTH; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.vault.guessPassword(i)) {
                    System.out.println("Password guessed by " + this.getName());
                    System.exit(0);
                }
            }
        }
    }

    public static class DescendingHackerThread extends HackerThread {

        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int i = MAX_LENGTH; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.vault.guessPassword(i)) {
                    System.out.println("Password guessed by " + this.getName());
                    System.exit(0);
                }
            }
        }
    }

    public static class PoliceThread extends Thread {

        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Countdown " + i);
            }
            System.out.println("Caught!!");
            System.exit(0);
        }
    }
}
