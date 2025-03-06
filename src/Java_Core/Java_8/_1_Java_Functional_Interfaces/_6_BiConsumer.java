package Java_Core.Java_8._1_Java_Functional_Interfaces;

import java.util.function.BiConsumer;

//✅ Takes two inputs (T, U) and performs an action, returns nothing.
public class _6_BiConsumer {
    public static void main(String[] args) {
        BiConsumer<String, Integer> printDetails = (name, age) ->
                System.out.println(name + " is " + age + " years old");

        printDetails.accept("Anvith", 21); // Output: Anvith is 21 years old
    }
}
