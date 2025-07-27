class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;

        int maxDist = 0;

        for (int i = 0; i < n; i++) {

            if (i > maxDist) {
                return false;
            }

            maxDist = Math.max(maxDist, i + nums[i]);

        }

        return true;

    }

    public boolean help(int[] nums, int n, int index) {

        if (index == n - 1) {
            return true;
        }

        if (index >= n) {
            return false;
        }

        for (int i = 1; i <= nums[index]; i++) {
            if (help(nums, n, index + i)) {
                return true;
            }
        }

        return false;

    }

}
