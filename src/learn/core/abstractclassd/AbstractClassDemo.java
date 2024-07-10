package learn.core.abstractclassd;

/**
 * All possible things you can do with an abstract class
 */
public abstract class AbstractClassDemo {

    /**
     * It allows both static and non-static variables
     */
    public static final Integer i = 10;

    private Integer j = 12;

    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }

    /**
     * Main method works as expected in an abstract class
     */
    public static void main(String[] args) {
        System.out.println("Main method can work in an abstract class");
    }

    /**
     * Abstract methods can be overloaded
     */
    public abstract void abstractMethod();

    public abstract void abstractMethod(Integer i);

    /**
     * This method is optional to override
     */
    public void nonAbstractMethod() {
        System.out.println("public void nonAbstractMethod()");
        privateMethod();
        privateStaticMethod();
    }

    /**
     * Used to directly call it on the class itself
     */
    public static void staticMethod() {
        System.out.println("public static void staticMethod()");
    }

    /**
     * Used for internal non-abstract methods
     */
    private static void privateStaticMethod() {
        System.out.println("private static void privateStaticMethod()");
    }

    /**
     * Used for internal non-abstract methods
     */
    private void privateMethod() {
        System.out.println("private void privateMethod()");
    }
}
