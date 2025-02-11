package DSA.Practice.Arrays.Medium;

import java.util.HashMap;

public class _6_Count_Number_of_Bad_Pairs {

    //Optimal Approach
    public long countBadPairs2(int[] nums) {

        int n = nums.length;

        int badPairs = 0;
        int totalPairs = (n * (n - 1)) / 2;
        int goodPairs = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = i - nums[i];
            int prevCount = hashMap.getOrDefault(val, 0);
            goodPairs = goodPairs + prevCount;
            hashMap.put(val, hashMap.getOrDefault(val, 0) + 1);
        }

        return badPairs = totalPairs - goodPairs;
    }

    //Brute Force
    public long countBadPairs(int[] nums) {

        int n = nums.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((long) (j - i) != (long) (nums[j] - nums[i])) {
                    count++;
                }
            }
        }

        return count;

    }
}
