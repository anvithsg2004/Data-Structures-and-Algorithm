package Java_Core.Java_8.Method_and_Constructor_References;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _2_Constructor_Reference {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Anvith", "Remo", "Dog");
        List<student> students = names.stream().map(student::new).collect(Collectors.toList());

    }
}
