package Java_Core.Java_8.BiPredicate_BiFunction_BiConsumer;

import javax.print.DocFlavor;
import java.util.function.BiConsumer;

public class _3_BiConsumer {
    public static void main(String[] args) {

        BiConsumer<Integer, Integer> biConsumer = (x, y) -> {
            System.out.println(x + y);
        };

        biConsumer.accept(5, 5);

    }
}
