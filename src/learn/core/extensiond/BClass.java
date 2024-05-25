package learn.core.extensiond;

public class BClass extends AClass {
    public int x = 11;

    /**
     * Throws can be ignored or a narrower exception can be used in throws
     */
    @Override
    public void normalMethod() throws RuntimeException {
        System.out.println("From B class");
    }
}
