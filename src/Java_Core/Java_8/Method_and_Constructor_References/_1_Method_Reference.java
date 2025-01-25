package Java_Core.Java_8.Method_and_Constructor_References;

import java.util.Arrays;
import java.util.List;

public class _1_Method_Reference {

    public static void print(String s) {
        System.out.println(s);
    }

    public void show(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

        //When the function is static in the class.
        List<String> students = Arrays.asList("Anvith", "Remo", "Dog");
        students.forEach(_1_Method_Reference::print);

        //When the function is not static in the class.
        _1_Method_Reference test = new _1_Method_Reference();
        List<String> students2 = Arrays.asList("Anvith", "Remo", "Dog");
        students2.forEach(test::show);

    }
}
