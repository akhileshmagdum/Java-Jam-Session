package learn.core.abstractclassd;

public class BClass extends AbstractClassDemo {
    @Override
    public void abstractMethod() {
        System.out.println("Bclass");
    }

    @Override
    public void abstractMethod(Integer i) {
        System.out.println(i + "Bclass");
    }
}
