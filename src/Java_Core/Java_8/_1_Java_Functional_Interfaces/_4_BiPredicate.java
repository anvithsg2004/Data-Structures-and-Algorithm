package Java_Core.Java_8._1_Java_Functional_Interfaces;

import java.util.function.BiPredicate;

//✅ Takes two inputs (T, U) and returns a boolean (true or false).
public class _4_BiPredicate {
    public static void main(String[] args) {
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;

        System.out.println(checkLength.test("Java", 4)); // true
        System.out.println(checkLength.test("Hello", 3)); // false
    }
}
