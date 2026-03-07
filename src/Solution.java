class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int currentCount = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                count = Math.max(count, currentCount);
                currentCount = 0;
            } else if (nums[i] == 1) {
                currentCount++;
            }

        }

        return Math.max(count, currentCount);

    }
}
