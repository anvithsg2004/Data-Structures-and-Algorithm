package DSA.Practice.Bit_Manipulation.Easy;

import java.util.ArrayList;
import java.util.List;

public class _1_Sum_of_All_Subset_XOR_Totals {
    public int subsetXORSum(int[] nums) {

        List<List<Integer>> allSubset = new ArrayList<>();

        int n = nums.length;

        int totalNumberOfSet = (1 << n); // 2^n subsets

        for (int i = 0; i < totalNumberOfSet; i++) {

            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < n; j++) {

                // Check if the j-th bit is set in i
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }

            }

            allSubset.add(subset);

        }

        int sum = 0;

        int subsetLength = allSubset.size();

        for (int i = 0; i < subsetLength; i++) {

            if (allSubset.get(i).isEmpty()) {
                continue;
            }

            int ans = 0;

            for (int j = 0; j < allSubset.get(i).size(); j++) {

                ans = ans ^ allSubset.get(i).get(j);

            }

            sum = sum + ans;

        }

        return sum;

    }
}
