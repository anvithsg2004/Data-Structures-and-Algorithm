package Java_Core.Java_8.Function;

import java.util.function.Function;

public class _3_ {
    public static void main(String[] args) {

        Function<Integer, Integer> function = x -> x * 2;
        Function<Integer, Integer> function1 = x -> x * x * x;

        System.out.println(function.andThen(function1).apply(2));


        //These both are the same
        //compose is used to reverse this that's it "System.out.println(function.andThen(function1).apply(2));"
        System.out.println(function1.andThen(function).apply(2));
        System.out.println(function.compose(function1).apply(2));


    }
}
