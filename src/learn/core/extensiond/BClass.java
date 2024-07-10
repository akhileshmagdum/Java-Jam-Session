package learn.core.extensiond;

public class BClass extends AClass {
    public int x = 11;

    public int getX() {
        return x;
    }

    /**
     * Throws can be ignored or a narrower exception can be used in throws
     */
    @Override
    public void normalMethod() throws RuntimeException {
        System.out.println("From B class");
    }

    /**
     * This just hides the static method from the superclass and this is not true method overriding
     */
    public static void staticMethod() {
        System.out.println("static B");
    }
}
