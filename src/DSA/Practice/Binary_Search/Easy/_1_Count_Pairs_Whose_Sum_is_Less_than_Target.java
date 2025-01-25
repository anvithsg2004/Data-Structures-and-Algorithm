package DSA.Practice.Binary_Search.Easy;

import java.util.Collections;
import java.util.List;

public class _1_Count_Pairs_Whose_Sum_is_Less_than_Target {

    //Brute Force
    public int countPairs(List<Integer> nums, int target) {

        int count = 0;

        int n = nums.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int sum = nums.get(i) + nums.get(j);

                if (sum < target) {
                    count++;
                }

            }
        }

        return count;

    }


    //Better Solution
    public int countPairs2(List<Integer> nums, int target) {

        Collections.sort(nums); // Sort the list first
        int count = 0;
        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            int sum = nums.get(left) + nums.get(right);

            if (sum < target) {
                count += (right - left); // Count all pairs (left, left+1), (left, left+2), ..., (left, right)
                left++; // Move the left pointer to the right
            } else {
                right--; // Move the right pointer to the left to reduce the sum
            }
        }

        return count;

    }


    public static void main(String[] args) {

    }
}
