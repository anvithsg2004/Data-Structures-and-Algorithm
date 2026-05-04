package neetcode150._2_Two_Pointers;

import java.util.*;

public class _6_4Sum {

    // Brute Force Solution
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;

        Arrays.sort(nums);

        Set<List<Integer>> results = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (i != j && j != k && k != l && l != i) {

                            int currentSum = nums[i] + nums[j] + nums[k] + nums[l];

                            if (currentSum == target) {
                                List<Integer> currentNum = new ArrayList<>();
                                currentNum.add(nums[i]);
                                currentNum.add(nums[j]);
                                currentNum.add(nums[k]);
                                currentNum.add(nums[l]);

                                results.add(currentNum);
                            }

                        }
                    }
                }
            }
        }

        return new ArrayList<>(results);

    }

    // Better Solution
    public List<List<Integer>> fourSum1(int[] nums, int target) {

        int n = nums.length;

        Arrays.sort(nums);

        Set<List<Integer>> results = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Integer> hashSet = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    if (i != j && j != k && k != i) {

                        long remainingSum = (long) target - ((long) nums[i] + nums[j] + nums[k]);

                        if (remainingSum < Integer.MIN_VALUE || remainingSum > Integer.MAX_VALUE) {
                            continue;
                        }

                        int rem = (int) remainingSum;

                        if (hashSet.contains(rem)) {
                            List<Integer> currentNum = new ArrayList<>();
                            currentNum.add(nums[i]);
                            currentNum.add(nums[j]);
                            currentNum.add(nums[k]);
                            currentNum.add(rem);

                            Collections.sort(currentNum);
                            results.add(currentNum);
                        }

                    }

                    hashSet.add(nums[k]);
                }
            }
        }

        return new ArrayList<>(results);

    }

}
