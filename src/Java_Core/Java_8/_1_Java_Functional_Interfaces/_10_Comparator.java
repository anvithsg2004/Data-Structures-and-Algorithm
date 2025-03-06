package Java_Core.Java_8._1_Java_Functional_Interfaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//✅ Compares two objects and returns an int value.
//✅ Returns:
//
//0 if equal
//Negative (-ve) if first is smaller
//Positive (+ve) if first is greater
public class _10_Comparator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Anvith", "Zara", "Ben");

        names.sort(Comparator.naturalOrder()); // Sorting alphabetically

        System.out.println(names); // Output: [Anvith, Ben, John, Zara]
    }
}
