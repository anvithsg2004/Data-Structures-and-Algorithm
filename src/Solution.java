import java.util.Arrays;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int n = nums.length;

        int maxiOnes = 0;

        int current = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                current = 0;
            }

            if (nums[i] == 1) {
                current = current + 1;
                maxiOnes = Math.max(maxiOnes, current);
            }

        }

        return maxiOnes;

    }
}
