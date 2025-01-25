package DSA.Practice.Binary_Search.Medium;

import java.util.List;

public class _15_Minimum_Absolute_Difference_Between_Elements_With_Constraint {

    public boolean isPossible(List<Integer> nums, int minimumDistance, int[] minimum) {

        int n = nums.size();

        boolean itChanged = false;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (Math.abs(j - i) >= minimumDistance && Math.abs(nums.get(j) - nums.get(i)) < minimum[0]) {

                    minimum[0] = Math.min(minimum[0], Math.abs(nums.get(j) - nums.get(i)));

                    itChanged = true;

                }

            }

        }

        return itChanged;

    }

    public int minAbsoluteDifference(List<Integer> nums, int x) {

        int n = nums.size();

        int low = x;
        int high = n;

        int[] mini = new int[1];

        mini[0] = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(nums, mid, mini)) {

                high = mid - 1;

            } else {

                low = mid + 1;

            }

        }

        return mini[0];

    }

    public static void main(String[] args) {

    }
}
