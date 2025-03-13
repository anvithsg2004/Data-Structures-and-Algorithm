package DSA.Sorting;

import java.util.*;

//Quick Sort Algorithm (Steps)
//Choose a Pivot (can be first, last, middle, or a random element).
//Partition the Array:
//Rearrange the elements so that all elements smaller than the pivot are on the left, and all greater are on the right.
//The pivot is placed in its correct sorted position.
//Recursively Apply Quick Sort to the left and right subarrays.

public class _5_Quick_Sort {

    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low;
        int j = high;

        while (i < j) {
            //'i' moves right until it finds an element greater than pivot.
            while (i <= high - 1 && array[i] <= pivot) {
                i++;
            }
            //'j' moves left until it finds an element smaller than pivot.
            while (j >= low + 1 && array[j] > pivot) {
                j--;
            }
            //When i < j, swap array[i] and array[j].
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        //swap array[low] (pivot) with array[j], placing the pivot in the correct position.
        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;

        return j;
    }

    public static void quick_sort(int[] array, int low, int high) {
        if (low < high) {
            //Example ==  {4 6 2 5 7 9 1 3};
            //Place the Pivot in the correct place.
            //After Finding the Pivot and putting in the correct place.
            //The new Array == {2 1 3 "4" 6 5 7 9};
            int PI = partition(array, low, high);
            //Now the same for the down as before.
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
