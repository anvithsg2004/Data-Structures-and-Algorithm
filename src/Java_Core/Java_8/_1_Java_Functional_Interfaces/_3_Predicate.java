package Java_Core.Java_8._1_Java_Functional_Interfaces;

import java.util.function.Predicate;

//✅ Takes an input (T) and returns a boolean (true or false).
public class _3_Predicate {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;

        System.out.println(isEven.test(4)); // true
        System.out.println(isEven.test(7)); // false
    }
}
