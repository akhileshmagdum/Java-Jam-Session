package learn.core.interfaced;

/**
 * All possible things you can do with an interface
 */
public interface InterfaceDemo {

    /**
     * Variables in an interface can only be public static and final
     */
    Integer i = 10;

    /**
     * Main method works as expected in an interface
     */
    public static void main(String[] args) {
        System.out.println("Main method can also be written in an interface");
        someMethod();
    }

    /**
     * Used by default methods within the interface
     */
    private static void someMethod() {
        System.out.println("private static void someMethod()");
    }

    /**
     * Used by the default methods within the interface
     */
    private void privateInterfaceMethod() {
        System.out.println("private void privateInterfaceMethod()");
    }

    /**
     * Provides default implementation, It is optional to override this
     */
    default void defaultMethod() {
        System.out.println("default void defaultMethod()");
        privateInterfaceMethod();
        someMethod();
    }

    /**
     * Abstract method, It is compulsory to override it.
     */
    void abstractMethod();

    /**
     * Can be directly called on the interface
     */
    static void publicStaticMethod() {
        System.out.println("static void publicStaticMethod()");
    }
}
