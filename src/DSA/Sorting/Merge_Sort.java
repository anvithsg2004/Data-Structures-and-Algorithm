package DSA.Sorting;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Merge_Sort {

    public static void merge(int[] array, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                temp.add(array[left]);
                left++;
            }
            else {
                temp.add(array[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(array[left]);
            left++;
        }

        while (right <= high) {
            temp.add(array[right]);
            right++;
        }

        for (int i = low; i < right; i++) {
            array[i] = temp.get(i - low);
        }
    }

    public static void merge_sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        merge_sort(array, low, mid);
        merge_sort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the Array : ");
        int n = in.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + i + "th Value : ");
            array[i] = in.nextInt();
        }

        System.out.println(Arrays.toString(array));

        System.out.println("After : ");
        merge_sort(array, 0, n - 1);

        System.out.println(Arrays.toString(array));
    }
}
