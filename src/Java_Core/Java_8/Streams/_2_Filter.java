package Java_Core.Java_8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _2_Filter {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 4, 12, 5, 88, 44, 8454, 5, 12, 877, 8, 1, 1, 5, 5, 5, 4, 2, 5, 55);

        //Use predicate to filter this list
        List<Integer> filteredList = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());

        System.out.println(filteredList);

    }
}
