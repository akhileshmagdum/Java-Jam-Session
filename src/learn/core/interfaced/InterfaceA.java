package learn.core.interfaced;

public interface InterfaceA {
    default void run() {
        System.out.println("A");
    }
}
