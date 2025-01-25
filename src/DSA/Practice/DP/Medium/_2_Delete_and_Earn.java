package DSA.Practice.DP.Medium;

import java.util.HashMap;
import java.util.Map;

public class _2_Delete_and_Earn {

    //Recursion
    public int deleteAndEarn(int[] nums) {

        Map<Integer, Integer> frequency = new HashMap<>();

        int maxNum = 0;

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            maxNum = Math.max(maxNum, num);
        }

        return helper(frequency, 0, maxNum);

    }

    public int helper(Map<Integer, Integer> frequency, int num, int maxNum) {

        if (num > maxNum) {
            return 0;
        }

        int earn = (num * frequency.getOrDefault(num, 0)) + helper(frequency, num + 2, maxNum);

        int skip = helper(frequency, num + 1, maxNum);

        return Math.max(earn, skip);

    }

    //Memoization
    public int deleteAndEarn2(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int maxNum = 0;

        // Build the frequency map and find the maximum number in the array
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            maxNum = Math.max(maxNum, num);
        }

        // Memoization map to store results of subproblems
        Map<Integer, Integer> memo = new HashMap<>();

        return helper(frequency, 0, maxNum, memo);
    }

    public int helper(Map<Integer, Integer> frequency, int num, int maxNum, Map<Integer, Integer> memo) {
        // Base case: if the number exceeds maxNum, return 0
        if (num > maxNum) {
            return 0;
        }

        // Check if the result for this number is already computed
        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        // Calculate the points if we "earn" or "skip" this number
        int earn = (num * frequency.getOrDefault(num, 0)) + helper(frequency, num + 2, maxNum, memo);
        int skip = helper(frequency, num + 1, maxNum, memo);

        // Take the maximum of the two choices
        int result = Math.max(earn, skip);

        // Store the result in the memoization map
        memo.put(num, result);

        return result;
    }

}
