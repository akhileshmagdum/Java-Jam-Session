package learn.core.immutabled;


public final class ActualFinalClass {

    private final int num;
    private final String name;

    public ActualFinalClass(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}
