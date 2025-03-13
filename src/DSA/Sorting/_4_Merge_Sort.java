package DSA.Sorting;

import java.util.*;

public class _4_Merge_Sort {

    //Merge Sort (Dry Run)
    //Input:
    //array = [38, 27, 43, 3, 9, 82, 10]
    //Steps:
    //Divide: [38, 27, 43] and [3, 9, 82, 10]
    //Further divide: [38] [27, 43] and [3, 9] [82, 10]
    //Merge [27, 43] → [27, 38, 43]
    //Merge [3, 9] → [3, 9] and [82, 10] → [10, 82]
    //Merge [3, 9, 10, 82]
    //Merge [27, 38, 43, 3, 9, 10, 82] → [3, 9, 10, 27, 38, 43, 82]
    //Final Output:
    //[3, 9, 10, 27, 38, 43, 82]

    public static void merge(int[] array, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                temp.add(array[left]);
                left = left + 1;
            } else {
                temp.add(array[right]);
                right = right + 1;
            }
        }

        while (left <= mid) {
            temp.add(array[left]);
            left = left + 1;
        }
        while (right <= high) {
            temp.add(array[right]);
            right = right + 1;
        }

        for (int i = low; i <= high; i++) {
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
