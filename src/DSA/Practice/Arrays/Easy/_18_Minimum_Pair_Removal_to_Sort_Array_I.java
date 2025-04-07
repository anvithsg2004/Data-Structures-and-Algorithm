package DSA.Practice.Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

public class _18_Minimum_Pair_Removal_to_Sort_Array_I {
    public static int minimumPairRemoval(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        boolean isSorted = false;

        isSorted = isSorted(nums);

        if (isSorted) {
            return 0;
        }

        List<Integer> array = new ArrayList<>();

        for (int num : nums) {
            array.add(num);
        }

        int count = 0;

        boolean isNonDecreasing = true;

        while (isNonDecreasing) {
            int[] mini = minimumPair(array);

            array.set(mini[0], mini[2]);
            array.remove(mini[1]);

            isNonDecreasing = !isSorted(array);
            count++;

        }

        return count;

    }

    public static int[] minimumPair(List<Integer> nums) {
        int i = 0;
        int j = 1;
        int minimumSum = nums.get(0) + nums.get(1);

        for (int k = 1; k < nums.size(); k++) {
            int sum = nums.get(k - 1) + nums.get(k);
            if (sum < minimumSum) {
                minimumSum = sum;
                i = k - 1;
                j = k;
            }
        }

        return new int[]{i, j, minimumSum};
    }

    public static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSorted(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        System.out.println(minimumPairRemoval(nums));
    }

}
