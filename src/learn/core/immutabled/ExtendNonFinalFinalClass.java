package learn.core.immutabled;

public class ExtendNonFinalFinalClass extends NonFinalFinalClass {

    /**
     * If a class is immutable but not final this constructor should be called compulsorily
     */
    public ExtendNonFinalFinalClass(int a, int b) {
        super(a, b);
    }
}
