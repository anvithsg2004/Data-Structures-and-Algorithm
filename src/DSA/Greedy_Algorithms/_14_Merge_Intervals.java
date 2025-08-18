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

        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;
            while (j < n && intervals[j][0] <= end) { // ✅ compare with merged end
                start = Math.min(start, intervals[j][0]);
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            result.add(new int[]{start, end});

            i = j - 1; // skip merged intervals
        }

        return result.toArray(new int[result.size()][]);
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
