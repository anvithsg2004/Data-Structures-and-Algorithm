package DSA.Greedy_Algorithms;

import java.util.*;

public class _13_Insert_Interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();

        int i = 0;

        // Left Intervals (non-overlapping intervals before the new interval)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Overlapping Intervals (merge with the new interval)
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // Add the merged new interval

        // Right Intervals (non-overlapping intervals after the new interval)
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert the result to a 2D array
        return result.toArray(new int[result.size()][]);
    }

    public List<List<Integer>> insert2(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;

        // Left Intervals (Non-overlapping intervals before newInterval)
        //Compare with the give ith last interval with the new interval.
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(List.of(intervals[i][0], intervals[i][1]));
            i++; // Move to the next interval
        }

        // Overlapping Intervals (Merging process)
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]); // Expand left boundary
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]); // Expand right boundary
            i++; // Move to the next interval
        }
        // Add the merged interval
        result.add(List.of(newInterval[0], newInterval[1]));

        // Right Intervals (Non-overlapping intervals after newInterval)
        while (i < n) {
            result.add(List.of(intervals[i][0], intervals[i][1]));
            i++;
        }

        return result;
    }
}
