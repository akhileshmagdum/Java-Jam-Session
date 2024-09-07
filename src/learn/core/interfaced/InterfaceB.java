package learn.core.interfaced;

public interface InterfaceB {
    default void run() {
        System.out.println("B");
    }
}
