package DSA.Greedy_Algorithms;

public class _7_Jump_Game_I {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;  // Keeps track of the farthest index we can reach

        // Iterate through the array
        for (int i = 0; i < n; i++) {

            // If we reach an index greater than maxIndex, we are stuck → return false
            if (i > maxIndex) {
                return false;
            }

            // Update maxIndex to the farthest we can reach from index i
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        // If we successfully loop through without getting stuck, return true
        return true;
    }

    public static void main(String[] args) {
        _7_Jump_Game_I obj = new _7_Jump_Game_I();

        int[] nums1 = {2, 3, 1, 1, 4};  // Expected Output: true
        int[] nums2 = {3, 2, 1, 0, 4};  // Expected Output: false

        System.out.println(obj.canJump(nums1));
        System.out.println(obj.canJump(nums2));
    }
}
