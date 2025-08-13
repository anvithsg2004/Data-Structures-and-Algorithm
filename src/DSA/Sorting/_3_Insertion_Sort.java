package DSA.Sorting;

import java.util.*;

public class _3_Insertion_Sort {

    public static void insertionSort(int[] array, int size) {
        for (int i = 1; i < size; i++) {
            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                int temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Size of Array: ");
        int n = in.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + i + "th Value: ");
            array[i] = in.nextInt();
        }

        System.out.println("Array before sorting: " + Arrays.toString(array));

        insertionSort(array, n);

        System.out.println("Array after sorting: " + Arrays.toString(array));
    }
}
