package DSA.Binary_Search;

public class _16_Minimum_days_to_make_M_bouquets {

//Problem Statement = Return the minimum number of days you need
//to wait to be able to make m bouquets from the garden.
//If it is impossible to make m bouquets return -1.

    //Example Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
    //Output: 3
    //Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
    //We need 3 bouquets each should contain 1 flower.
    //After day 1: [x, _, _, _, _]   // we can only make one bouquet.
    //After day 2: [x, _, _, _, x]   // we can only make two bouquets.
    //After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.

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
}
