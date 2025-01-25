package Java_Core.Java_8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _5_Sorted {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 4, 12, 5, 88, 44, 8454, 5, 12, 877, 8, 1, 1, 5, 5, 5, 4, 2, 5, 55);

        //Use sorted() to sort the list.
        List<Integer> filteredList = list.stream().sorted().collect(Collectors.toList());

        System.out.println(filteredList);

        //Sort by custom function
        List<Integer> filteredList2 = list.stream().sorted((a, b) -> b - a).collect(Collectors.toList());

        System.out.println(filteredList2);

    }
}
