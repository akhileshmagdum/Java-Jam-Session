package learn.core;

public class GeneralTricks {

    /**
     * It performs operation if it can or concat the string
     * The static and public's position can be interchanged
     */
    static public void main(String[] args) {
        System.out.println(100 + 20 + "Result");
        System.out.println("100" + 20 + "Result");
        System.out.println(100 + "Result" + 20);
        System.out.println("100" + 20);
    }

    /**
     * Main method can be overloaded, but it cannot be used to run the program since JVM requires the method with String[] args
     * Only changing the return type also result it not called by JVM
     */
    public static void main(String args) {
        System.out.println("Akhilesh");
    }
}
