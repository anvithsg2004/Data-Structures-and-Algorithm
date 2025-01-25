package DSA.Binary_Search;

public class _16_Minimum_days_to_make_M_bouquets {

    public boolean possible(int[] arr, int day, int m, int k) {
        int n = arr.length;
        int count = 0;
        int noOfB = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                count++;
            } else {
                noOfB = noOfB + (count / k);
                count = 0;
            }
        }


        //For the last count.
        noOfB = noOfB + (count / k);
        return noOfB >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        //M = No of Bouquets
        //K = Adjacent Flowers Required

        long val = (long) m * k;
        int n = bloomDay.length;

        //No of Bouquets they want is greater than the flowers which we have.
        if (val > n) {
            return -1;
        }

        //Find the max and min for low and high as the range.
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }

        //Assign to it.
        int low = mini;
        int high = maxi;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

    }
}
