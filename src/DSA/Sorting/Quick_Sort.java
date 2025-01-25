package DSA.Sorting;

import java.util.Scanner;
import java.util.Arrays;

public class Quick_Sort {

    public static int partion(int[] array, int low, int high) {

        int pivot = array[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (array[i] <= pivot && i <= high - 1) {
                i++;
            }

            while (array[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;

        return j;
    }

    public static void quick_sort(int[] array, int low, int high) {
        if (low < high) {
            int PI = partion(array, low, high);
            quick_sort(array, low, PI - 1);
            quick_sort(array, PI + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the Array : ");
        int n = in.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + i + "th value : ");
            array[i] = in.nextInt();
        }

        System.out.println(Arrays.toString(array));

        System.out.println("After : ");
        quick_sort(array, 0, n - 1);

        System.out.println(Arrays.toString(array));
    }
}
