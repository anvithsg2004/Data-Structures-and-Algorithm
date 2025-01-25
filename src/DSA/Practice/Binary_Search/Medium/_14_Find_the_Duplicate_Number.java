package DSA.Practice.Binary_Search.Medium;

import java.util.Arrays;

public class _14_Find_the_Duplicate_Number {

    public int findDuplicate3(int[] nums) {

        //Tortoise and Hare Method (Floyd's Cycle Detection Algorithm).

        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;

    }

    public int findDuplicate2(int[] nums) {

        int n = nums.length;

        int[] hashing = new int[n];

        for (int i = 0; i < n; i++) {

            hashing[nums[i]]++;

            if (hashing[nums[i]] >= 2) {
                return nums[i];
            }

        }

        return -1;

    }

    public int findDuplicate(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);

        if (n == 1) {
            return -1;
        }

        int i = 0;

        for (int j = 1; j < n; j++) {

            if (nums[i] == nums[j]) {
                return nums[i];
            } else {
                i = j;
            }

        }

        return -1;

    }

    public static void main(String[] args) {

    }
}
