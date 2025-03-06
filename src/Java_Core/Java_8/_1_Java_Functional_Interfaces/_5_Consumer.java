package Java_Core.Java_8._1_Java_Functional_Interfaces;

import java.util.function.Consumer;

//✅ Takes an input (T) and performs an action, returns nothing.
public class _5_Consumer {
    public static void main(String[] args) {
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());

        printUpperCase.accept("hello"); // Output: HELLO
    }
}
