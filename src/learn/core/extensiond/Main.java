package learn.core.extensiond;

public class Main {

    public static void main(String[] args) throws Exception {
        AClass ab = new BClass();
        BClass b = new BClass();
        AClass a = new AClass();
        System.out.println(ab.x); // 10
        b.normalMethod(); //From B class
        ab.normalMethod(); //From B class
        AClass.staticMethod(); //A static
        BClass.staticMethod(); //B static
        a.staticMethod(); //A static
        b.staticMethod(); //B static
        ab.staticMethod(); //A static
    }
}
