package Java_Core.Java_8.Function;

import java.util.function.Function;

//Function Chaining

public class _2_ {
    public static void main(String[] args) {
        Function<String, String> function = s -> s.toUpperCase();
        Function<String, String> function1 = s -> s.substring(0, 3);
        Function<String, String> function2 = s -> String.valueOf(s.contains("v"));

        Function<String, String> stringFunction = function.andThen(function1).andThen(function2);
        System.out.println(stringFunction.apply("vipul"));
    }
}
