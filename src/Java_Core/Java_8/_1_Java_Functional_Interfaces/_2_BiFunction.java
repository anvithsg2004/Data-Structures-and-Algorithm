package Java_Core.Java_8._1_Java_Functional_Interfaces;

import java.util.function.BiFunction;

//✅ Takes two inputs (T, U) and returns a result (R).
public class _2_BiFunction {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, String> sumString = (a, b) -> "Sum: " + (a + b);

        System.out.println(sumString.apply(10, 20)); // Output: Sum: 30
    }
}
