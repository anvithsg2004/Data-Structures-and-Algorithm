package DSA.Practice.Arrays.Easy;

import java.util.HashMap;

public class _4_Number_of_Good_Pairs {

    //Optimal Code.
    public int numIdenticalPairs2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n : nums) {
            if (map.containsKey(n)) {
                count += map.get(n);
            }
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return count;
    }


    public int numIdenticalPairs(int[] nums) {

        int n = nums.length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && i < j) {
                    count++;
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {

    }
}
