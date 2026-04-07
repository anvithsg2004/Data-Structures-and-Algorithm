package DSA.Greedy_Algorithms;

import java.util.*;

public class _14_Merge_Intervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            int[] next = intervals[i];

            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                result.add(current);
                current = next;
            }

        }

        result.add(current);

        return result.toArray(new int[result.size()][]);

    }
}
