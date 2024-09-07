package learn.core.immutabled;

public class NonFinalFinalClass {

    private final int a;
    private final int b;

    public NonFinalFinalClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
