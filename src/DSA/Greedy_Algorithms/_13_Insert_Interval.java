package DSA.Greedy_Algorithms;

import java.util.*;

public class _13_Insert_Interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        int i = 0;

        List<int[]> result = new ArrayList<>();

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
