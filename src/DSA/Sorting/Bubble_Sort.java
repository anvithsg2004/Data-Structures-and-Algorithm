package DSA.Sorting;

import java.util.Scanner;
import java.util.Arrays;

public class Bubble_Sort {

    public static void bubble_sort(int[] array, int size) {
        for (int i = (size - 1); i >= 1; i--) {
            for (int j = 0; j <= (i - 1); j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int n = in.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + (i + 1) + "th Value: ");
            array[i] = in.nextInt();
        }

        System.out.println("Array before sorting: " + Arrays.toString(array));

        bubble_sort(array, n);

        System.out.println("Array after sorting: " + Arrays.toString(array));
    }
}
