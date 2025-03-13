package Java_Core.Java_8._1_Java_Functional_Interfaces;

public class _12_Custom_Functional_Interface {
    @FunctionalInterface
    public interface TriFunction<T, U, V, R> {
        abstract R apply(T t, U u, V v);
    }
}
