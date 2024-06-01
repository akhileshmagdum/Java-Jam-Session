package learn.core.extensiond;

public class Main {

    public static void main(String[] args) throws Exception {
        AClass ab = new BClass();
        BClass b = new BClass();
        AClass a = new AClass();

        // Variables are directly taken from the class reference
        // But methods are taken from the object whose constructor is called
        System.out.println(ab.x); // 10
        System.out.println(ab.getX()); // 11

        b.normalMethod(); //From B class
        ab.normalMethod(); //From B class
        AClass.staticMethod(); //A static
        BClass.staticMethod(); //B static
        a.staticMethod(); //A static
        b.staticMethod(); //B static
        ab.staticMethod(); //A static
    }
}
