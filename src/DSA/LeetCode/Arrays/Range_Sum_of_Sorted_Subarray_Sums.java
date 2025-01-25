package DSA.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class Range_Sum_of_Sorted_Subarray_Sums {

    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                arrayList.add(sum);
            }
        }

        Collections.sort(arrayList);

        int sum = 0;
        int mod = 1000000007;

        for (int i = left - 1; i < right; i++) {
            sum = (sum + arrayList.get(i)) % mod;
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
