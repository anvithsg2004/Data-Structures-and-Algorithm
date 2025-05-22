package DSA.Practice.Arrays.Medium;

import java.util.HashSet;

public class _19_Count_Complete_Subarrays_in_an_Array {
    public static int countCompleteSubarrays(int[] nums) {
        int n = nums.length;

        int uniqueNumber = 0;

        HashSet<Integer> unique = new HashSet<>();

        for (int num : nums) {
            unique.add(num);
        }

        uniqueNumber = unique.size();

        unique.clear();

        int count = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(nums[j]);
                if (set.size() == uniqueNumber) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 2, 2};
        System.out.println(countCompleteSubarrays(arr));
    }
}
