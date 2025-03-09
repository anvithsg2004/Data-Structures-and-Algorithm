package DSA.Array;

import java.util.ArrayList;

public class _4_Remove_Duplicates {

    //Use 2 Pointer Method
    public static void RemoveDuplicates(int[] array, ArrayList<Integer> result) {
        int i = 0;

        result.add(array[0]);

        for (int j = 1; j < array.length; j++) {
            if (array[i] != array[j]) {
                //If not equal, then go to the current j.
                i = j;
                result.add(array[i]);
            }
        }

        System.out.println(result);
    }
}
