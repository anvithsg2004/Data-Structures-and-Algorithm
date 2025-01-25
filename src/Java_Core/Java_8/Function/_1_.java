package Java_Core.Java_8.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class _1_ {
    public static void main(String[] args) {
        Function<String, Integer> function = x -> x.length();
        Function<String, String> function1 = s -> s.substring(0, 3);
        Function<List<student>, List<student>> studentFill = li -> {

            List<student> result = new ArrayList<>();

            for (student s : li) {

                if (function1.apply(s.getName()).equalsIgnoreCase("vip")) {
                    result.add(s);
                }

            }

            return result;

        };

        student s1 = new student(2, "viful");
        student s2 = new student(6, "anvith");
        student s3 = new student(9, "vipda");
        List<student> students = Arrays.asList(s1, s2, s3);
        List<student> filter = studentFill.apply(students);
        System.out.println(filter);

    }


    public static class student {

        public int age;

        public String name;

        @Override
        public String toString() {
            return "student{" + "age=" + age + ", name='" + name + '\'' + '}';
        }

        public student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
