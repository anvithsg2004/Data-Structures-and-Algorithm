package Java_Core.Java_8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _6_Limit {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 4, 12, 5, 88, 44, 8454, 5, 12, 877, 8, 1, 1, 5, 5, 5, 4, 2, 5, 55);

        //Use to limit the number of values in the list.
        List<Integer> filteredList = list.stream().sorted().limit(5).collect(Collectors.toList());

        System.out.println(filteredList);

    }
}
