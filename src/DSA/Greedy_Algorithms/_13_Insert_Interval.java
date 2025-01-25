package DSA.Greedy_Algorithms;

import java.util.ArrayList;
import java.util.List;

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

        //Left Intervals
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(List.of(intervals[i][0], intervals[i][1]));
            i = i + 1;
        }

        //Overlapping Intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i = i + 1;
        }
        // Add the merged new interval
        result.add(List.of(newInterval[0], newInterval[1]));

        //Right
        while (i < n) {
            result.add(List.of(intervals[i][0], intervals[i][1]));
            i = i + 1;
        }

        return result;

    }
}
