package learn.core.interfaced;

public class ClassAB implements InterfaceA, InterfaceB {

    @Override
    public void run() {
        InterfaceA.super.run();
        System.out.println("AB");
    }
}
