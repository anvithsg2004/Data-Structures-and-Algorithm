package Java_Core.Java_8._1_Java_Functional_Interfaces;

import java.util.function.Function;

//✅ Takes an input (T) and returns a result (R).
public class _1_Function {
    public static void main(String[] args) {
        Function<String, Integer> lengthFunction = str -> str.length();

        System.out.println(lengthFunction.apply("Hello")); // Output: 5
    }
}
