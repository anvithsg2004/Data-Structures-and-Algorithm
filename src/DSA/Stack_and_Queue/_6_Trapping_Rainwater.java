package DSA.Stack_and_Queue;

public class _6_Trapping_Rainwater {
    public int trap(int[] height) {

        int n = height.length;

        if (n == 0) {
            return 0; // Edge case: empty array
        }

        int total = 0;

        int[] leftMax = prefix(height);
        int[] rightMax = suffix(height);

        for (int i = 0; i < n; i++) {
            int leftIndexMax = leftMax[i];
            int rightIndexMax = rightMax[i];

            if (height[i] < leftIndexMax && height[i] < rightIndexMax) {
                total += Math.min(leftIndexMax, rightIndexMax) - height[i];
            }
        }

        return total;
    }

    public int[] prefix(int[] height) {

        int n = height.length;

        int[] prefix = new int[n];

        prefix[0] = height[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }

        return prefix;
    }

    public int[] suffix(int[] height) {

        int n = height.length;

        int[] suffix = new int[n];

        suffix[n - 1] = height[n - 1]; // Initialize the last element

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(height[i], suffix[i + 1]);
        }

        return suffix;
    }
}
