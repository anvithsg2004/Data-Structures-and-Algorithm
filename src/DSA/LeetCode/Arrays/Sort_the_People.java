package DSA.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sort_the_People {

    class Person {
        String name;
        int height;

        public Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        Person[] people = new Person[names.length];
        for (int i = 0; i < heights.length; i++) {
            people[i] = new Person(names[i], heights[i]);
        }

        Arrays.sort(people, Comparator.comparingInt(person -> -person.height));

        String[] sortNames = new String[heights.length];
        for (int i = 0; i < names.length; i++) {
            sortNames[i] = people[i].name;
        }

        return sortNames;
    }

    public static void main(String[] args) {

    }
}
