package DSA.Bit_Manipulation;

import java.util.HashMap;
import java.util.Map;

public class _13_Single_Number_II {

    // Brute Force
    public int singleNumber(int[] nums) {

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

            if (map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value == 1) {
                return key;
            }

        }

        return -1;

    }

    // Optimized Code
    public int singleNumber1(int[] nums) {

        int n = nums.length;

        int ans = 0;

        for (int bitIndex = 0; bitIndex < 31; bitIndex++) {

            int count = 0;

            for (int i = 0; i < n; i++) {
                if ((nums[i] & (1 << bitIndex)) != 0) {
                    count++;
                }
            }

            if (count % 3 == 1) {
                ans = ans | (1 << bitIndex);
            }

        }

        return ans;

    }

}
