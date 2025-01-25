package DSA.Array;

import java.util.HashSet;
import java.util.ArrayList;

public class _10_Union {

    public static void union(int[] array1, int[] array2) {

        //Take a HashSet and put the values of arr1 and arr2
        //as it will automatically remove the duplicates.
        HashSet<Integer> hash = new HashSet<>();
        ArrayList<Integer> union = new ArrayList<>();

        for (int i = 0; i < array1.length; i++) {
            hash.add(array1[i]);
        }

        for (int i = 0; i < array2.length; i++) {
            hash.add(array2[i]);
        }

        for (int i = 0; i < hash.size(); i++) {
            //This is the way to retrieve from the HashSet.
            union.add((Integer) hash.toArray()[i]);
        }

        System.out.println(union);
    }

    public static void main(String[] args) {

        int[] array1 = {0, 1, 0, 3, 12};

        int[] array2 = {1, 2, 3, 4, 5, 6, 7};

        union(array1, array2);
    }
}
