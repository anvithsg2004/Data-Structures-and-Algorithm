package Java_Core.Java_8.BiPredicate_BiFunction_BiConsumer;

import java.util.function.BiFunction;

public class _2_BiFunction {
    public static void main(String[] args) {

        //Here also same, this Bi-Function takes 2 parameter and give one output
        BiFunction<String, String, Integer> biFunction = (x, y) -> x.length() + y.length();
        System.out.println(biFunction.apply("Anvith", "Remo"));

    }
}
