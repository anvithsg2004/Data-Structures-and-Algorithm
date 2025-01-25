package DSA.Array;

import java.util.Scanner;
import java.util.Arrays;

public class _6_Left_Rotate_By_D_Places {

    public static void rotate(int[] array, int rotate) {

        int[] temp = new int[rotate];

        //First, how much they have said to rotate put that in the temp array.
        for (int i = 0; i < rotate; i++) {
            temp[i] = array[i];
        }

        //Start from the rotated index and put the value back as given an array.
        for (int j = rotate; j < array.length; j++) {
            array[j - rotate] = array[j];
        }

        int p = 0;

        //Put that back into the given array
        for (int k = array.length - rotate; k < array.length; k++) {
            array[k] = temp[p];
            p++;
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

        rotate(array, rotate);
    }
}
