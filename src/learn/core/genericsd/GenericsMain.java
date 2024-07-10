package learn.core.genericsd;

import java.util.List;

public class GenericsMain {

    public static void main(String[] args) {
        List<Number> numberList = List.of(1d, 2, 3, 4, 5l, 6.23, 7.11, 8, 9, 10);
        List<Integer> integerList = List.of(1, 2, 3, 5, 6, 7, 8, 9, 10);
        List<Double> doubleList = List.of(1d, 2d, 3d, 4d, 5d);

        System.out.println(getSumUpperBound(numberList));
        System.out.println(getSumUpperBound(doubleList));
        System.out.println(getSumLowerBound(integerList));
        System.out.println(getSumLowerBound(numberList));
//        System.out.println(getSumLowerBound(doubleList)); //This gives an error because of lower bound restrictions
    }

    /**
     * UPPER BOUND: Anything that extends Number class works with this method
     */
    public static int getSumUpperBound(List<? extends Number> list) {
        return list.stream().mapToInt(Number::intValue).reduce(0, (i1, i2) -> i1 + i2);
    }

    /**
     * LOWER BOUND: Anything that the Integer class extends works with this method
     */
    public static int getSumLowerBound(List<? super Integer> list) {
        return list.stream().map(Object::toString).mapToInt(Integer::parseInt).reduce(0, (i1, i2) -> i1 + i2);
    }

    /**
     * UNBOUNDED: Any kind of object works
     */
    public static int getSizeUnbounded(List<?> list) {
        return list.size();
    }
}
