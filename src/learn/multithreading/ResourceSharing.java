package learn.multithreading;

public class ResourceSharing {

    public static void main(String[] args) throws InterruptedException {
        Cart cart = new Cart();
        AddItemsThread addItemsThread = new AddItemsThread(cart);
        RemoveItemsThread removeItemsThread = new RemoveItemsThread(cart);

        addItemsThread.start();
        removeItemsThread.start();

        removeItemsThread.join();
        addItemsThread.join();
        System.out.println(cart.items);
    }

    public static class AddItemsThread extends Thread {
        private Cart cart;

        public AddItemsThread(Cart cart) {
            this.cart = cart;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                cart.addItems();
            }
            System.out.println("Add item thread");
        }
    }

    public static class RemoveItemsThread extends Thread {
        private Cart cart;

        public RemoveItemsThread(Cart cart) {
            this.cart = cart;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                cart.removeItems();
            }
            System.out.println("Remove item thread");
        }
    }

    public static class Cart {
        public int items = 0;

        public synchronized void addItems() {
            items++;
        }

        public synchronized void removeItems() {
            items--;
        }
    }
}
