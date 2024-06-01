package learn.core.abstractclassd;

public class ClassForAbstractClassDemo extends AbstractClassDemo {

    public static void main(String[] args) {
        ClassForAbstractClassDemo d = new ClassForAbstractClassDemo();
        d.nonAbstractMethod();
        d.setJ(20);
        System.out.println(d.getJ());
        System.out.println("Abstraction Demo");
        AbstractClassDemo a = new AClass();
        AbstractClassDemo b = new BClass();
        a.abstractMethod(); //Prints Aclass
        b.abstractMethod(); //Prints Bclass
    }

    @Override
    public void nonAbstractMethod() {
        super.nonAbstractMethod();
        //Calls the static method of the abstract class,
        //There is no need to extend the class just to use this method it can be directly imported
        staticMethod();
        System.out.println("Overridden non-abstract method");
    }

    @Override
    public void abstractMethod() {

    }

    @Override
    public void abstractMethod(Integer i) {

    }
}
