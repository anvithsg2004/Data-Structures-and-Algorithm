package DSA.Recursion.Pattern._1_Subset_Pattern;

import java.util.ArrayList;
import java.util.List;

public class _5_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        helper(0, 0, result, new ArrayList<>(), nums, k);

        return result.size();

    }

    public void helper(int sum, int index, List<List<Integer>> result, List<Integer> current, int[] nums, int k) {

        if (sum == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (index >= nums.length) {
            return;
        }

        // Pick
        current.add(nums[index]);
        helper(sum + nums[index], index + 1, result, current, nums, k);

        // Not Pick
        current.remove(current.size() - 1);
        helper(sum, index + 1, result, current, nums, k);

    }

}
