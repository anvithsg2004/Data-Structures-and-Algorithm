package DSA.Greedy_Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Intervals {
    int start;
    int end;

    public Intervals(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class intervalsComparator implements Comparator<Intervals> {
    @Override
    public int compare(Intervals o1, Intervals o2) {
        if (o1.end < o2.end) {
            return -1;
        } else if (o1.end > o2.end) {
            return 1;
        }
        return 0;
    }
}

public class _15_Non_Overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;

        ArrayList<Intervals> intervalsArrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            intervalsArrayList.add(new Intervals(intervals[i][0], intervals[i][1]));
        }

        intervalsComparator ic = new intervalsComparator();
        Collections.sort(intervalsArrayList, new intervalsComparator());

        int count = 0;
        int limit = intervalsArrayList.get(0).end;

        for (int i = 1; i < n; i++) {
            // Check for overlap
            if (intervalsArrayList.get(i).start < limit) {
                count++;  // If overlapped, increment the count
                limit = Math.min(limit, intervalsArrayList.get(i).end);  // Keep the one that ends earlier
            } else {
                limit = intervalsArrayList.get(i).end;  // No overlap, update the limit
            }
        }

        return count;

    }
}
