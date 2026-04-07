package DSA.Greedy_Algorithms;

import java.util.Arrays;

public class _15_Non_Overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {

            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                prevEnd = intervals[i][1];
            }

        }

        return count;

    }
}
