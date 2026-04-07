package DSA.Sliding_Window;

public class _13_Sliding_Window {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        if (k > n) {
            return new int[]{};
        }

        int[] result = new int[n - k + 1];

        int start = 0;

        int currentMax = Integer.MIN_VALUE;
        int currentMaxIndex = -1;

        for (int i = 0; i < n; i++) {

            if (nums[i] >= currentMax) {
                currentMax = nums[i];
                currentMaxIndex = i;
            }

            if (i >= k - 1) {

                if (currentMaxIndex < start) {

                    currentMax = Integer.MIN_VALUE;

                    for (int j = start; j <= i; j++) {

                        if (nums[j] >= currentMax) {
                            currentMax = nums[j];
                            currentMaxIndex = j;
                        }

                    }

                }

                result[start] = currentMax;
                start++;

            }

        }

        return result;

    }
}
