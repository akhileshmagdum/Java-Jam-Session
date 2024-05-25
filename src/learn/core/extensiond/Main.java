package learn.core.extensiond;

public class Main {

    public static void main(String[] args) throws Exception {
        AClass a = new BClass();
        BClass b = new BClass();
        System.out.println(a.x); // 10
        b.normalMethod(); //From B class
        a.normalMethod(); //From B class
    }
}
