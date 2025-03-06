package Java_Core.Java_8._1_Java_Functional_Interfaces;

import java.util.function.Supplier;

//✅ Takes no input and returns a result (T).
public class _7_Supplier {
    public static void main(String[] args) {
        Supplier<Double> randomSupplier = () -> Math.random();

        System.out.println(randomSupplier.get()); // Output: Random number
    }
}
