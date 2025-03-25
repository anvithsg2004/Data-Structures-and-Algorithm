package DSA.Dynamic_Programming._7_DP_On_LIS;

import java.util.*;

//What is a Subset?
//In Subsequence, we pick the elements, and we follow the order.
//But in the Subset we pick the elements, and we do not follow any orders.
//For Example, {1, 16, 7, 8, 4}
//we pick {1, 16, 8}, now this is a subsequence.
//Now we jumble as many times as we can, and those jumbled are the subsets.

//Here the question is {1, 16, 8}, this is the elements we picked.
//We make pairs out of this.
//(16, 8) (1, 8) (1, 16)
//These should be divisible by either each other.

public class _4_Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);

//        // Reverse using streams
//        nums = Arrays.stream(nums) // Convert array to IntStream
//                .boxed()         // Box int to Integer
//                .sorted((a, b) -> b - a) // Sort in reverse order
//                .mapToInt(Integer::intValue) // Unbox back to int
//                .toArray();      // Collect into an array

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int previousIndex = 0; previousIndex <= i - 1; previousIndex++) {
                if (nums[i] % nums[previousIndex] == 0 && dp[previousIndex] + 1 > dp[i]) {
                    dp[i] = 1 + dp[previousIndex];
                    hash[i] = previousIndex;
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i < n; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(nums[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            answer.add(nums[lastIndex]);
        }

        Collections.reverse(answer);

        return answer;

    }
}
