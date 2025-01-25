package Java_Core.Java_8.Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _7_Skip {

    public static void main(String[] args) {

        //It just skip the nth element
        List<Integer> list = Stream.iterate(0 , x -> x + 1).limit(101).skip(1).collect(Collectors.toList());

        System.out.println(list);

    }

}
