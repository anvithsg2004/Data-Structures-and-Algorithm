package Java_Core.Java_8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _1_Conversion {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Anvith", "Remo", "Dog");
        Stream<String> stream = list.stream();

        String[] array = {"Anvith", "Remo", "Dog"};
        Stream<String> stream1 = Arrays.stream(array);

        //By Creating own
        Stream<Integer> integerStream = Stream.of(1, 2, 5, 9, 10);

        //It will take the initial starting number and the unary operator
        Stream<Integer> limit = Stream.iterate(0, n -> n + 1).limit(200);

        //It will take the supplier which nothing and gives something.
        Stream<String> stream2 = Stream.generate(() -> "hello").limit(5);

    }

}
