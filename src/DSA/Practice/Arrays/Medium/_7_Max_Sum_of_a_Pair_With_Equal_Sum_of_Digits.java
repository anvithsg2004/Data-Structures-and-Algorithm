package DSA.Practice.Arrays.Medium;

import java.util.*;

public class _7_Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits {

    public int maximumSum(int[] nums) {

        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int digitSum = help(nums[i]);

            // Fix: If key doesn't exist, create a new ArrayList first
            map.putIfAbsent(digitSum, new ArrayList<>());
            map.get(digitSum).add(nums[i]); // Store the number instead of the index
        }

        System.out.println(map); // Debugging line

        int sum = -1;

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> arrayList = entry.getValue();

            if (arrayList.size() < 2) continue; // If less than 2 numbers, skip

            // Sort the list to get the two largest values
            Collections.sort(arrayList, Collections.reverseOrder());
            sum = Math.max(sum, arrayList.get(0) + arrayList.get(1));
        }

        return sum;

    }

    public int help(int num) {

        int sum = 0;
        while (num > 0) {
            sum += num % 10; // Extract the last digit and add to sum
            num /= 10;       // Remove last digit
        }
        return sum;

    }
}
