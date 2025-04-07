package DSA.Array;

import java.util.ArrayList;

public class _35_Count_Reverse_Pairs {

    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr
        int count = 0;

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);

                if (arr[left] > (2 * arr[right])) {
                    count++;
                }

                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        //Transferring all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return count;
    }

//    public static int countPairs(int[] arr, int low, int mid, int high) {
//        int right = mid + 1;
//        int cnt = 0;
//        for (int i = low; i <= mid; i++) {
//            while (right <= high && arr[i] > 2 * arr[right]) right++;
//            cnt += (right - (mid + 1));
//        }
//        return cnt;
//    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
//        cnt += countPairs(arr, low, mid, high); //Modification
        cnt += merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }

    public static int team(int[] skill, int n) {
        return mergeSort(skill, 0, n - 1);
    }
}
