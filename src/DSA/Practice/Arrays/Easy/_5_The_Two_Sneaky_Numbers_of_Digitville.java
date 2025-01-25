package DSA.Practice.Arrays.Easy;

import java.util.ArrayList;
import java.util.HashMap;

public class _5_The_Two_Sneaky_Numbers_of_Digitville {

    public int[] getSneakyNumbers(int[] nums) {

        int n = nums.length;

        HashMap<Integer, Integer> frequency = new HashMap<>();

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (frequency.containsKey(nums[i])) {
                res.add(nums[i]);
            }

            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);

        }

        int[] result = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {

            result[i] = res.get(i);

        }

        return result;

    }

    public static void main(String[] args) {

    }
}
