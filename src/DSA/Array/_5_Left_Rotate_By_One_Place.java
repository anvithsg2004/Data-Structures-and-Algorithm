package DSA.Array;

import java.util.Arrays;

public class _5_Left_Rotate_By_One_Place {

    public static void Left_Rotate(int[] array) {
        int temp = array[0];

        for (int i = 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }

        array[array.length - 1] = temp;

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 0, 0, 0};
        Left_Rotate(array);
    }
}
