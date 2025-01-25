package Java_Core.Java_8.BiPredicate_BiFunction_BiConsumer;

import java.util.function.BiPredicate;

public class _1_BiPredicate {
    public static void main(String[] args) {

        //This came because in PREDICATE there was only single parameter to be passed.
        //But in BI-PREDICATE we can pass two parameter.
        BiPredicate<Integer, Integer> biPredicate = (x, y) -> x == y;
        System.out.println(biPredicate.test(2, 2));

    }
}
