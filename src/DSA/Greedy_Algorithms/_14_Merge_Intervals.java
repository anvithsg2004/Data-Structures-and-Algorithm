package DSA.Greedy_Algorithms;

import java.util.*;

//Step 2: Initialize First Interval
//start = 1, end = 3
//Step 3: Process Each Interval
//Processing {2,6}
//i[0] = 2, i[1] = 6
//Since 2 <= end (3), they overlap.
//Merge by updating end = max(6, 3) = 6
//Current Interval: {1,6} (Merged)
//Processing {8,10}
//i[0] = 8, i[1] = 10
//Since 8 > end (6), they do not overlap.
//Add {1,6} to the result.
//Update start = 8, end = 10
//Processing {15,18}
//i[0] = 15, i[1] = 18
//Since 15 > end (10), they do not overlap.
//Add {8,10} to the result.
//Update start = 15, end = 18
//Step 4: Add the Last Interval
//Add {15,18} to the result.

public class _14_Merge_Intervals {

    public int[][] merge(int[][] intervals) {

        // List to store merged intervals
        List<int[]> result = new ArrayList<>();

        // Edge case: If there are no intervals, return an empty array
        if (intervals.length == 0) {
            return result.toArray(new int[0][]);
        }

        // Step 1: Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: Initialize start and end with the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Step 3: Iterate through intervals
        for (int[] i : intervals) {
            if (i[0] <= end) {
                // If intervals overlap, update the end to the maximum value
                end = Math.max(i[1], end);
            } else {
                // If no overlap, add the previous interval to result
                result.add(new int[]{start, end});

                // Start a new interval
                start = i[0];
                end = i[1];
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});

        // Convert result list to an array
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        _14_Merge_Intervals obj = new _14_Merge_Intervals();

        // Example 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(obj.merge(intervals1)));
        // Dry Run:
        // Step 1: Sort intervals -> [[1,3], [2,6], [8,10], [15,18]]
        // Step 2: Merge {1,3} and {2,6} -> becomes {1,6}
        // Step 3: {8,10} is separate, {15,18} is separate
        // Final Output: [[1,6], [8,10], [15,18]]

        // Example 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println(Arrays.deepToString(obj.merge(intervals2)));
        // Dry Run:
        // Step 1: Sort intervals -> [[1,4], [4,5]]
        // Step 2: Merge {1,4} and {4,5} -> becomes {1,5}
        // Final Output: [[1,5]]
    }
}
