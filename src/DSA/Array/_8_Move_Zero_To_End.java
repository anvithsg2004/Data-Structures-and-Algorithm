package DSA.Array;

import java.util.ArrayList;
import java.util.Arrays;

public class _8_Move_Zero_To_End {

    //Optimized Solution
    public static void moveToEnd(int[] array) {
        int index = 0; // Pointer to place the next non-zero element

        // First pass: Move all non-zero elements to the front
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[index] = array[i];
                index = index + 1;
            }
        }

        // Second pass: Fill the remaining positions with zeros
        while (index < array.length) {
            array[index] = 0;
            index = index + 1;
        }

        // Print the result
        System.out.println(Arrays.toString(array));
    }


    public static void Move_To_End(int[] array) {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                temp.add(array[i]);
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i);
        }

        int nz = temp.size();

        for (int i = nz; i < array.length; i++) {
            array[i] = 0;
        }

        System.out.println(Arrays.toString(array));
    }
}
