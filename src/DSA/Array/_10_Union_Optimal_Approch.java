package DSA.Array;

import java.util.ArrayList;

public class _10_Union_Optimal_Approch {

    public static ArrayList<Integer> Union(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;

        ArrayList<Integer> union = new ArrayList<>();

        //If union.size() == 0, trying to access union.get(union.size() - 1)
        //would cause an IndexOutOfBoundsException

        while (i < array1.length && j < array2.length) {
            //If array1[i] is smaller, add that to maintain it sorted and increase the 'i' index.
            if (array1[i] <= array2[j]) // Case 1 and 2
            {
                if (union.size() == 0 || union.get(union.size() - 1) != array1[i]) {
                    union.add(array1[i]);
                }
                i++;
            } //If array2[j] is smaller, add that to maintain it sorted and increase the 'j' index.
            else {
                if (union.size() == 0 || union.get(union.size() - 1) != array2[j])
                    union.add(array2[j]);
                j++;
            }
        }

        //Put all the remaining elements.

        //First 'i'
        while (i < array1.length) {
            if (union.get(union.size() - 1) != array1[i]) {
                union.add(array1[i]);
            }
            i++;
        }

        //Next 'j'
        while (j < array2.length) {
            if (union.get(union.size() - 1) != array2[j]) {
                union.add(array2[j]);
            }
            j++;
        }

        return union;
    }
}
