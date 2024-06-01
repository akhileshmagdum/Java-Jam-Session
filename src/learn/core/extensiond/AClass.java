package learn.core.extensiond;

public class AClass {
    public int x = 10;

    public void normalMethod() throws Exception {
        System.out.println("From class A");
    }

    /**
     * If this method is declared as final it will give us compilation error
     * since method hiding is disabled.
     */
    public static void staticMethod() {
        System.out.println("static A");
    }
}
