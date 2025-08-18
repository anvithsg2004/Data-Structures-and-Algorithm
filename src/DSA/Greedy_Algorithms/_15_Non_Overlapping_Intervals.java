package DSA.Greedy_Algorithms;

import java.util.Arrays;

public class _15_Non_Overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;

        int limit = intervals[0][1];

        for (int i = 1; i < n; i++) {

            if (intervals[i][0] < limit) {
                count++;
                limit = Math.min(limit, intervals[i][1]);
            } else {
                limit = intervals[i][1];
            }

        }

        return count;

    }
}
