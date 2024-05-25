package learn.core;

public class GeneralTricks {

    /**
     * It performs operation if it can or concat the string
     * The static and public's position can be interchanged
     */
    static public void main(String[] args) {
        System.out.println(100 + 20 + "Result"); // 130Result
        System.out.println("100" + 20 + "Result"); // 10020Result
        System.out.println(100 + "Result" + 20); // 100Result20
        System.out.println("100" + 20 + 10); // 1002010
        System.out.println(new String("Akhilesh") == new String("Akhilesh")); // false
        System.out.println(new String("Akhilesh") == "Akhilesh"); //false
        System.out.println("Akhilesh" == "Akhilesh"); //true
        System.out.println(new String("Akhilesh").intern() == "Akhilesh"); //true

        // This is called IntegerCache this is done for int with range from -127 to 127 by default
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b); //true
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d); //false
    }

    /**
     * Main method can be overloaded, but it cannot be used to run the program since JVM requires the method with String[] args
     * Only changing the return type also result it not called by JVM
     */
    public static void main(String args) {
        System.out.println("Akhilesh");
    }
}
