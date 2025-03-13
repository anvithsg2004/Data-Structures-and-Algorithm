package Java_Core.Java_8.Streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _8_Peek {

    public static void main(String[] args) {

        //It is to apply any function in the middle.
        Stream.iterate(0, x -> x + 1)
                .limit(101).skip(1)
                .peek(x -> System.out.println(x))
                .collect(Collectors.toList());

    }

}
