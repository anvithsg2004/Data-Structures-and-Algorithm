package DSA.Array;

import java.util.Arrays;
import java.util.Scanner;

public class _7_Right_Rotate_By_D_Places {

    public static void Right_Rotate(int[] array, int rotate) {
        int[] temp = new int[rotate];

        //Put the values in the temp array.
        for (int i = array.length - rotate; i < array.length; i++) {
            temp[i - array.length + rotate] = array[i];
        }

        //Now shift the array back by give rotate.
        for (int i = array.length - rotate - 1; i >= 0; i--) {
            array[i + rotate] = array[i];
        }

        //Add the temp values in the array and return it.
        for (int i = 0; i < rotate; i++) {
            array[i] = temp[i];
        }

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int size = array.length;
        System.out.println("Enter the D value : ");
        int d = in.nextInt();

        int rotate = d % size;

        Right_Rotate(array, rotate);
    }
}
