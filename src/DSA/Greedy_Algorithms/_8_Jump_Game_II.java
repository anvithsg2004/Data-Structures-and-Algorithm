package DSA.Greedy_Algorithms;

public class _8_Jump_Game_II {

    public int jump(int[] nums) {

        int n = nums.length;

        int jumps = 0;
        int currentRangeEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {

            if (i > farthest) {
                return -1;
            }

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentRangeEnd) {
                jumps++;
                currentRangeEnd = farthest;
            }

        }

        return jumps;

    }
}
