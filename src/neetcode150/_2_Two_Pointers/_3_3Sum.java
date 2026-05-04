package neetcode150._2_Two_Pointers;

import java.util.*;

public class _3_3Sum {
    // Brute Force
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;

        Set<List<Integer>> results = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    if (i != j && j != k && k != i) {

                        int currentSum = nums[i] + nums[j] + nums[k];

                        if (currentSum == 0) {

                            List<Integer> currentResult = new ArrayList<>();
                            currentResult.add(nums[i]);
                            currentResult.add(nums[j]);
                            currentResult.add(nums[k]);

                            Collections.sort(currentResult);

                            results.add(currentResult);

                        }

                    }

                }
            }
        }

        return new ArrayList<>(results);

    }

    // Better Solution
    public List<List<Integer>> threeSum1(int[] nums) {

        int n = nums.length;

        Set<List<Integer>> results = new HashSet<>();

        for (int i = 0; i < n; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {

                int remaining = 0 - (nums[i] + nums[j]);

                if (hashSet.contains(remaining) && i != j) {

                    List<Integer> currentResult = new ArrayList<>();
                    currentResult.add(nums[i]);
                    currentResult.add(nums[j]);
                    currentResult.add(remaining);

                    Collections.sort(currentResult);

                    results.add(currentResult);

                }

                hashSet.add(nums[j]);

            }
        }

        return new ArrayList<>(results);

    }

    public List<List<Integer>> threeSum2(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    List<Integer> currentResult = new ArrayList<>();
                    currentResult.add(nums[i]);
                    currentResult.add(nums[left]);
                    currentResult.add(nums[right]);

                    result.add(currentResult);

                    // Skip Left Duplicates
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip Right Duplicates
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }

            }

        }

        return result;

    }
}
