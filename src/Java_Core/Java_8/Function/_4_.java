package Java_Core.Java_8.Function;

import java.util.function.Function;

public class _4_ {
    public static void main(String[] args) {
        //Identity is a Static Method inside Function Interface
        //This just returns the input, that's it its job;
        //Just as function which return the given parameter.
        Function<String, String> identityFunction = Function.identity();
        System.out.println(identityFunction.apply("Anvith"));
    }
}
