package DSA.Practice.Binary_Search.Medium;

//Did not solve by Binary Search
//Do it...

import java.util.PriorityQueue;

class add {

    double fraction;
    int i;
    int j;

    public add(double fraction, int i, int j) {

        this.fraction = fraction;
        this.i = i;
        this.j = j;

    }

}

public class _2_K_th_Smallest_Prime_Fraction {

    //Best Solution
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int n = arr.length;

        PriorityQueue<add> pq = new PriorityQueue<>((a, b) -> Double.compare(a.fraction, b.fraction));

        for (int i = 0; i < n; i++) {

            int low = i;
            int high = n - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                double lowHigh = (double) arr[low] / arr[high];
                pq.add(new add(lowHigh, low, high));

                double midHigh = (double) arr[mid] / arr[high];
                pq.add(new add(midHigh, mid, high));

                low = mid + 1;

            }

            if (pq.size() >= k) {
                break;
            }

        }

        add elementAtIndex = null;

        // Remove the smallest (k-1) elements, so the k-th smallest is at the top
        for (int i = 0; i < k; i++) {
            elementAtIndex = pq.poll();
        }

        // elementAtIndex now holds the k-th smallest fraction
        return new int[]{arr[elementAtIndex.i], arr[elementAtIndex.j]};

    }

    //Brute Force Solution
    //Time Complexity: O(n^2 log n)
    //Space Complexity: O(n^2)
    public int[] kthSmallestPrimeFraction2(int[] arr, int k) {

        int n = arr.length;

        PriorityQueue<add> pq = new PriorityQueue<>((a, b) -> Double.compare(a.fraction, b.fraction));

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                double fraction = (double) arr[i] / arr[j];

                pq.add(new add(fraction, i, j));

            }

        }

        add elementAtIndex = null;

        // Remove the smallest (k-1) elements, so the k-th smallest is at the top
        for (int i = 0; i < k; i++) {
            elementAtIndex = pq.poll();
        }

        // elementAtIndex now holds the k-th smallest fraction
        return new int[]{arr[elementAtIndex.i], arr[elementAtIndex.j]};
    }

    public int[] kthSmallestPrimeFraction3(int[] arr, int k) {

        int n = arr.length;

        double min = Integer.MAX_VALUE;

        double previous = Integer.MAX_VALUE;

        int[] results = new int[2];

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                previous = min;

                double fraction = (double) arr[i] / arr[j];

                min = Math.min(min, fraction);

                if (min != previous) {

                    results[0] = i;
                    results[1] = j;

                }

            }

        }

        return results;
    }

    public static void main(String[] args) {

    }
}
