package DSA.Subarrays.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//✅ What's happening here?
//record Pair(int i, int j) {} automatically creates:
//equals() ➔ to avoid duplicates
//hashCode() ➔ for HashSet working
//toString() ➔ to print nicely

//✅ What is record in Java?
//A record is a special type of class in Java used to store data.
//It automatically creates:
//constructor
//getters
//toString()
//equals()
//hashCode()
//You don't need to write all that manually.
//It saves a lot of typing. 📝

//✅ record automatically creates constructor, getters, equals, hashCode, toString.
record Pair(int smaller, int larger) {
}

public class _5_Longest_Harmonious_Subsequence {

    //Brute Force Solution == n^2
    public static int findLHS(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        HashSet<Pair> harmoniousPairs = new HashSet<>();

        // Finding all pairs with difference exactly 1
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                if (nums[end] - nums[start] == 1) {
                    harmoniousPairs.add(new Pair(nums[start], nums[end]));
                }
            }
        }

        System.out.println(harmoniousPairs);

        int maxLength = 0;

        for (Pair pair : harmoniousPairs) {
            int smaller = pair.smaller();
            int larger = pair.larger();

            int firstOccurrence = 0;
            int lastOccurrence = 0;

            // Find first occurrence of smaller or larger
            for (int idx = 0; idx < n; idx++) {
                if (nums[idx] == smaller || nums[idx] == larger) {
                    firstOccurrence = idx;
                    break;
                }
            }

            // Find last occurrence of smaller or larger
            for (int idx = n - 1; idx >= 0; idx--) {
                if (nums[idx] == smaller || nums[idx] == larger) {
                    lastOccurrence = idx;
                    break;
                }
            }

            maxLength = Math.max(maxLength, lastOccurrence - firstOccurrence + 1);
        }

        return maxLength;
    }

    //Optimised Solution = n
    public static int findLHS1(int[] nums) {

        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int maxiLength = 0;

        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                int currentLength = map.get(num) + map.get(num + 1);
                maxiLength = Math.max(maxiLength, currentLength);
            }
        }

        return maxiLength;

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 1, 1, 1};

        System.out.println(findLHS(nums));   // Output: 5
        System.out.println(findLHS(nums1));  // Output: 2
        System.out.println(findLHS(nums2));  // Output: 0
    }
}
