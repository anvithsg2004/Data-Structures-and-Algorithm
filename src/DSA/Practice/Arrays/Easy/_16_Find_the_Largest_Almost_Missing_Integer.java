package DSA.Practice.Arrays.Easy;

import java.util.*;

public class _16_Find_the_Largest_Almost_Missing_Integer {
    public static int largestInteger(int[] nums, int k) {

        int n = nums.length;

        int[] freq = new int[51];

        for (int i = 0; i <= n - k; i++) {
            HashSet<Integer> numbers = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                numbers.add(nums[j]);
            }

            for (Integer integer : numbers) {
                freq[integer]++;
            }
        }

        System.out.println(Arrays.toString(freq));

        int maxNumber = -1;

        for (int i = 0; i < 51; i++) {
            if (freq[i] > 0 && freq[i] == 1) {
                maxNumber = Math.max(i, maxNumber);
            }
        }

        return maxNumber;

    }

    public static void main(String[] args) {
        int[] nums = {3, 9, 2, 1, 7};
        int k = 3;
        largestInteger(nums, k);
    }
}
