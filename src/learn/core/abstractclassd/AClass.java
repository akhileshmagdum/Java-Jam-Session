package learn.core.abstractclassd;

public class AClass extends AbstractClassDemo {
    @Override
    public void abstractMethod() {
        System.out.println("Aclass");
    }

    @Override
    public void abstractMethod(Integer i) {
        System.out.println(i + "Aclass");
    }
}
