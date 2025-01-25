package Java_Core.Java_8.Consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class _1_ {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Anvith");

        //This can not return anything.
        //But any other things can be written in that.
        //Like doing some this with the database.

        Consumer<List<Integer>> listConsumer = li -> {

            for (Integer i : li) {
                System.out.println(i + 100);
            }

        };

        Consumer<List<Integer>> listConsumer1 = li -> {

            for (Integer i : li) {
                System.out.println(i + 100);
            }

        };

        listConsumer.accept(Arrays.asList(1, 2, 3, 4));


        //Consumer Chaining
        listConsumer1.andThen(listConsumer).accept(Arrays.asList(1, 2, 3, 4));

        //How it works
        Consumer<List<Integer>> listConsumer2 = listConsumer1.andThen(listConsumer);
        listConsumer2.accept(Arrays.asList(1, 2, 3, 4));
    }
}
