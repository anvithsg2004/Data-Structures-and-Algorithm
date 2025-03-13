package Java_Core.Java_8._1_Java_Functional_Interfaces;

import java.util.function.UnaryOperator;

//✅ Takes an input (T) and returns the same type (T).
//✅ It's a Function<T, T> where input and output types are the same or different.
public class _8_UnaryOperator {
    public static void main(String[] args) {
        UnaryOperator<Integer> square = n -> n * n;

        System.out.println(square.apply(5)); // Output: 25
    }
}
