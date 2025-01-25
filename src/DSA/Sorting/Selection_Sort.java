package DSA.Sorting;

import java.util.Scanner;
import java.util.Arrays;

public class Selection_Sort {

    public static void section_sort(int[] array, int size) {
        for (int i = 0; i <= (size - 2); i++) {
            int mini = i;
            for (int j = i; j <= (size-1); j++) {
                if (array[j] < array[mini]) {
                    mini = j;
                }
            }
            int temp = array[mini];
            array[mini] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of an Array : ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + i + "th Number : ");
            array[i] = in.nextInt();
        }

        section_sort(array, n);

        System.out.println(Arrays.toString(array));
    }
}
