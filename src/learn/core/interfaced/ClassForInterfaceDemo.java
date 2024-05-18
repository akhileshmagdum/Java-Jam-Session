package learn.core.interfaced;

public class ClassForInterfaceDemo implements InterfaceDemo {

    public static void main(String[] args) {
        ClassForInterfaceDemo classForInterfaceDemo = new ClassForInterfaceDemo();
        classForInterfaceDemo.defaultMethod();
    }

    /**
     * Overriding a default method
     */
    @Override
    public void defaultMethod() {
        InterfaceDemo.super.defaultMethod(); //Calling the default method
        System.out.println("Overridden default method");
    }

    @Override
    public void abstractMethod() {
        System.out.println("Compulsory to override this method");
    }
}
