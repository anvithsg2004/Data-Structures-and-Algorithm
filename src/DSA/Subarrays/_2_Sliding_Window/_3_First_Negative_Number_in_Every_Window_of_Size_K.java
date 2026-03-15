package DSA.Subarrays._2_Sliding_Window;

import java.util.LinkedList;
import java.util.Queue;

public class _3_First_Negative_Number_in_Every_Window_of_Size_K {
    public static int[] firstNegative(int[] arr, int k) {

        int n = arr.length;

        int[] result = new int[n - k + 1];

        Queue<Integer> q = new LinkedList<>();

        int left = 0;

        for (int right = 0; right < n; right++) {

            if (arr[right] < 0) {
                q.add(arr[right]);
            }

            if (right - left + 1 == k) {

                if (q.isEmpty()) {
                    result[left] = 0;
                } else {
                    result[left] = arr[q.peek()];
                }

                if (!q.isEmpty() && q.peek() == left) {
                    q.poll();
                }

                left++;

            }

        }

        return result;

    }
}
