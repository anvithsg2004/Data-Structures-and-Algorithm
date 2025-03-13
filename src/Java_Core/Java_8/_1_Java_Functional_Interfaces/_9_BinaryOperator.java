package Java_Core.Java_8._1_Java_Functional_Interfaces;

import java.util.function.BinaryOperator;

//✅ Takes two inputs of the same type (T) and returns the same or different type (T).
//✅ It's a BiFunction<T, T, T>.
public class _9_BinaryOperator {
    public static void main(String[] args) {
        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        System.out.println(multiply.apply(5, 10)); // Output: 50
    }
}
