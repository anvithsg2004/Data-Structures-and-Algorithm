package Java_Core.Java_8.Lambda_Expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class _1_Sort {

    static class student {

        public int age;

        public String name;

        public student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public String toString() {
            return this.age + " " + this.name;
        }

    }

    public static void main(String[] args) {

        student s1 = new student(17, "Anvith");
        student s2 = new student(15, "Poorvith");
        student s3 = new student(36, "Sumathi");

        List<student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        Collections.sort(list, (a, b) -> b.age - a.age);
        System.out.println(list.toString());

    }
}
