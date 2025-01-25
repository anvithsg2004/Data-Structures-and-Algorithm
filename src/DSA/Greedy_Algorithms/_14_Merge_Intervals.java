package DSA.Greedy_Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class
_14_Merge_Intervals {
    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();

        if (intervals.length == 0) {
            return result.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {
            if (i[0] <= end) {
                end = Math.max(i[1], end);
            } else {
                result.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }

        result.add(new int[]{start, end});
        return result.toArray(new int[0][]);

    }
}
