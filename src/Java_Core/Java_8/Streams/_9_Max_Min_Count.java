package Java_Core.Java_8.Streams;

import java.util.stream.Stream;

public class _9_Max_Min_Count {
    public static void main(String[] args) {

        //Get the Max element in the custom order.
        Integer integer = Stream.iterate(0, x -> x + 1).peek(System.out::println).limit(100).max((a, b) -> b - a).get();

        System.out.println(integer);

        //Get the count of all numbers.
        Long integer1 = Stream.iterate(0, x -> x + 1).peek(System.out::println).limit(100).count();

        System.out.println(integer1);

    }
}
