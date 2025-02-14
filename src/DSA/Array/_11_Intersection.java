package DSA.Array;

import java.util.ArrayList;

public class _11_Intersection {

    //This question is same as the union but here we add when the elements are both equal.
    public static void intersection(int[] array1, int[] array2) {
        int i = 0, j = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        while (i < array1.length && j < array2.length) {
            if (array1[i] == array2[j]) {
                if (answer.isEmpty() || answer.get(answer.size() - 1) != array1[i]) {
                    answer.add(array1[i]);
                }
                i++;
                j++;
            } //If the array2[j] is greater, then increase 'i' to make the elements equal.
            else if (array1[i] < array2[j]) {
                i++;
            } //If the array1[i] is greater, then increase 'j' to make the elements equal.
            else {
                j++;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 2, 3, 3, 4, 5, 6};

        int[] array2 = {2, 3, 3, 5, 6, 6, 7};

        intersection(array1, array2);
    }
}
